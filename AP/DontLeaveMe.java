package HighSchool.AP;

import java.util.Scanner;

public class DontLeaveMe {
    public static void main(String[] args) {
        Scanner fred = new Scanner(System.in);
        String repeatText = "";

        while (!repeatText.toLowerCase().equals("exit")) {
            System.out.print("What should I say? ");
            repeatText = fred.nextLine();
            if(!repeatText.toLowerCase().equals("exit")) {
                System.out.println(repeatText + "\n");
            }
        }
        System.out.println("Exiting...");
    }
}
