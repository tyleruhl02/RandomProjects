package HighSchool.AP;

public class Banana extends Fruit {
    private boolean peeled;

    public Banana() {
        //super();
        peeled = false;
    }

    public void peel() {
        peeled = true;
    }

    public void eat() {
        if(peeled) {
            super.eat();
        }
    }
}
