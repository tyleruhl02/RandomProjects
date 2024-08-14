import random
import time
import threading
import logging
import os

logging.basicConfig(level=logging.INFO)
logger = logging.getLogger(os.path.basename(__file__))

zero = {}
one = {}
two = {}
three = {}
four = {}
five = {}
six = {}
seven = {}
eight = {}
nine = {}
ten = {}
eleven = {}
twelve = {}
thirteen = {}

class Player:
    def __init__(self, name, str):
        str = str.split("\t")
        self.name = name
        self.age = int(str[0])
        self.games = int(str[1])
        self.pas = int(str[2])
        self.abs = int(str[3])
        self.runs = int(str[4])
        self.hits = int(str[5])
        self.doubles = int(str[6])
        self.triples = int(str[7])
        self.hrs = int(str[8])
        self.singles = self.hits - self.doubles - self.triples - self.hrs
        self.rbis = int(str[9])
        self.sbs = int(str[10])
        self.walks = int(str[11])
        self.sos = int(str[12])
        self.ba = float(str[13])
        self.obp = float(str[14])
        self.slg = float(str[15])
        self.ops = float(str[16])

        self.walk_percentage = self.walks / self.pas
        self.single_percentage = self.singles / self.abs
        self.double_percentage = self.doubles / self.abs
        self.triple_percentage = self.triples / self.abs
        self.hrs_percentage = self.hrs / self.abs
        self.so_percentage = self.sos / self.abs

    def take_bat(self):
        num = random.random()
        if num < self.walk_percentage:
            return "walk"

        num = random.random()
        if num < self.single_percentage:
            return "single"
        num -= self.single_percentage
        if num < self.double_percentage:
            return "double"
        num -= self.double_percentage
        if num < self.triple_percentage:
            return "triple"
        num -= self.triple_percentage
        if num < self.hrs_percentage:
            return "hr"
        num -= self.hrs_percentage
        if num < self.so_percentage:
            return "so"

        num -= self.so_percentage
        #if num < 0.01:
        #    return "random"

        return "out"


    def __str__(self):
        print("Player Age:", self.age)
        print("Player Games:", self.games)
        print("Player Pas:", self.pas)
        print("Player Abs:", self.abs)
        print("Player Runs:", self.runs)
        print("Player Hits:", self.hits)
        print("Player Singles:", self.singles)
        print("Player Doubles:", self.doubles)
        print("Player Triples:", self.triples)
        print("Player HRs:", self.hrs)
        print("Player SBs:", self.sbs)
        print("Player Walks:", self.walks)
        print("Player Sos:", self.sos)
        print("Player Ba:", self.ba)
        print("Player Obp:", self.obp)
        print("Player SLg:", self.slg)
        print("Player Ops:", self.ops)
        return self.name

    def __repr__(self):
        return self.name


Oswaldo_Cabrera = Player("Oswaldo Cabrera", "25	81	260	239	34	58	8	0	6	31	3	16	52	.243	.290	.351	.641	24	81")
Aaron_Judge = Player("Aaron Judge", "32	106	468	376	81	117	25	1	38	97	5	83	115	.311	.442	.686	1.128	113	106")
Juan_Soto = Player("Juan Soto", "25	104	473	382	86	117	22	4	27	75	5	85	74	.306	.431	.597	1.028	98	104")
Giancarlo_Stanton = Player("Giancarlo Stanton", "34	70	285	263	34	63	10	0	18	44	0	21	90	.240	.298	.483	.781	37	70")
Ben_Rice = Player("Ben Rice", "25	34	130	110	15	23	6	0	7	22	0	15	34	.209	.300	.455	.755	15	34")
Anthony_Volpe = Player("Anthony Volpe", "23	107	481	445	67	112	19	7	9	38	18	30	102	.252	.303	.387	.689	51	107")
Alex_Verdugo = Player("Alex Verdugo", "28	104	435	393	47	92	23	1	10	46	1	33	68	.234	.290	.374	.664	43	104")
Austin_Wells = Player("Austin Wells", "24	71	236	198	29	47	10	1	8	26	1	30	46	.237	.336	.419	.755	28	71")
Jazz_Chisolm = Player("Jazz Chisolm", "26	103	430	388	43	92	13	4	14	47	21	37	109	.237	.309	.399	.709	47	103")
Gleyber_Torres = Player("Gleyber Torres", "27	102	421	370	46	87	18	0	10	40	4	41	94	.235	.313	.365	.678	42	102")
DJ_LeMehieu = Player("DJ LeMehieu", "35	46	159	138	12	24	3	0	1	13	0	17	26	.174	.266	.217	.483	8	46")
Anthony_Rizzo = Player("Anthony Rizzo", "34	70	290	263	31	58	7	0	8	27	0	19	48	.221	.286	.338	.625	24	70")
Trent_Grisham = Player("Trent Grisham", "27	59	158	135	16	25	7	0	6	20	1	18	41	.185	.291	.370	.662	14	59")

