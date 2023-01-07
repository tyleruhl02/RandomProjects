package HighSchool.Other;

import java.util.Arrays;

public class ScrabblePlayer {
    private String name;
    private int score;
    private String[] tiles;
    private boolean isComputer;

    public ScrabblePlayer(String name, boolean isComputer) {
        this.name = name;
        this.score = 0;
        this.tiles = new String[] {"", "", "", "", "", "", ""};
        this.isComputer = isComputer;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore(int points) {
        score += points;
    }

    public String[] getTiles() {
        return tiles;
    }

    public void removeTile(String s) {
        for (int i = 0; i < tiles.length; i++) {
            if(s.equals(tiles[i])) {
                tiles[i] = "";
            }
        }
    }

    public void addTile(String s) {
        System.out.println(Arrays.toString(tiles));
        for (int i = 0; i < tiles.length; i++) {
            if(tiles[i].equals("")) {
                this.tiles[i] = s;
            }
        }
    }

    public boolean isComputer() {
        return isComputer;
    }
}
