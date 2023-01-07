package HighSchool.CnData;

public class ComparingCases {
    private static int compareCases(String s) throws IllegalArgumentException {
        int UCcount = 0;
        int LCcount = 0;
        for (int i = 0; i < s.length(); i++) {
            if(Character.isUpperCase(s.charAt(i))) {
                UCcount++;
            }
            else if (Character.isLowerCase(s.charAt(i))) {
                LCcount++;
            }
            else {
                throw new IllegalArgumentException();
            }
        }
        return UCcount-LCcount;
    }

    public static void main(String[] args) {
        System.out.println(compareCases("ABBh"));
        System.out.println(compareCases("g5"));
        System.out.println(compareCases("m?h"));
    }
}
