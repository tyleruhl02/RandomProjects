package HighSchool.Other;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class WordHunt {
    private static boolean isSame(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if(a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }

    private static int[] getRoute(int x, int y, int len, ArrayList<int[]> combos) {

        int[] route = new int[len];

        for (int i = 0; i < len; i++) {
            route[i] = 0;

            //if(route[i])
        }


        return new int[1];
    }

    private static int[][] getAllRoutes(char[][] arr) {
        ArrayList<int[]> combos = new ArrayList<>();

        int[] temp = getRoute(0, 0, 3, combos);



        return new int[1][1];
    }

    public static void main(String[] args) throws Exception {
        File f = new File("words.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));
        ArrayList<String> words = new ArrayList<String>();
        String s;
        while ((s = br.readLine()) != null) {
            words.add(s.toUpperCase());
        }

        char[][] arr = new char[4][4];
        
        Scanner fred = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            String line = fred.nextLine();
            arr[i][0] = line.charAt(0); arr[i][1] = line.charAt(1);
            arr[i][2] = line.charAt(2); arr[i][3] = line.charAt(3);
        }

        int[][] allRoutes = getAllRoutes(arr);

        /*for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }*/
    }
}