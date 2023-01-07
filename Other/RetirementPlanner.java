package HighSchool.Other;

import java.util.Scanner;

public class RetirementPlanner {
    public static void main(String[] args) {
        Scanner Shira = new Scanner(System.in);

        System.out.println("How much do you plan to save per year?");
        double salary = Shira.nextDouble();

        System.out.println("How many years do you have until retirement?");
        int years = Shira.nextInt();

        System.out.println("How much do you expect to earn per year?");
        System.out.println("     (Enter as percentage 7.5% should be entered as 7.5)");
        double percentage = Shira.nextDouble()/100;

        double total = 0;
        double earnings = 0;

        System.out.printf("%5s%12s%12s%12s%12s\n", "Year", "Starting", "Deposit", "Earnings", "Ending");

        for (int i = 0; i <= years; i++) {
            if(i == 1)
                earnings = 1;
            earnings = total*percentage;
            System.out.printf("%5d%,12.2f%,12.2f%,12.2f%,12.2f\n", i, total, salary, earnings, total+earnings+salary);
            total += earnings+salary;
        }
    }
}
