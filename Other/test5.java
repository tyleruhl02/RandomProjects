package HighSchool.Other;

import java.util.Random;

public class test5 {
    public static void main(String[] args) {
        //System.out.println(System.currentTimeMillis());
        /*long i = 2;
        i = (long) Math.pow(i, 63);

        System.out.println(i);*/
        /*for (int i = 0; i < 100; i++) {
            System.out.println(new Random().nextInt(2));
        }*/

        /*int[][] kevin = new int[10][1];

        for (int i = 0; i < kevin.length; i++) {
            System.out.print(kevin[i]);
        }
        System.out.println();

        int[][] charles = kevin;

        int[][] steve = kevin.clone();

        for (int i = 0; i < kevin.length; i++) {
            System.out.print(charles[i]);
        }
        System.out.println();

        for (int i = 0; i < kevin.length; i++) {
            System.out.print(steve[i]);
        }
        System.out.println();*/

        /*String text = "hello mate";

        int a = 3;

        String start = text.substring(0, a);

        System.out.println(text + start);*/

        /*for (double x = -10; x <= 10; x+=0.1) {
            for (double y = -10; y < 10; y+=0.1) {
                if(Math.abs((x*x + y*y) - 4) < 0.01) {
                    System.out.print("X");
                }
                else {
                    System.out.print("O");
                }
            }
            System.out.println();
        }*/

        for (int i = 0; i < 1000; i++) {


            System.out.println(new Random().nextInt(2));
        }
    }
}
