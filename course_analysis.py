import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import os
from pprint import pprint

import logging

class bcolors:
    CYAN = '\033[96m'
    MAGENTA = '\033[95m'
    BLUE = '\033[94m'
    YELLOW = '\033[93m'
    GREEN = '\033[92m'
    RED = '\033[91m'
    ENDC = '\033[0m'
    BOLD = '\033[1m'
    UNDERLINE = '\033[4m'

def special_print(color, text, end="\n"):
    print(f"{color}{text}{bcolors.ENDC}", end=end)

def red_print(text, end="\n"):
    print(f"{bcolors.RED}{text}{bcolors.ENDC}", end=end)

def green_print(text, end="\n"):
    print(f"{bcolors.GREEN}{text}{bcolors.ENDC}", end=end)

def blue_print(text, end="\n"):
    print(f"{bcolors.BLUE}{text}{bcolors.ENDC}", end=end)

def cyan_print(text, end="\n"):
    print(f"{bcolors.CYAN}{text}{bcolors.ENDC}", end=end)

def magenta_print(text, end="\n"):
    print(f"{bcolors.MAGENTA}{text}{bcolors.ENDC}", end=end)

def yellow_print(text, end="\n"):
    print(f"{bcolors.YELLOW}{text}{bcolors.ENDC}", end=end)

def custom_print(color, text, length):
    b4 = round((length - len(text)) / 2)
    special_print(color, "#" * b4, end="")
    print(text, end="")
    special_print(color, "#" * (length - b4 - len(text)), end="")

PATH = "courses"
CLUBS = "Driver-3 Iron-4 Iron-5 Iron-6 Iron-7 Iron-8 Iron-9 Iron-P Wedge-G Wedge-S Wedge-L Wedge".split("-")

CLUB_ACCURACY = {
    "Driver": 0.75,
    "3 Iron": 0.2,
    "4 Iron": 0.3,
    "5 Iron": 0.6,
    "6 Iron": 0.65,
    "7 Iron": 0.7,
    "8 Iron": 0.75,
    "9 Iron": 0.8,
    "P Wedge": 0.9,
    "G Wedge": 0.9,
    "S Wedge": 0.9,
    "L Wedge": 0.9,
}

CLUB_DISTANCES = {
    "Driver": 240,
    "3 Iron": 190,
    "4 Iron": 180,
    "5 Iron": 170,
    "6 Iron": 160,
    "7 Iron": 150,
    "8 Iron": 135,
    "9 Iron": 125,
    "P Wedge": 110,
    "G Wedge": 100,
    "S Wedge": 90,
    "L Wedge": 80,
}

def get_complex_par(temp, row, index):
    try:
        if(temp[row][index] < temp[row+1][index]):
            return temp[-3][index][0]
        else:
            return temp[-3][index][2]
    except:
        return temp[-3][index][2]


def get_sum(temp):
    sum = 0
    for key in temp.keys():
        sum += temp[key][1]
    return sum


def create_course(file):
    df = pd.read_csv(file)
    output = {}
    if len(df.columns) < 15:
        temp = df[df.columns].to_numpy().tolist()
        for i in range(len(temp)-3):
            tee_dict = {}
            for j in range(1, 10):
                try:
                    tee_dict[int(temp[-1][j])] = (int(temp[i][j]), int(temp[-3][j]), int(temp[-2][j]))
                except:
                    par = get_complex_par(temp, i, j)
                    tee_dict[int(temp[-1][j])] = (int(temp[i][j]), int(par), int(temp[-2][j]))
            try:
                tee_dict[0] = (int(temp[i][11]), get_sum(tee_dict), (temp[i][12], temp[i][13]))
            except:
                tee_dict[0] = (int(temp[i][11]), get_sum(tee_dict))
            output[temp[i][0]] = tee_dict
    else:
        temp = df[df.columns].to_numpy().tolist()
        for i in range(len(temp) - 3):
            tee_dict = {}
            for j in range(1, 10):
                try:
                    tee_dict[int(temp[-1][j])] = (int(temp[i][j]), int(temp[-3][j]), int(temp[-2][j]))
                except:
                    par = get_complex_par(temp, i, j)
                    tee_dict[int(temp[-1][j])] = (int(temp[i][j]), int(par), int(temp[-2][j]))
            for j in range(11, 20):
                try:
                    tee_dict[int(temp[-1][j])] = (int(temp[i][j]), int(temp[-3][j]), int(temp[-2][j]))
                except:
                    par = get_complex_par(temp, i, j)
                    tee_dict[int(temp[-1][j])] = (int(temp[i][j]), int(par), int(temp[-2][j]))
            try:
                tee_dict[0] = (int(temp[i][22]), get_sum(tee_dict), (temp[i][23], temp[i][24]))
            except:
                tee_dict[0] = (int(temp[i][22]), get_sum(tee_dict))
            output[temp[i][0]] = tee_dict

    return output


