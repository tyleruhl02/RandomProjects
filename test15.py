import tkinter as tk
from tkinter import filedialog
import pandas as pd
import matplotlib.pyplot as plt

# Function to browse files
def browse_file():
    file_path = filedialog.askopenfilename(filetypes=[("CSV files", "*.csv")])
    if file_path:
        load_and_plot_data(file_path)

# Function to load and plot data
def load_and_plot_data(file_path):
    df = pd.read_csv(file_path)
    plt.figure()
    df.plot()
    plt.show()

# Setting up the Tkinter window
root = tk.Tk()
root.title("CSV File Browser")

# Adding a button to browse files
browse_button = tk.Button(root, text="Browse CSV File", command=browse_file)
browse_button.pack(pady=20)

# Running the Tkinter event loop
root.mainloop()