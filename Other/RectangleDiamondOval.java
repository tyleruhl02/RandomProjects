package HighSchool.Other;

public class RectangleDiamondOval {
    public static void main(String[] args) {
        /*Equation rect1 = new Equation("0", 5);
        Equation rect2 = new Equation("0", -5);
        Equation rect3 = new Equation("a", 3);
        Equation rect4 = new Equation("a", -3);

        Equation diam1 = new Equation("2.5/1.5", 5);
        Equation diam2 = new Equation("2.5/1.5", -5);
        Equation diam3 = new Equation("-2.5/1.5", 5);
        Equation diam4 = new Equation("-2.5/1.5", -5);

        Equation[] equations = {rect1, rect2, rect3, rect4, diam1, diam2, diam3, diam4};*/
        int[][] points = new int[360][2];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 360; j++) {
                Equation e;
                if (j < 45) {
                    e = new Equation(j + "/45", 0);
                }
                else if (j < 90) {
                    e = new Equation((j-45)+"", 0);
                }
                else if (j < 135) {
                    e = new Equation((j-90)*-1+"", 0);
                }
                else if (j < 180) {
                    e = new Equation((j-135)*-1+"/45", 0);
                }
                else if (j < 225) {
                    e = new Equation((j-180) + "/45", 0);
                }
                else if (j < 270) {
                    e = new Equation((j-225)+"", 0);
                }
                else if (j < 315) {
                    e = new Equation((j-270)*-1+"", 0);
                }
                else {
                    e = new Equation((j-315)*-1+"/45", 0);
                }
                System.out.println(e.getDoubleM());
                //points[j] = equations[i].intersects(e);
            }
        }
    }
}