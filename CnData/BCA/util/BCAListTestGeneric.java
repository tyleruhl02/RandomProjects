package HighSchool.CnData.BCA.util;

import java.util.Random;

public class BCAListTestGeneric {

    public static void main (String args[]) {
        BCAList<Integer> l = new BCAArrayList<Integer>();
        BCAList<String> l2 = new BCAArrayList<String>();
        Random rand = new Random(1000);

        if (l.isEmpty())
            System.out.println("Passed 0");
        else
            System.out.println("**FAILED** 0");

        l.add(10);
        l.add(15);
        l.add(2);

        if (l.toString().startsWith("0: 10; 1: 15; 2: 2;"))
            System.out.println("Passed 1");
        else {
            System.out.println("**FAILED** 1");
            System.out.println(l.toString());
        }


        l.add(19);
        l.add(-14);
        l.add(7);
        l.add(14444);

        if (l.remove(3).equals(19))
            System.out.println("Passed 2");
        else
            System.out.println("**FAILED** 2");

        if (l.get(3).equals(-14))
            System.out.println("Passed 3");
        else
            System.out.println("**FAILED** 3");

        try {
            l.get(6);
            System.out.println("**FAILED** 4 - no get exception");
        }
        catch (IndexOutOfBoundsException ex) {
            System.out.println("Passed 4");
        }

        try {
            l.add(6, -47);
            if(l.get(6).equals(-47))
                System.out.println("Passed 5");
            else
                System.out.println("**FAILED** 5");
        }
        catch (IndexOutOfBoundsException ex) {
            System.out.println("**FAILED** 5 (Exception)");
        }

        try {
            l.add(8, 63);
            System.out.println("**FAILED** 6");
        }
        catch (IndexOutOfBoundsException ex) {
            System.out.println("Passed 6");
        }

        if (l.contains(15) )
            System.out.println("Passed 7a");
        else
            System.out.println("**FAILED** 7a");

        if (!l.contains(99))
            System.out.println("Passed 7b");
        else
            System.out.println("**FAILED** 7b");

        if (!l.isEmpty())
            System.out.println("Passed 8");
        else
            System.out.println("**FAILED** 8");

        if (l.size() == 7)
            System.out.println("Passed 8b");
        else
            System.out.println("**FAILED** 8b (size should be 7 but is " + l.size() + ")");


        for (int i=0; i<500; i++)
            l.add(rand.nextInt(20000));

        if (l.indexOf(-14) == 3)
            System.out.println("Passed 9");
        else
            System.out.println("**FAILED** 9");

        if (l.lastIndexOf(14444) == 80)
            System.out.println("Passed 10");
        else
            System.out.println("**FAILED** 10");

        if (l.indexOf(14444) == 5)
            System.out.println("Passed 11");
        else
            System.out.println("**FAILED** 11");

        if ((l.indexOf(49000) == -1) )
            System.out.println("Passed 12a");
        else
            System.out.println("**FAILED** 12a");

        if ((l.lastIndexOf(49000) == -1) )
            System.out.println("Passed 12b");
        else
            System.out.println("**FAILED** 12b");

        if (!l.contains(49000))
            System.out.println("Passed 13");
        else
            System.out.println("**FAILED** 13");

        int size = l.size();

        if (l.remove(new Integer(15)))
            System.out.println("Passed 14");
        else
            System.out.println("**FAILED** 14");

        if (l.get(1).equals(2))
            System.out.println("Passed 14");
        else
            System.out.println("**FAILED** 14");

        if (l.size() == size-1)
            System.out.println("Passed 15");
        else
            System.out.println("**FAILED** 15");

        l.clear();

        if (l.size() == 0)
            System.out.println("Passed 16");
        else
            System.out.println("**FAILED** 16");



        l2.add("pepperoni");

        System.out.println(l2);

        l2.add(0,"pizza");
        l2.add(1,"pie");

        if (l2.toString().startsWith("0: pizza; 1: pie; 2: pepperoni;"))
            System.out.println("Passed 17");
        else {
            System.out.println("**FAILED** 17");
            System.out.println(l2.toString());
        }

        if (l2.indexOf("pi" + "zza") == 0)
            System.out.println("Passed 17a");
        else
            System.out.println("**FAILED** 17a");

        try {
            if (l2.lastIndexOf("pi" + "zza") == 0)
                System.out.println("Passed 17c");
            else
                System.out.println("**FAILED** 17c: " + l2.lastIndexOf("pi" + "zza") );
        } catch (Exception ex) {
            System.out.println("**FAILED** 17c (Exception)");
        }

        try {
            if(l2.remove("pizza"))
                System.out.println("Passed 18a");
            else
                System.out.println("**FAILED** 18a");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("**FAILED** 18a (IndexOutOfBoundsException)");
        } catch (NullPointerException ex) {
            System.out.println("**FAILED** 18a (NullPointerException)");
        }

        try {
            if(!l2.remove("piranha"))
                System.out.println("Passed 18b");
            else
                System.out.println("**FAILED** 18b");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("**FAILED** 18b (IndexOutOfBoundsException)");
        } catch (NullPointerException ex) {
            System.out.println("**FAILED** 18b (NullPointerException)");
        }


        try {
            if(l2.remove("pepperoni"))
                System.out.println("Passed 19a");
            else
                System.out.println("**FAILED** 19a");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("**FAILED** 19a (Exception)");
        } catch (NullPointerException ex) {
            System.out.println("**FAILED** 19a (NullPointerException)");
        }

        try {
            if(!l2.remove("pepperoni"))
                System.out.println("Passed 19b");
            else
                System.out.println("**FAILED** 19b");

        } catch (IndexOutOfBoundsException ex) {
            System.out.println("**FAILED** 19b (IndexOutOfBoundsException)");
        } catch (NullPointerException ex) {
            System.out.println("**FAILED** 19b (NullPointerException)");
        }

        if(l2.remove(0).equals("pie"))
            System.out.println("Passed 20");
        else
            System.out.println("**FAILED** 20");

        try {
            l2.remove(1);
            System.out.println("**FAILED** 21");
        }
        catch (IndexOutOfBoundsException ex) {
            System.out.println("Passed 21");
        }


    }
}