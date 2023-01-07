package HighSchool.CnData.BCA.util;

public class BCAMapByArrayList<T> implements BCAMap<T> {
    private BCAEntry<T>[] list = new BCAEntry[5];
    private int mapsize = 0;

    private void expand() {
        BCAEntry<T>[] newList = new BCAEntry[list.length*2];
        for (int i = 0; i < list.length; i++) {
            newList[i] = list[i];
        }
        list = newList;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int size() {
        return mapsize;
    }

    @Override
    public boolean isEmpty() {
        return mapsize == 0;
    }

    @Override
    public boolean containsKey(String key) throws NullPointerException {
        if(key == null) {
            throw new NullPointerException();
        }
        String[] keys = keys();
        for (int i = 0; i < keys.length; i++) {
            if(key.equals(keys[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(T value) throws NullPointerException {
        if(value == null) {
            throw new NullPointerException();
        }
        BCAList<T> values = values();
        for (int i = 0; i < values.size(); i++) {
            if(value.equals(values.get(i))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T get(String key) throws NullPointerException {
        if(key == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < mapsize; i++) {
            if(list[i].key.equals(key)) {
                return list[i].value;
            }
        }
        return null;
    }

    @Override
    public T getOrDefault(String key, T defaultValue) throws NullPointerException {
        if(key == null || defaultValue == null) {
            throw new NullPointerException();
        }
        if(containsKey(key)) {
            return get(key);
        }
        return defaultValue;
    }

    @Override
    public T put(String key, T value) throws NullPointerException {
        if(key == null || value == null) {
            throw new NullPointerException();
        }
        if(containsKey(key)) {
            for (int i = 0; i < mapsize; i++) {
                if(list[i].key.equals(key)) {
                    T tempValue = list[i].value;
                    list[i].value = value;
                    return tempValue;
                }
            }
        }
        if(mapsize >= list.length) {
            expand();
        }
        list[mapsize] = new BCAEntry<>(key, value);
        mapsize++;
        return null;
    }

    @Override
    public T remove(String key) throws NullPointerException {
        if(key == null) {
            throw new NullPointerException();
        }
        if(containsKey(key)) {
            for (int i = 0; i < mapsize; i++) {
                if(list[i].key.equals(key)) {
                    BCAEntry<T>[] newList = new BCAEntry[list.length];
                    int helper = 0;
                    for (int j = 0; j < list.length; j++) {
                        if(i != j) {
                            newList[j+helper] = list[j];
                        }
                        else {
                            helper = -1;
                        }
                    }
                    T tempValue = list[i].value;
                    list = newList;
                    mapsize--;
                    return tempValue;
                }
            }
        }
        return null;
    }

    @Override
    public void clear() {
        list = new BCAEntry[5];
        mapsize = 0;
    }

    @Override
    public BCAEntry<T>[] toArray() {
        BCAEntry<T>[] arr = new BCAEntry[mapsize];
        for (int i = 0; i < mapsize; i++) {
            arr[i] = list[i];
        }
        return arr;
    }

    @Override
    public String[] keys() {
        String[] keys = new String[mapsize];
        //System.out.println(Arrays.toString(keys));
        //System.out.println(Arrays.toString(list));
        for (int i = 0; i < mapsize; i++) {
            keys[i] = list[i].key;
        }
        return keys;
    }

    @Override
    public BCAList<T> values() {
        BCAList<T> values = new BCAArrayList();
        for (int i = 0; i < mapsize; i++) {
            values.add(list[i].value);
        }
        return values;
    }
}
