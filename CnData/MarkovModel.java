package HighSchool.CnData;

import HighSchool.CnData.BCA.util.*;

import java.util.Random;
import java.lang.IllegalArgumentException;

public class MarkovModel {
    //BCAMapByHashedLinkedList<BCAMapByHashedLinkedList<String>> map;

    BCAMap<BCAMap<Integer>> model;
    int order;

    private static final int ASCII = 128;

    //creates a Markov model of order k for the specified text
    public MarkovModel(String text, int k) {

        model = new BCAMapByHashedLinkedList<BCAMap<Integer>>(10);
        order = k;

        String startText = text.substring(0, k);
        text += startText;

        System.out.println("hello");

        for (int i = k; i <= text.length()-1; i++) {
            System.out.println(text.length());
            String kgram = text.substring(i-k, i);
            String nextLetter = Character.toString(text.charAt(i));

            if(!contains(model.keys(), kgram)) {
                model.put(kgram, new BCAMapByHashedLinkedList<Integer>(10));
            }
            if(contains(model.get(kgram).keys(), nextLetter)) {
                model.get(kgram).put(nextLetter, model.get(kgram).get(nextLetter)+1);
            }
            else {
                model.get(kgram).put(nextLetter, 1);
            }

        }
    }

    private boolean contains (String[] a, String b) {
        for (int i = 0; i < a.length; i++) {
            if(b.equals(a[i])) {
                return true;
            }
        }
        return false;
    }

    // returns the order k of this Markov model
    public int order() {
        return order;
    }

    // returns a string representation of the Markov model (as described below)
    public String toString() {
        String s = "";
        String[] keys = model.keys();
        for (int i = 0; i < keys.length; i++) {
            s += keys[i] + ": ";
            String[] keys2 = model.get(keys[i]).keys();
            for (int j = 0; j < keys2.length; j++) {
                s += keys2[j] + " " + model.get(keys[i]).get(keys2[j]) + " ";
            }
            s += "\n";
        }
        return s;
    }

    // returns the number of times the specified kgram appears in the text
    // throws java.lang.IllegalArgumentException if kgram not of length k
    public int freq(String kgram) {
        if(kgram.length() != order) {
            throw new IllegalArgumentException();
        }
        try {
            String[] a = model.get(kgram).keys();
            int count = 0;
            for (int i = 0; i < a.length; i++) {
                count += model.get(kgram).get(a[i]);
            }
            return count;
        }
        catch(NullPointerException e) {
            return 0;
        }
    }

    // returns the number of times the character c follows the specified
    // kgram in the text
    // throws java.lang.IllegalArgumentException if kgram not of length k
    // or if c is not an ASCII character.
    public int freq(String kgram, char c) {
        if (kgram.length() != order || ((int) c > ASCII)) {
            throw new IllegalArgumentException();
        }
        try {
            return model.get(kgram).get(Character.toString(c));
        }
        catch(NullPointerException e) {
            return 0;
        }
    }

    // returns a random character that follows the specified kgram in the text,
    // chosen with weight proportional to the number of times that character
    // follows the specified kgram in the text
    // if the kgram is not of length k OR does not appear in the text, throw a
    // java.lang.IllegalArgumentException.
    public char random(String kgram) {
        if(kgram.length() != order || !contains(model.keys(), kgram)) {
            throw new IllegalArgumentException();
        }

        int total = 0;

        String[] a = model.get(kgram).keys();
        for (int i = 0; i < a.length; i++) {
            total += model.get(kgram).get(a[i]);
        }

        int random = new Random().nextInt(total);

        //System.out.println(total);
        //System.out.println(random);

        int i = 0;

        while (random >= 0) {
            random -= model.get(kgram).get(a[i]);
            i++;
        }

        return a[i-1].charAt(0);
    }

    // tests this class by directly calling all instance methods
    public static void main(String[] args) {
        String text1 = "banana";
        System.out.println("Source text: " + text1);
        MarkovModel model1 = new MarkovModel(text1, 2);
        System.out.println("model's toString():");
        System.out.println(model1.toString());
        System.out.println("freq(\"an\", 'a')    = " + model1.freq("an", 'a'));
        System.out.println("freq(\"na\", 'b')    = " + model1.freq("na", 'b'));
        System.out.println("freq(\"na\", 'a')    = " + model1.freq("na", 'a'));
        System.out.println("freq(\"na\")         = " + model1.freq("na"));
        System.out.println();

        //System.exit(0);

        String text2 = "na na na na hey hey hey goodbye";
        System.out.println("Source text: " + text2);
        MarkovModel model2 = new MarkovModel(text2, 3);
        System.out.println("model's toString():");
        System.out.println(model2.toString());
        System.out.println("freq(\"na \", 'n')   = " + model2.freq("na ", 'n'));
        System.out.println("freq(\"na \", 'h')   = " + model2.freq("na ", 'h'));
        System.out.println("freq(\"na \")        = " + model2.freq("na "));
        System.out.println("freq(\"hey\")        = " + model2.freq("hey"));
        System.out.println();

        String text3 = "one fish two fish red fish blue fish";
        System.out.println("Source text: " + text3);
        MarkovModel model3 = new MarkovModel(text3, 4);
        System.out.println("model's toString():");
        System.out.println(model3.toString());
        System.out.println("freq(\"ish \", 'r')  = " + model3.freq("ish ", 'r'));
        System.out.println("freq(\"ish \", 'x')  = " + model3.freq("ish ", 'x'));
        System.out.println("freq(\"ish \")       = " + model3.freq("ish "));
        System.out.println("freq(\"tuna\")       = " + model3.freq("tuna"));

        // Create additional tests!
    }

}