Roster = [Oswaldo_Cabrera, Aaron_Judge, Juan_Soto, Giancarlo_Stanton, Ben_Rice, Anthony_Volpe, Alex_Verdugo, Austin_Wells, Jazz_Chisolm, Gleyber_Torres, DJ_LeMehieu, Anthony_Rizzo, Trent_Grisham]
Lineup1 = [Anthony_Volpe, Juan_Soto, Aaron_Judge, Giancarlo_Stanton, Jazz_Chisolm, Austin_Wells, Alex_Verdugo, Gleyber_Torres, Ben_Rice]
Lineup2 = [Trent_Grisham, Anthony_Rizzo, Gleyber_Torres, Alex_Verdugo, Anthony_Volpe, Ben_Rice, Oswaldo_Cabrera, DJ_LeMehieu, Austin_Wells]

def get_outcome(bases, hit, second_to_home=False, first_to_third=False, first_to_home=False):
    runs = 0

    if first_to_third == True and second_to_home == False:
        first_to_third = False

    if hit == "walk":
        if bases[2]:
            runs += 1

        bases[2] = bases[1]
        bases[1] = bases[0]
        bases[0] = True

    if hit == "single":
        if bases[2]:
            runs += 1
            bases[2] = False

        if bases[1]:
            if second_to_home:
                runs += 1
                bases[1] = False
            else:
                bases[1]= False
                bases[2] = True

        if bases[0]:
            if first_to_third:
                bases[2] = True
            else:
                bases[1] = True

        bases[0] = True


    elif hit == "double":
        if bases[2]:
            runs += 1
            bases[2] = False

        if bases[1]:
            runs += 1

        if bases[0]:
            if first_to_home:
                runs += 1
                bases[0] = False
            else:
                bases[0] = False
                bases[2] = True

        bases[1] = True

    elif hit == "triple":
        if bases[2]:
            runs += 1

        if bases[1]:
            runs += 1
            bases[1] = False

        if bases[0]:
            runs += 1
            bases[0] = False

        bases[2] = True

    elif hit == "hr":
        if bases[2]:
            runs += 1
            bases[2] = False

        if bases[1]:
            runs += 1
            bases[1] = False

        if bases[0]:
            runs += 1
            bases[0] = False

        runs += 1

    return runs, bases


