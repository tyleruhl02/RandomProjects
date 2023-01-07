package HighSchool.AP.Object_Lab;

// Part B1c: Aidan, Patrick
public class Coach implements SportsProfessional {
    private final double KNOWLEDGE_CHANCE = .20;
    private final double CHARISMA_CHANCE = .30;

    private String name;
    //Once again all stats are rated 0-10
    private int gamesCoached;
    private int knowledge;
    private int charisma;

    public Coach(String name) {
        this.name = name;
        this.gamesCoached = 0;
        this.knowledge = 0;
        this.charisma = 0;
    }

    public Coach(String name, int gamesCoached, int knowledge, int charisma) {
        this.name = name;
        this.gamesCoached = gamesCoached;
        this.knowledge = knowledge;
        this.charisma = charisma;
    }

    public void practice() {
        if(charisma < MAX_STAT && knowledge < MAX_STAT) {
            if(charisma > knowledge) {
                if(Math.random() < KNOWLEDGE_CHANCE)
                    knowledge++;
            }
            else {
                if(Math.random() < CHARISMA_CHANCE)
                    charisma++;
            }
        }
    }

    public int perform() {
        int pre_luck = (knowledge * charisma) + (5 * gamesCoached);
        int luck = (int)(Math.random() * MAX_PERFORM_VARIANCE) + 1;
        int performance = pre_luck * luck;

        gamesCoached++;

        return performance;
    }

    public String getName() {
        return name;
    }

    public int getGamesCoached() {
        return gamesCoached;
    }

    public int getKnowledge() {
        return knowledge;
    }

    public int getCharisma() {
        return charisma;
    }
}