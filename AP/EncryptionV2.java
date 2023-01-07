package HighSchool.AP;

public class EncryptionV2 {

    private final static int STARTING_INDEX = 32;
    private final static int NUMBER_OF_CHARACTERS = 95;

    public static String encrypt(int key, String text) {
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
        String outputText = "";
        char currentChar;
        for (int i = 0; i < text.length(); i++) {
            currentChar = (char) (((text.charAt(i) - key - STARTING_INDEX) % NUMBER_OF_CHARACTERS + NUMBER_OF_CHARACTERS) % NUMBER_OF_CHARACTERS + STARTING_INDEX);
            key = key + currentChar;
            outputText += currentChar;
        }
        return outputText;
    }

    public static void main(String[] args) {
        System.out.println(decrypt(16, encrypt(16, "Four score and seven years ago our fathers brought forth on this continent, a new nation, conceived in Liberty, and dedicated to the proposition that all men are created equal.")));
        System.out.println(decrypt(10, encrypt(10, "Hello")));
    }
}