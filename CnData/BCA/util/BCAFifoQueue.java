package HighSchool.CnData.BCA.util;

import java.util.NoSuchElementException;

/**
 * A BCAFifoQueue uses a BCALinkedList as an instance variable. Linked lists are a
 * great choice for implementing queues as both the enqueue and dequeue
 * operations run in constant time. (If implemented with an ArrayList, the
 * elements of the array are shifted on each dequeue operation.)
 */
public class BCAFifoQueue<T> implements BCAQueue<T> {
	private BCALinkedList list = new BCALinkedList();

	public BCAFifoQueue() {
	}

	/** Adds a new element to the rear (tail) of the queue. */
	public void enqueue(T o) {
		list.add(o);
	}

	/**
	 * Removes the front item from the queue and returns it.
	 *
	 * @exception NoSuchElementException
	 *                if the queue is empty.
	 */
	@SuppressWarnings("unchecked")
	public T dequeue() {
		if(list.size() == 0)
			throw new NoSuchElementException();
		return (T) list.remove(0);
	}

	/**
	 * Returns the next item from the queue without popping it.
	 * If no item, returns null
	 *
	 */
	 @SuppressWarnings("unchecked")
	public T peek() {
	 	if (list.size() ==0)
			return null;
	 	return (T) list.get(0);
	}

	/**
	 * Returns whether the queue is empty or not.
	 */
	public boolean isEmpty() {
		return (list.size() == 0);
	}

	/**
	 * Returns the number of items currently in the queue.
	 */
	public int size() {
		return list.size();
	}
}