def get_courses():
    courses = {}
    for file in os.listdir(PATH):
        courses[file[:-4]] = create_course(os.path.join(PATH, file))

    return courses


def get_tees(courses):
    black = []
    white = []
    gold = []
    red = []
    for key in courses.keys():
        for tee in courses[key]:
            if tee == "Black Tee":
                black += (list(courses[key][tee].values()))
            if tee == "White Tee":
                white += (list(courses[key][tee].values()))
            if tee == "Gold Tee":
                gold += (list(courses[key][tee].values()))
            if tee == "Red Tee":
                red += (list(courses[key][tee].values()))

    return black, white, gold, red


def get_distance_histogram(data, index):
    colors = ["BLACK", "WHITE", "GOLD", "RED"]
    fig, ((ax0, ax1, ax2, ax3)) = plt.subplots(4, 1, figsize=(6, 10))
    bins = 12
    big = max(data[0][index])
    small = min(data[3][index])
    w = (big - small) / bins
    for i, ax in enumerate([ax0, ax1, ax2, ax3]):
        ax.hist(data[i][index], bins=np.arange(small, big+w, w))
        ax.set_title(colors[i] + " PAR " + str(index+3))
    #fig.tight_layout()
    plt.show()


def get_course_scatter(course_tee):
    distances = []
    pars = []
    handicaps = []
    for key in sorted(course_tee.keys())[1:]:
        distances.append(course_tee[key][0])
        pars.append(course_tee[key][1])
        handicaps.append(course_tee[key][2])

    print(distances)
    print(pars)
    print(handicaps)

    plt.scatter(distances, handicaps, c=pars)
    plt.legend()
    plt.show()
    # print(course_tee)


def print_combo(distance, combo, ratio=0.4):
    RATIO = ratio
    YARD_INTERVALS = 100

    sim_distance = round(distance*RATIO)


    for i in range(YARD_INTERVALS, distance, YARD_INTERVALS):
        print(f"{i}".rjust(round(YARD_INTERVALS * RATIO)), end="")
    print()
    yellow_print("#" * (sim_distance-5), end="")
    green_print("#" * 9)

    partial_sum = 0
    dists = [round(CLUB_DISTANCES[x] * RATIO - round(i/2 + 0.25)) for i, x in enumerate(combo[:-1])]
    for i in range(len(dists)):
        yellow_print("#" * (dists[i] - 2), end="")
        partial_sum += dists[i] + 1
        cyan_print("###", end="")
    green_print("#" * (sim_distance + 4 - partial_sum))

    partial_sum = 0
    dists = [round(CLUB_DISTANCES[x] * RATIO - round(i / 2 + 0.25)) for i, x in enumerate(combo[:-1])]
    for i in range(len(dists)):
        if combo[i] == "Driver":
            custom_print(bcolors.RED, combo[i], dists[i] - 2)
        elif "Iron" in combo[i]:
            custom_print(bcolors.MAGENTA, combo[i], dists[i] - 2)
        elif "Wedge" in combo[i]:
            custom_print(bcolors.BLUE, combo[i], dists[i] - 2)
        partial_sum += dists[i] + 1
        cyan_print("###", end="")
    green_print("#" * (sim_distance + 4 - partial_sum))

    """partial_sum = 0
    #yellow_print("#" * sum(dists))
    for i in range(len(combo) - 1):
        dist = round(CLUB_DISTANCES[combo[i]] * RATIO)
        partial_sum += dist
        if combo[i] == "Driver":
            red_print("#" * round(CLUB_DISTANCES[combo[i]] * RATIO - 1), end="")
        elif "Iron" in combo[i]:
            magenta_print("#" * round(CLUB_DISTANCES[combo[i]] * RATIO - 1), end="")
        elif "Wedge" in combo[i]:
            blue_print("#" * round(CLUB_DISTANCES[combo[i]] * RATIO - 1), end="")
        cyan_print("#", end="")
    green_print("#" * (sim_distance + 4 - partial_sum))"""

    partial_sum = 0
    dists = [round(CLUB_DISTANCES[x] * RATIO - round(i / 2 + 0.25)) for i, x in enumerate(combo[:-1])]
    for i in range(len(dists)):
        yellow_print("#" * (dists[i] - 2), end="")
        partial_sum += dists[i] + 1
        cyan_print("###", end="")
    green_print("#" * (sim_distance + 4 - partial_sum))

    """yellow_print("#" * (sim_distance-5), end="")
    green_print("#" * 9)"""
    #yellow_print("#" * (sim_distance-5), end="")
    #green_print("#" * 9)
    yellow_print("#" * (sim_distance-5), end="")
    green_print("#" * 9)

