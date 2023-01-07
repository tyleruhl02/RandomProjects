package HighSchool.Other;

import java.util.ArrayList;
import java.util.Arrays;

public class RU_Class {
    private String id;
    private String name;
    private ArrayList<String> tags;

    public RU_Class(String id, String name) {
        this.id = id;
        this.name = name;
        this.tags = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTags() {
        return Arrays.toString(tags.toArray());
    }

    public void addTag(String tag) {
        this.tags.add(tag);
    }

    @Override
    public String toString() {
        return "ID: " + this.id + "\tNAME: " + this.name + "\tTAGS: " + "" + Arrays.toString(tags.toArray()) + "";
    }
}
