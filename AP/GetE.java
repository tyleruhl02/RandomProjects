package HighSchool.AP;

public class GetE {
    private static int factorial(int n) {
        return n == 0 ? 1 : n*factorial(n-1);
    }

    public static void main(String[] args) {
        //Scanner fred = new Scanner(System.in);
        int n = Integer.parseInt(args[0]); //fred.nextInt();
        double eEstimate = 0;
        for (int i = 0; i < n; i++) {
            eEstimate += 1.0/(factorial(i));
        }
        System.out.printf("%.9f", eEstimate);
    }
}