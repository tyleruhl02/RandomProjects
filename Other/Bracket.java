package HighSchool.Other;

public class Bracket {
    public static void main(String[] args) {
        Compete c = new Compete();

        final int[] NCAABRACKET2019 = { 74, 210,
                                        329, 44,
                                        176, 142,
                                        330, 257,
                                        163, 21,
                                        149, 351,
                                        152, 175,
                                        171, 28,

                                        103, 85,
                                        294, 20,
                                        159, 188,
                                        90, 327,
                                        33, 12,
                                        306, 218,
                                        192, 91,
                                        172, 184,

                                        331, 95,
                                        178, 226,
                                        346, 231,
                                        133, 317,
                                        328, 258,
                                        244, 227,
                                        50, 127,
                                        299, 55,

                                        208, 125,
                                        323, 336,
                                        17, 195,
                                        134, 213,
                                        126, 224,
                                        115, 101,
                                        347, 269,
                                        137, 0};

        int[] round1 = NCAABRACKET2019.clone();
        int[] round2 = new int[32];
        int[] round3 = new int[16];
        int[] round4 = new int[8];
        int[] round5 = new int[4];
        int[] round6 = new int[2];
        int champion = -1;
        DataReader r = new DataReader();
        Team[] teams = r.getStats();
        int a = 0;
        for (int i = 0; i < round1.length; i++) {
            System.out.println(teams[round1[i]].name);
        }
        System.out.println("\n");

        for (int i = 0; i < round1.length; i+=2) {
            round2[i/2] = c.getWinner(round1[i], round1[i+1]);
        }
        System.out.println("\n");
        for (int i = 0; i < round2.length; i++) {
            System.out.println(teams[round2[i]].name);
        }
        System.out.println("\n");

        for (int i = 0; i < round2.length; i+=2) {
            round3[i/2] = c.getWinner(round2[i], round2[i+1]);
        }
        System.out.println("\n");
        for (int i = 0; i < round3.length; i++) {
            System.out.println(teams[round3[i]].name);
        }
        System.out.println("\n");

        for (int i = 0; i < round3.length; i+=2) {
            round4[i/2] = c.getWinner(round3[i], round3[i+1]);
        }
        System.out.println("\n");
        for (int i = 0; i < round4.length; i++) {
            System.out.println(teams[round4[i]].name);
        }
        System.out.println("\n");

        for (int i = 0; i < round4.length; i+=2) {
            round5[i/2] = c.getWinner(round4[i], round4[i+1]);
        }
        System.out.println("\n");
        for (int i = 0; i < round5.length; i++) {
            System.out.println(teams[round5[i]].name);
        }
        System.out.println("\n");

        for (int i = 0; i < round5.length; i+=2) {
            round6[i/2] = c.getWinner(round5[i], round5[i+1]);
        }
        System.out.println("\n");
        for (int i = 0; i < round6.length; i++) {
            System.out.println(teams[round6[i]].name);
        }
        System.out.println("\n");

        champion = c.getWinner(round6[0], round6[1]);
        System.out.println("\n");
        System.out.println(teams[champion].name);
    }
}
