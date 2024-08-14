from pprint import pprint

you = "ImAwesome"

def get_data(file):
    with open(file, 'r') as f:
        text = f.read()
    return text.replace("you", you).replace("You", you)


def get_users(data):
    data = list(set([d[4:d.index(" ")] for d in data.split("\n")]))
    output = []
    for datum in data:
        if datum[0] == '_' or datum == "longest" or datum == "largest" or datum == "You":
            continue
        output.append(datum)
    return output


def parse_line(user, line):
    if user.startswith("_") or user.startswith("longest") or user.startswith("largest") or line.startswith("rolled") or line.startswith("moved") or line.startswith("wants") or line.startswith("placed") or line.startswith("used"):
        return

    return_dict = {user: {"ore": 0, "grain": 0, "lumber": 0, "wool": 0, "brick": 0, "misc": 0}}

    if line.startswith("received") or line.startswith("got"):
        line = line.split(" ")
        return_dict[user]["ore"] = line.count("ore")
        return_dict[user]["grain"] = line.count("grain")
        return_dict[user]["lumber"] = line.count("lumber")
        return_dict[user]["wool"] = line.count("wool")
        return_dict[user]["brick"] = line.count("brick")
        return return_dict

    if line.startswith("built"):
        line = line.split(" ")
        if line[2] == "road":
            return_dict[user]["brick"] = -1
            return_dict[user]["lumber"] = -1
        if line[2] == "settlement":
            return_dict[user]["brick"] = -1
            return_dict[user]["lumber"] = -1
            return_dict[user]["wool"] = -1
            return_dict[user]["grain"] = -1
        if line[2] == "city":
            return_dict[user]["grain"] = -2
            return_dict[user]["ore"] = -3
        return return_dict

    if line.startswith("bought"):
        return_dict[user]["grain"] = -1
        return_dict[user]["ore"] = -1
        return_dict[user]["wool"] = -1
        return return_dict

    if line.startswith("discarded"):
        line = line.split(" ")
        return_dict[user]["ore"] = -line.count("ore")
        return_dict[user]["grain"] = -line.count("grain")
        return_dict[user]["lumber"] = -line.count("lumber")
        return_dict[user]["wool"] = -line.count("wool")
        return_dict[user]["brick"] = -line.count("brick")
        return return_dict

    if line.startswith("gave bank"):
        line = line.split(" and took ")

        gave = line[0].split(" ")
        took = line[1].split(" ")

        return_dict[user]["ore"] += took.count("ore")
        return_dict[user]["grain"] += took.count("grain")
        return_dict[user]["lumber"] += took.count("lumber")
        return_dict[user]["wool"] += took.count("wool")
        return_dict[user]["brick"] += took.count("brick")

        return_dict[user]["ore"] += -gave.count("ore")
        return_dict[user]["grain"] += -gave.count("grain")
        return_dict[user]["lumber"] += -gave.count("lumber")
        return_dict[user]["wool"] += -gave.count("wool")
        return_dict[user]["brick"] += -gave.count("brick")

        return return_dict

    if line.startswith("gave"):
        line = line.split(" and got ")

        gave = line[0].split(" ")
        took = line[1].split(" ")
        other_user = took[-1]

        return_dict[user]["ore"] += took.count("ore")
        return_dict[user]["grain"] += took.count("grain")
        return_dict[user]["lumber"] += took.count("lumber")
        return_dict[user]["wool"] += took.count("wool")
        return_dict[user]["brick"] += took.count("brick")

        return_dict[user]["ore"] += -gave.count("ore")
        return_dict[user]["grain"] += -gave.count("grain")
        return_dict[user]["lumber"] += -gave.count("lumber")
        return_dict[user]["wool"] += -gave.count("wool")
        return_dict[user]["brick"] += -gave.count("brick")

        return_dict[other_user] = {"ore": 0, "grain": 0, "lumber": 0, "wool": 0, "brick": 0, "misc": 0}

        return_dict[other_user]["ore"] += gave.count("ore")
        return_dict[other_user]["grain"] += gave.count("grain")
        return_dict[other_user]["lumber"] += gave.count("lumber")
        return_dict[other_user]["wool"] += gave.count("wool")
        return_dict[other_user]["brick"] += gave.count("brick")

        return_dict[other_user]["ore"] += -took.count("ore")
        return_dict[other_user]["grain"] += -took.count("grain")
        return_dict[other_user]["lumber"] += -took.count("lumber")
        return_dict[other_user]["wool"] += -took.count("wool")
        return_dict[other_user]["brick"] += -took.count("brick")

        return return_dict

    if line.startswith("stole") and line.find("from") != -1:
        line = line.split(" ")
        other_user = line[-1]
        card = line[1].replace("card", "misc")

        return_dict[user][card] = 1
        return_dict[other_user] = {"ore": 0, "grain": 0, "lumber": 0, "wool": 0, "brick": 0, "misc": 0}
        return_dict[other_user][card] = -1

        return return_dict

    return -1

    #print(line)

    #print(line)
    #quit()
    #if(line.starts)


def update_hands(hands, turn_outcome):
    for key in turn_outcome.keys():
        hands[key]["ore"] += turn_outcome[key]["ore"]
        hands[key]["grain"] += turn_outcome[key]["grain"]
        hands[key]["lumber"] += turn_outcome[key]["lumber"]
        hands[key]["wool"] += turn_outcome[key]["wool"]
        hands[key]["brick"] += turn_outcome[key]["brick"]
        hands[key]["misc"] += turn_outcome[key]["misc"]

    return hands

def main():
    data = get_data(file)
    users = get_users(data)
    hands = {}
    for user in users:
        hands[user] = {"ore": 0, "grain": 0, "lumber": 0, "wool": 0, "brick": 0, "misc": 0}

    data = data.split("\n")

    for index, line in enumerate(data):
        if index in [0, 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 13, 14, 16, 17, 19]:  # starting lines
            continue
        line = line.split(" ", 1)
        user = line[0][4:]
        turn_outcome = parse_line(user, line[1])
        print(turn_outcome)
        if turn_outcome == -1:                          # MONOPOLY
            line = line[1].split(" ")
            for key in hands.keys():
                if key == user:
                    hands[user][line[-1]] += int(line[1])
                else:
                    hands[key][line[-1]] = 0
            pprint(hands)
        elif turn_outcome == None:
            pass
        else:
            hands = update_hands(hands, turn_outcome)

    pprint(hands)

if __name__ == '__main__':
    file = "data.txt"
    main()