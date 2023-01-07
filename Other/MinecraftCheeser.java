package HighSchool.Other;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;

public class MinecraftCheeser extends JPanel {
    public static BufferedImage preImage;
    public static BufferedImage postImage;

    public static Color terracotta = new Color(152, 95, 69);
    public static Color whiteTerracotta = new Color(207, 175, 159);
    public static Color orangeTerracotta = new Color(160, 79, 30);
    public static Color magentaTerracotta = new Color(147, 85, 106);
    public static Color lightBlueTerracotta = new Color(113, 107, 136);
    public static Color yellowTerracotta = new Color(187, 133, 27);
    public static Color limeTerracotta = new Color(95, 109, 42);
    public static Color pinkTerracotta = new Color(158, 73, 74);
    public static Color grayTerracotta = new Color(51, 32, 25);
    public static Color lightGrayTerracotta = new Color(136, 105, 95);
    public static Color cyanTerracotta = new Color(81, 86, 87);
    public static Color purpleTerracotta = new Color(116, 65, 82);
    public static Color blueTerracotta = new Color(69, 54, 87);
    public static Color brownTerracotta = new Color(72, 42, 25);
    public static Color greenTerracotta = new Color(71, 78, 34);
    public static Color redTerracotta = new Color(140, 55, 39);
    public static Color blackTerracotta = new Color(29, 13, 4);

    public static Color whiteConcrete = new Color(208, 214, 215);
    public static Color orangeConcrete = new Color(226, 99, 0);
    public static Color magentaConcrete = new Color(169, 43, 159);
    public static Color lightBlueConcrete = new Color(30, 138, 200);
    public static Color yellowConcrete = new Color(241, 175, 13);
    public static Color limeConcrete = new Color(93, 169, 16);
    public static Color pinkConcrete = new Color(214, 100, 143);
    public static Color grayConcrete = new Color(51, 55, 59);
    public static Color lightGrayConcrete = new Color(126, 126, 116);
    public static Color cyanConcrete = new Color(13, 120, 136);
    public static Color blueConcrete = new Color(41, 43, 145);
    public static Color purpleConcrete = new Color(101, 26, 158);
    public static Color greenConcrete = new Color(72, 91, 31);
    public static Color brownConcrete = new Color(96, 57, 25);
    public static Color redConcrete = new Color(144, 30, 30);
    public static Color blackConcrete = new Color(2, 3, 7);

    public static Color smoothSandstone = new Color(218, 207, 163);
    public static Color stone = new Color(116, 116, 116);
    public static Color smoothStone = new Color(176, 176, 176);

    public static Color[] materials = {terracotta, whiteTerracotta, orangeTerracotta, magentaTerracotta, lightBlueTerracotta, yellowTerracotta, limeTerracotta, pinkTerracotta, grayTerracotta, lightGrayTerracotta, cyanTerracotta, purpleTerracotta, blueTerracotta, brownTerracotta, greenTerracotta, redTerracotta, blackTerracotta,
            whiteConcrete, orangeConcrete, magentaConcrete, lightBlueConcrete, yellowConcrete, limeConcrete, pinkConcrete, grayConcrete, lightGrayConcrete, cyanConcrete, purpleConcrete, blueConcrete, brownConcrete, greenConcrete, redConcrete, blackConcrete,
            smoothSandstone, stone, smoothStone};

    public static int width = 50;
    public static int height = 93;

    public static int output[][] = new int[width][height];
    public static Color output2[][] = new Color[width][height];
    public static String output3[][] = new String[width][height];

    public static String outputString = "";

