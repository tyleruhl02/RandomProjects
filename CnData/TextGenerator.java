package HighSchool.CnData;

import java.util.Scanner;
import java.lang.StringBuilder;
import java.lang.IllegalArgumentException;

public class TextGenerator {

    // reads in entire file from standard input
    // as a single String;
    public static String readStdInAsString() {
        Scanner input = new Scanner(System.in);
        StringBuilder text = new StringBuilder();
        while (input.hasNextLine()) {
            String line = input.nextLine().trim().replaceAll("\\s+", " ");
            text.append(line);
            text.append(" ");//this could be changed to "\n" to include line breaks.
        }
        input.close();
        // reduce all whitespace down to single spaces,
        // and trim whitespace from beginning and end.
        return text.toString().trim();
    }

    // takes two integer command-line arguments k and T;
    // reads the input text from standard input;
    // builds a Markov model of order k from the input text;
    // then, starting with the k-gram consisting of the first k characters of the
    // input text, prints T characters generated by simulating a trajectory
    // through the corresponding Markov chain.
    public static void main(String[] args) throws Exception {//throws IllegalArgumentException {
        int k, T;
        try {
            k = Integer.parseInt(args[0]);
            T = Integer.parseInt(args[1]);
        } catch (Exception e) {
            throw new IllegalArgumentException("Arguments should be 2 ints, k and T.");
        }

        String text = readStdInAsString();

        /*k = 4;
        T = 1000;

        String text = "";
        try {
            text = new String(Files.readAllBytes(Paths.get("sample_texts\\TaleOfTwoCities.txt")));
        } catch (IOException e) {

        }*/

        MarkovModel m = new MarkovModel(text, k);

        System.out.println(m);

        String output = text.substring(0, k);

        for (int i = output.length(); i < T; i++) {
            output += m.random(output.substring(output.length()-k));
        }

        System.out.println(output);
    }


}