def play_a_hole(distance, par):
    accuracy = 1
    tee = True
    combos = []
    if par == 5:
        accuracy *= CLUB_ACCURACY["Driver"]
        distance -= CLUB_DISTANCES["Driver"]
        par -= 1
        tee = False
    if par == 4:
        keys = list(CLUB_DISTANCES.keys())
        for i in range(len(keys)):
            for j in range(i, len(keys)):
                if keys[i] == keys[j] or (not tee and keys[i] == "Driver"):
                    continue
                if abs(distance - (CLUB_DISTANCES[keys[i]] + CLUB_DISTANCES[keys[j]])) < 10:
                    likelihood = CLUB_ACCURACY[keys[i]] * CLUB_ACCURACY[keys[j]]
                    if tee:
                        combos.append([keys[i], keys[j], round(likelihood, 4)])
                    else:
                        combos.append(["Driver", keys[i], keys[j], round(likelihood*CLUB_ACCURACY["Driver"], 4)])
    if par == 3:
        min = 50
        club = ""
        for key in CLUB_DISTANCES.keys():
            if abs(distance - CLUB_DISTANCES[key]) < min:
                min = abs(distance - CLUB_DISTANCES[key])
                club = key
        combos.append([club, CLUB_ACCURACY[club]])
    return sorted(combos, key=lambda x : x[-1], reverse=True)

def play_a_course(course_tee):
    print(course_tee[1])
    play_a_hole(course_tee[1][0], course_tee[1][1])

    for i in range(1, 19):
        print(f"HOLE NUMBER {i}: {course_tee[i]}")
        combos = play_a_hole(course_tee[i][0], course_tee[i][1])
        print_combo(course_tee[i][0], combos[0])

def main():
    courses = get_courses()
    black, white, gold, red = get_tees(courses)
    blacks = [[x[0] for x in black if x[0] < 1000 and x[1] == 3], [x[0] for x in black if x[0] < 1000 and x[1] == 4], [x[0] for x in black if x[0] < 1000 and x[1] == 5]]
    whites = [[x[0] for x in white if x[0] < 1000 and x[1] == 3], [x[0] for x in white if x[0] < 1000 and x[1] == 4], [x[0] for x in white if x[0] < 1000 and x[1] == 5]]
    golds = [[x[0] for x in gold if x[0] < 1000 and x[1] == 3], [x[0] for x in gold if x[0] < 1000 and x[1] == 4], [x[0] for x in gold if x[0] < 1000 and x[1] == 5]]
    reds = [[x[0] for x in red if x[0] < 1000 and x[1] == 3], [x[0] for x in red if x[0] < 1000 and x[1] == 4], [x[0] for x in red if x[0] < 1000 and x[1] == 5]]
    tees = [blacks, whites, golds, reds]

    get_course_scatter(courses["Rutgers"]["White Tee"])
    #play_a_course(courses["Rutgers"]["White Tee"])

    #for i in range(len(tees[0])):
    #    get_distance_histogram(tees, i)

if __name__ == '__main__':
    main()
