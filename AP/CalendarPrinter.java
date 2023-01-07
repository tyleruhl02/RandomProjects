package HighSchool.AP;// MADE BY MARCUS AND TYLER

import java.util.Random;

public class CalendarPrinter {
    private static int[] daysPerMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static String[] monthNames = "January February March April May June July August September October November December".split(" ");
    private static final String ANSI_RESET = "\u001B[0m"; // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
    private static final String ANSI_RED = "\u001B[31m"; // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
    private static final int JANUARY = 1, FEBRUARY = 2, MARCH = 3, APRIL = 4, MAY = 5, JUNE = 6, JULY = 7, AUGUST = 8, SEPTEMBER = 9, OCTOBER = 10, NOVEMBER = 11, DECEMBER = 12;
    private static final int SUNDAY = 0, MONDAY = 1, TUESDAY = 2, WEDNESDAY = 3, THURSDAY = 4, FRIDAY = 5, SATURDAY = 6;
    private static final int NUMOFWEEKS = 7, DAYSINAWEEK = 7, NUMOFSPACESINMONTH = 20, NUMOFCHARSINALINE = 66;
    private static final int STARTOFTHIRDWEEK = 15, ENDOFTHIRDWEEK = 21, VETERANSDAY = 11, STARTOFFOURTHWEEK = 22, ENDOFFOURTHWEEK = 28, STARTOFLASTWEEKOFMAY = 25, LASTDAYOFMAY = 31, CHRISTMASDAY = 25, NEWYEARSDAY = 1, FOURTHOFJULY = 4, ENDOFFIRSTWEEK = 7, TAXDAYONSATURDAY = 17, TAXDAYONSUNDAY = 16, TAXDAY = 15;

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
        if (month == FEBRUARY && dayOfWeek == MONDAY && (dayOfMonth >= STARTOFTHIRDWEEK && dayOfMonth <= ENDOFTHIRDWEEK)) { // President's Day
            return ANSI_RED + "*p" + ANSI_RESET;
        }
        else if (month == NOVEMBER && dayOfMonth == VETERANSDAY) { // Veteran's Day
            return ANSI_RED + "*v" + ANSI_RESET;
        }
        else if (month == NOVEMBER && dayOfWeek == THURSDAY && (dayOfMonth >= STARTOFFOURTHWEEK && dayOfMonth <= ENDOFFOURTHWEEK)) { // Thanksgiving
            return ANSI_RED + "*t" + ANSI_RESET;
        }
        else if (month == MAY && dayOfWeek == MONDAY && (dayOfMonth >= STARTOFLASTWEEKOFMAY && dayOfMonth <= LASTDAYOFMAY)) { // Memorial Day
            return ANSI_RED + "*m" + ANSI_RESET;
        }
        else if (month == DECEMBER && dayOfMonth == CHRISTMASDAY) { // Christmas
            return ANSI_RED + "*c" + ANSI_RESET;
        }
        else if (month == JANUARY && dayOfMonth == NEWYEARSDAY) { // New Year's Day
            return ANSI_RED + "*y" + ANSI_RESET;
        }
        else if (month == JULY && dayOfMonth == FOURTHOFJULY) { // 4th of July
            return ANSI_RED + "*4" + ANSI_RESET;
        }
        else if (month == SEPTEMBER && dayOfWeek == MONDAY && dayOfMonth <= ENDOFFIRSTWEEK) { // Labor Day
            return ANSI_RED + "*L" + ANSI_RESET;
        }
        else if (month == APRIL && dayOfWeek == MONDAY && (dayOfMonth == TAXDAYONSATURDAY || dayOfMonth == TAXDAYONSUNDAY)) { // Tax Day on Weekend
            return ANSI_RED + "*x" + ANSI_RESET;
        }
        else if (month == APRIL && (dayOfWeek != SUNDAY && dayOfWeek != SATURDAY) && dayOfMonth == TAXDAY) { // Normal Tax Day
            return ANSI_RED + "*x" + ANSI_RESET;
        }
        else if (dayOfMonth < 10) { // Checks if the date is double digits
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
        for (int j = 0; j < NUMOFWEEKS; j++) {
            if (dayOfMonth == 1 && j < dayOfWeek) { // FILLS IN THE FIRST FEW BLANK DAYS
                outputText += "  ";
            }
            else {
                if(!monthOver) {
                    if(printSpecialDays) {
                        outputText += getSpecialDay(month, dayOfWeek, dayCounter);
                        dayOfWeek = (dayOfWeek + 1) % DAYSINAWEEK;
                    }
                    else {
                        outputText += dayCounter < 10 ? " " + dayCounter : dayCounter; // CHECKS IF THE DIGIT IS A SINGLE DIGIT OR DOUBLE DIGIT
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
        /*String outputText = startMonth == 7 ? "" : " ";
        String spaces = "";
        for (int i = 0; i < (NUMOFSPACESINMONTH-monthNames[startMonth-1].length())/2; i++) {
            spaces += " ";
        }
        outputText += spaces + monthNames[startMonth-1] + spaces + "   ";

        spaces = "";
        for (int i = 0; i < (NUMOFSPACESINMONTH-monthNames[startMonth].length())/2; i++) {
            spaces += " ";
        }
        outputText += spaces + monthNames[startMonth] + spaces + "   ";

        spaces = "";
        for (int i = 0; i < (NUMOFSPACESINMONTH-monthNames[startMonth+1].length())/2; i++) {
            spaces += " ";
        }
        outputText += spaces + monthNames[startMonth + 1] + spaces;*/
        String outputText = "";
        if(startMonth == 1) {
            outputText += "      January                February                March        ";
        }
        else if(startMonth == 4) {
            outputText += "       April                   May                    June        ";
        }
        else if(startMonth == 7) {
            outputText += "        July                  August               September      ";
        }
        else if(startMonth == 10) {
            outputText += "      October                November               December      ";
        }
    return outputText + "\nSu Mo Tu We Th Fr Sa   Su Mo Tu We Th Fr Sa   Su Mo Tu We Th Fr Sa";
    }

    public static void printMonth(int year, int month, int janFirst, boolean leapYear) {
        int firstDay = findFirstDayOfMonth(month, janFirst, leapYear);
        String outputText = "";
        for (int i = 0; i < (NUMOFSPACESINMONTH - (monthNames[month - 1].length() + 1 + (year + "").length())) / 2; i++) { // CENTERS THE HEADING
            System.out.print(" ");
        }
        System.out.println(monthNames[month - 1] + " " + year);
        System.out.println("Su Mo Tu We Th Fr Sa");
        int dayCounter = 1;
        int dayOfWeek = firstDay;
        for (int i = 0; i < NUMOFWEEKS-1; i++) {
            outputText += getMonthPrintByWeek(month, dayOfWeek, dayCounter, leapYear, false, false); // GETS A STRING OF THE WEEK
            if (dayCounter == 1) { // ADDS NEW WEEK
                dayCounter += DAYSINAWEEK - dayOfWeek;
            } else {
                dayCounter += DAYSINAWEEK;
            }
            dayOfWeek = 0;
            if (dayCounter > daysPerMonth[month - 1] + (leapYear ? 1 : 0)) { // CHECKS IF MONTH IS OVER
                break;
            }
            outputText += "\n";
        }
        System.out.println(outputText); // Prints out
    }

    public static void printYear (int year, int janFirst, boolean leapYear) {
        for (int i = 0; i < (NUMOFCHARSINALINE - (""+year).length())/2; i++) { // CENTERS HEADING
            System.out.print(" ");
        }
        System.out.println(year);

        int month = 1;

        for (int i = 0; i < NUMOFWEEKS-3; i++) {
            int[] daysOfWeeks = {findFirstDayOfMonth(month, janFirst, leapYear), findFirstDayOfMonth(month+1, janFirst, leapYear), findFirstDayOfMonth(month+2, janFirst, leapYear)};
            int[] dayCounters = {1, 1, 1};
            boolean[] monthOver = {false, false, false};
            String outputText = "";
            System.out.println(getHeaderLine(month));
            for (int j = 0; j < NUMOFWEEKS-1; j++) {
                outputText =    getMonthPrintByWeek(month, daysOfWeeks[0], dayCounters[0], leapYear, monthOver[0], true) + "  " +
                                getMonthPrintByWeek(month+1, daysOfWeeks[1], dayCounters[1], leapYear, monthOver[1], true) + "  " +
                                getMonthPrintByWeek(month+2, daysOfWeeks[2], dayCounters[2], leapYear, monthOver[2], true);
                for (int k = 0; k < 3; k++) {
                    if (dayCounters[k] == 1) { // ADDS NEW WEEK
                        dayCounters[k] += DAYSINAWEEK - daysOfWeeks[k];
                    } else {
                        dayCounters[k] += DAYSINAWEEK;
                    }
                    daysOfWeeks[k] = 0;
                    if (dayCounters[k] > daysPerMonth[month - 1 + k] + (leapYear ? 1 : 0)) { // CHECKS IF MONTH IS OVER
                        monthOver[k] = true;
                    }
                }
                System.out.println(outputText); // Prints out
            }
            month += 3;
        }
    }

    public static void main(String[] args) {
        //printMonth(2016, 2, 5, false);
        //printMonth2()
        Random randy = new Random();
        for (int i = 0; i < 2019; i++) {
            printYear(i, randy.nextInt(7), false);
        }
        //printYear(2007, 5, false);
    }
}
