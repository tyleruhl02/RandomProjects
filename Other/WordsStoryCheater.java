package HighSchool.Other;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WordsStoryCheater {
    public static Scanner fred = new Scanner(System.in);

    private static String[] importStringArray() throws IOException {
        FileReader is = new FileReader("wordlist.txt");
        BufferedReader buf = new BufferedReader(is);
        String line = buf.readLine();
        StringBuilder sb = new StringBuilder();
        while(line != null){
            sb.append(line).append("\n");
            line = buf.readLine();
        }
        return sb.toString().split("\n");
    }

    private static ArrayList<String> getInfo() {
        ArrayList<String> letters = new ArrayList<>();
        System.out.println("Type in the characters with no spaces.");
        String[] temp = fred.nextLine().toLowerCase().split("");
        for (int i = 0; i < temp.length; i++) {
            letters.add(temp[i]);
        }
        return letters;
    }

    private static String[] getWordsContainingLetter(ArrayList<String> letters, String[] words) {
        ArrayList<String> possibleWords = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            boolean entireCorrect = true;
            boolean[] correct = new boolean[words[i].length()];
            for (int j = 0; j < words[i].length(); j++) {
                for (int k = 0; k < letters.size(); k++) {
                    if (words[i].substring(j, j+1).equals(letters.get(k))) {
                        correct[j] = true;
                    }
                }
            }
            for (int k = 0; k < correct.length; k++) {
                if(!correct[k]) {
                    entireCorrect = false;
                    break;
                }
            }
            if(entireCorrect) {
                possibleWords.add(words[i]);
            }
        }
        String[] returnedWords = new String[possibleWords.size()];
        for (int i = 0; i < possibleWords.size(); i++) {
            returnedWords[i] = possibleWords.get(i);
        }
        return returnedWords;
    }

    private static String[] getWordsRightLength(int length, String[] words) {
        int counter = 0;
        for (int i = 0; i < words.length; i++) {
            if(words[i].length() != length) {
                words[i] = "";
                counter++;
            }
        }
        String[] returnedWords = new String[words.length-counter];
        counter = 0;
        for (int i = 0; i < words.length; i++) {
            if(!words[i].equals("")) {
                returnedWords[counter] = words[i];
                counter++;
            }
        }
        return returnedWords;
    }

    private static String[] getWordsWithLettersAtIndex(String input, int index, String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if(!words[i].substring(index, index+1).equals(input)) {
                words[i] = "";
                count++;
            }
        }
        String[] returnedWords = new String[words.length-count];
        count = 0;
        for (int i = 0; i < words.length; i++) {
            if(!words[i].equals("")) {
                returnedWords[count] = words[i];
                count++;
            }
        }
        return returnedWords;
    }

    private static String[] getWordsWithoutRightPlacement(String input, int index, String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            boolean[] correct = new boolean[words[i].length()];
            if(words[i].substring(index, index+1).equals(input)) {
                words[i] = "";
            }
            for (int j = 0; j < words[i].length(); j++) {
                if(words[i].substring(j, j+1).equals(input)) {
                    correct[j] = true;
                }
            }
            boolean letterInWord = false;
            for (int j = 0; j < correct.length; j++) {
                if(correct[j]) {
                    letterInWord = true;
                }
            }
            if(letterInWord == false) {
                words[i] = "";
                count++;
            }
        }
        String[] returnedWords = new String[words.length-count];
        count = 0;
        for (int i = 0; i < words.length; i++) {
            if(!words[i].equals("")) {
                returnedWords[count] = words[i];
                count++;
            }
        }
        return returnedWords;
    }

    public static void main(String[] args) throws IOException {
        String[] possibleWords = importStringArray();
        ArrayList<String> letters = getInfo();
        System.out.println("How many letters is the word?");

        possibleWords = getWordsContainingLetter(letters, possibleWords);
        System.out.println(Arrays.toString(possibleWords));

        int length = fred.nextInt();
        possibleWords = getWordsRightLength(length, possibleWords);
        System.out.println(Arrays.toString(possibleWords));

        boolean gameNotOver = true;
        int answer = 0;

        while (gameNotOver) {
            System.out.println( "\n\nTo delete letters press 1.\n" +
                                "To place correct letters press 2.\n" +
                                "To mention letters in the wrong place press 3.\n" +
                                "To restart press 4.");
            while (answer < 1 || answer > 4) {
                answer = fred.nextInt();
            }
            if (answer == 1) {
                System.out.println(String.join(", ", letters));
                System.out.println("Which letters would you like to delete? (answer separated by nothing)");
                fred.nextLine();
                String[] lettersToRemove = fred.nextLine().toLowerCase().split("");
                for (int i = letters.size()-1; i >= 0; i--) {
                    for (int j = 0; j < lettersToRemove.length; j++) {
                        if(letters.get(i).equals(lettersToRemove[j])) {
                            letters.remove(lettersToRemove[j]);
                            break;
                        }
                    }
                }
                possibleWords = getWordsContainingLetter(letters, possibleWords);
                System.out.println(Arrays.toString(possibleWords));
                answer = 0;
            }
            else if (answer == 2) {
                System.out.println("Which letter is in which position? (type index separated by nothing)");
                fred.nextLine();
                String input = fred.nextLine();
                //if (input.equals("")) {
                //    answer = 0;
                //}
                int index = Integer.parseInt(input.substring(0, 1));
                input = input.substring(input.length()-1);
                possibleWords = getWordsWithLettersAtIndex(input, index, possibleWords);
                System.out.println(Arrays.toString(possibleWords));
                answer = 0;
            }
            else if (answer == 3) {
                System.out.println("Which letter is in which position? (type index separated by space then letter)");
                fred.nextLine();
                String input = fred.nextLine();
                int index = Integer.parseInt(input.substring(0, 1));
                input = input.substring(input.length()-1);
                possibleWords = getWordsWithoutRightPlacement(input, index, possibleWords);
                System.out.println(Arrays.toString(possibleWords));
                answer = 0;
            }
            else {
                System.exit(0);
            }
        }
    }
}
