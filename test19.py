import threading

# Array created for 5 elements
a = [0] * 5

# Lock object to synchronize access to the array
lock = threading.Lock()

# Thread created for write operation
t1 = threading.Thread(target=lambda: write_thread())

# Thread created for read operation
t2 = threading.Thread(target=lambda: read_thread())


def write_thread():
    global a
    global lock

    # Here the array is being synchronized
    with lock:
        print("Enter the elements:")
        for i in range(5):
            a[i] = int(input())
        print("Writing done successfully")


def read_thread():
    global a
    global lock

    # Here the array is being synchronized
    with lock:
        print("The elements are:")
        for i in range(5):
            print(a[i])
        print("Reading done successfully")


def main():
    # Write thread is started
    t1.start()

    # Read thread is started
    t2.start()

    # Wait for both threads to finish
    t1.join()
    t2.join()

main()