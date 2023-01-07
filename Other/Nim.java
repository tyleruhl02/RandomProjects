package HighSchool.Other;

import java.util.Scanner;

public class Nim {
    private static void printPile(int p1, int p2, int p3) {
        System.out.printf("\nPile 1: %d\nPile 2: %d\nPile 3: %d\n\n", p1, p2, p3);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int pile1 = 9;
        int pile2 = 9;
        int pile3 = 9;
        int turn = 1;
        int pileChosen = 0;
        int numOfStones = 0;

        while(pile1 > 0 || pile2 > 0 || pile3 > 0) {
            if(turn == 0) {
                turn = 1;
            }
            else {
                turn = 0;
            }

            printPile(pile1, pile2, pile3);

            System.out.println("Player " + (turn+1) + ":");
            System.out.print("From which pile would you like to take? ");
            pileChosen = in.nextInt();
            System.out.print("How many stones would you like to take? ");
            numOfStones = in.nextInt();

            if(pileChosen == 1) {
                pile1 -= numOfStones;
            }
            if(pileChosen == 2) {
                pile2 -= numOfStones;
            }
            if(pileChosen == 3) {
                pile3 -= numOfStones;
            }
        }

        System.out.println("\nYou took the last stone! Player " + (turn+1) + " loses.");
    }
}
