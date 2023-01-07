package HighSchool.Other;

public class Person {
    private double skill;
    private double luck;

    public Person(double skill, double luck) {
        this.skill = skill;
        this.luck = luck;
    }

    public double getSkill() {
        return skill;
    }

    public double getLuck() {
        return luck;
    }

    @Override
    public String toString() {
        return "Client{" +
                "skill=" + skill +
                ", luck=" + luck +
                '}';
    }
}
