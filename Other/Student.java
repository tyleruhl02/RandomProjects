package HighSchool.Other;

public class Student {
    private double Tri1Grade;
    private double Tri2Grade;
    private double Tri3Grade;
    private boolean sweat;

    public Student(double tri1Grade, double tri2Grade, double tri3Grade, boolean sweat) {
        Tri1Grade = tri1Grade;
        Tri2Grade = tri2Grade;
        Tri3Grade = tri3Grade;
        this.sweat = sweat;
    }

    public double getTri1Grade() {
        return Tri1Grade;
    }

    public double getTri2Grade() {
        return Tri2Grade;
    }

    public double getTri3Grade() {
        return Tri3Grade;
    }

    @Override
    public String toString() {
        return  "Tri1Grade=" + Math.round(Tri1Grade*10)/10.0 +
                ", Tri2Grade=" + Math.round(Tri2Grade*10)/10.0 +
                ", Tri3Grade=" + Math.round(Tri3Grade*10)/10.0 + (sweat?", sweat":"");
    }
}
