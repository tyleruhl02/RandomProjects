package HighSchool.Other;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Compete {
    public static Map<String, Integer> possession(Team offense, Team defense, Map<String, Integer> m) {
        Random r = new Random();
        if(r.nextInt(1000) < defense.stealPercentage*10) { // Defense steals ball
            m.replace("team2steals",  m.get("team2steals")+1);
            m.replace("team1tovs",  m.get("team1tovs")+1);
            return m;
        }
        else if(r.nextInt(1000) < (offense.turnoverPercentage*10)-(defense.stealPercentage*10)) { // Offense turns ball over
            m.replace("team1tovs",  m.get("team1tovs")+1);
            return m;
        }
        else if(r.nextInt(1000) < defense.foulPercentage*10) { // Offense is fouled
            m.replace("team1fouls",  m.get("team1fouls")+1);
            if(m.get("team2fouls") >= 7) { // Offense is in bonus
                if(m.get("team2fouls") <= 10) { // Offense is not in double bonus
                    if(r.nextInt(1000) < offense.freeThrowPercentage*10) { // Offense makes first free throw
                        m.replace("team1score",  m.get("team1score")+1);
                        m.replace("team1fts", m.get("team1fts")+1);
                        if(r.nextInt(1000) < offense.freeThrowPercentage*10) { // Offense makes second free throw
                            m.replace("team1score",  m.get("team1score")+1);
                            m.replace("team1fts", m.get("team1fts")+1);
                            return m;
                        }
                        else { // Offense misses second free throw
                            if(r.nextInt(1000) < offense.offensiveReboundPercentage*10) { // Offense gets offensive rebound
                                m.replace("team1rebs", m.get("team1rebs")+1);
                                m = possession(offense, defense, m);
                            }
                            m.replace("team2rebs", m.get("team2rebs")+1);
                            return m;
                        }
                    }
                    else { // Offense misses first free throw
                        if(r.nextInt(1000) < offense.offensiveReboundPercentage*10) { // Offense gets offensive rebound
                            m.replace("team1rebs", m.get("team1rebs")+1);
                            m = possession(offense, defense, m);
                        }
                        m.replace("team2rebs", m.get("team2rebs")+1);
                        return m;
                    }
                }
                else { // Offense is in double bonus
                    if(r.nextInt(1000) < offense.freeThrowPercentage*10) { // Offense makes first free throw
                        m.replace("team1score",  m.get("team1score")+1);
                        m.replace("team1fts", m.get("team1fts")+1);
                    }
                    if(r.nextInt(1000) < offense.freeThrowPercentage*10) { // Offense makes second free throw
                        m.replace("team1score",  m.get("team1score")+1);
                        m.replace("team1fts", m.get("team1fts")+1);
                    }
                    else { // Offense misses second free throw
                        if(r.nextInt(1000) < offense.offensiveReboundPercentage*10) { // Offense gets offensive rebound
                            m.replace("team1rebs", m.get("team1rebs")+1);
                            m = possession(offense, defense, m);
                        }
                        m.replace("team2rebs", m.get("team2rebs")+1);
                        return m;
                    }
                }
            }
        }
        else if(r.nextInt(1000) < defense.blockPercentage*10) { // Shot blocked
            m.replace("team2blocks",  m.get("team2blocks")+1);
            if(r.nextInt(2) == 0) {
                m.replace("team1rebs", m.get("team1rebs")+1);
                m = possession(offense, defense, m);
            }
            m.replace("team2rebs", m.get("team2rebs")+1);
            return m;
        }
        else if(r.nextInt(1000) < offense.threePointShotPercentage*10) { // Offense takes a 3pointer
            if(r.nextInt(1000) < offense.threePointFieldGoalPercentage*10) { // Offense makes a 3pointer
                m.replace("team1score",  m.get("team1score")+3);
                return m;
            }
            else { // Offense misses a 3pointer
                if(r.nextInt(1000) < offense.offensiveReboundPercentage*10) { // Offense gets offensive rebound
                    m.replace("team1rebs", m.get("team1rebs")+1);
                    m = possession(offense, defense, m);
                }
                m.replace("team2rebs", m.get("team2rebs")+1);
                return m;
            }
        }
        else if(r.nextInt(1000) < offense.threePointShotPercentage*10) { // Offense takes a 3pointer
            if(r.nextInt(1000) < offense.threePointFieldGoalPercentage*10) { // Offense makes a 3pointer
                m.replace("team1score", m.get("team1score")+3);
                m.replace("team1threes", m.get("team1threes")+1);
                return m;
            }
            else { // Offense misses a 3pointer
                if(r.nextInt(1000) < offense.offensiveReboundPercentage*10) { // Offense gets offensive rebound
                    m.replace("team1rebs", m.get("team1rebs")+1);
                    m = possession(offense, defense, m);
                }
                m.replace("team2rebs", m.get("team2rebs")+1);
                return m;
            }
        }
        else if(r.nextInt(1000) < offense.twoPointFieldGoalPercentage*10) { // Offense makes 2pointer
            m.replace("team1score",  m.get("team1score")+2);
            m.replace("team1twos", m.get("team1twos")+1);
            return m;
        }
        else { // Offense misses 2pointer
            if(r.nextInt(1000) < offense.offensiveReboundPercentage*10) { // Offense gets offensive rebound
                m.replace("team1rebs", m.get("team1rebs")+1);
                m = possession(offense, defense, m);
            }
            m.replace("team2rebs", m.get("team2rebs")+1);
            return m;
        }
        return m;
    }

    public static Map<String, Integer> compete(Team team1, Team team2) {
        int totalPossessions = ((int)(team1.possessionsPerGame + team2.possessionsPerGame)) / 2;
        //boolean team1pos = true;
        Map<String, Integer> m = new HashMap<String, Integer>();
        m.put("team1score", 0);
        m.put("team2score", 0);
        m.put("team1rebs", 0);
        m.put("team2rebs", 0);
        m.put("team1fouls", 0);
        m.put("team2fouls", 0);
        m.put("team1threes", 0);
        m.put("team2threes", 0);
        m.put("team1twos", 0);
        m.put("team2twos", 0);
        m.put("team1fts", 0);
        m.put("team2fts", 0);
        m.put("team1steals", 0);
        m.put("team2steals", 0);
        m.put("team1blocks", 0);
        m.put("team2blocks", 0);
        m.put("team1tovs", 0);
        m.put("team2tovs", 0);

        int[] arr = new int[9];

        for (int i = 0; i < totalPossessions; i++) {
            m = possession(team1, team2, m);

            arr[0] = m.get("team1score");
            arr[1] = m.get("team1rebs");
            arr[2] = m.get("team1fouls");
            arr[3] = m.get("team1threes");
            arr[4] = m.get("team1twos");
            arr[5] = m.get("team1fts");
            arr[6] = m.get("team1steals");
            arr[7] = m.get("team1blocks");
            arr[8] = m.get("team1tovs");

            m.replace("team1score", m.get("team2score"));
            m.replace("team1rebs", m.get("team2rebs"));
            m.replace("team1fouls", m.get("team2fouls"));
            m.replace("team1threes", m.get("team2threes"));
            m.replace("team1twos", m.get("team2twos"));
            m.replace("team1fts", m.get("team2fts"));
            m.replace("team1steals", m.get("team2steals"));
            m.replace("team1blocks", m.get("team2blocks"));
            m.replace("team1tovs", m.get("team2tovs"));

            m.replace("team2score", arr[0]);
            m.replace("team2rebs", arr[1]);
            m.replace("team2fouls", arr[2]);
            m.replace("team2threes", arr[3]);
            m.replace("team2twos", arr[4]);
            m.replace("team2fts", arr[5]);
            m.replace("team2steals", arr[6]);
            m.replace("team2blocks", arr[7]);
            m.replace("team2tovs", arr[8]);

            m = possession(team2, team1, m);

            arr[0] = m.get("team1score");
            arr[1] = m.get("team1rebs");
            arr[2] = m.get("team1fouls");
            arr[3] = m.get("team1threes");
            arr[4] = m.get("team1twos");
            arr[5] = m.get("team1fts");
            arr[6] = m.get("team1steals");
            arr[7] = m.get("team1blocks");
            arr[8] = m.get("team1tovs");

            m.replace("team1score", m.get("team2score"));
            m.replace("team1rebs", m.get("team2rebs"));
            m.replace("team1fouls", m.get("team2fouls"));
            m.replace("team1threes", m.get("team2threes"));
            m.replace("team1twos", m.get("team2twos"));
            m.replace("team1fts", m.get("team2fts"));
            m.replace("team1steals", m.get("team2steals"));
            m.replace("team1blocks", m.get("team2blocks"));
            m.replace("team1tovs", m.get("team2tovs"));

            m.replace("team2score", arr[0]);
            m.replace("team2rebs", arr[1]);
            m.replace("team2fouls", arr[2]);
            m.replace("team2threes", arr[3]);
            m.replace("team2twos", arr[4]);
            m.replace("team2fts", arr[5]);
            m.replace("team2steals", arr[6]);
            m.replace("team2blocks", arr[7]);
            m.replace("team2tovs", arr[8]);

            System.out.println(m.get("team1score") + " - " + m.get("team2score"));
        }

        Object[] s = m.keySet().toArray();
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i] + ": " + m.get(s[i]));
        }

        double team1winpct = 30*(((double)team1.wins)/team1.games);
        double team2winpct = 30*(((double)team2.wins)/team2.games);

        double team1sos = team1.strengthOfSchedule+15;
        double team2sos = team2.strengthOfSchedule+15;

        double team1ptdiff = team1.avgPointDifferential*1.5;
        double team2ptdiff = team1.avgPointDifferential*1.5;

        //double team1change = team1winpct+team1sos+team1ptdiff;//((team1sos+team1.avgPointDifferential)*(Math.pow(team1winpct, 2)));
        //double team2change = team1winpct+team2sos+team2ptdiff;//((team2sos+team2.avgPointDifferential)*(Math.pow(team2winpct, 2)));

        double team1change = 0;
        double team2change = 0;

        //System.out.println(team1change);
        //System.out.println(team2change);

        m.replace("team1score", m.get("team1score") + ((int)(team1change-team2change)));

        if(m.get("team1score").equals(m.get("team2score"))) {
            m = compete(team1, team2);
        }

        //System.out.println(team1.name + ":" + m.get("team1score"));
        //System.out.println(team2.name + ":" + m.get("team2score"));
        //System.out.println("a");

        return m;
    }

    /*public int getWinner(int a, int b) {
        DataReader r = new DataReader();
        Team[] teams = r.getStats();
        Map<String, Integer> m;// = new HashMap<String, Integer>();
        int games = 11;
        double team1TP = 0;
        double team2TP = 0;
        int team1wins = 0;
        int team2wins = 0;
        for (int i = 0; i < games; i++) {
            m = compete(teams[a], teams[b]);
            team1TP += m.get("team1score");
            team2TP += m.get("team2score");
            if(m.get("team1score") > m.get("team2score")) {
                team1wins++;
            }
        }
        team2wins = games-team1wins;
        m = compete(teams[a], teams[b]);
        System.out.println(teams[a].name + ": " + (team1wins) + " - " + teams[b].name + ": " + (team2wins));
        //System.out.println(teams[a].name + " : " + teams[b].name);
        if(team1wins > team2wins) {
            return a;
        }
        return b;
    }*/

    public static int getWinner(int team1, int team2) {
        DataReader r = new DataReader();
        Team[] teams = r.getStats();
        Map<String, Integer> m = new HashMap<String, Integer>();

        int team1wins = 0;
        int team2wins = 0;

        double numOfGames = 1;

        /*int team1 = 74;
        int team2 = 149;*/

        int team1TP = 0;
        int team2TP = 0;

        for (int i = 0; i < numOfGames; i++) {
            m = compete(teams[team1], teams[team2]);
            team1TP += m.get("team1score");
            team2TP += m.get("team2score");
            if(m.get("team1score") > m.get("team2score")) {
                team1wins++;
            }
            else {
                team2wins++;
            }
        }
        if(team1wins > team2wins) {
            System.out.println(teams[team1].name);
        }
        else {
            System.out.println(teams[team2].name);
        }
        System.out.println(team1wins);
        System.out.println(team2wins);

        System.out.println((team1TP / numOfGames) + " - " + (team2TP/numOfGames));

        return team1wins > team2wins ? team1 : team2;
        /*int[] teamWins = new int[teams.length];
        int numOfGames = 1;

        for (int i = 0; i < teams.length; i++) {
            for (int j = 0; j < teams.length; j++) {
                if(i != j) {
                    for (int k = 0; k < numOfGames; k++) {
                        m = compete(teams[i], teams[j]);
                        teamWins[i] += m.get("team1score") > m.get("team2score") ? 1 : 0;
                    }
                }
            }
            System.out.println(teams[i].name);
        }

        for (int i = 0; i < teams.length; i++) {
            System.out.println(teams[i].name + ": " + 100*(teamWins[i] / (numOfGames*(teams.length-1))) + "%");
        }*/
    }

    public static void main(String[] args) {
        DataReader r = new DataReader();
        Team[] teams = r.getStats();
        Map<String, Integer> m = new HashMap<String, Integer>();

        System.out.printf("%5s%25s%5s%5s%5s%7s%7s%6s%6s%6s%6s%6s%6s%6s%6s%6s%6s%6s\n", "No.", "Name", "G", "W", "L", "PD", "SOS", "Pace", "FTr", "3PAr", "STL%", "BLK%", "TOV%", "ORB%", "2FG%", "3FG%", "FT%", "PF%");
        for (int i = 0; i < teams.length; i++) {
        //for(int i = 74; i < 100; i+=17) {
            System.out.printf("%5d%25s%5d%5d%5d%7.2f%7.2f%6.1f%6.1f%6.1f%6.1f%6.1f%6.1f%6.1f%6.1f%6.1f%6.1f%6.1f\n", i, teams[i].name, teams[i].games, teams[i].wins, teams[i].losses, teams[i].avgPointDifferential, teams[i].strengthOfSchedule, teams[i].possessionsPerGame, teams[i].freeThrowAttemptPercentage, teams[i].threePointShotPercentage, teams[i].stealPercentage, teams[i].blockPercentage, teams[i].turnoverPercentage, teams[i].offensiveReboundPercentage, teams[i].twoPointFieldGoalPercentage, teams[i].threePointFieldGoalPercentage, teams[i].freeThrowPercentage, teams[i].foulPercentage);
        }

        int team1 = 172;
        int team2 = 91;
        int a = getWinner(team1, team2);
        //System.out.println(a);
    }
}
