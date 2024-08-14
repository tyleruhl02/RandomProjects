from tkinter import *
from pandastable import Table, TableModel

import warnings
warnings.simplefilter(action='ignore', category=FutureWarning)

import pandas as pd

class TestApp(Frame):
    def __init__(self, parent=None):
        self.parent = parent
        Frame.__init__(self)
        self.main = self.master
        self.main.geometry('600x400+200+100')
        self.main.title('Table app')
        f = Frame(self.main)
        f.pack(fill=BOTH,expand=1)
        #df = TableModel.getSampleData()
        #print(df)
        #print(type(df))
        df = pd.read_csv("courses/Darlington.csv")
        self.table = pt = Table(f, dataframe=df, showtoolbar=True, showstatusbar=True)
        pt.show()
        return

app = TestApp()
app.mainloop()