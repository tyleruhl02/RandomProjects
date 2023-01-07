package HighSchool.AP;// MADE BY MARCUS AND TYLER


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ASCIIText {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        ArrayList<String> results = new ArrayList<String>(); // This part and the lines after are from here: https://stackoverflow.com/questions/5694385/getting-the-filenames-of-all-files-in-a-folder

        File[] files = new File("C:\\Users\\tyler\\IdeaProjects\\JavaProjects\\Fonts").listFiles();

        for (File file : files) {
            if (file.isFile()) {
                results.add(file.getName());
            }
        }

        System.out.println("Which font would you like? (1, 2, 3, or 4)");

        for (int i = 0; i < results.size(); i++) {
            System.out.println(i+1 + ". " + results.get(i));
        }

        String inputFile = results.get(in.nextInt()-1);

        in.nextLine();

        String input = "";
        File file = new File("Fonts\\" + inputFile);
        BufferedReader br = new BufferedReader(new FileReader(file));
        { // THIS BRACE IS DERIVED FROM HERE: https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
            String st;
            int count = 0;
            while ((st = br.readLine()) != null) {
                if (st.length() >= 2 && st.substring(0, 2).equals("//")) {
                    count++;
                }
                if(count == 2) {
                    break;
                }
            }
            input = br.readLine();
        }
        int linesPerLetter = Integer.parseInt(input.substring(0, 1));
        //String[] listOfChars = input.substring(2).split("");
        char[] allCharacters = input.substring(2).toCharArray();
        String[][] ASCIICharacters = new String[allCharacters.length][linesPerLetter];

        br.readLine();

        for (int i = 0; i < ASCIICharacters.length; i++) {
            for (int j = 0; j < linesPerLetter; j++) {
                ASCIICharacters[i][j] = br.readLine();
            }
            br.readLine();
        }

        System.out.print("Text to print: ");

        String inputText = in.nextLine();
        String[] outputText = new String[linesPerLetter];
        int primaryIndex = 0;

        for (int i = 0; i < inputText.length(); i++) {
            for (int j = 0; j < linesPerLetter; j++) {
                for (int k = 0; k < allCharacters.length; k++) {
                    if(allCharacters[k] == inputText.charAt(i)) {
                        primaryIndex = k;
                    }
                }
                outputText[j] += ASCIICharacters[primaryIndex][j];
            }
        }

        for (int i = 0; i < linesPerLetter; i++) {
            System.out.println(outputText[i].substring(4));
        }
    }
}