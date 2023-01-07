package HighSchool.AP;

public class MakeChange {

    public static String makeChange(double money) {
        final int[] MODS = {10000, 5000, 2000, 1000, 500, 100, 25, 10, 5, 1};
        int[] amounts = new int[10];
        String returnString = "";
        int currency = (int) Math.round(money * 100);

        for (int i = 0; i < 10; i++) {
            amounts[i] = currency / MODS[i];
            currency %= MODS[i];
            returnString += amounts[i] + " ";
        }

        return returnString.substring(0, returnString.length()-1);
    }

    public static void main(String[] args) {
        System.out.println(makeChange(1.15));
    }
}
