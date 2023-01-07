package HighSchool.Other;

import java.util.Scanner;

public class RomanNumeralConverter {
    public static void main(String[] args) {
        Scanner fred = new Scanner(System.in);

        int num = fred.nextInt();

        String s = "";
        for (int i = 0; i < num; i++) {
            s += "I";
        }

        System.out.println(s);
        s = s.replace("IIIII", "V");
        System.out.println(s);
        s = s.replace("IIII", "IV");
        System.out.println(s);
        s = s.replace("VV", "X");
        System.out.println(s);
        s = s.replace("VIV", "IX");
        System.out.println(s);
        s = s.replace("XXXXX", "L");
        System.out.println(s);
        s = s.replace("XXXX", "XL");
        System.out.println(s);
        s = s.replace("LL", "C");
        System.out.println(s);
        s = s.replace("LXL", "XC");
        System.out.println(s);
        s = s.replace("CCCCC", "D");
        System.out.println(s);
        s = s.replace("CCCC", "CD");
        System.out.println(s);
        s = s.replace("DD", "M");
        System.out.println(s);
        s = s.replace("DCD", "CM");
        System.out.println(s);
    }
}
