package HighSchool.Other;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {
    public static void printBoard(String[] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.println(board[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner fred = new Scanner(System.in);
        String[] board = {"----|  ", "|  ", "|  ", "|  ", "|  ", "|  ", "-------"};

        File f = new File("words.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));
        ArrayList<String> words = new ArrayList<String>();
        String s;
        while ((s = br.readLine()) != null) {
            words.add(s.toUpperCase());
        }

        String word = words.get((int) (Math.random() * words.size() + 1));
        String printWord = "";

        for (int i = 0; i < word.length(); i++) {
            printWord+="-";
        }

        int lives = 6;
        ArrayList<Character> usedLetters = new ArrayList<Character>();

        while(lives > 0 || word.contains("-")) {
            System.out.println(printWord + "\n");
            printBoard(board);
            System.out.println(lives);
            System.out.println(usedLetters);
            char letter = fred.nextLine().toUpperCase().charAt(0);
            if(word.contains(letter + "")) {
                for (int i = 0; i < word.length(); i++) {
                    if(word.charAt(i) == letter) {
                        printWord = printWord.substring(0, i) + letter + printWord.substring(i+1);
                    }
                }
            }
            else {
                usedLetters.add(letter);
                lives--;
                switch(lives) {
                    case 5:
                        board[1]+=" O";
                        break;
                    case 4:
                        board[2]+=" |";
                        break;
                    case 3:
                        board[2]="|  /|";
                        break;
                    case 2:
                        board[2]+="\\";
                        break;
                    case 1:
                        board[3]+="/";
                        break;
                    case 0:
                        board[3]+=" \\";
                        break;
                }
            }
        }

        System.out.println(word);
        System.out.println(printWord);

        printBoard(board);
    }
}
