package HighSchool.Other;

public class RealityTest {
    public static void main(String[] args) {
        Person[] people = new Person[100];
        for (int i = 0; i < people.length; i++) {
            people[i] = new Person(Math.random()*90, Math.random()*10);
        }

        Person[] topPeople = new Person[10];
        double max = 0;
        int maxIndex = 0;
        for (int i = 0; i < topPeople.length; i++) {
            for (int j = 0; j < people.length; j++) {
                if(people[j].getLuck()+people[j].getSkill() > max) {
                    max = people[j].getLuck()+people[j].getSkill();
                    maxIndex = j;
                }
            }
            topPeople[i] = people[maxIndex];
            people[maxIndex] = new Person(0, 0);
            max = 0;
            maxIndex = 0;
        }

        for (int i = 0; i < topPeople.length; i++) {
            System.out.println(topPeople[i]);
        }
    }
}