def play_game(Lineup, debug=False, sleep=0):
    inning = 1
    up = 0
    runs = 0
    walks = 0
    singles = 0
    doubles = 0
    triples = 0
    hrs = 0
    bases = [False, False, False]
    outs = 0
    while inning < 10:
        result = Lineup[up].take_bat()
        if result == "out" or result == "so":
            outs += 1
            #print(result)
            #print("outs: ", outs)
            if outs == 3:
                bases = [False, False, False]
                outs = 0
                inning += 1
        else:
            rbis, bases = get_outcome(bases, result)
            runs += rbis
            if result == "single":
                singles += 1
            elif result == "double":
                doubles += 1
            elif result == "triple":
                triples += 1
            elif result == "hr":
                hrs += 1
            elif result == "walk":
                walks += 1
            #print(result)
            #print(rbis, bases)
        if debug:
            print("\nBATTER: " + Lineup[up].name)
            print("RESULT: " + result + "\n")
            print("INNING: " + str(inning))
            print("OUTS: " + str(outs))
            print("RUNS: " + str(runs))
            print("BASES: " + str(bases))
        up += 1
        up = up % 9
        time.sleep(sleep)
    return runs, singles, doubles, triples, hrs, walks

#str(Oswaldo_Cabrera)
#for i in range(100):
#    print(Oswaldo_Cabrera.take_bat())

def sim_set(num):
    logger.info(f"THREAD {num} STARTING.")

    top10 = {0: [], 1: [], 2: [], 3: [], 4: [], 5: [], 6: [], 7: [], 8: [], 9: []}

    start = {0: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9],
             1: [1, 0, 2, 3, 4, 5, 6, 7, 8, 9],
             2: [2, 0, 1, 3, 4, 5, 6, 7, 8, 9],
             3: [3, 0, 1, 2, 4, 5, 6, 7, 8, 9],
             4: [4, 0, 1, 2, 3, 5, 6, 7, 8, 9],
             5: [5, 0, 1, 2, 3, 4, 6, 7, 8, 9],
             6: [6, 0, 1, 2, 3, 4, 5, 7, 8, 9],
             7: [7, 0, 1, 2, 3, 4, 5, 6, 8, 9],
             8: [8, 0, 1, 2, 3, 4, 5, 6, 7, 9],
             9: [9, 0, 1, 2, 3, 4, 5, 6, 7, 8],
             10: [10, 0, 1, 2, 3, 4, 5, 6, 7, 8],
             11: [11, 0, 1, 2, 3, 4, 5, 6, 7, 8],
             12: [12, 0, 1, 2, 3, 4, 5, 6, 7, 8],
             13: [13, 0, 1, 2, 3, 4, 5, 6, 7, 8]}

    arr = start[num]

    while True:
        arr[-1] += 1
        for i in range(len(arr) - 1, -1, -1):
            if arr[i] >= len(Roster):
                arr[i] = 0
                arr[i-1] += 1
                if i == 5:
                    logger.info(arr)

        if arr[0] != num:
            break

        if len(arr) == len(set(arr)):
            #logger.info(arr)
            runs = 0
            lineup = [Roster[arr[i]] for i in range(9)]
            for i in range(1000):
                runs += play_game(lineup)[0]

            if runs > min(top10.keys()):
                del top10[min(top10.keys())]
                top10[runs] = lineup

    logger.info(f"THREAD: {num} ENDING.")


    """for lineup in lineups:
        runs = 0
        lineup = [Roster[lineups[i]] for i in range(9)]
        for i in range(1000):
            runs += play_game(lineup)[0]

        if runs > min(top10.keys()):
            del top10[min(top10.keys())]
            top10[runs] = lineup"""

    if num == 0:
        global zero
        zero = top10
    elif num == 1:
        global one
        one = top10
    elif num == 2:
        global two
        two = top10
    elif num == 3:
        global three
        three = top10
    elif num == 4:
        global four
        four = top10
    elif num == 5:
        global five
        five = top10
    elif num == 6:
        global six
        six = top10
    elif num == 7:
        global seven
        seven = top10
    elif num == 8:
        global eight
        eight = top10
    elif num == 9:
        global nine
        nine = top10
    elif num == 10:
        global ten
        ten = top10
    elif num == 11:
        global eleven
        eleven = top10
    elif num == 12:
        global twelve
        twelve = top10
    elif num == 13:
        global thirteen
        thirteen = top10




