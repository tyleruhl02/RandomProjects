package HighSchool.Other;

import java.io.BufferedReader;
import java.io.FileReader;

public class CurseWordCounter {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("file.txt"));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        while (line != null) {
            sb.append(line).append("\n");
            line = br.readLine();
        }

        String fileAsString = sb.toString().toLowerCase();

        String[] curseWords = {"fuck", "bitch", "nigger", "nigga", "hell", "damn", "ass", "shit", "bastard", "crap", "cunt", "pussy", "dick"};
        int[] counts = new int[curseWords.length];
        int totalCurses = 0;

        for (int i = 0; i < counts.length; i++) {
            counts[i] = count(fileAsString, curseWords[i]);
            totalCurses += counts[i];
        }

        for (int i = 0; i < counts.length; i++) {
            System.out.println(curseWords[i] + ": " + counts[i]);
        }
        System.out.println("total: " + totalCurses);
    }

    public static int count(String text, String word) {
        int counter = 0;
        for (int i = 0; i < text.length()-word.length(); i++) {
            if(text.substring(i, word.length()+i).equals(word)) {
                counter++;
            }
        }
        return counter;
    }
}
