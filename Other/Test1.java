package HighSchool.Other;

import java.util.Random;

public class Test1 {
    public static void main(String[] args) {
        Random randy = new Random();
        int[] counts = new int[13];
        for (int i = 0; i < 10000; i++) {
            int randInt = (randy.nextInt(9)+1)+randy.nextInt(5);
            counts[randInt-1]++;
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println(i+1 + ": " + counts[i]);
        }
    }
}
