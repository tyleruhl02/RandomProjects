"""from time import strftime, localtime

def main(t):
    print(strftime('%Y-%m-%d %H:%M:%S', localtime(t)))

if __name__ == "__main__":
    t = 1718029731.648913524
    main(t)
"""

import time

start_time = time.time()

count = 0
for i in range(1000000000):
    count += 1

end_time = time.time()

print(f"ELAPSED: {end_time - start_time}")