package HighSchool.Other;

public class Arc {
    private static String equation;
    private static int lowerBound;
    private static int upperBound;

    public Arc(String equation) {
        this.equation = equation;
    }

    private void parseEquation() {
        String[] values = equation.split("/+");
        System.out.println(values);
    }

    public static String getEquation() {
        return equation;
    }

    public static void setEquation(String equation) {
        Arc.equation = equation;
    }
}
