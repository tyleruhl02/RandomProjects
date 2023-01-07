package HighSchool.CnData;

import java.util.Random;

public class CreatingACircle {
    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 0; i < 50; i++) {
            System.out.println(r.nextInt(2));
        }
    }
}
