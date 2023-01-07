package HighSchool.AP;

public class TwelveDays {

    private static String singThatSong() {
        String textOutput = "";
        String[] firstWordCases = {"first","second","third","fourth","fifth","sixth","seventh","eigth","ninth","tenth","eleventh","twelfth"};

        for(int iteration = 0; iteration < 12; iteration++) {
            textOutput += "On the " + firstWordCases[iteration] + " day of high school my, my teacher gave to me\n";

            switch(iteration) {
                case 11:
                    textOutput += "Twelve lunch detentions\n";
                case 10:
                    textOutput += "Eleven vocab lists\n";
                case 9:
                    textOutput += "Ten Practice Problems\n";
                case 8:
                    textOutput += "Nine performance skits\n";
                case 7:
                    textOutput += "Eight examinations\n";
                case 6:
                    textOutput += "Seven lab reports\n";
                case 5:
                    textOutput += "Six chapters' reading\n";
                case 4:
                    textOutput += "Five Shakespeare plays!\n";
                case 3:
                    textOutput += "Four hundred emails\n";
                case 2:
                    textOutput += "Three rough drafts\n";
                case 1:
                    textOutput += "Two problem sets\nAnd ";
                case 0:
                    String endingCase = iteration == 0 ? "A" : "a";
                    textOutput += endingCase + " lecture about my workload\n\n";
                    break;
            }
        }
        return textOutput;
    }
    public static void main(String[] args) {
        System.out.println(singThatSong());
    }
}
