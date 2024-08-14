import requests
import pandas as pd
from bs4 import BeautifulSoup
import re
import logging
import os
import time

logging.basicConfig(level=logging.INFO)
logger = logging.getLogger(os.path.basename(__file__))

def getdata(url):
    r = requests.get(url)
    return r.text

def main():
    #url = "https://www.pro-football-reference.com/years/2023/passing.htm"
    #url = "https://www.pro-football-reference.com/years/2023/rushing.htm"
    url = "https://www.pro-football-reference.com/years/2023/receiving.htm" # CHANGE URL HERE
    htmldata = getdata(url)
    soup = BeautifulSoup(htmldata, "html.parser")

    data = str(soup.find_all("table")).split("\n")

    qbs_ids = []

    for item in data:
        if 'csk="' in item and "TE" in item:    # CHANGE POSITION HERE
            item = item.split('csk="')[2]
            item = item.split('" data-append-csv="')
            item[1] = item[1].split('"')[0]
            print(item)
            qbs_ids.append(item)
            #time.sleep(1)

    with open("te_ids.csv", "w") as f:              # CHANGE FILENAME HERE
        f.write("last,first,id\n")
        for item in qbs_ids:
            f.write(",".join(item) + "\n")

            #start = print(item.find('data-append-csv="'))

    #print(soup)

if __name__ == '__main__':
    main()