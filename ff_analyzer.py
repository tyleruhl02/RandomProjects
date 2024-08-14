import numpy as np
import requests
import pandas as pd
import matplotlib.pyplot as plt
from scipy import stats
from bs4 import BeautifulSoup
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split
import re
import logging
import os
import time
from pprint import pprint
import json
import warnings


warnings.simplefilter(action='ignore', category=FutureWarning)
pd.options.mode.chained_assignment = None  # default='warn'

def get_defensive_data(data):
    data = data.sort_values(["game_date", "team"])
    for day in data["game_date"].unique():
        temp_df = data.query(f'game_date == "{day}"')
        for team in temp_df["team"].unique():
            temp_df = temp_df.query(f'team == "{team}"')
            print(temp_df)
            try:
                opp = temp_df["opp"].unique()[0]
            except:
                print(team)
                print(temp_df)
                quit()

            te_recs = temp_df.query('pos == "TE"')["rec"].sum()
            te_rec_tds = temp_df.query('pos == "TE"')["rec_td"].sum()
            te_rec_yds = temp_df.query('pos == "TE"')["rec_yds"].sum()
            te_rush_tds = temp_df.query('pos == "TE"')["rush_td"].sum()
            te_rush_yds = temp_df.query('pos == "TE"')["rush_yds"].sum()

            print(te_recs)
            print(te_rec_tds)
            print(te_rec_yds)
            print(te_rush_tds)
            print(te_rush_yds)


            if len(temp_df) > 5:
                print(temp_df["opp"])
    quit()
    print(len(data["team"].unique()))
    quit()

def graph_player(data, name):
    points = np.array(data["fantasy_points"])
    mean = points.mean()
    median = points[points.argsort()[round(len(points) / 2)]]
    mode = stats.mode(points.round())[0]

    print(mean)
    print(median)
    #print(mode)

    fig, ax = plt.subplots(figsize=(10, 10))
    ax.hist(points, bins=15)
    ax.axvline(x=mean, color="k", linewidth=5, label="Mean")
    ax.axvline(x=median, color="r", linewidth=5, label="Median")
    ax.set_title(name)
    #ax.axvline(x=mode, color="k", linewidth=5, label="Mode")
    ax.legend()
    plt.show()
    print(points)

def get_average_fantasy_points_per_game(data, start_year, end_year, id):
    res = data.query(f'(year >= {start_year}) and (year <= {end_year}) and (id == "{id}")')

    total_points = sum(res["fantasy_points"])
    games_played = sum(res["played"].isna())

    if games_played == 0:
        return 0

    return round(total_points / games_played, 2)

def run_linear_regression(season_data : pd.DataFrame):



    season_data = season_data.sort_values(by=["id", "year"])

    """season_data["fantasy_points_sum_last_3"] = (
        season_data.assign(fantasy_points=season_data["fantasy_points"].shift(fill_value=0))
        .groupby("id").rolling(3, min_periods=0)["fantasy_points"]
        .sum().astype(float).droplevel(0)
    )"""

    season_data["next_year_fp"] = (
        season_data.assign(fantasy_points=season_data["fantasy_points"].shift(-1, fill_value=0))
        .groupby("id").rolling(1, min_periods=0)["fantasy_points"]
        .sum().astype(float).droplevel(0)
    )

    season_data = season_data.query("year != 2023")

    #season_data = season_data.query("fantasy_points_sum_last_3 > 100 and fantasy_points > 100")

    """X = season_data["fantasy_points"].to_numpy()
    Y = (season_data["fantasy_points_sum_last_3"] / 3).to_numpy()

    slope, intercept, r_value, p_value, std_err = stats.linregress(X, Y)"""

    X1 = season_data["rec"].to_numpy()
    X2 = season_data["rec_td"].to_numpy()
    X3 = season_data["rush_td"].to_numpy()
    X4 = season_data["rec_yds"].to_numpy()
    X5 = season_data["rush_yds"].to_numpy()

    X = [[X1[i], X2[i], X3[i], X4[i], X5[i]] for i in range(len(X1))]
    Y = season_data["next_year_fp"].to_numpy()

    X_train, X_test, y_train, y_test = train_test_split(X, Y, test_size=0.25)

    reg = LinearRegression().fit(X_train, y_train)

    print(reg.score(X_train, y_train))
    print(reg.score(X_test, y_test))

    print(reg.coef_)
    print(reg.intercept_)

    quit()

    print(slope)
    print(intercept)

    fig, ax = plt.subplots(figsize=(10, 10))

    ax.scatter(X, Y)
    ax.set_xlabel("fantasy_points")
    ax.set_ylabel("fatnasy_points_last_3_avg")

    x_vals = np.array(ax.get_xlim())
    y_vals = intercept + slope * x_vals

    plt.plot(x_vals, y_vals, '-', color="r")

    plt.show()



    print(season_data)

    print(season_data.columns)
    print(season_data["played"])

    quit()

def get_season_data(data) -> pd.DataFrame:
    data["played"].fillna(1, inplace=True)
    data["played"].replace("Inactive", 0, inplace=True)
    data["played"].replace("Did Not Play", 0, inplace=True)
    return data.groupby(['year', 'id', 'pos']).sum(numeric_only=True).reset_index()

def get_regular_season(data):
    return data.query('((year >= 2021) and (week_num <= 18)) or (week_num <= 17)')

def get_playoffs(data):
    return data.query('((year >= 2021) and (week_num >= 19)) or (week_num >= 18)')

def main():
    data = pd.read_csv('MASTER_NFL_DATA.csv')
    data = data.replace("SDG", "LAC").replace("OAK", "LVR").replace("STL", "LAR")

    players_df = get_regular_season(data)

    players = list(data["id"].unique())

    def_df = get_defensive_data(players_df)

    #print(get_season_data(data))

    season_data = get_season_data(players_df)

    qbs_df = season_data.query('(pos == "QB")')
    rbs_df = season_data.query('(pos == "RB")')
    wrs_df = season_data.query('(pos == "WR")')
    tes_df = season_data.query('(pos == "TE")')

    season_data.drop(columns=["game_num", "week_num", "age"], inplace=True)

    #season_data.to_csv('MASTER_NFL_REGULAR_SEASON_DATA.csv', index=False)

    #my_dict = {}
    #ids = temp["id"].unique()
    #print(ids)

    #print(season_data)

    """rodge = season_data.query('id == "RodgAa00"')

    rodge["fantasy_points_sum_last_3"] = (
        rodge.assign(fantasy_points=rodge["fantasy_points"].shift(fill_value=0))
        .groupby("id").rolling(3, min_periods=0)["fantasy_points"]
        .sum().astype(float).droplevel(0)
    )"""

    run_linear_regression(wrs_df)

    print(season_data)
    print()

    #mahomes = data.query('id == "MahoPa00" and played != "Inactive" and played != "Did Not Play"')
    #print(mahomes)
    #graph_player(mahomes, "Patrick Mahomes")

    #average_points_last_three_seasons = {}

    #for rb in rbs:
    #    average_points_last_three_seasons[rb] = get_average_fantasy_points_per_game(rbs_df, 2021, 2023, rb)

    #average_points_last_three_seasons = sorted(average_points_last_three_seasons.items(), key=lambda x: x[1], reverse=True)

    #print(average_points_last_three_seasons)

    #print(data)

if __name__ == '__main__':
    main()