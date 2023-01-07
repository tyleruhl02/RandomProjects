package HighSchool.AP.Object_Lab;

// Part B1b: Aidan, Patrick
public class Player implements SportsProfessional {
    private final double SPEED_CHANCE = .10;
    private final double ENDURANCE_CHANCE = .20;
    private final double HITSTRENGTH_CHANCE = .30;
    private final double ACCURACY_CHANCE = .10;

    private String name;

    // All stats measured from 0 - MAX_STAT, 0 being worst MAX_STAT being best
    private int speed;
    private int endurance;
    private int hitStrength;
    private int accuracy;

    public Player(String name) {
        this.name = name;
        this.speed = 0;
        this.endurance = 0;
        this.hitStrength = 0;
        this.accuracy = 0;
    }

    public Player(String name, int speed, int endurance, int hitStrength, int accuracy) {
        this.name = name;
        this.speed = speed;
        this.endurance = endurance;
        this.hitStrength = hitStrength;
        this.accuracy = accuracy;
    }

    public void practice() {
        //Stats come in pairs, speed+endurance / hitStrength+accuracy, only one of each pair can reach 10

        if(speed < MAX_STAT && endurance < MAX_STAT) {
            if(speed > endurance) {
                if(Math.random() < ENDURANCE_CHANCE)
                    endurance++;
            }
            else {
                if(Math.random() < SPEED_CHANCE)
                    speed++;
            }
        }

        if(hitStrength < MAX_STAT && accuracy < MAX_STAT) {
            if(hitStrength > accuracy) {
                if(Math.random() < ACCURACY_CHANCE)
                    accuracy++;
            }
            else {
                if(Math.random() < HITSTRENGTH_CHANCE)
                    hitStrength++;
            }
        }
    }

    public int perform() {
        int pre_luck = (speed * endurance) + (hitStrength * accuracy);
        int luck = (int)(Math.random() * MAX_PERFORM_VARIANCE) + 1;
        int performance = pre_luck * luck;
        return performance;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public int getEndurance() {
        return endurance;
    }

    public int gethitStrength() {
        return hitStrength;
    }

    public int getAccuracy() {
        return accuracy;
    }
}