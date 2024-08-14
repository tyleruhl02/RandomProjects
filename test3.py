import requests
import pandas as pd
from bs4 import BeautifulSoup
import re
import logging
import os

BATTING_HEADERS = "Pos Name Age G PA AB R H 2B 3B HR RBI SB CS BB SO BA OBP SLG OPS OPS+ TB GDP HBP SH SF IBB".split()
PITCHING_HEADERS = "Pos Name Age W L W-L% ERA G GS GF CG SHO SV IP H R ER HR BB IBB SO HBP BK WP BF ERA+ FIP WHIP H9 HR9 BB9 SO9 SO/W".split()
TEAM = "NYY"
YEAR = "2024"

logging.basicConfig(level=logging.INFO)
logger = logging.getLogger(os.path.basename(__file__))

def getdata(url):
    r = requests.get(url)
    return r.text


def clean_name(name):
    name = name.replace("*", "").replace("#", "")
    special = name.find("(")
    if special != -1:
        name = name[:special-1]
    return name


def get_batters(arr):
    batters = []
    for player in arr:
        try:
            player_data = {}
            player_data["Pos"] = player[0]
            player_data["Name"] = clean_name(player[1])
            for i in range(2, len(BATTING_HEADERS)):
                player_data[BATTING_HEADERS[i]] = player[i]
            batters.append(player_data)
        except Exception as e:
            pass
    return batters


def get_pitchers(arr):
    pitchers = []
    for player in arr:
        try:
            player_data = {}
            player_data["Pos"] = player[0]
            player_data["Name"] = clean_name(player[1])
            for i in range(2, len(PITCHING_HEADERS)):
                player_data[PITCHING_HEADERS[i]] = player[i]
            pitchers.append(player_data)
        except Exception as e:
            pass
    return pitchers


"""def main(teams, start_year):
    master = {}
    for team in teams:
        master[team] = {}
    for i in range(start_year, 0, -1):
        #print(i)
        url = f"https://www.baseball-reference.com/teams/NYY/{i}.shtml"
        print(url)
        htmldata = getdata(url)
        soup = BeautifulSoup(htmldata, 'html.parser')
        tables = soup.find_all('table')
        print(tables)

        important_tables = []

        for table in tables:
            data = []
            table_body = table.find("tbody")
            rows = table_body.find_all('tr')
            for row in rows:
                cols = row.find_all('td')
                cols = [ele.text.strip() for ele in cols]
                data.append([ele for ele in cols if ele])

            print(data)
            if len(data) > 10:
                important_tables.append(data)

        if len(important_tables) < 2:
            print(important_tables)
            break"""


"""if __name__ == "__main__":
    teams = "NYY BAL BOS TOR TBR CLE KCR MIN DET CHW SEA TEX HOU LAA OAK PHI ATL WSN NYM MIA MIL STL CIN CHC PIT LAD SDP SFG ARI COL".split()
    start_year = 2024
    main(teams, start_year)"""

TEAMS_MLB_DOT_COM = [
    "baltimore-orioles",
    "boston-red-sox",
    "chicago-white-sox",
    "cleveland-guardians",
    "detroit-tigers",
    "houston-astros",
    "kansas-city-royals",
    "los-angeles-angels",
    "minnesota-twins",
    "new-york-yankees",
    "oakland-athletics",
    "seattle-mariners",
    "tampa-bay-rays",
    "texas-rangers",
    "toronto-blue-jays",
    "arizona-diamondbacks",
    "atlanta-braves",
    "chicago-cubs",
    "cincinnati-reds",
    "colorado-rockies",
    "los-angeles-dodgers",
    "miami-marlins",
    "milwaukee-brewers",
    "new-york-mets",
    "philadelphia-phillies",
    "pittsburgh-pirates",
    "san-diego-padres",
    "san-francisco-giants",
    "st-louis-cardinals",
    "washington-nationals"
]

HITTING_STATS = "TEAM G AB R H 2B 3B HR RBI BB SO SB CS AVG OBP SLG OPS".split()

def print_master(master):
    for team in sorted(master.keys()):
        print(team)
        for year in sorted(master[team].keys()):
            print("\t" + str(year))
            for player in sorted(master[team][year].keys()):
                print("\t\t" + "{:<19}".format(str(player)) + ": " + str(master[team][year][player]))

def main(start_year, end_year, teams):
    master = {}
    for team in teams:
        master[team] = {}
        #print(team)
        logger.info(team)
        for year in range(start_year, end_year+1):
            master[team][year] = {}
            #print(year)
            logger.info(year)
            url = f"https://www.mlb.com/stats/{team}/{year}?playerPool=ALL"
            htmldata = getdata(url)
            soup = BeautifulSoup(htmldata, "html.parser")

            names = []
            positions = []
            data = []

            try:
                aaas = soup.find_all('a')
                good = []
                for aaa in aaas:
                    if str(aaa).startswith("<a aria-label="):
                        good.append(aaa)
                for i in range(1, len(good) - 1):
                    names.append(str(good[i])[15:str(good[i]).find('"', 16)])

                divs = soup.find_all('div')
                good = []
                for div in divs:
                    if str(div).startswith('<div class="position-SAxuJGcx">'):
                        good.append(div)
                for i in range(len(good)):
                    positions.append(str(good[i])[str(good[i]).find(">")+1:str(good[i]).find("<", 3)])

                table = soup.find('table')
                table_body = table.find("tbody")
                rows = table_body.find_all('tr')
                for row in rows:
                    cols = row.find_all('td')
                    cols = [ele.text.strip() for ele in cols]
                    data.append([ele for ele in cols if ele])

            except Exception as e:
                pass

            if len(data) != len(names) != len(positions):
                continue

            for i in range(len(names)):
                player_dict = {}
                for j in range(1, len(data[i])):
                    player_dict[HITTING_STATS[j]] = data[i][j]
                player_dict["POS"] = positions[i]
                master[team][year][names[i]] = player_dict

            #print(master[team][year])

    print_master(master)
            #print(master[team][year])

if __name__ == '__main__':
    main(1876, 2023, TEAMS_MLB_DOT_COM)



"""htmldata = getdata("https://www.mlb.com/stats/new-york-yankees/2023?playerPool=ALL")
soup = BeautifulSoup(htmldata, 'html.parser')
#print(soup.get_text)
tables = soup.find_all('table')
aaas = soup.find_all('a')
good = []
for aaa in aaas:
    if str(aaa).startswith("<a aria-label="):
        good.append(aaa)
        print(aaa)
names = []
for i in range(1, len(good)-1):
    names.append(str(good[i])[15:str(good[i]).find('"', 16)])
print(names)
#print(good)
#haha = soup.text.split('<a aria-label="')
#print(haha[1])
#print(tables[0])
#tables = tables[0].split('<div class="index-qx7H9R5s">')
#print(tables)
#quit()
#important_tables = []
for table in tables:
    data = []
    table_body = table.find("tbody")

    rows = table_body.find_all('tr')
    for row in rows:
        cols = row.find_all('td')
        cols = [ele.text.strip() for ele in cols]
        data.append([ele for ele in cols if ele])

    #if len(data) > 10:
    #    important_tables.append(data)
    print(data)
    print(len(data))

print(len(names))

quit()

batters = get_batters(important_tables[0])
pitchers = get_pitchers(important_tables[1])
for batter in batters:
    print(batter)

for pitcher in pitchers:
    print(pitcher)
"""