class bcolors:
    MAGENTA = '\033[95m'
    BLUE = '\033[94m'
    CYAN = '\033[96m'
    GREEN = '\033[92m'
    YELLOW = '\033[93m'
    RED = '\033[91m'
    ENDC = '\033[0m'
    BOLD = '\033[1m'
    UNDERLINE = '\033[4m'

import sys
import time

def print_percentage_meter(percent, length=200, print_time=False):

    output = ""

    if percent < 1/6:
        text = "#" * round(percent * length)
        output += f"[{bcolors.RED}{text.ljust(length)}{bcolors.ENDC}]"
        if print_time: print(output)
        return output

    text = "#" * round((1/6) * length)
    output += f"[{bcolors.RED}{text}{bcolors.ENDC}"

    if percent < 2/6:
        text = "#" * round((percent - (1/6)) * length)
        output += f"{bcolors.YELLOW}{text.ljust(round(length - (length * 1/6)))}{bcolors.ENDC}]"
        if print_time: print(output)
        return output

    text = "#" * round((1/6) * length)
    output += f"{bcolors.YELLOW}{text}{bcolors.ENDC}"

    if percent < 3/6:
        text = "#" * round((percent - (2/6)) * length)
        output += f"{bcolors.GREEN}{text.ljust(round(length - (length * 2/6)))}{bcolors.ENDC}]"
        if print_time: print(output)
        return output

    text = "#" * round((1/6) * length)
    output += f"{bcolors.GREEN}{text}{bcolors.ENDC}"

    if percent < 4/6:
        text = "#" * round((percent - (3/6)) * length)
        output += f"{bcolors.CYAN}{text.ljust(round(length - (length * 3/6)))}{bcolors.ENDC}]"
        if print_time: print(output)
        return output

    text = "#" * round((1/6) * length)
    output += f"{bcolors.CYAN}{text}{bcolors.ENDC}"

    if percent < 5/6:
        text = "#" * round((percent - (4/6)) * length)
        output += f"{bcolors.BLUE}{text.ljust(round(length - (length * 4/6)))}{bcolors.ENDC}]"
        if print_time: print(output)
        return output

    text = "#" * round((1/6) * length)
    output += f"{bcolors.BLUE}{text}{bcolors.ENDC}"

    if percent < 1:
        text = "#" * round((percent - (5/6)) * length)
        output += f"{bcolors.MAGENTA}{text.ljust(round(length - (length * 5/6)))}{bcolors.ENDC}]"
        if print_time: print(output)
        return output

    text = "#" * round((1/6) * length)
    output += f"{bcolors.MAGENTA}{text}{bcolors.ENDC}]"

    if print_time: print(output)
    return output


if __name__ == '__main__':
    for i in range(201):
        sys.stdout.write('\r' + print_percentage_meter(i / 200, 200, False))
        time.sleep(0.02)

"""
a = 0  
for x in range (0,3):
    a = a + 1
    b = ("Loading" + "." * a)
    # \r prints a carriage return first, so `b` is printed on top of the previous line.
    sys.stdout.write('\r'+b)
    time.sleep(0.5)
print (a)
"""