package HighSchool.Other;

import java.util.Arrays;

public class test102 {
    public static void main(String[] args) {
        /*String[] states = ("Alabama\n" +
                "Alaska\n" +
                "Arizona\n" +
                "Arkansas\n" +
                "California\n" +
                "Colorado\n" +
                "Connecticut\n" +
                "Delaware\n" +
                "Florida\n" +
                "Georgia\n" +
                "Hawaii\n" +
                "Idaho\n" +
                "Illinois\n" +
                "Indiana\n" +
                "Iowa\n" +
                "Kansas\n" +
                "Kentucky\n" +
                "Louisiana\n" +
                "Maine\n" +
                "Maryland\n" +
                "Massachusetts\n" +
                "Michigan\n" +
                "Minnesota\n" +
                "Mississippi\n" +
                "Missouri\n" +
                "Montana\n" +
                "Nebraska\n" +
                "Nevada\n" +
                "New Hampshire\n" +
                "New Jersey\n" +
                "New Mexico\n" +
                "New York\n" +
                "North Carolina\n" +
                "North Dakota\n" +
                "Ohio\n" +
                "Oklahoma\n" +
                "Oregon\n" +
                "Pennsylvania\n" +
                "Rhode Island\n" +
                "South Carolina\n" +
                "South Dakota\n" +
                "Tennessee\n" +
                "Texas\n" +
                "Utah\n" +
                "Vermont\n" +
                "Virginia\n" +
                "Washington\n" +
                "West Virginia\n" +
                "Wisconsin\n" +
                "Wyoming").split("\n");*/

        String[] professions = ("Psychiatrist\n" +
                "Art Therapist\n" +
                "Clinical Social Work/Therapist\n" +
                "Counselor \n" +
                "Drug & Alcohol Counselor\n" +
                "Drug and Alcohol Counseling Intern\n" +
                "Licensed Professional Counselor\n" +
                "Licensed Psychoanalyst\n" +
                "Limited Licensed Psychologist\n" +
                "LPC Intern\n" +
                "Marriage & Family Therapist\n" +
                "Marriage & Family Therapist Intern\n" +
                "Marriage & Family Therapist Associate\n" +
                "Occupational Therapist\n" +
                "Pastoral Counselor\n" +
                "Physician Assistant\n" +
                "Pre-Licensed Professional\n" +
                "Psychiatric Nurse\n" +
                "Psychiatric Nurse Practitioner\n" +
                "Psychiatrist\n" +
                "Psychological Associate\n" +
                "Psychologist\n" +
                "Registered Psychotherapist").split("\n");

        //String("")

        /*String[] states = ("Art Therapist\nLicensed Clinical Social Worker\nLicensed Social Worker\nLicensed Counselor\nDrug & Alcohol Counselor / Therapist\n" +
        "Certified Drug and Alcohol Counselor\nDrug and Alcohol Counseling Intern\nCertified Alcohol and Drug Counselor\nLicensed Professional Counselor\n" +
        "Licensed Psychoanalyst\nLimited Licensed Psychologist\nLPC Intern\nMarriage & Family Therapist\nMarriage & Family Therapist Intern\n" +
        "Marriage & Family Therapist Associate\nOccupational Therapist\nPastoral Counselor\nPhysician Assistant\nPre-Licensed Professional\n" +
        "Psychiatric Nurse\nPsychiatric Nurse Practitioner\nPsychiatrist\nPsychological Associate\nPsychologist\nRegistered Psychotherapist").split("\n");*/

        /*String[] s = ("Armenian Mandarin Farsi Hindi Arabic ASL Bosnian Cantonese Creole Croatian Dutch Filipino " +
        "French German Greek Gujarati Hebrew Hungarian Italian Japanese Korean Polish Portuguese Punjabi Romanian Russian " +
        "Serbian Sinhalese Swedish Turkish Ukrainian Urdu Vietnamese Yiddish").split(" ");*/

        /*String[] s = ("Aetna\nAmerigrop\nAmeriHealth\nAnthem\nBeacon Health Options\nBlue Cross\nBlue Shield\nBlueCross and BlueShield\n" +
        "Cigna and Evernorth\nComPsych\nEmblem Health\nEmpire BlueCross BlueShield\nGHI\nHealth Net\nHorizon Blue Cross and Blue Shield\nHumana\n" +
        "Magellan\nMagnaCare\nMedicaid\nMedicare\nMHN (Healthnet)\nMultplan\nOptum\nOscar Health\nOxford\nQualCare\nTRICARE\nUMR\nUnitedHealthcare (UHC or UBH)").split("\n");*/

        Arrays.sort(professions);

        for (int i = 0; i < professions.length-1; i++) {
            //System.out.println(i + ": " + s[i]+","+toCamelCase(s[i]));
            System.out.println(professions[i] + "," + professions[i]);
        }
    }

    public static String toCamelCase(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("&", "And");
        s = s.replaceAll(" / ", " ");
        s = s.replaceAll("-", " ");
        final String[] UPPERCASELETTERS = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");
        final String[] LOWERCASELETTERS = "a b c d e f g h i j k l m n o p q r s t u v w x y z".split(" ");
        s = s.substring(0, 1).toLowerCase() + s.substring(1);
        for (int i = 1; i < s.length(); i++) {
            try {
                if (s.substring(i, i + 1).equals(" ")) {
                    s = s.substring(0, i) + s.substring(i + 1, i + 2).toUpperCase() + s.substring(i + 2);
                }
            }
            catch (Exception e){
                System.out.println("COMPLETED");
            }
        }
        return s;
        //int i = s.indexOf(" ");
        //for (int j = s.length()-1; j > 0; j--) {
//
        //}
        //if (i == -1) {
        //    return s;
        //}
        //return s.substring(0, i) + s.substring(i+1, i+2).toUpperCase() + s.substring(i+2);
    }
}
