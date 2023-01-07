package HighSchool.AP;

public class Encryption {

    private final static int STARTING_INDEX = 65;
    private final static int NUMBER_OF_CHARACTERS = 26;

    public static String encrypt(int key, String text) {
        text = text.toUpperCase();
        String outputText = "";
        char currentChar;
        for (int i = 0; i < text.length(); i++) {
            currentChar = text.charAt(i);
            try {
                key += text.charAt(i - 1);
            }
            catch(Exception e) {
                outputText += (char) ((currentChar + key - STARTING_INDEX) % NUMBER_OF_CHARACTERS + STARTING_INDEX);
                continue;
            }
            outputText += (char) ((currentChar + key - STARTING_INDEX) % NUMBER_OF_CHARACTERS + STARTING_INDEX);
        }
        return outputText;
    }

    public static String decrypt(int key, String text) {
        text = text.toUpperCase();
        String outputText = "";
        char currentChar;
        for (int i = 0; i < text.length(); i++) {
            currentChar = text.charAt(i);
            try {
                key = (text.charAt(i - 1) - STARTING_INDEX) % NUMBER_OF_CHARACTERS + STARTING_INDEX;
            }
            catch(Exception e) {
                outputText += (char) ((currentChar - key + STARTING_INDEX) % NUMBER_OF_CHARACTERS + STARTING_INDEX);
                continue;
            }
            outputText += (char) ((currentChar - key + STARTING_INDEX) % NUMBER_OF_CHARACTERS + STARTING_INDEX);
        }
        return outputText;
    }

    public static void main(String[] args) {
        System.out.println(encrypt(1, "HELLOBOY"));
        System.out.println(decrypt(1, "IZXVWKLW"));
        System.out.println(decrypt(12, encrypt(12, "WHATISUP")));
    }
}
