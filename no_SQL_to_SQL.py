import requests
import pandas as pd
from bs4 import BeautifulSoup
import re
import logging
import os
import time
from pprint import pprint
import json

def main():
    with open("qb_data.json") as infile:
        data = json.load(infile)



    text = "id,year,game_num,week_num,age,game_date,team,home,opp,game_result,played,gs,pass_cmp,pass_att,pass_yds,pass_td,pass_int,pass_rating,pass_sacked,pass_sacked_yds,rush_att,rush_yds,rush_td,rec,rec_yds,rec_td,catch_pct,fumbles,fumbles_lost,offense,off_pct".split(",")

    df = pd.DataFrame(columns=text)

    counter = 0

    for player_id in data:
        for year in data[player_id]["data"]:
            print(year)
            for week in data[player_id]["data"][year]:
                print(data[player_id]["data"][year][week])
                data[player_id]["data"][year][week]["year"] = year
                data[player_id]["data"][year][week]["id"] = player_id
                df.loc[counter] = data[player_id]["data"][year][week]
                counter += 1

    df.to_csv("qb_data.csv", index=False)

            #print(data[player_id]["data"][year])
        #print(df.columns)
        #print(df)
        #quit()

if __name__ == '__main__':
    main()