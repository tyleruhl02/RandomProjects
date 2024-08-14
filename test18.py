import threading

map = {"Cubes": [], "Squares": []}
lock = threading.Lock()

def print_cube(num):
    print("Cube: {}" .format(num * num * num))
    global map
    global lock
    with lock:
        map["Cubes"].append(num * num * num)


def print_square(num):
    print("Square: {}" .format(num * num))
    map["Squares"].append(num * num)


if __name__ =="__main__":
    t1 = threading.Thread(target=print_square, args=(10,))
    t2 = threading.Thread(target=print_cube, args=(10,))

    t1.start()
    t2.start()

    t1.join()
    t2.join()

    print(map)

    print("Done!")