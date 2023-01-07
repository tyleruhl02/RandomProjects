package HighSchool.CnData.lab1;

/**
 * Created by bryres on 1/31/2017.
 */
public class Ex12_4 {
    public static void main(String[] args) {
        try {
            new Loan(-14, 3, 9);
            System.out.println("Failed 1.");
        }
        catch (IllegalArgumentException ex) {
            System.out.println("Passed 1: Exception in constructor caught.");
        }

        try {
            new Loan(6, 0, 9);
            System.out.println("Failed 2.");
        }
        catch (IllegalArgumentException ex) {
            System.out.println("Passed 2: Exception in constructor caught.");
        }

        try {
            new Loan(6, 18, -1);
            System.out.println("Failed 3.");
        }
        catch (IllegalArgumentException ex) {
            System.out.println("Passed 3: Exception in constructor caught.");
        }

        Loan l = new Loan(4, 6, 2);
        try {
            l.setAnnualInterestRate(-1);
            System.out.println("Failed 4.");
        }
        catch (IllegalArgumentException ex) {
            System.out.println("Passed 4: Exception in annual interest rate caught.");
        }

        try {
            l.setNumberOfYears(-5);
            System.out.println("Failed 5.");
        }
        catch (IllegalArgumentException ex) {
            System.out.println("Passed 5: Exception in years caught.");
        }

        try {
            l.setLoanAmount(-1);
            System.out.println("Failed 6.");
        }
        catch (IllegalArgumentException ex) {
            System.out.println("Passed 6: Exception in loan amount caught.");
        }


    }
}
