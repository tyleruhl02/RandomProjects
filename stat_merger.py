import requests
import pandas as pd
from bs4 import BeautifulSoup
import re
import logging
import os
import time
from pprint import pprint
import json

def calculate_fantasy_points(df):
    df["pass_yds"].fillna(0, inplace=True)
    df["pass_td"].fillna(0, inplace=True)
    df["pass_int"].fillna(0, inplace=True)
    df["rush_yds"].fillna(0, inplace=True)
    df["rush_td"].fillna(0, inplace=True)
    df["rec"].fillna(0, inplace=True)
    df["rec_yds"].fillna(0, inplace=True)
    df["rec_td"].fillna(0, inplace=True)
    df["fumbles_lost"].fillna(0, inplace=True)

    df["fantasy_points"] =  round(0.04 * df["pass_yds"] + \
                            4 * df["pass_td"] + \
                            (-2) * df["pass_int"] + \
                            0.1 * df["rush_yds"] + \
                            6 * df["rush_td"] + \
                            1 * df["rec"] + \
                            0.1 * df["rec_yds"] + \
                            6 * df["rec_td"] + \
                            (-2) * df["fumbles_lost"], 2)
    return df


def combine(qb_df, rb_df, wr_df, te_df):
   return pd.concat([qb_df, rb_df, wr_df, te_df], ignore_index=True)

def main():
    qb_df = pd.read_csv('qb_data.csv')
    rb_df = pd.read_csv('rb_data.csv')
    wr_df = pd.read_csv('wr_data.csv')
    te_df = pd.read_csv('te_data.csv')

    qb_df["pos"] = "QB"
    rb_df["pos"] = "RB"
    wr_df["pos"] = "WR"
    te_df["pos"] = "TE"

    cols = [list(qb_df.columns), list(rb_df.columns), list(wr_df.columns), list(te_df.columns)]

    fat_col = list(set(cols[0] + cols[1] + cols[2] + cols[3]))

    print(fat_col)
    print(len(fat_col))

    for col in cols:
        print(len(col))
    print(cols)

    #quit()

    all_pos_df = calculate_fantasy_points(combine(qb_df, rb_df, wr_df, te_df))

    all_pos_df.to_csv('MASTER_NFL_DATA.csv', index=False)

    print(all_pos_df["id"])


if __name__ == '__main__':
    main()