package HighSchool.CnData.BCA.util2;
import java.util.ArrayList;
import java.util.NoSuchElementException;

//public class BCAMinPQ<E extends Comparable<E>> implements BCAQueue<E> {
//
//  /*Stores items in heap starting at index 1*/
//  private ArrayList<E> heap = new ArrayList<>();
//  /*Number of items in the heap.*/
//  private int size;
//
//  public BCAMinPQ() {
//     /* dummy element in index 0, making actual elements start at index 1 */
//    heap.add(null);
//    /* Size will also be the index of the LAST element in the heap, if it exists*/
//    size = 0;
//  }
//
//  /**
//   * Return index of the left child of element at index i.
//   */
//  private int leftChildOf(int i){
//      return i*2;
//  }
//
//  /**
//   * Return index of the right child of element at index i.
//   */
//  private int rightChildOf(int i){
//      return i*2 + 1;
//  }
//
//  /**
//   * Return index of the parent of element at index i.
//   */
//  private int parentOf(int i){
//      return i/2;
//  }
//
//  /**
//   * Swap the elements at indexes i1 and i2.
//   */
//  private void swap(int i1, int i2){
//    E temp = heap.get(i1);
//    heap.set(i1, heap.get(i2));
//    heap.set(i2, temp);
//  }
//
//  /**
//   * Push up the element at index i (swapping with bigger parent)
//   * until it is at the appropriate level. (parent is smaller)
//   * This will fix the heap property if the element of index i
//   * is the only element out of place.
//   */
//  private void pushUp(int i) {
//    while (i != 1  /* TODO continue as long as i is not the root index  */) {
//
//      if (heap.get(parentOf(i)).compareTo(heap.get(i)) > 0 /* TODO stop if parent is smaller!*/)  /**/
//        swap(i, parentOf(i));
//        i = parentOf(i);
//
//      /* TODO Push element at i up!*/
//
//    }
//  }
//
//  /** Adds a new element to the the queue. */
//  public void enqueue(E o){
//    /* TODO Add new element to heap, maintaining both shape and heap properties*/
//      heap.add(o);
//      pushUp(size);
//      size++;
//
//  }
//
///* Try BCAMinPQTest now! You should pass 0.1 to 0.6*/
//
//
//  /**
//  * Returns the next item from the queue without popping it.
//  * If no item, returns null
//  */
//  public E peek(){
//    /* TODO Return minimum element of heap*/
//    return heap.get(1);
//  }
//
//  /* Try BCAMinPQTest now! You should pass 1a*/
//
//  /**
//   * Push down the element at index i (swapping with its smallest child)
//   * until it is at the appropriate level. (children are both bigger)
//   * This will fix the heap property if the element of index i
//   * is the only element out of place.
//   */
//  private void pushDown(int i) {
//    while(i <= size / 2 /* TODO continue as long as i has at least 1 child  */) {
//      /* TODO pick the smaller child (there might only be one!) */
//        System.out.println(this);
//        System.out.println(i);
//        int smallerChild = heap.get(i*2).compareTo(heap.get(i*2+1)) > 0 ? i*2 : i*2+1;
//
//      if (heap.get(i).compareTo(heap.get(leftChildOf(i))) > 0 && heap.get(i).compareTo(heap.get(rightChildOf(i))) > 0/* TODO stop if i is smaller than its children!*/)
//        swap(i, smallerChild);
//        i = smallerChild;
//
//      /* TODO Push element at i down!*/
//    }
//  }
//
//  /**
//   * Removes the smallest item from the queue and returns it.
//   *
//   * @exception NoSuchElementException
//   *                if the queue is empty.
//   */
//  public E dequeue(){
//
//    if (isEmpty())
//      throw new NoSuchElementException("MinPQ is empty");
//
//    swap(1, size-1);
//      System.out.println(this);
//    E item = heap.remove(size-1);
//    pushDown(1);
//    size--;
//
//    /* TODO Remove minimum element in heap, maintaining both shape and heap properties*/
//    /* HINT: Swap minimum element and last element FIRST! */
//
//    return item;
//  }
//
//  /* Try BCAMinPQTest now! You should pass the remaining tests 1b through 8, and HeapSort*/
//
//  /**
//   * Returns whether the queue is empty or not.
//   */
//  public boolean isEmpty(){
//    return size == 0;
//  }
//
//  /**
//   * Returns the number of items currently in the queue.
//   */
//  public int size() {
//    return size;
//  }
//
//  /**
//   * Return item at index i
//   */
//  public E get(int i) {
//    return heap.get(i);
//  }
//
//    @Override
//    public String toString() {
//      String s = "";
//        for (int i = 0; i < size; i++) {
//            s += i + ": " + heap.get(i) + "\n";
//        }
//        return s;
//    }
//}

