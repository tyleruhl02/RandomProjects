package HighSchool.AP.Object_Lab;

import java.util.Random;

public class DumbGambler implements Gambler {
    private double balance;

    public DumbGambler(int balance) {
        this.balance = balance;
    }

    private Team coinFlip(Team t1, Team t2) {
        if(new Random().nextInt(2) == 1) {
            return t1;
        }
        return t2;
    }

    private double betAmount() {
        return new Random().nextInt(((int)balance)+1);
    }

    @Override
    public double gamble(Team t1, Team t2) {
        if(coinFlip(t1, t2).equals(t1)) {
            return betAmount();
        }
        else {
            return betAmount()*-1;
        }
    }

    @Override
    public void transactMoney(int amount) {
        balance += amount;
    }
}
