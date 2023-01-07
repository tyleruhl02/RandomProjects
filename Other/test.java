package HighSchool.Other;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        //double Y = 100;
        //double p1 = 8;
        //double p2 = 4;
        //double q1 = 4*((p2*p2)/(p1*p1));
        //double q2 = (Y/p2) - (4*p2)/p1;
        //double u = 4*(Math.sqrt(q1))+q2;
        //double q1 = 10*p2/p1;
        //double q2 = Y/p2-10;
        //double u = 10*Math.log(q1)+q2;
        /*double q1 = Y/(p1+p2*Math.sqrt(p1/p2));
        double q2 = Y/(p1*Math.sqrt(p2/p1)+p2);
        double u = -1/q1-1/q2;

        System.out.println(q1);
        System.out.println(q2);
        System.out.println(p1*q1+p2*q2);

        System.out.println(u);


        double x = 1;

        for (int i = 0; i < 365*10; i++) {
            x *= 1.001;
        }

        System.out.println(x);*/

        /*double x = 8.73;
        int needed = 33;
        double total = 0;

        for (int i = 0; i < needed; i++) {
            total += x;
            //System.out.println(x);
            x = x*1.07;
        }

        System.out.println(total);

        double mps = 93.30;
        double multiplier = 0.001;

        System.out.println(total/(mps*multiplier)/60);*/


        // 4294967296
        // 2321312130


        for(int i = -10; i <= 10; i++) {
            System.out.println("x: " + i + "\tx^3 - x: " + ((i*i*i) - i));
        }
    }
}