    private static void createAndShowGUI() {
        MinecraftCheeser panel = new MinecraftCheeser();

        JFrame frame = new JFrame("TestFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setPreferredSize(new Dimension(1000, 1000));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int size = 10;
                //g2.setColor(materials[output[i][j]]);
                //if(materials[output[i][j]].equals(blackConcrete) || materials[output[i][j]].equals(blackTerracotta)) {// || materials[output[i][j]].equals(grayTerracotta)) {
                //    g2.setColor(Color.WHITE);
                //}
                //else {
//                String[] test1 = outputString.split("\n");
//                String[] blank = test1[0].split("\t");
//                String[][] test2 = new String[test1.length][blank.length];
//                for (int k = 0; k < test2.length; k++) {
//                    test2[k] = test1[k].split("\t");
//                }
//                System.out.println(test2[i][j]);
                    g2.setColor(materials[output[i][j]]);
                //}
                //System.out.println(output[i][j]);
                //System.out.println(materials[output[i][j]]);
                //g2.setColor(new Color((int) (Math.random() *256), (int) (Math.random() *256), (int) (Math.random() *256)));
                g2.fillRect(i*size, j*size, size, size);
            }
        }
    }

    public static double distance(Color c1, Color c2) {
        return Math.sqrt(Math.pow(c1.getRed()-c2.getRed(), 2) + Math.pow(c1.getGreen()-c2.getGreen(), 2) + Math.pow(c1.getBlue()-c2.getBlue(), 2));
    }

    public static void main(String[] args) {
        try {
            preImage = ImageIO.read(new File("File_004.jpeg"));
        }
        catch(Exception e) {
            System.out.println("ERROR!");
        }

        HashMap<Color, String> map = new HashMap<>();
        map.put(terracotta,         "terracotta           ");
        map.put(whiteTerracotta,    "white terracotta     ");
        map.put(orangeTerracotta,   "orange terracotta    ");
        map.put(magentaTerracotta,  "magenta terracotta   ");
        map.put(lightBlueTerracotta,"light blue terracotta");
        map.put(yellowTerracotta,   "yellow terracotta    ");
        map.put(limeTerracotta,     "lime terracotta      ");
        map.put(pinkTerracotta,     "pink terracotta      ");
        map.put(grayTerracotta,     "gray terracotta      ");
        map.put(lightGrayTerracotta,"light gray terracotta");
        map.put(cyanTerracotta,     "cyan terracotta      ");
        map.put(purpleTerracotta,   "purple terracotta    ");
        map.put(blueTerracotta,     "blue terracotta      ");
        map.put(brownTerracotta,    "brown terracotta     ");
        map.put(greenTerracotta,    "green terracotta     ");
        map.put(redTerracotta,      "red terracotta       ");
        map.put(blackTerracotta,    "black terracotta     ");
        map.put(whiteConcrete,      "white concrete       ");
        map.put(orangeConcrete,     "orange concrete      ");
        map.put(magentaConcrete,    "magenta concrete     ");
        map.put(lightBlueConcrete,  "light blue concrete  ");
        map.put(yellowConcrete,     "yellow concrete      ");
        map.put(limeConcrete,       "lime concrete        ");
        map.put(pinkConcrete,       "pink concrete        ");
        map.put(grayConcrete,       "gray concrete        ");
        map.put(lightGrayConcrete,  "light gray concrete  ");
        map.put(cyanConcrete,       "cyan concrete        ");
        map.put(purpleConcrete,     "purple concrete      ");
        map.put(blueConcrete,       "blue concrete        ");
        map.put(brownConcrete,      "brown concrete       ");
        map.put(greenConcrete,      "green concrete       ");
        map.put(redConcrete,        "red concrete         ");
        map.put(blackConcrete,      "black concrete       ");
        map.put(smoothSandstone,    "smooth sandstone     ");
        map.put(stone,              "stone                ");
        map.put(smoothStone,        "smooth stone         ");

        HashMap<String, Integer> counter = new HashMap<>();
        for (String s : map.values()) {
            counter.put(s, 0);
        }

        System.out.println(map.size());
        System.out.println(counter.size());

        System.out.println("w:" + preImage.getWidth());
        System.out.println("h:" + preImage.getHeight());
        System.out.println("WIDTH TO HEIGHT RATIO: " + preImage.getWidth() / (float) preImage.getHeight());

        //int width = 18;
        //int height = 24;

        //Color[][] output = new Color[width][height];
        System.out.println(Arrays.toString(output));

        int xUnit = preImage.getWidth()/width;
        int yUnit = preImage.getHeight()/height;

        int rTotal = 0;
        int gTotal = 0;
        int bTotal = 0;


        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                rTotal = 0;
                gTotal = 0;
                bTotal = 0;
                for (int k = 0; k < xUnit; k++) {
                    for (int l = 0; l < yUnit; l++) {
                        int pixel = preImage.getRGB(i*xUnit+k, j*yUnit+l);
                        rTotal += (pixel >> 16) & 0xff;
                        gTotal += (pixel >> 8) & 0xff;
                        bTotal += (pixel) & 0xff;
                    }
                }
                rTotal = rTotal / (xUnit*yUnit);
                gTotal = gTotal / (xUnit*yUnit);
                bTotal = bTotal / (xUnit*yUnit);

                double lowestNum = Double.MAX_VALUE;
                int index = 0;

                for (int k = 0; k < materials.length; k++) {
                    double distance = distance(materials[k], new Color(rTotal, gTotal, bTotal));
                    if(distance < lowestNum) {
                        lowestNum = distance;
                        index = k;
                    }
                }

                output[i][j] = index;
                //System.out.println("1: " + output[i][j]);
                output2[i][j] = materials[index];
                //System.out.println("2: " + output2[i][j]);
                output3[i][j] = map.get(output2[i][j]);
                //System.out.println("3: " + output3[i][j]);
                int num = counter.get(output3[i][j]);
                counter.replace(output3[i][j], num, num+1);

            }
        }

        //System.out.println(counter);

        //String[] names = new String[output.length];
        //String name = "";



        for (int i = 0; i < output[0].length; i++) {
            for (int j = 0; j < output.length; j++) {
                //name += output3[j][i] + "\t";
                int num = counter.get(output3[j][i]);
                counter.replace(output3[j][i], num, num);
                //System.out.print(output3[j][i] + "\t");
            }
            //names[i] = name;
            //name = "";
            //System.out.println();
        }

        //for (int i = output3.length-1; i >= 0; i--) {
        for (int i = 0; i <= output.length; i++) {
            outputString += (142 - i) + ": ";
            for (int j = output[0].length - 1 - (54); j >= 0; j--) {
                if(i == output.length) {
                    outputString += 2206-j + "                   \t";
                }
                else {
                    outputString += output3[i][j] + "\t";
                }
                //System.out.print(output3[i][j] + "\t");
            }
            outputString += "\n";
        }
        System.out.println(outputString);

        /*for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[0].length; j++) {
                name += output3[i][j] + "\t";
                int num = counter.get(output3[i][j]);
                counter.replace(output3[i][j], num, num+1);
                System.out.print(output3[i][j] + "\t");
            }
            names[i] = name;
            name = "";
            System.out.println();
        }*/

        //String[] keys = (String[]) counter.keySet().toArray();

        for (String s : counter.keySet()) {
            if(counter.get(s) != 0) {
                System.out.println(s + ": " + counter.get(s) / 64 + " " + counter.get(s) % 64);
            }
        }

        /*for (int i = 0; i < names.length; i++) {
            ArrayList<Integer> counts = new ArrayList<>();
            String[] tempArr = names[i].split("\t");
            ArrayList<String> tempArr2 = new ArrayList<>();
            for (int j = 0; j < tempArr.length; j++) {
                if(!tempArr[j].equals(" "))
                    tempArr2.add(tempArr[j].trim());
            }
            System.out.println(tempArr2);
            String currentString = tempArr2.get(0);
            counts.add(0);
            ArrayList<Integer> removers = new ArrayList<>();
            for (int j = 1; j < tempArr2.size(); j++) {
                //System.out.println("tempArr:" + tempArr2.get(j) + "\t" + j);
                //System.out.println("currentString:"+currentString + "\n");
                if(tempArr2.get(j).equals(currentString)) {
                    counts.add(counts.get(counts.size()-1)+1);
                    counts.remove(counts.size()-2);
                    removers.add(j);
                }
                else {
                    currentString = tempArr2.get(j);
                    counts.add(0);
                }
            }
            for (int j = removers.size()-1; j > 0; j--) {
                tempArr2.remove((int) removers.get(j));
            }
            String stringBuilder = "";
            System.out.println(tempArr2);
            System.out.println(counts);
            tempArr2.remove(0);
            int counted = 0;
            for (int j = 0; j < counts.size(); j++) {
                counted+= counts.get(j)+1;
            }
            System.out.println("counted:" + counted);
            for (int j = 0; j < tempArr2.size(); j++) {
                stringBuilder += tempArr2.get(j) + " x" + counts.get(j) + "  ";
            }
            System.out.println(stringBuilder);
        }*/

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

    }
}
