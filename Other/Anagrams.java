package HighSchool.Other;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Anagrams {
    public static int size = 6;

    private static int factorial(int n) {
        if(n == 0)
            return 1;
        return n*factorial(n-1);
    }

    private static int getTotalCombos(char[] arr) {
        ArrayList<Integer> counts = new ArrayList<Integer>();
        ArrayList<Character> chars = new ArrayList<Character>();

        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            if(!chars.contains(arr[i])) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] == arr[j]) {
                        count++;
                    }
                }
                counts.add(count);
                chars.add(arr[i]);
            }
        }

        int totalCombos = factorial(size);
        for (int i = 0; i < counts.size(); i++) {
            totalCombos /= factorial(counts.get(i));
        }

        return totalCombos;
    }

    private static String getRandomCombination(char[] arr) {
        Random randy = new Random();
        ArrayList<Integer> ints = new ArrayList<Integer>();
        ints.add(0); ints.add(1); ints.add(2); ints.add(3); ints.add(4); ints.add(5);

        String output = "";

        for (int i = 0; i < 6; i++) {
            int randomInt = randy.nextInt(ints.size());
            output += arr[ints.get(randomInt)];
            ints.remove(ints.get(randomInt));
        }
        return output;
    }

    private static boolean isUnique(String arr) {
        for (int i = 0; i < arr.length(); i++) {
            for (int j = i+1; j < arr.length(); j++) {
                if(arr.charAt(i) == arr.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static String[] getAllCombinations(char[] arr, int numOfLetters) {
        /*String[] combos = new String[getTotalCombos(arr)];

        int counter = 0;

        for (int i = 0; i < combos.length; i++) {
            while (true) {
                String randomCombo = getRandomCombination(arr);

                boolean exit = false;
                System.out.println(randomCombo);
                for (int j = 0; j < counter; j++) {
                    System.out.println(combos[j]);
                    System.out.println(Arrays.toString(combos));
                    System.out.println(counter);
                    if (combos[j].equals(randomCombo)) {
                        exit = true;
                    }
                }
                if(exit) {
                    break;
                }

                combos[i] = randomCombo;
                counter++;
                break;
            }
        }

        System.out.println(Arrays.toString(combos));
        return combos;*/

        /*ArrayList<String> combos = new ArrayList<String>();
        if(numOfLetters == 6) {
            int[] ints = {0, 0, 0, 0, 0, 0};

            for (int i = 0; i < 46655; i++) {
                ints[5]++;
                if (ints[5] == 6) {
                    ints[5] = 0;
                    ints[4]++;
                    if (ints[4] == 6) {
                        ints[4] = 0;
                        ints[3]++;
                        if (ints[3] == 6) {
                            ints[3] = 0;
                            ints[2]++;
                            if (ints[2] == 6) {
                                ints[2] = 0;
                                ints[1]++;
                                if (ints[1] == 6) {
                                    ints[1] = 0;
                                    ints[0]++;
                                }
                            }
                        }
                    }
                }
                
                if (isUnique(ints)) {
                    String s = "";
                    for (int j = 0; j < 6; j++) {
                        s += arr[ints[j]];
                    }
                    combos.add(s);
                }
            }
        }
        if(numOfLetters == 5) {
            int[] ints = {0, 0, 0, 0, 0};

            for (int i = 0; i < 3124; i++) {
                ints[4]++;
                if (ints[4] == 6) {
                    ints[4] = 0;
                    ints[3]++;
                    if (ints[3] == 6) {
                        ints[3] = 0;
                        ints[2]++;
                        if (ints[2] == 6) {
                            ints[2] = 0;
                            ints[1]++;
                            if (ints[1] == 6) {
                                ints[1] = 0;
                                ints[0]++;
                            }
                        }
                    }
                }

                if (isUnique(ints)) {
                    String s = "";
                    for (int j = 0; j < 5; j++) {
                        s += arr[ints[j]];
                    }
                    combos.add(s);
                }
            }
        }
        if(numOfLetters == 4) {
            int[] ints = {0, 0, 0, 0};

            for (int i = 0; i < 255; i++) {
                ints[3]++;
                if (ints[3] == 6) {
                    ints[3] = 0;
                    ints[2]++;
                    if (ints[2] == 6) {
                        ints[2] = 0;
                        ints[1]++;
                        if (ints[1] == 6) {
                            ints[1] = 0;
                            ints[0]++;
                        }
                    }
                }

                if (isUnique(ints)) {
                    String s = "";
                    for (int j = 0; j < 4; j++) {
                        s += arr[ints[j]];
                    }
                    combos.add(s);
                }
            }
        }
        if(numOfLetters == 3) {
            int[] ints = {0, 0, 0};
            ints[2]++;
            if (ints[2] == 6) {
                ints[2] = 0;
                ints[1]++;
                if (ints[1] == 6) {
                    ints[1] = 0;
                    ints[0]++;
                }
            }

            if (isUnique(ints)) {
                String s = "";
                for (int j = 0; j < 3; j++) {
                    s += arr[ints[j]];
                }
                combos.add(s);
            }
        }
        String[] rightcombos = new String[combos.size()];
        for (int i = 0; i < rightcombos.length; i++) {
            rightcombos[i] = combos.get(i);
        }
        return rightcombos;*/
        return new String[0];
    }

    public static void main(String[] args) throws Exception {
        // get words array

        File f = new File("goodWords.txt");

        BufferedReader br = new BufferedReader(new FileReader(f));

        ArrayList<String> words = new ArrayList<String>();
        String s;
        while ((s = br.readLine()) != null) {
            words.add(s);
        }

        // get input

        Scanner fred = new Scanner(System.in);
        System.out.println("Letters: ");
        String input = fred.nextLine();
        ArrayList<Character> letters = new ArrayList<Character>();
        for (int i = 0; i < size; i++) {
            letters.add(input.charAt(i));
        }

        char[] allLetters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        ArrayList<Character> badLetters = new ArrayList<Character>();

        for (int i = 0; i < allLetters.length; i++) {
            //System.out.println(badLetters);
            if(!letters.contains(allLetters[i])) {
                badLetters.add(allLetters[i]);
            }
        }

        //System.out.println(Arrays.toString(badLetters));



        // get combinations

        ArrayList<String> goodcombos = new ArrayList<String>();

        for (int i = 0; i < words.size(); i++) {
            boolean goodWord = true;
            for (int j = 0; j < words.get(i).length(); j++) {
                for (int k = 0; k < badLetters.size(); k++) {
                    if(words.get(i).charAt(j) == badLetters.get(k)) {
                        goodWord = false;
                        break;
                    }
                }
                if(!goodWord) {
                    break;
                }
            }
            if(goodWord) {
                goodcombos.add(words.get(i));
            }
        }

        //System.out.println(goodcombos);

        ArrayList<String> answers = new ArrayList<String>();
        for (int i = 0; i < goodcombos.size(); i++) {
            if(goodcombos.get(i).length() == 6 && isValid(goodcombos.get(i), letters)) {
                answers.add(goodcombos.get(i));
            }
        }
        for (int i = 0; i < goodcombos.size(); i++) {
            if(goodcombos.get(i).length() == 5 && isValid(goodcombos.get(i), letters)) {
                answers.add(goodcombos.get(i));
            }
        }
        for (int i = 0; i < goodcombos.size(); i++) {
            if(goodcombos.get(i).length() == 4 && isValid(goodcombos.get(i), letters)) {
                answers.add(goodcombos.get(i));
            }
        }
        for (int i = 0; i < goodcombos.size(); i++) {
            if(goodcombos.get(i).length() == 3 && isValid(goodcombos.get(i), letters)) {
                answers.add(goodcombos.get(i));
            }
        }

        for (int i = 0; i < answers.size(); i++) {
            System.out.println(answers.get(i));
        }
    }

    private static boolean isValid(String s, ArrayList<Character> letters) {
        ArrayList<Character> lets = new ArrayList<Character>();
        for (int i = 0; i < letters.size(); i++) {
            lets.add(letters.get(i));
        }
        for (int i = 0; i < s.length(); i++) {
            boolean chilln = false;
            for (int j = 0; j < lets.size(); j++) {
                if(lets.get(j) == s.charAt(i)) {
                    lets.remove(lets.get(j));
                    chilln = true;
                    break;
                }
            }
            if(!chilln) {
                return false;
            }

        }
        return true;
    }
}
// lcttae