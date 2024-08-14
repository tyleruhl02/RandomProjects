import matplotlib.pyplot as plt
import numpy as np

"""data = {"Precision": 0.78, "Recall": 0.82, "F1": 0.8}

labels = list(data.keys())
values = list(data.values())

fig, ax = plt.subplots(figsize=(10, 10))
ax.bar(labels, values)
colors = ["blue", "orange", "grey"]
plt.xticks(fontsize=20)
for i, patch in enumerate(ax.patches):
    patch.set_color(colors[i])
    plt.text(patch.get_x() + 0.33, patch.get_y() + patch.get_height() + 0.01, str(round(patch.get_height(), 3)), fontsize=15)
plt.yticks(np.arange(0, 1.01, 0.1))
plt.text(-0.4, -0.1, "FP COUNT", fontsize=16)
plt.show()"""
"""
x = list(np.arange(11) / 4)

print(x)"""

global TITLE

with open("TEST.csv", "a") as outfile:
    outfile.write("3,4,7,3,6")
    outfile.write("5,2,6,3,6")

def main():
    TITLE = "TEST.csv"


thresholds = [0, 2.1]

thresholds = str(thresholds).replace(" ", "")[1:-1]
print(thresholds)

#print(",".join(thresholds))
