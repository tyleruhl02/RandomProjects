package HighSchool.Other;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderProgram {
    public static void main(String[] args) throws IOException {
        FileReader is = new FileReader("wordlist.txt");
        BufferedReader buf = new BufferedReader(is);
        String line = buf.readLine();
        StringBuilder sb = new StringBuilder();
        while(line != null){
            sb.append(line).append("\n");
            line = buf.readLine();
        }
        String fileAsString = sb.toString();
        System.out.println("Contents : " + fileAsString);
    }
}
