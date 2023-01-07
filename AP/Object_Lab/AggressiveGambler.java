package HighSchool.AP.Object_Lab;

public class AggressiveGambler implements Gambler {
    private double balance;

    public AggressiveGambler(int balance) {
        this.balance = balance;
    }

    @Override
    public double gamble(Team t1, Team t2) {
        int odds = calculateOdds(t1, t2);
        if(odds == 0) {
            return 0;
        }
        if(odds > 0) {
            return balance;
        }
        else if(odds < 0) {
            return balance*-1;
        }
        else {
            return 0;
        }
    }

    private int calculateOdds(Team t1, Team t2) {
        int t1s = t1.getTeamStrength();
        int t2s = t2.getTeamStrength();
        int t1m = t1.getMorale();
        int t2m = t2.getMorale();

        int team1score = (int) (t1s * ((t1m+10)/5.0));
        int team2score = (int) (t2s * ((t2m+10)/5.0));

        return team1score-team2score;
    }

    @Override
    public void transactMoney(int amount) {
        balance += amount;
    }
}
