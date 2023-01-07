package HighSchool.AP;// MADE BY MARCUS AND TYLER

public class CalendarPrinter2 {
    private static int[] daysPerMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static String[] monthNames = "January February March April May June July August September October November December".split(" ");
    private static final String ANSI_RESET = "\u001B[0m"; // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
    private static final String ANSI_RED = "\u001B[31m"; // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

    private static int numberOfSpecialCharacters(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == '*') {
                count++;
            }
        }
        return count;
    }

    private static String getSpecialDay(int month, int dayOfWeek, int dayOfMonth) {
        if (month == 2 && dayOfWeek == 1 && (dayOfMonth >= 15 && dayOfMonth <= 21)) { // President's Day
            return "*p";
        }
        else if (month == 11 && dayOfMonth == 11) { // Veteran's Day
            return "*v";
        }
        else if (month == 11 && dayOfWeek == 4 && (dayOfMonth >= 22 && dayOfMonth <= 28)) { // Thanksgiving
            return "*t";
        }
        else if (month == 5 && dayOfWeek == 1 && (dayOfMonth >= 25 && dayOfMonth <= 31)) { // Memorial Day
            return "*m";
        }
        else if (month == 12 && dayOfMonth == 25) { // Christmas
            return "*c";
        }
        else if (month == 1 && dayOfMonth == 1) { // New Year's Day
            return "*y";
        }
        else if (month == 7 && dayOfMonth == 4) { // 4th of July
            return "*4";
        }
        else if (month == 9 && dayOfWeek == 1 && dayOfMonth <= 7) { // Labor Day
            return "*L";
        }
        else if (month == 4 && dayOfWeek == 1 && (dayOfMonth == 17 || dayOfMonth == 16)) { // Tax Day on Weekend
            return "*x";
        }
        else if (month == 4 && (dayOfWeek != 0 && dayOfWeek != 6) && dayOfMonth == 15) { // Normal Tax Day
            return "*x";
        }
        else if (dayOfMonth < 10) {
            return " " + dayOfMonth;
        }
        else {
            return "" + dayOfMonth;
        }
    }

    private static String getMonthPrintByWeek(int month, int dayOfWeek, int dayOfMonth, boolean leapYear, boolean returnBlank, boolean printSpecialDays) {
        if(returnBlank) {
            return "                     ";
        }
        String outputText = "";
        boolean monthOver = false;
        int dayCounter = dayOfMonth;
        for (int j = 0; j < 7; j++) {
            if (dayOfMonth == 1 && j < dayOfWeek) { // FILLS IN THE FIRST FEW BLANK DAYS
                outputText += "  ";
            }
            else {
                if(!monthOver) {
                    if(printSpecialDays) {
                        outputText += getSpecialDay(month, dayOfWeek, dayCounter);
                        dayOfWeek = (dayOfWeek + 1) % 7;
                    }
                    else {
                        outputText += dayCounter < 10 ? " " + dayCounter : dayCounter;
                    }
                    if (dayCounter >= daysPerMonth[month-1] + (leapYear ? 1 : 0)) { // CHECKS IF MONTH IS OVER
                        monthOver = true;
                    }
                }
                else {
                    outputText += "  ";
                }
                dayCounter ++;
            }
            outputText += " ";
        }
        return outputText;
    }

    private static int findFirstDayOfMonth(int month, int janFirst, boolean leapYear) {
        int firstDay = janFirst;
        for (int i = 1; i < month; i++) {
            firstDay = (firstDay + daysPerMonth[i - 1]) % 7;
            if (leapYear && i == 2) {
                firstDay = (firstDay + 1) % 7;
            }
        }
        return firstDay;
    }

    private static String getHeaderLine(int startMonth) {
        String outputText = startMonth == 7 ? "" : " ";
        String spaces = "";
        for (int i = 0; i < (20-monthNames[startMonth-1].length())/2; i++) {
            spaces += " ";
        }
        outputText += spaces + monthNames[startMonth-1] + spaces + "   ";

        spaces = "";
        for (int i = 0; i < (20-monthNames[startMonth].length())/2; i++) {
            spaces += " ";
        }
        outputText += spaces + monthNames[startMonth] + spaces + "   ";

        spaces = "";
        for (int i = 0; i < (20-monthNames[startMonth+1].length())/2; i++) {
            spaces += " ";
        }
        outputText += spaces + monthNames[startMonth + 1] + spaces;
        return outputText + "\nSu Mo Tu We Th Fr Sa   Su Mo Tu We Th Fr Sa   Su Mo Tu We Th Fr Sa";
    }

    public static void printMonth(int year, int month, int janFirst, boolean leapYear) {
        int firstDay = findFirstDayOfMonth(month, janFirst, leapYear);
        String outputText = "";
        for (int i = 0; i < (20 - (monthNames[month - 1].length() + 1 + (year + "").length())) / 2; i++) { // CENTERS THE HEADING
            System.out.print(" ");
        }
        System.out.println(monthNames[month - 1] + " " + year);
        System.out.println("Su Mo Tu We Th Fr Sa");
        int dayCounter = 1;
        int dayOfWeek = firstDay;
        for (int i = 0; i < 6; i++) {
            outputText += getMonthPrintByWeek(month, dayOfWeek, dayCounter, leapYear, false, false); // GETS A STRING OF THE WEEK
            if (dayCounter == 1) { // ADDS NEW WEEK
                dayCounter += 7 - dayOfWeek;
            } else {
                dayCounter += 7;
            }
            dayOfWeek = 0;
            if (dayCounter > daysPerMonth[month - 1] + (leapYear ? 1 : 0)) { // CHECKS IF MONTH IS OVER
                break;
            }
            outputText += "\n";
        }
        if (outputText.contains("*")) {                                     // PRINTING OUT IN RED
            int numberOfSpecials = numberOfSpecialCharacters(outputText);
            int indexOfSpecial = 0;
            for (int i = 0; i < numberOfSpecials; i++) {
                indexOfSpecial = outputText.indexOf("*", indexOfSpecial);
                System.out.print(outputText.substring(0, indexOfSpecial));
                System.out.print(ANSI_RED + outputText.substring(indexOfSpecial, indexOfSpecial + 2) + ANSI_RESET); // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
            }
            System.out.println(outputText.substring(indexOfSpecial + 2));
        } else {
            System.out.println(outputText);
        }

    }

    public static void printYear (int year, int janFirst, boolean leapYear) {
        for (int i = 0; i < (66 - (""+year).length())/2; i++) { // CENTERS HEADING
            System.out.print(" ");
        }
        System.out.println(year);

        int month = 1;

        for (int i = 0; i < 4; i++) {
            int[] daysOfWeeks = {findFirstDayOfMonth(month, janFirst, leapYear), findFirstDayOfMonth(month+1, janFirst, leapYear), findFirstDayOfMonth(month+2, janFirst, leapYear)};
            int[] dayCounters = {1, 1, 1};
            boolean[] monthOver = {false, false, false};
            String outputText = "";
            System.out.println(getHeaderLine(month));
            for (int j = 0; j < 6; j++) {
                outputText =    getMonthPrintByWeek(month, daysOfWeeks[0], dayCounters[0], leapYear, monthOver[0], true) + "  " +
                                getMonthPrintByWeek(month+1, daysOfWeeks[1], dayCounters[1], leapYear, monthOver[1], true) + "  " +
                                getMonthPrintByWeek(month+2, daysOfWeeks[2], dayCounters[2], leapYear, monthOver[2], true);
                for (int k = 0; k < 3; k++) {
                    if (dayCounters[k] == 1) { // ADDS NEW WEEK
                        dayCounters[k] += 7 - daysOfWeeks[k];
                    } else {
                        dayCounters[k] += 7;
                    }
                    daysOfWeeks[k] = 0;
                    if (dayCounters[k] > daysPerMonth[month - 1 + k] + (leapYear ? 1 : 0)) { // CHECKS IF MONTH IS OVER
                        monthOver[k] = true;
                    }
                }
                if (outputText.contains("*")) {                                     // PRINTING OUT IN RED
                    int numberOfSpecials = numberOfSpecialCharacters(outputText);
                    int indexOfSpecial = 0;
                    int startIndex = 0;
                    for (int k = 0; k < numberOfSpecials; k++) {
                        indexOfSpecial = outputText.indexOf("*", indexOfSpecial+1);
                        System.out.print(outputText.substring(startIndex, indexOfSpecial));
                        System.out.print(ANSI_RED + outputText.substring(indexOfSpecial, indexOfSpecial + 2) + ANSI_RESET); // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
                        startIndex = indexOfSpecial+2;
                    }
                    System.out.println(outputText.substring(indexOfSpecial + 2));
                } else {
                    System.out.println(outputText);
                }
            }
            month += 3;
        }
    }

    public static void main(String[] args) {
        //printMonth(2016, 2, 5, false);
        //printMonth2()
        printYear(2013, 2, false);
    }
}