public class BCAMinPQ<E extends Comparable<E>> implements BCAQueue<E> {

  /*Stores items in heap starting at index 1*/
  private ArrayList<E> heap = new ArrayList<>();
  /*Number of items in the heap.*/
  private int size;

  public BCAMinPQ() {
    /* dummy element in index 0, making actual elements start at index 1 */
    heap.add(null);
    /* Size will also be the index of the LAST element in the heap, if it exists*/
    size = 0;
  }

  /**
   * Return index of the left child of element at index i.
   */
  private int leftChildOf(int i){
    if (i*2 <= size) {
      return i*2;
    }
    return -1;
  }

  /**
   * Return index of the right child of element at index i.
   */
  private int rightChildOf(int i){
    if(i*2 +1 <= size) {
      return i * 2 + 1 /* TODO */;
    }
    return -1;
  }

  /**
   * Return index of the parent of element at index i.
   */
  private int parentOf(int i){
    return i/2 /* TODO */;
  }

  /**
   * Swap the elements at indexes i1 and i2.
   */
  private void swap(int i1, int i2){
    E temp = heap.get(i1);
    heap.set(i1, heap.get(i2));
    heap.set(i2, temp);
  }

  /**
   * Push up the element at index i (swapping with bigger parent)
   * until it is at the appropriate level. (parent is smaller)
   * This will fix the heap property if the element of index i
   * is the only element out of place.
   */
  private void pushUp(int i) {
    while ( i != 1  /* TODO continue as long as i is not the root index  */) {

      if ( heap.get(parentOf(i)).compareTo(heap.get(i)) > 0 /* TODO stop if parent is smaller!*/) { /**/
        swap(parentOf(i), i);
        i /= 2;
      }
      else {
        i = 1;
      }

      /* TODO Push element at i up!*/

    }
  }

  /** Adds a new element to the the queue. */
  public void enqueue(E o){
    heap.add(o);
    if(size != 0) {
      pushUp(size+1);
    }
    size++;
    /* TODO Add new element to heap, maintaining both shape and heap properties*/
  }

  /* Try BCAMinPQTest now! You should pass 0.1 to 0.6*/


  /**
   * Returns the next item from the queue without popping it.
   * If no item, returns null
   */
  public E peek(){
    /* TODO Return minimum element of heap*/
    return heap.get(1);
  }

  /* Try BCAMinPQTest now! You should pass 1a*/

  /**
   * Push down the element at index i (swapping with its smallest child)
   * until it is at the appropriate level. (children are both bigger)
   * This will fix the heap property if the element of index i
   * is the only element out of place.
   */
  private void pushDown(int i) {
    //System.out.println(this);
    System.out.println(this);
    while(leftChildOf(i) != -1 && rightChildOf(i) != -1 /* TODO continue as long as i has at least 1 child  */) {
      /* TODO pick the smaller child (there might only be one!) */

      int smallerChild = heap.get(i*2).compareTo(heap.get(i*2+1)) > 0 ? i*2 : i*2+1;

      if (heap.get(i).compareTo(heap.get(leftChildOf(i))) > 0 && heap.get(i).compareTo(heap.get(rightChildOf(i))) > 0 /* TODO stop if i is smaller than its children!*/)
        break;

      swap(i, smallerChild);
      i = smallerChild;

      /* TODO Push element at i down!*/
    }
    System.out.println(this);
  }

  /**
   * Removes the smallest item from the queue and returns it.
   *
   * @exception NoSuchElementException
   *                if the queue is empty.
   */
  public E dequeue(){

    if (isEmpty())
      throw new NoSuchElementException("MinPQ is empty");

    swap(size, 1);
    E item = heap.remove(size);
    size--;
    pushDown(1);
    return item;
    /* TODO Remove minimum element in heap, maintaining both shape and heap properties*/
    /* HINT: Swap minimum element and last element FIRST! */}

  /* Try BCAMinPQTest now! You should pass the remaining tests 1b through 8, and HeapSort*/

  /**
   * Returns whether the queue is empty or not.
   */
  public boolean isEmpty(){
    return size == 0;
  }

  /**
   * Returns the number of items currently in the queue.
   */
  public int size() {
    return size;
  }

  /**
   * Return item at index i
   */
  public E get(int i) {
    return heap.get(i);
  }

  @Override
  public String toString() {
    String s = "";
      for (int i = 1; i < size+1; i++) {
          s += i + ": " + heap.get(i) + "\n";
      }
      return s;
  }
}
