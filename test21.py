import numpy as np
from sklearn.linear_model import LinearRegression
import pandas as pd

import scipy

my_y = [2, 5, 6, 10]
my_x = [19, 23, 22, 30]



slope, intercept, r_value, p_value, std_err = scipy.stats.linregress(my_x, my_y)

print(r_value ** 2)

quit()

#X = np.array([1, 1, 2, 3]).reshape(-1, 1)
#print(X)
# y = 1 * x_0 + 2 * x_1 + 3
#Y = np.array([1, 2, 3, 4]).reshape(-1, 1)
#print(Y)

X = np.array([[1], [1], [2], [2]])
print(X)
Y = np.dot(X, np.array([2])) + 3
print(Y)

reg = LinearRegression().fit(X, Y)
reg.score(X, Y)
reg.coef_
reg.intercept_
reg.predict(np.array([[3, 5]]))



"""df = pd.read_csv('bottle.csv')
df_binary = df[['Salnty', 'T_degC']]

# Taking only the selected two attributes from the dataset
df_binary.columns = ['Sal', 'Temp']
# display the first 5 rows
df_binary.head()"""