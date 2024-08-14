import argparse
import matplotlib.pyplot as plt
import numpy as np
import pandas
import pandas as pd
import os
import logging
import random as r
from matplotlib.colors import LinearSegmentedColormap


human_labels = "A B C D E F G H".split()
computer_labels = "A B C D E F G H I J K".split()

data = []
for i in range(10000):
    data.append([r.choice(human_labels), r.choice(computer_labels)])

df = pandas.DataFrame(data, columns=["human_labels", "computer_labels"])
print(df)

df2 = pandas.DataFrame(columns=computer_labels, index=human_labels)
df3 = pandas.DataFrame(columns=computer_labels, index=human_labels)
for human_behavior in human_labels:
    human_df = df[df["human_labels"] == human_behavior]
    human_count = human_df["human_labels"].count()
    for computer_behavior in computer_labels:
        computer_count = human_df[human_df["computer_labels"] == computer_behavior]["computer_labels"].count()
        df2.loc[human_behavior, computer_behavior] = computer_count
        df3.loc[human_behavior, computer_behavior] = computer_count / human_count * 10000
print(df2)

print(df3.to_numpy())
fake_heat_map = df3.to_numpy().astype(int)
#fake_heat_map = (np.random.rand(len(human_labels), len(computer_labels)) * 100).round().astype(int)
print(fake_heat_map)

colors = [(1, 0, 0), (0.8, 0.8, 0), (0, 1, 0)]  # Red to Green
#colors = [(0, 0, 0), (0, 0, 1), (0, 1, 1), (0, 1, 0), (1, 1, 0), (1, 0, 0), (1, 0, 1), (1, 1, 1)]

# Create a colormap object
cmap = LinearSegmentedColormap.from_list("custom_red_green", colors)

fig, ax = plt.subplots(figsize=(10, 10))
im = ax.imshow(fake_heat_map, cmap=cmap)

ax.set_xticks(np.arange(len(computer_labels)), labels=computer_labels)
ax.set_yticks(np.arange(len(human_labels)), labels=human_labels)

plt.setp(ax.get_xticklabels(), rotation=45, ha="right", rotation_mode="anchor")

for i in range(len(human_labels)):
    for j in range(len(computer_labels)):
        text = ax.text(j, i, (fake_heat_map[i, j] / 100), ha="center", va="center", color="k", fontsize=20)

ax.set_title("Fake Heat Map", fontsize=20)
fig.tight_layout()
#fig.savefig("Fake Heat Map.png")
plt.show()

#im.savefig("test4.png")

plt.savefig("test4.png", arr=im)

#plt.savefig("test4.png")
#plt.savefig("Fake Heat Map.jpg", bbox_inches="tight", dpi=150)

#fig2 = plt.figure(figsize=(11, 11), facecolor="cyan", edgecolor="black", layout="constrained")
#fig2.add_axes(ax)
#fig2.savefig("Fake Heat Map.png")

