package HighSchool.Other;

import java.util.ArrayList;
import java.util.Random;

public class test2 {
    public static void main(String[] args) {
        Random fred = new Random();
        ArrayList<Integer> boys = new ArrayList<>();
        ArrayList<Integer> girls = new ArrayList<>();
        int num = 0;
        for(int i = 0; i < 10000000; i++) {
            num = fred.nextInt(2);
            while (num == 1) {
                girls.add(1);
                num = fred.nextInt(2);
            }
            boys.add(1);
        }
        System.out.println(girls.size());
        System.out.println(boys.size());
    }
}
