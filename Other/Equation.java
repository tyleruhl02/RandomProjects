package HighSchool.Other;

public class Equation {
    private String m;
    private int b;
    private double doubleM;

    public Equation(String m, int b) {
        this.m = m;
        this.b = b;
        this.doubleM = getMvalue();
    }

    private double getMvalue() {
        int mIndex = m.indexOf('/');
        System.out.println(mIndex);
        if (mIndex == -1) {
            return Double.parseDouble(m);
        }
        return (Double.parseDouble(m.substring(0, mIndex)))/(Double.parseDouble(m.substring(mIndex+1)));
    }

    public String getM() {
        return m;
    }

    public int getB() {
        return b;
    }

    public double getDoubleM() {
        return doubleM;
    }

    public int[] intersects (Equation e) {
        return new int[] {0, 0};
    }
}