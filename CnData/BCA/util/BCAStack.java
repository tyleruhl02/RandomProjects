package HighSchool.CnData.BCA.util;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class BCAStack implements BCAQueue {
	BCAArrayList list = new BCAArrayList();

	public BCAStack() {}

	/** Pushes "o" onto the stack. */
	public void push (Object o) {
			list.add(o);
	}

	public void enqueue(Object o){
		push(o);
	}

	/** Pops and returns the top of the stack.  Throws EmptyStackException if
	 * the stack is empty.
	 */
	public Object pop()
	{
		if (list.size() == 0)
			throw new EmptyStackException();
		return list.remove(list.size() - 1);
	}

	public Object dequeue()
	{
		try {
			return pop();
		} catch(EmptyStackException ex){
			throw new NoSuchElementException(ex.getMessage());
		}
	}

	/** Looks at the object at the top of this stack without removing it from the stack.
	 * Returns null if the stack is empty.
	 */
	public Object peek()
	{
		if (list.size() == 0)
			return  null;
		return list.get(list.size() - 1);
	}

	/**
	 * Removes all of the elements from this stack. This method releases all
	 * references to objects stored in the stack so that they can be garbage
	 * collected.
	 */
	public void clear() {
		list.clear();
	}

	/** Returns true if the stack is empty, false otherwise. */
	public boolean isEmpty() {
		return (list.size() == 0);
	}

	/** Returns the number of objects in this list. */
	public int size() {
		return list.size();
	}
}
