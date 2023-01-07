package HighSchool.Other;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DigitalCharacterRecognition {
    public static final int SENSITIVITY = 125;
    public static void main(String[] args) throws IOException {

        File imgFile = new File("TextTester.PNG");
        BufferedImage img = ImageIO.read(imgFile);
        BufferedImage img2 = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);

        int r = 0;
        int g = 0;
        int b = 0;
        int avg = 0;

        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                int pixel = img.getRGB(j, i);
                r = (pixel >> 16) & 0xff;
                g = (pixel >> 8) & 0xff;
                b = (pixel) & 0xff;
                avg = (r+g+b)/3;

                img2.setRGB(j, i, new Color(avg, avg, avg).getRGB());
                /*if(avg > 100) {
                    System.out.print(" ");
                }
                else {
                    System.out.print("0");
                }*/
            }
            //System.out.println();
        }

        int[][] checkArr = new int[img2.getWidth()][img2.getHeight()];
        int[] colorValues = new int[img2.getHeight()];
        int counter = 0;

        for (int i = 0; i < img2.getHeight(); i++) {
            counter = 0;
            for (int j = 0; j < img2.getWidth(); j++) {
                int pixel = img2.getRGB(j, i);
                if(((pixel) & 0xff) < SENSITIVITY) {
                    counter++;
                    checkArr[j][i] = 1;
                }
                else {
                    checkArr[j][i] = 0;
                }
            }
            colorValues[i] = counter;
        }

        ArrayList<int[]> significantRows = new ArrayList<>();

        int check = -1;

        for (int i = 0; i < colorValues.length; i++) {
            System.out.println(colorValues[i]);
            if(check == -1 && colorValues[i] != 0) {
                check = i;
            }
            if(check != -1 && colorValues[i] == 0) {
                significantRows.add(new int[] {check, i-1});
                check = -1;
            }
        }

        //for (int i = 0; i < significantRows.size(); i++) {
        //    System.out.println(significantRows.get(i)[0] + "->" + significantRows.get(i)[1]);
        //}

        BufferedImage letter;

        File[] files = new File("ArialFont\\").listFiles();

        ArrayList<Letter> letters = new ArrayList<>();

        for(File f : files) {
            if(f.getName().length() == 6) { // loop through letters
                letter = ImageIO.read(f);
                for (int i = 0; i < significantRows.size(); i++) { // loop through significant rows
                    double multiplier = 0.5;
                    int[][] newLetter;
                    int rowHeight = significantRows.get(i)[1]-significantRows.get(i)[0];
                    while (multiplier*letter.getHeight() < rowHeight) { // loop through sizes
                        newLetter = resize(letter, (int) (multiplier * letter.getWidth()), (int) (multiplier * letter.getHeight()));
                        for (int j = 0; j < rowHeight-newLetter[0].length; j++) {
                            for (int k = 0; k < img2.getWidth()-newLetter.length; k++) {
                                counter = 0;
                                for (int l = 0; l < newLetter.length; l++) {
                                    for (int m = 0; m < newLetter[0].length; m++) {
                                        if(newLetter[l][k] == checkArr[k][j+significantRows.get(i)[0]]) {
                                            counter++;
                                        }
                                    }
                                }
                                if(counter > newLetter.length*newLetter[0].length*0.8) {
                                    letters.add(new Letter(k, j+significantRows.get(i)[0], (int) (multiplier * letter.getWidth()), (int) (multiplier * letter.getHeight()), f.getName().charAt(0)));
                                }
                            }
                        }
                        multiplier += 0.1;
                    }
                }
            }
        }

        for (int i = 0; i < letters.size(); i++) {
            System.out.println(letters.get(i));
        }

        //for (int i = 0; i < ; i++) {

        //}

        File outputFile = new File("TextTester2.png");
        ImageIO.write(img2, "png", outputFile);
    }

    // https://stackoverflow.com/questions/9417356/bufferedimage-resize
    public static BufferedImage resizeHelper(BufferedImage img, int newW, int newH) {
        int w = img.getWidth();
        int h = img.getHeight();
        BufferedImage dimg = new BufferedImage(newW, newH, img.getType());
        Graphics2D g = dimg.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);
        g.dispose();
        return dimg;
    }

    public static int[][] resize(BufferedImage img, int newW, int newH) {
        BufferedImage newImg = resizeHelper(img, newW, newH);
        int[][] returnArr = new int[img.getWidth()][img.getHeight()];
        for (int i = 0; i < newImg.getHeight(); i++) {
            for (int j = 0; j < newImg.getWidth(); j++) {
                int pixel = newImg.getRGB(j, i);
                if(((pixel) & 0xff) < SENSITIVITY) {
                    returnArr[j][i] = 1;
                }
                else {
                    returnArr[j][i] = 0;
                }
            }
        }
        return returnArr;
    }
}
