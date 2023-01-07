package HighSchool.CnData.BCA.util;


/**************************
 *
 * Linked list implementation of BCAList2
 *
 */
public class BCALinkedList<T> implements BCAList<T> {
	protected Node head = null;
	protected Node tail = null;
	protected int listSize = 0;

	public BCALinkedList(){

	}

	/************************
	 *
	 * Node is an inner class (or nested class) for building the linked list.
	 * BCALinkedList can use it but it is not obviously accessible to other classes.
	 * (We can use "private" to hide it from outside classes, but we will leave it accessible)
	 */
	protected class Node {
		T data = null;
		Node next = null;

		public Node (T o) {
			data = o;
		}
	}

	@Override
	public void add(T o) {
		if(listSize == 0) {
			Node n = new Node(o);
			head = n;
			tail = n;
			listSize = 1;
		}
		else if(listSize == 1) {
			head.next = new Node(o);
			tail = head.next;
			listSize++;
		}
		else {
			Node n = head;
			do {
				n = n.next;
			}
			while (n.next != null);
			n.next = new Node(o);
			tail = n.next;
			listSize++;
		}
	}

	@Override
	public void add(int index, T o) throws IndexOutOfBoundsException {
		Node n = head;
		try {
			for (int i = 0; i < index - 1; i++) {
				n = n.next;
			}
			Node newNode = new Node(o);
			newNode.next = n.next;
			n.next = newNode;
			if(newNode.next == null) {
				tail = newNode;
			}
			listSize++;
		}
		catch(Exception e) {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public void clear() {
		listSize = 0;
		head = null;
		tail = null;
	}

	@Override
	public boolean contains(T o) {
		Node n = head;
		do {
			if(n.data.equals(o)) {
				return true;
			}
			n = n.next;
		}
		while(n.next != null);
		return false;
	}

	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		Node n = head;
		try {
			for (int i = 0; i < index; i++) {
				n = n.next;
			}
		}
		catch(Exception e) {
			throw new IndexOutOfBoundsException();
		}
		return n.data;
	}

	@Override
	public int indexOf(T o) {
		Node n = head;
		int count = 0;
		do {
			if(n.data.equals(o)) {
				return count;
			}
			n = n.next;
			count++;
		}
		while(n.next != null);
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public int lastIndexOf(T o) {
		Node n = head;
		int count = 0;
		int highestMatch = -1;
		do {
			if(n.data.equals(o)) {
				highestMatch = count;
			}
			n = n.next;
			count++;
		}
		while(n.next != null);
		return highestMatch;
	}

	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		Node n = head;
		//System.out.println(index);
		try {
			if(index != 0 && index != listSize-1) {
				for (int i = 0; i < index - 1; i++) {
					n = n.next;
				}
			}
			else {
				if(index == 0) {
					T o = head.data;
					head = head.next;
					listSize--;
					return o;
				}
				else {
					for (int i = 0; i < listSize-1; i++) {
						n = n.next;
					}
					T o = n.data;
					tail = n;
					listSize--;
					return o;
				}
			}
		}
		catch(Exception e) {
			throw new IndexOutOfBoundsException();
		}
		T o = n.next.data;
		n.next = n.next.next;
		listSize--;
		return o;
	}

	@Override
	public boolean remove(T o) {
		Node n = head;
		do {
			if(n.next.data.equals(o)) {
				n.next = n.next.next;
				listSize--;
				return true;
			}
			n = n.next;
		}
		while(n.next != null);
		return false;
	}

	@Override
	public int size() {
		return listSize;
	}

	@Override
	public String toString() {
		if(listSize == 0) {
			return "";
		}
		String s = "";
		Node n = head;
		int count = 0;
		do {
			s += count + ": " + n.data + "; ";
			n = n.next;
			count++;
		}
		while(n != null);

		return s;
	}
}
