import numpy as np

window = 3

pred = np.random.randint(5, size=100)
pred = np.where(pred < 1, 1, 0)

GT = np.random.randint(20, size=100)
GT = np.where(GT < 1, 1, 0)

#print(arr1)
#print(sum(arr1[arr1 == 1]))

print("i, GT, pred")
for i in range(100):
    print(i, GT[i], pred[i])

for i in range(len(GT)):
    if GT[i] == 1:
        for j in range(max(i - window, 0), min(i + window + 1, len(GT))):
            if pred[j] == 1:
                pred[i], pred[j] = pred[j], pred[i]
                break

print("i, GT, pred")
for i in range(100):
    print(i, GT[i], pred[i])