package HighSchool.Other;

import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner fred = new Scanner(System.in);

        int LOWER_BOUND = 0;
        int UPPER_BOUND = 10;
        int random_number = (int) (Math.random() * (UPPER_BOUND-LOWER_BOUND+1)) + LOWER_BOUND;

        System.out.println("Guess a random number between " + LOWER_BOUND + " and " + UPPER_BOUND + ".");

        int guess = fred.nextInt();
        int count = 1;

        while(random_number != guess) {
            if(guess < random_number)
                System.out.println("Your guess is too low!");
            else
                System.out.println("Your guess is too high!");
            guess = fred.nextInt();
            count++;
        }

        System.out.println("Correct, you guessed the number " + random_number + " in " + count + " tries!");
    }
}
