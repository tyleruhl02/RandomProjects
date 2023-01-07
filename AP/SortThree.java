package HighSchool.AP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SortThree {

    public static void main(String[] args) {
        int NUMBER_OF_NUMBERS = 3;

        Scanner fred = new Scanner(System.in);
        System.out.println("How large would you like the array to be?");
        int[] array = new int[fred.nextInt()];
        int[] counter = new int[NUMBER_OF_NUMBERS];
        int counterIndex = 0;
        ArrayList<Integer> orderOfIndecies = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * NUMBER_OF_NUMBERS) + 1;
            counter[array[i]-1]++;
        }

        System.out.println("Start array: " + Arrays.toString(array));

        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) {
                orderOfIndecies.add(i);
            }
        }
        try {
            counterIndex = orderOfIndecies.get(0);

            for (int i = 0; i < array.length; i++) {
                array[i] = counterIndex + 1;
                counter[counterIndex]--;
                if (counter[counterIndex] == 0) {
                    orderOfIndecies.remove(0);
                    if (i != array.length - 1)
                        counterIndex = orderOfIndecies.get(0);
                }
            }
        }
        catch(IndexOutOfBoundsException e) { }
        System.out.println("End array: " + Arrays.toString(array));
    }
}
