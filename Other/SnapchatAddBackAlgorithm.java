package HighSchool.Other;

public class SnapchatAddBackAlgorithm {
    private static int crunchNumbers(int number) {
        return 10000-number;
    }

    private static int getValue(int retardity, int whatYouThinkOfPerson) {
        return crunchNumbers(retardity*whatYouThinkOfPerson);
    }

    public static void main(String[] args) {
        int retardity;
        int whatYouThinkOfPerson;

        for (retardity = 5; retardity <= 100; retardity+=5) {
            for (whatYouThinkOfPerson = 100; whatYouThinkOfPerson >= 5; whatYouThinkOfPerson-=5) {
                int value = getValue(retardity, whatYouThinkOfPerson);
                System.out.print("\t\t\t" + retardity + "," + whatYouThinkOfPerson + "\t: " + value);
            }
            System.out.println("\n");
        }
    }
}
