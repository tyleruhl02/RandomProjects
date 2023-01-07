package HighSchool.Other;

import java.util.Arrays;

public class test4 {
    static boolean[][] b = new boolean[40][60];

    private static int numOfSurroundingCells (int row, int column) {
        //if(row == 0) {

        //}
        //else if(row == MAX_ROWS-1) {
        //
        //}
        int count = 0;
        int[][] changers = {{-1, -1, -1, 0, 1, 1, 1, 0}, {1, 0, -1, -1, -1, 0, 1, 1}};
        for (int i = 0; i < 8; i++) {
            try {
                if (b[row + changers[0][i]][column + changers[1][i]]) {
                    count++;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                continue;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        //int[][][][][] hello = new int[1000000][1000000][1000000][1000000][1000000];
        //System.out.println("\u001B[41m\u001B[36mhello");
        for (int i = 0; i < b.length; i++) {
            System.out.println(Arrays.toString(b[i]));
        }
        b[0][0] = true;
        b[0][1] = true;
        b[1][1] = true;
        System.out.println(numOfSurroundingCells(1, 0));
        //System.out.println();
    }
}