def main():
    """arr = list()
    with open("uhl_test.txt") as infile:
        text = infile.read()
        text = "[" + text[:-2] + "]"
        arr = eval(text)

    mid_time = time.time()

    arr2 = [[el for el in arr if el[0] == i] for i in range(13)]
    print(arr)
    print(arr2)

    end_time = time.time()

    print(start_time)
    print(mid_time)
    print(end_time)

    quit()"""

    logger.info("START")

    t0 = threading.Thread(target=sim_set, args=(0,))
    t1 = threading.Thread(target=sim_set, args=(1,))
    t2 = threading.Thread(target=sim_set, args=(2,))
    t3 = threading.Thread(target=sim_set, args=(3,))
    t4 = threading.Thread(target=sim_set, args=(4,))
    t5 = threading.Thread(target=sim_set, args=(5,))
    t6 = threading.Thread(target=sim_set, args=(6,))
    t7 = threading.Thread(target=sim_set, args=(7,))
    t8 = threading.Thread(target=sim_set, args=(8,))
    t9 = threading.Thread(target=sim_set, args=(9,))
    t10 = threading.Thread(target=sim_set, args=(10,))
    t11 = threading.Thread(target=sim_set, args=(11,))
    t12 = threading.Thread(target=sim_set, args=(12,))

    t0.start()
    t1.start()
    t2.start()
    t3.start()
    t4.start()
    t5.start()
    t6.start()
    t7.start()
    t8.start()
    t9.start()
    t10.start()
    t11.start()
    t12.start()

    t0.join()
    t1.join()
    t2.join()
    t3.join()
    t4.join()
    t5.join()
    t6.join()
    t7.join()
    t8.join()
    t9.join()
    t10.join()
    t11.join()
    t12.join()

    print("zero:")
    print(zero)
    print("one:")
    print(one)
    print("two:")
    print(two)
    print("three:")
    print(three)
    print("four:")
    print(four)
    print("five:")
    print(five)
    print("six:")
    print(six)
    print("seven:")
    print(seven)
    print("eight:")
    print(eight)
    print("nine:")
    print(nine)
    print("ten:")
    print(ten)
    print("eleven:")
    print(eleven)
    print("twelve:")
    print(twelve)



"""def main():
    top10 = {0: [], 1: [], 2: [], 3: [], 4: [], 5: [], 6: [], 7: [], 8: [], 9: []}
    lineups = [0, 1, 2, 3, 4, 5, 6, 7, 8]

    start_time = time.time()

    while lineups[0] < len(Roster):
        lineups[-1] += 1
        for i in range(len(lineups)-1, 0, -1):
            if lineups[i] == len(Roster):
                if i == 0:
                    break
                lineups[i] = 0
                lineups[i-1] += 1

        if len(lineups) == len(set(lineups)):
            runs = 0
            lineup = [Roster[lineups[i]] for i in range(9)]
            for i in range(1000):
                runs += play_game(lineup)[0]

            if runs > min(top10.keys()):
                del top10[min(top10.keys())]
                top10[runs] = lineup

        if round(time.time() - start_time, 1) % 60 == 0:
            print("START: " + str(start_time))
            print("ELAPSED: " + str(time.time() - start_time))
            print(lineups)

    end_time = time.time()
    print("START TIME: " + str(start_time))
    print("END TIME: " + str(end_time))
    print("TOTAL TIME: " + str(end_time - start_time))

    print(top10)

    #print(list(countUp(0, (12, 12, 12, 12, 12, 12, 12, 12, 12), 13)))
    #print(list(countUp(0, (12, 12, 12), 13)))
    #print(list(countUp(0, (9, 9, 9), 10)))
    #print(list(countUp(start=0, end=(12, 12, 12, 12, 12, 12, 12, 12, 12), base=13)))
    #print(list(countUp(start=0, end=(12, 12, 12), base=13)))"""

if __name__ == '__main__':
    main()

#play_game(Lineup)