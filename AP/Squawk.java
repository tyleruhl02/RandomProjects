package HighSchool.AP;

import java.util.Scanner;

public class Squawk {
    public static void main(String[] args) {
        Scanner fred = new Scanner(System.in);

        System.out.print("What should I say? ");
        String squawksaying = fred.nextLine();
        System.out.print("How many times should I say it? ");
        int squawknumber = fred.nextInt();
        if(squawknumber >= 1 && squawknumber <= 8) {
            for (int i = 0; i < squawknumber; i++) {
                System.out.println(squawksaying);
            }
        }
    }
}
