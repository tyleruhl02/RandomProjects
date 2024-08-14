import requests
import pandas as pd
from bs4 import BeautifulSoup
import re
import logging
import os
import time
from pprint import pprint
import json

logging.basicConfig(level=logging.INFO)
logger = logging.getLogger(os.path.basename(__file__))

def getdata(url):
    r = requests.get(url)
    return r.text

def get_te(id):
    first_letter = id[0]

    te_data = {}
    te_data_text = ""

    important_keys = ["game_num",
                      "week_num",
                      "age",
                      "rush_att",
                      "rush_yds",
                      "rush_td",
                      "targets",
                      "rec",
                      "rec_yds",
                      "rec_td",
                      "catch_pct",
                      "fumbles",
                      "fumbles_lost",
                      "offense",
                      "off_pct"]

    for year in range(2011, 2024, 1):
        url = f"https://www.pro-football-reference.com/players/{first_letter}/{id}/gamelog/{year}/"  # CHANGE URL HERE
        htmldata = getdata(url)
        soup = BeautifulSoup(htmldata, "html.parser")

        data = str(soup.find_all("table")).split("\n")

        pattern = r'data-stat="([^"]+)">([^<]+)<'

        season = {}

        for ele in data:
            if 'data-stat="game_date"' in ele and 'csk' in ele:
                game = {}

                matches = re.findall(pattern, ele)

                for match in matches:                               # IMPORTANT STATS
                    if match[0] in important_keys:
                        try:
                            game[match[0]] = int(match[1])
                        except ValueError:
                            try:
                                game[match[0]] = float(match[1])
                            except ValueError:
                                game[match[0]] = match[1]


                ele = ele.split('.htm">', 1)[1]         # DATE
                ele = ele.split("</a>", 1)
                game["game_date"] = ele[0]
                ele = ele[1]

                ele = ele.split('.htm">', 1)[1]         # TEAM
                ele = ele.split("</a>", 1)
                game["team"] = ele[0]
                ele = ele[1]

                ele = ele.split('.htm">', 1)            # HOME/AWAY
                if "@" in ele[0]:
                    game["home"] = False
                else:
                    game["home"] = True
                ele = ele[1]

                ele = ele.split("</a>", 1)              # OPP
                game["opp"] = ele[0]
                ele = ele[1]

                ele = ele.split('.htm">', 1)[1]         # RESULT
                ele = ele.split("</a>", 1)
                game["game_result"] = ele[0]
                ele = ele[1]

                if "Did Not Play" in ele:                           # DNP
                    game["played"] = "Did Not Play"

                if "Inactive" in ele:                               # INACTIVE
                    game["played"] = "Inactive"

                if "*" in ele:                                      # GAME STARTED
                    game["gs"] = True
                else:
                    game["gs"] = False

                season[game["week_num"]] = game

        te_data[year] = season
        logger.info(f"{id}: {year}")
        time.sleep(2.5)

    return te_data

def main():
    with open("te_ids.csv") as infile:
        data = infile.read().split("\n")[1:]

    tes = {}

    counter = 0

    for row in data:
        try:
            row = row.split(",")
            first_name = row[1]
            last_name = row[0]
            id = row[2]
            te_data = get_te(id)
            tes[id] = {"last": last_name, "first": first_name, "data": te_data}
            counter += 1
        except Exception as e:
            pass

    with open("te_data.json", "w") as outfile:
        json.dump(tes, outfile)


    #print(data)


if __name__ == '__main__':
    main()