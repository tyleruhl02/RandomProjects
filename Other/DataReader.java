package HighSchool.Other;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataReader {
    //public static void main(String[] args) {
    public Team[] getStats() {
        List<List<String>> records = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\tyler\\IdeaProjects\\JavaProjects\\sportsref_download (1) - sportsref_download (1).csv"));
            String line;
            while ((line = br.readLine()) != null) {
                //System.out.println(line);
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        }
        catch(Exception e) {

        }
        Team[] teams = new Team[353];
        for (int i = 2; i < records.size(); i++) {
            teams[i-2] = new Team();
            teams[i-2].name = records.get(i).get(1).trim();
            teams[i-2].games = Integer.parseInt(records.get(i).get(2));
            teams[i-2].wins = Integer.parseInt(records.get(i).get(3));
            teams[i-2].losses = Integer.parseInt(records.get(i).get(4));
            teams[i-2].strengthOfSchedule = Double.parseDouble(records.get(i).get(7));
            teams[i-2].totalPoints = Integer.parseInt(records.get(i).get(14));
            teams[i-2].totalPointsAllowed = Integer.parseInt(records.get(i).get(15));
            teams[i-2].avgPointDifferential = ((double)(teams[i-2].totalPoints-teams[i-2].totalPointsAllowed))/teams[i-2].games;
            teams[i-2].possessionsPerGame = Double.parseDouble(records.get(i).get(16));
            teams[i-2].freeThrowAttemptPercentage = Double.parseDouble(records.get(i).get(18))*100;
            teams[i-2].threePointShotPercentage = Double.parseDouble(records.get(i).get(19))*100;
            teams[i-2].stealPercentage = Double.parseDouble(records.get(i).get(23));
            teams[i-2].blockPercentage = Double.parseDouble(records.get(i).get(24));
            teams[i-2].turnoverPercentage = Double.parseDouble(records.get(i).get(26));
            teams[i-2].offensiveReboundPercentage = Double.parseDouble(records.get(i).get(27));
            teams[i-2].totalShotsMade = Integer.parseInt(records.get(i).get(30));
            teams[i-2].totalShotsAttempted = Integer.parseInt(records.get(i).get(31));
            teams[i-2].totalThreesMade = Integer.parseInt(records.get(i).get(33));
            teams[i-2].totalThreesAttempted = Integer.parseInt(records.get(i).get(34));
            teams[i-2].twoPointFieldGoalPercentage = (((double)(teams[i-2].totalShotsMade - teams[i-2].totalThreesMade)) / ((double)(teams[i-2].totalShotsAttempted - teams[i-2].totalThreesAttempted)))*100;
            teams[i-2].threePointFieldGoalPercentage = (((double) teams[i-2].totalThreesMade) / ((double) teams[i-2].totalThreesAttempted))*100;
            teams[i-2].freeThrowPercentage = Double.parseDouble(records.get(i).get(38))*100;
            teams[i-2].foulPercentage = (Double.parseDouble(records.get(i).get(45)) / (teams[i-2].games * teams[i-2].possessionsPerGame))*100;
        }

        return teams;
    }
}
