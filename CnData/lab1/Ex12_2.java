package HighSchool.CnData.lab1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex12_2 {
    public static void main(String[] args) {
        Scanner fred = new Scanner(System.in);

        int int1 = 0;
        int int2 = 0;

        while(int1 == 0 || int2 == 0) {
            try {
                System.out.print("Type in an integer. ");
                int1 = fred.nextInt();
                System.out.print("Type in another integer. ");
                int2 = fred.nextInt();
                break;
            }
            catch(InputMismatchException e) {
                System.out.println("\u001B[42m\u001B[31mType in an INTEGER!\u001B[0m"); // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
                int1 = 0;
                int2 = 0;
                fred.nextLine();
            }
        }
        System.out.printf("The sum of %d and %d is %d.", int1, int2, int1+int2);
    }
}
