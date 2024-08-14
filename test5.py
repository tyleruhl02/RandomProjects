import random as r
import numpy as np

def run_iteration(options, divider):
    choices = np.arange(options)
    magic_number = r.choice(choices)
    print()
    for i in range(len(choices)):
        if i % divider == 0:
            choices[i] = -1
    choices = choices[choices != -1]
    print(choices)


def run_simulation(options, divider, num_iterations):
    run_iteration(options, divider)


def main():
    run_simulation(60, 2, 1)


if __name__ == '__main__':
    main()
