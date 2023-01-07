package HighSchool.AP.Object_Lab;

import java.util.ArrayList;

// Part B2: Aidan, Patrick
public class Team {
    private ArrayList<SportsProfessional> teamMembers;
    private int morale;

    public int compete() {
        int performance = 0;

        for(SportsProfessional sp : teamMembers) {
            performance += sp.perform();
        }

        return performance * ((10 + morale)/20);
    }

    public void train() {
        for(SportsProfessional sp : teamMembers) {
            sp.practice();
        }
    }

    public void handleResult(boolean result) {
        if(result) {        //WE WON!!! :)
            if(morale < 10)
                morale++;
        }
        else {              // :(
            if(morale > 0)
                morale--;
        }
    }

    public int getMorale() {
        return morale;
    }

    public int getTeamStrength() {
        int strength = 0;

        for(SportsProfessional sp : teamMembers) {
            if(sp instanceof Player) {
                strength += ((Player)sp).getAccuracy();
                strength += ((Player)sp).getEndurance();
                strength += ((Player)sp).getSpeed();
                strength += ((Player)sp).gethitStrength();
            }
            else {
                strength += ((Coach)sp).getCharisma();
                strength += ((Coach)sp).getGamesCoached() * 5;
                strength += ((Coach)sp).getKnowledge();
            }
        }

        return strength;
    }

    public SportsProfessional hireProfessional(SportsProfessional sp) {
        SportsProfessional toReturn = null;
        for(SportsProfessional s : teamMembers) {
            if(s.getClass().equals(sp.getClass())) {
                toReturn = s;
                teamMembers.remove(s);
                teamMembers.add(sp);
            }
        }
        return toReturn;
    }
}