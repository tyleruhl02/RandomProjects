package HighSchool.AP;

public class FruitRunner {
    public static void main(String[] args) {
        Banana myBanana = new Banana();
        myBanana.eat();
        System.out.println(myBanana.isEaten());
        myBanana.peel();
        myBanana.eat();
        System.out.println(myBanana.isEaten());
    }
}
