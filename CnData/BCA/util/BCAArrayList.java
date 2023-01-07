package HighSchool.CnData.BCA.util;

public class BCAArrayList <T> implements BCAList<T> {
    private T[] array;
    int listSize;

    public BCAArrayList() {

        array = (T[]) new Object[5];
        listSize = 0;
    }

    private void expand() {
        T[] oldArray = array.clone();
        array = (T[]) new Object[array.length*2];
        for (int i = 0; i < oldArray.length; i++) {
            array[i] = oldArray[i];
        }
    }

    @Override
    public void add(T o) {
        if(listSize == array.length) {
            expand();
        }
        array[listSize] = o;
        listSize++;
    }

    @Override
    public void add(int index, T o) throws IndexOutOfBoundsException {
        if(index < 0 || index > listSize) {
            throw new IndexOutOfBoundsException();
        }
        else {
            if (listSize == array.length) {
                expand();
            }
            System.out.println(index);
            if(index != 0) {
                for (int i = listSize; i > index; i--) {
                    array[listSize - i] = array[listSize - i - 1];
                }
                array[index] = o;
            }
            else {
                for (int i = listSize; i > 1; i--) {
                    array[listSize - i] = array[listSize - i - 1];
                }
                array[0] = o;
            }
            listSize++;
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < listSize; i++) {
            array[i] = null;
        }
        listSize = 0;
    }

    @Override
    public boolean contains(T o) {
        for (int i = 0; i < listSize; i++) {
            if(array[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        return array[index];
    }

    @Override
    public int indexOf(T o) {
        for (int i = 0; i < listSize; i++) {
            if(array[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return listSize == 0;
    }

    @Override
    public int lastIndexOf(T o) {
        for (int i = listSize-1; i > 0; i--) {
            if(array[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        T o = array[index];
        for (int i = index; i < listSize; i++) {
            array[i] = array[i+1];
        }
        listSize--;
        return o;
    }

    @Override
    public boolean remove (T o) {
        for (int i = 0; i < listSize; i++) {
            if(array[i].equals(o)) {
                for (int j = i; j < listSize; j++) {
                    array[j] = array[j+1];
                }
                listSize--;
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return listSize;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < listSize; i++) {
            s += i + ": " + array[i] + "; ";
        }
        return s;
    }
}
