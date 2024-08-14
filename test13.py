import numpy as np
import matplotlib.pyplot as plt

arr1 = np.random.rand(100, 1)

arr1 = (arr1 + 1) / 2

plt.scatter(np.arange(0, 100, 1), arr1[:, 0], c='blue')
plt.ylim(0, 1)
plt.show()