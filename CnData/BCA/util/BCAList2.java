package HighSchool.CnData.BCA.util;

public interface BCAList2<T> {

	/** Appends the specified object to the end of this list. */
	public void add(T o);

	/**
	 * Inserts the specified object at the specified position in this list.
	 * Existing objects in the list are shifted right. If the specified index is
	 * at the end of list, the specified object is appended to the end of the
	 * list.
	 *
	 * @throws IndexOutOfBoundsException
	 *             if index is invalid.
	 */
	public void add(int index, T o);

	/**
	 * Removes all of the elements from this list. This method releases all
	 * references to objects stored in the list so that they can be garbage
	 * collected.
	 */
	public void clear();

	/** Returns true if this list contains the specified object. */
	public boolean contains(T o);

	/**
	 * Returns the object at the specified position in this list.
	 *
	 * @throws IndexOutOfBoundsException
	 *             if index is invalid.
	 */
	public T get(int index);

	/**
	 * Returns the index of the first occurrence of the specified element in
	 * this list, or -1 if this list does not contain the element.
	 */
	public int indexOf(T o);

	/** Returns true if this list contains no elements. */
	public boolean isEmpty();

	/**
	 * Returns the index of the last occurrence of the specified element in this
	 * list, or -1 if this list does not contain the element.
	 */
	public int lastIndexOf(T o);

	/**
	 * Removes and returns the element at the specified position in this list.
	 *
	 * @throws IndexOutOfBoundsException if index is invalid.
	 */
	public T remove(int index);

	/**
	 * Removes the first occurrence of the specified element from this list, if
	 * it is present.
	 *
	 * @return true if an object is removed, false otherwise.
	 */
	public boolean remove(T o);

	/** Returns the number of objects in this list. */
	public int size();

	/** Used for debugging.  Prints every element in the list along with its index.  For example,
	 * assume the list contains the values 15, 19, 12.
	 * toString should return the following string: "0: 15; 1: 19; 2: 12;"
	 */
	public String toString();

}
