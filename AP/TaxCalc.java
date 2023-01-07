package HighSchool.AP;

import java.text.DecimalFormat;

public class TaxCalc {

    private static DecimalFormat formatter = new DecimalFormat("#,###.00");
    private static final int MAX_BRACKET = 217450;
    private static final int SECOND_MAX_BRACKET = 142700;
    private static final int THIRD_MAX_BRACKET = 70700;
    private static final int FOURTH_MAX_BRACKET = 17400;
    private static final double HIGHEST_PERCENT = 0.33;
    private static final double SECOND_HIGHEST_PERCENT = 0.28;
    private static final double THIRD_HIGHEST_PERCENT = 0.25;
    private static final double FOURTH_HIGHEST_PERCENT = 0.15;

    public static String newTax(double income) {
        return "$" + formatter.format(newTaxCalc(income));
    }

    private static double newTaxCalc (double income) {
        if(income < MAX_BRACKET) {
            return oldTaxCalc(income);
        }
        else {
            return income * HIGHEST_PERCENT;
        }
    }

    public static String oldTax(double income) {
        return "$" + formatter.format(oldTaxCalc(income));
    }

    private static double oldTaxCalc (double income) {
        double tax = 0;
        if (income >= MAX_BRACKET) {
            tax += (income - MAX_BRACKET) * HIGHEST_PERCENT;
            income = MAX_BRACKET - 0.01;
        }
        if (income >= SECOND_MAX_BRACKET && income < MAX_BRACKET) {
            tax += (income - SECOND_MAX_BRACKET) * SECOND_HIGHEST_PERCENT;
            income = SECOND_MAX_BRACKET - 0.01;
        }
        if (income >= THIRD_MAX_BRACKET && income < SECOND_MAX_BRACKET) {
            tax += (income - THIRD_MAX_BRACKET) * THIRD_HIGHEST_PERCENT;
            income = THIRD_MAX_BRACKET-0.01;
        }
        if (income > FOURTH_MAX_BRACKET && income < THIRD_MAX_BRACKET) {
            tax += ((income - FOURTH_MAX_BRACKET) * FOURTH_HIGHEST_PERCENT) + (FOURTH_MAX_BRACKET/10);
        }

        return tax;
    }

    private static String taxDifference (double income) {
        return "$" + formatter.format(newTaxCalc(income) - oldTaxCalc(income));
    }

    public static void main(String[] args) {
        double salary = 5000000;
        System.out.println(oldTax(salary));
        System.out.println(newTax(salary));
        System.out.println(taxDifference(salary));
    }
}
