package HighSchool.CnData.BCA.util;

public class BCAMapByHashedLinkedList<T> implements BCAMap<T> {
    protected BCALinkedList<BCAEntry<T>> buckets[] = null;

    public BCAMapByHashedLinkedList (int numBuckets) {
        buckets = new BCALinkedList[numBuckets];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new BCALinkedList<BCAEntry<T>>();
        }
    }

    @Override
    public int size() {
        int size = 0;

        for (int i=0; i<buckets.length; i++) {
            size += buckets[i].size();
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        for (int i=0; i<buckets.length; i++) {
            if (buckets[i].isEmpty() == false) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean containsKey(String key) {
        if (getOrDefault(key, null) != null)
            return true;
        else
            return false;
    }

    @Override
    public boolean containsValue(T value) {
        if(value == null) {
            throw new NullPointerException ("value cannot be null!");
        }

        for (int i=0; i<buckets.length; i++) {
            BCALinkedList<BCAEntry<T>> list = buckets[i];

            BCALinkedList<BCAEntry<T>>.Node n = list.head;
            for (int j = 0; j < list.size(); j++) {
                if(n.data.equals(value)) {
                    return true;
                }
                n = n.next;
            }

            /*for (int j=0; j<list.listSize; j++) {
                if (list.get(j).value.equals(value))
                    return true;
            }*/
        }

        return false;
    }

    @Override
    public T get(String key) {
        return getOrDefault(key, null);
    }

    @Override
    public T getOrDefault(String key, T defaultValue) {
        if(key == null) {
            throw new NullPointerException ("key cannot be null!");
        }

        int bucket = Math.abs(key.hashCode()) % buckets.length;
        BCALinkedList<BCAEntry<T>> list = buckets[bucket];

        BCALinkedList<BCAEntry<T>>.Node n = list.head;
        for (int j = 0; j < list.size(); j++) {
            if(n.data.key.equals(key)) {
                return n.data.value;
            }
            n = n.next;
        }

        /*for (int i=0; i<list.listSize; i++) {
            if (list.get(i).key.equals(key))
                return (list.get(i)).value;
        }*/

        return defaultValue;
    }

    @Override
    public T put(String key, T value) {
        if(key == null) {
            throw new NullPointerException ("key cannot be null!");
        }
        if(value == null) {
            throw new NullPointerException ("value cannot be null!");
        }

        int bucket = Math.abs(key.hashCode()) % buckets.length;
        BCALinkedList<BCAEntry<T>> list = buckets[bucket];

        BCALinkedList<BCAEntry<T>>.Node n = list.head;
        for (int j = 0; j < list.size(); j++) {
            if(n.data.key.equals(key)) {
                T oldVal = n.data.value;
                n.data.value = value;
                return oldVal;
            }
            n = n.next;
        }

        /*for (int i=0; i<list.listSize; i++) {
            if (list.get(i).key.equals(key)) {
                T oldVal = list.get(i).value;
                list.get(i).value = value;
                return oldVal;
            }
        }*/

        list.add (new BCAEntry<T> (key, value));

        return null;
    }

    @Override
    public T remove(String key) {
        if(key == null) {
            throw new NullPointerException ("key cannot be null!");
        }

        int bucket = Math.abs(key.hashCode()) % buckets.length;
        BCALinkedList<BCAEntry<T>> list = buckets[bucket];

        BCALinkedList<BCAEntry<T>>.Node n = list.head;
        for (int i = 0; i < list.size(); i++) {
            if(n.data.key.equals(key)) {
                T o = n.data.value;
                //System.out.println(i);
                list.remove(i);
                return o;
            }
            n = n.next;
        }

        /*for (int i=0; i<list.listSize; i++) {
            if ((list.get(i)).key.equals(key)) {
                T o = (list.get(i)).value;
                list.remove(i);
                return o;
            }
        }*/

        return null;
    }

    @Override
    public void clear() {
        for (int i=0; i<buckets.length; i++) {
            buckets[i].clear();
        }
    }

    @Override
    public BCAEntry<T>[] toArray() {
        BCAEntry<T>[] entryList = new BCAEntry[size()];
        int index = 0;
        for (int i=0; i<buckets.length; i++) {
            for (int j=0; j<buckets[i].listSize; j++) {
                BCAEntry<T> e = buckets[i].get(j);
                entryList[index++] = new BCAEntry<T> (e.key, e.value);
            }
        }
        return entryList;
    }

    @Override
    public String[] keys() {
        String[] keys = new String[size()];
        int index = 0;
        for (int i=0; i<buckets.length; i++) {
            for (int j=0; j<buckets[i].listSize; j++) {
                keys[index++] = (buckets[i].get(j)).key;
            }
        }
        return keys;
    }

    @Override
    public BCAList<T> values() {
        BCAList<T> values = new BCALinkedList<>();
        int index = 0;
        for (int i=0; i<buckets.length; i++) {
            for (int j=0; j<buckets[i].listSize; j++) {
                values.add(buckets[i].get(j).value);
            }
        }
        return values;
    }
}
