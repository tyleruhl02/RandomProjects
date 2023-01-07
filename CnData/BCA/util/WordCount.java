package HighSchool.CnData.BCA.util;

//import bca.util.*;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.lang.StringBuilder;
import java.util.Arrays;

public class WordCount {

    public static String cleanWord(String word) {
        StringBuilder sb = new StringBuilder();
        char[] arr = word.toLowerCase().toCharArray();
        for (int i = 0; i <arr.length; i++){
            if(Character.isLetter(arr[i]))
                sb.append(arr[i]);
        }
        return sb.toString();
    }

    public static BCAArrayList<String> parseFile(String filename)
            throws FileNotFoundException {
        BCAArrayList<String> list = new BCAArrayList<String>();
        Scanner reader = new Scanner(new FileReader(filename));
        while(reader.hasNext()) {
            String word = cleanWord(reader.next());
            list.add(word);
        }
        reader
                .close();
        return list;
    }

    public static void wordCount( BCAArrayList<String> list, BCAMap<Integer> map) {
        long start = System.currentTimeMillis();
        for(int i = 0; i < list.size(); i++) {
            String word = list.get(i);
            int freq = map.getOrDefault(word, 0);
            map.put(word, freq + 1);
        }
        long end = System.currentTimeMillis();
        System.out.printf("Time: %.3f seconds\n", (end - start) / 1000.0);

        BCAEntry<Integer>[] entries = map.toArray();
        Arrays.sort(entries, new CompareBCAEntryByValue());

        for (int i = 1; i<= 3; i++) {
            BCAEntry<Integer> e = entries[entries.length - i];
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        BCAArrayList<String> list = parseFile("TaleOfTwoCities.txt");

        System.out.println("\nMap By ArrayList");
        wordCount(list, new BCAMapByArrayList<Integer>());

        System.out.println("\n1 buckets");
        wordCount(list, new BCAMapByHashedArrayList<Integer>(1));

        System.out.println("\n10 buckets");
        wordCount(list, new BCAMapByHashedArrayList<Integer>(10));

        System.out.println("\n100 buckets");
        wordCount(list, new BCAMapByHashedArrayList<Integer>(100));

        System.out.println("\n1000 buckets");
        wordCount(list, new BCAMapByHashedArrayList<Integer>(1000));

        System.out.println("\nMap By LinkedList");

        System.out.println("\n1 buckets");
        wordCount(list, new BCAMapByHashedLinkedList<Integer>(1));

        System.out.println("\n10 buckets");
        wordCount(list, new BCAMapByHashedLinkedList<Integer>(10));

        System.out.println("\n100 buckets");
        wordCount(list, new BCAMapByHashedLinkedList<Integer>(100));

        System.out.println("\n1000 buckets");
        wordCount(list, new BCAMapByHashedLinkedList<Integer>(1000));

        //too much memory!
        // System.out.println("1000000000 buckets");
        // wordCount(list, new BCAMapByHashedArrayList_complete<Integer>(1000000000));


        System.out.println("\nBaseline");
        wordCount(list, new BCAMapBaseline<Integer>());



    }


}