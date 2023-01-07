package HighSchool.Other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Scrabble {
    public static HashMap<String, Integer> tiles = new HashMap<>();
    public static void main(String[] args) {
        int[][] boardMultiplier =  {{4, 0, 0, 1, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 4},
                                    {0, 3, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 3, 0},
                                    {0, 0, 3, 0, 0, 0, 1, 0, 1, 0, 0, 0, 3, 0, 0},
                                    {1, 0, 0, 3, 0, 0, 0, 1, 0, 0, 0, 3, 0, 0, 1},
                                    {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                                    {0, 2, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2, 0},
                                    {0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0},
                                    {4, 0, 0, 1, 0, 0, 0, 3, 0, 0, 0, 1, 0, 0, 4},
                                    {0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0},
                                    {0, 2, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2, 0},
                                    {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                                    {1, 0, 0, 3, 0, 0, 0, 1, 0, 0, 0, 3, 0, 0, 1},
                                    {0, 0, 3, 0, 0, 0, 1, 0, 1, 0, 0, 0, 3, 0, 0},
                                    {0, 3, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 3, 0},
                                    {4, 0, 0, 1, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 4}};

        String[][] board = new String[15][15];

        for (int i = 0; i < 12; i++) {
            tiles.put("E"+i, 1);
        }
        for (int i = 0; i < 9; i++) {
            tiles.put("A"+i, 1);
        }
        for (int i = 0; i < 9; i++) {
            tiles.put("I"+i, 1);
        }
        for (int i = 0; i < 8; i++) {
            tiles.put("O"+i, 1);
        }
        for (int i = 0; i < 6; i++) {
            tiles.put("N"+i, 1);
        }
        for (int i = 0; i < 6; i++) {
            tiles.put("R"+i, 1);
        }
        for (int i = 0; i < 6; i++) {
            tiles.put("T"+i, 1);
        }
        for (int i = 0; i < 4; i++) {
            tiles.put("L"+i, 1);
        }
        for (int i = 0; i < 4; i++) {
            tiles.put("S"+i, 1);
        }
        for (int i = 0; i < 4; i++) {
            tiles.put("U"+i, 1);
        }
        for (int i = 0; i < 4; i++) {
            tiles.put("D"+i, 2);
        }
        for (int i = 0; i < 3; i++) {
            tiles.put("G"+i, 2);
        }
        tiles.put("B0", 3);
        tiles.put("B1", 3);
        tiles.put("C0", 3);
        tiles.put("C1", 3);
        tiles.put("M0", 3);
        tiles.put("M1", 3);
        tiles.put("P0", 3);
        tiles.put("P1", 3);

        tiles.put("F0", 4);
        tiles.put("F1", 4);
        tiles.put("H0", 4);
        tiles.put("H1", 4);
        tiles.put("V0", 4);
        tiles.put("V1", 4);
        tiles.put("W0", 4);
        tiles.put("W1", 4);
        tiles.put("Y0", 4);
        tiles.put("Y1", 4);

        tiles.put("K0", 5);
        tiles.put("J0", 8);
        tiles.put("X0", 8);
        tiles.put("Q0", 10);
        tiles.put("Z0", 10);

        tiles.put(" 0", 0);
        tiles.put(" 1", 0);

        int numOfPlayers = 2;
        int numOfComputers = 0;
        String[] playerNames = getPlayerNames(numOfPlayers, numOfComputers);

        ScrabblePlayer[] players = new ScrabblePlayer[numOfPlayers];

        for (int i = 0; i < numOfPlayers; i++) {
            players[i] = new ScrabblePlayer(playerNames[i], i >= numOfPlayers-numOfComputers);
            for (int j = 0; j < 7; j++) {
                String letter = pickLetter();
                tiles.remove(letter);
                players[i].addTile(letter);
            }
        }

        System.out.println(Arrays.toString(players[0].getTiles()));

        int turn = 0;
        boolean gameOn = true;

        while (gameOn) {
            pickLetter();
            turn = (turn + 1) % numOfPlayers;
        }
    }

    private static String pickLetter() {
        String[] keys = new String[tiles.keySet().size()];
        keys = tiles.keySet().toArray(keys);
        System.out.println(Arrays.toString(keys));
        tiles.remove(keys[(int)(Math.random() * tiles.keySet().size())]);
        return "";
    }

    private static String[] getPlayerNames(int numOfPlayers, int numOfComputers) {
        Scanner fred = new Scanner(System.in);
        String[] names = new String[numOfPlayers];
        for (int i = 0; i < numOfPlayers; i++) {
            if(i < numOfPlayers-numOfComputers) {
                System.out.println("Enter the name of player " + (i + 1) + ": ");
            }
            else {
                System.out.println("Enter the name of player " + (i + 1) + " (computer): ");
            }
            names[i] = fred.nextLine();
        }
        return names;
    }
}
