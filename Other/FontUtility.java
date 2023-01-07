package HighSchool.Other;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FontUtility {
    public static void main(String[] args) throws IOException {
        File imgFile = new File("ArialFont\\Arial1.PNG");
        BufferedImage img = ImageIO.read(imgFile);

        int r = 0;
        int g = 0;
        int b = 0;

        ArrayList<Integer> indicies = new ArrayList<>();

        for (int i = 0; i < img.getWidth(); i++) {
            r = 0;
            g = 0;
            b = 0;
            boolean index = true;
            for (int j = 0; j < img.getHeight(); j++) {
                int pixel = img.getRGB(i, j);
                r = (pixel >> 16) & 0xff;
                g = (pixel >> 8) & 0xff;
                b = (pixel) & 0xff;
                //System.out.println("(" + i + ", " + j + "): " + "(" + r + " " + g + " " + b + ")");
                if(r + g + b == 0) {
                    index = false;
                    break;
                }
            }
            if(index) {
                indicies.add(i);
            }

            //System.out.println(i + ": " + "(" + r + " " + g + " " + b + ")");
        }
        System.out.println(Arrays.toString(indicies.toArray()));

        String[] alphabet = "a1 b1 c1 d1 e1 f1 g1 h1 i1 j1 k1 l1 m1 n1 o1 p1 q1 r1 s1 t1 u1 v1 w1 x1 y1 z1 A2 B2 C2 D2 E2 F2 G2 H2 I2 J2 K2 L2 M2 N2 O2 P2 Q2 R2 S2 T2 U2 V2 W2 X2 Y2 Z2".split(" ");
        System.out.println(alphabet.length);

        int counter = 0;

        for (int i = 0; i < indicies.size()-1; i++) {
            if(indicies.get(i+1) - indicies.get(i) > 1) {
                int beg = 0;
                for (int j = 0; j < img.getHeight(); j++) {
                    System.out.println();
                    System.out.println(indicies.get(i));
                    System.out.println(indicies.get(i + 1));
                    System.out.println();
                    for (int k = indicies.get(i); k < indicies.get(i + 1); k++) {
                        System.out.println("(" + k + ", " + j + ")");
                        int pixel = img.getRGB(k, j);
                        if(((pixel >> 16) & 0xff) + ((pixel >> 8) & 0xff) + ((pixel) & 0xff) < 400) {
                            beg = j;
                            break;
                        }
                    }
                    if(beg != 0) {
                        break;
                    }
                }
                int end = img.getHeight();
                for (int j = img.getHeight()-1; j >= 0; j--) {
                    for (int k = indicies.get(i); k < indicies.get(i + 1); k++) {
                        int pixel = img.getRGB(k, j);
                        if(((pixel >> 16) & 0xff) + ((pixel >> 8) & 0xff) + ((pixel) & 0xff) < 400) {
                            end = j;
                            break;
                        }
                    }
                    if(end != img.getHeight()) {
                        break;
                    }
                }

                System.out.println(alphabet[counter]);
                System.out.println("BEG: " + beg);
                System.out.println("END: " + end);
                BufferedImage subimage = img.getSubimage(indicies.get(i), beg, indicies.get(i+1) - indicies.get(i), end-beg);
                File outputFile = new File("ArialFont\\" + alphabet[counter++] + ".png");
                ImageIO.write(subimage, "png", outputFile);
                //String[][] letter = new String[indicies.get(i+1)-indicies.get(i)][img.getHeight()];
                /*for (int j = 1; j < indicies.get(i + 1) - indicies.get(i); j++) {
                    for (int k = 0; k < img.getHeight(); k++) {
                        int pixel = img.getRGB(j+indicies.get(i), k);
                        if(((pixel >> 16) & 0xff) + ((pixel >> 8) & 0xff) + ((pixel) & 0xff) < 100 ) {
                            System.out.print("0");
                        }
                        else {
                            System.out.print(".");
                        }
                    }
                    System.out.println();
                }
                System.out.println();*/
            }
        }

        /*FileWriter myWriter = new FileWriter("ArialFont\\Arial.txt");
        for (int i = 0; i < indicies.size()-1; i++) {
            if(indicies.get(i+1) - indicies.get(i) > 1) {
                String[][] letter = new String[indicies.get(i+1)-indicies.get(i)][img.getHeight()];
                for (int j = 1; j < indicies.get(i + 1) - indicies.get(i); j++) {
                    for (int k = 0; k < img.getHeight(); k++) {
                        int pixel = img.getRGB(j+indicies.get(i), k);
                        if(((pixel >> 16) & 0xff) + ((pixel >> 8) & 0xff) + ((pixel) & 0xff) < 100 ) {
                            letter[j][k] = "0";
                        }
                        else {
                            letter[j][k] = ".";
                        }
                    }
                }

                for (int j = 0; j < letter[0].length; j++) {
                    String s = "";
                    for (int k = 1; k < letter.length; k++) {
                        s += letter[k][j] + " ";
                    }
                    System.out.println(s);
                    myWriter.write(s + "\n");
                    //System.out.println(Arrays.toString(letter[j]));
                }
                myWriter.write("\n");
            }
        }*/

        // PART 2 ******************************************************************************************************
        /*
        imgFile = new File("ArialFont\\Arial2.PNG");
        img = ImageIO.read(imgFile);

        indicies = new ArrayList<>();

        for (int i = 0; i < img.getWidth(); i++) {
            r = 0;
            g = 0;
            b = 0;
            boolean index = true;
            for (int j = 0; j < img.getHeight(); j++) {
                int pixel = img.getRGB(i, j);
                r = (pixel >> 16) & 0xff;
                g = (pixel >> 8) & 0xff;
                b = (pixel) & 0xff;
                //System.out.println("(" + i + ", " + j + "): " + "(" + r + " " + g + " " + b + ")");
                if(r + g + b == 0) {
                    index = false;
                    break;
                }
            }
            if(index) {
                indicies.add(i);
            }

            //System.out.println(i + ": " + "(" + r + " " + g + " " + b + ")");
        }
        System.out.println(Arrays.toString(indicies.toArray()));
        for (int i = 0; i < indicies.size()-1; i++) {
            if(indicies.get(i+1) - indicies.get(i) > 1) {
                String[][] letter = new String[indicies.get(i+1)-indicies.get(i)][img.getHeight()];
                for (int j = 1; j < indicies.get(i + 1) - indicies.get(i); j++) {
                    for (int k = 0; k < img.getHeight(); k++) {
                        int pixel = img.getRGB(j+indicies.get(i), k);
                        if(((pixel >> 16) & 0xff) + ((pixel >> 8) & 0xff) + ((pixel) & 0xff) < 100 ) {
                            letter[j][k] = "0";
                        }
                        else {
                            letter[j][k] = ".";
                        }
                    }
                }

                for (int j = 0; j < letter[0].length; j++) {
                    String s = "";
                    for (int k = 1; k < letter.length; k++) {
                        s += letter[k][j] + " ";
                    }
                    System.out.println(s);
                    //if(s.contains("1")) {
                        myWriter.write(s + "\n");
                    //}
                    //System.out.println(Arrays.toString(letter[j]));
                }
                myWriter.write("\n");
            }
        }

        */
        //myWriter.close();

    }
}
