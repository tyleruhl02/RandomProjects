package HighSchool.CnData.BCA;

import java.util.Arrays;

public class Yurrr {
    public static void main(String[] args) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = new int[10];
        two = one.clone();
        System.out.println(Arrays.toString(two));
    }
}
