package HighSchool.Other;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;

public class StatsProject {
    public static String parseLine(String inputLine) {
        String[] items = inputLine.split(",");
        String outputStr = "";
        outputStr += items[2];
        int homeRuns = Integer.parseInt(items[11]);
        int atBats = Integer.parseInt(items[6]);
        double HRper100ABs = ((homeRuns*1.0) / atBats)*100;

        outputStr += "\t"+HRper100ABs;
        return outputStr;
    }

    public static void main(String[] args) throws Exception {
        File dir = new File("MLB_TEAMS");
        File[] fileArray = dir.listFiles();
        for (int i = 0; i < fileArray.length; i++) {
            //System.out.println(fileArray[i]);
            //System.out.println(fileArray[i].);
        }
        Random r = new Random();

        int randomTeam = 0;
        int randomPlayerNum = 0;
        File randomFile;
        String randomPlayer;
        BufferedReader br;

        for(int i = 0; i < 50; i++) {
            randomTeam = r.nextInt(30);
            randomPlayerNum = r.nextInt(9);
            randomFile = fileArray[randomTeam];
            br = new BufferedReader(new FileReader(randomFile));
            for (int j = 0; j < randomPlayerNum; j++) {
                br.readLine();
            }
            randomPlayer = br.readLine();
            System.out.println(i+1 + ":\t" + parseLine(randomPlayer));
        }

    }
}
