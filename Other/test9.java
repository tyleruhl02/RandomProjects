package HighSchool.Other;

public class test9 {
    public static void main(String[] args) {
        int count = 0;
        int n = 6;
        int[] a = new int[100];
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(a[i] + a[j] == 0) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
