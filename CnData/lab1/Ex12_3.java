package HighSchool.CnData.lab1;

import java.util.Random;
import java.util.Scanner;

public class Ex12_3 {
    public static void main(String[] args) {
        Scanner fred = new Scanner(System.in);
        Random randy = new Random();

        int[] intArray = new int[100];

        for (int i = 0; i < 100; i++) {
            intArray[i] = randy.nextInt();
        }

        try {
            System.out.print("What index of the list do you wish to have? ");
            System.out.println(intArray[fred.nextInt()]);
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Out of Bounds.");
        }
    }
}
