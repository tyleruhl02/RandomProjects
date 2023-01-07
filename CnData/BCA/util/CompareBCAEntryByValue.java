package HighSchool.CnData.BCA.util;

import java.util.Comparator;

public class CompareBCAEntryByValue implements Comparator<BCAEntry> {

    @Override
    @SuppressWarnings("unchecked")
    public int compare(BCAEntry o1, BCAEntry o2) {
        return ((Comparable)o1.value).compareTo(o2.value);
        //Values may not be Comparable, so a runtime exception might occur
        //if its not.
    }

}