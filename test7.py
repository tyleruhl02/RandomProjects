import numpy as np
import matplotlib.pyplot as plt

arr = np.random.rand(1000000)
arr = (arr * 100).round()

quarters = [round(x // 25) for x in arr]
arr = arr % 25
dimes = [round(x // 10) for x in arr]
arr = arr % 10
nickels = [round(x // 5) for x in arr]
arr = arr % 5
pennies = [round(x // 1) for x in arr]
arr = arr % 1

def average(lst):
    return sum(lst) / len(lst)

print(average(quarters))
print(average(dimes))
print(average(nickels))
print(average(pennies))

#print(arr)

guess = 3341 * (0.01 * (2/4.72)) + 3341 * (0.05 * (0.4/4.72)) + 3341 * (0.1 * (0.8/4.72)) + 3341 * (0.25 * (1.52/4.72))

print("Guess = " + str(guess))

plt.hist(pennies)
plt.show()