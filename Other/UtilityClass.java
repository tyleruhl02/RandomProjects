package HighSchool.Other;

import java.io.*;
import java.util.ArrayList;

public class UtilityClass {
    public static void main(String[] args) throws Exception {
        File f = new File("words.txt");

        BufferedReader br = new BufferedReader(new FileReader(f));

        ArrayList<String> words = new ArrayList<String>();
        String s;
        while ((s = br.readLine()) != null) {
            words.add(s);
        }

        char[] bannedChars = "1234567890,-./?\\'".toCharArray();

        for (int i = words.size()-1; i >= 0; i--) {
            for (int j = 0; j < bannedChars.length; j++) {
                //System.out.println(words.size());
                //System.out.println(i);
                if(words.get(i).length() > 6) {// || words.get(i).contains(bannedChars[i] + "")) {
                    words.remove(words.get(i));
                    break;
                }
            }
            if(i % 10000 == 0) {
                System.out.println(i);
            }
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter("goodWords.txt"));
        for (int i = 0; i < words.size(); i++) {
            bw.write(words.get(i).toLowerCase() + "\n");
        }

        bw.close();
    }
}
