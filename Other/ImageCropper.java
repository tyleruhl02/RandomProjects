package HighSchool.Other;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.util.ArrayList;

public class ImageCropper extends JPanel {
    public BufferedImage img;

    public ImageCropper() {
        this.setBackground(Color.WHITE);
        this.setFocusable(true);
        try {
            img = ImageIO.read(new File("page-1-Sobel-awardees-791x1024.jpeg"));
        }
        catch(Exception e) {
            System.out.println("RIP");
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(img, 0, 0, this);
        final byte[] pixels = ((DataBufferByte) img.getRaster().getDataBuffer()).getData();
        System.out.println(img.getHeight());
        int rsum = 0;
        int gsum = 0;
        int bsum = 0;
        ArrayList<Integer> importantRows = new ArrayList<>();
        ArrayList<Integer> importantRows2 = new ArrayList<>();
        for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += 3) {
            int R = 0;
            int G = 0;
            int B = 0;
            int A;
            //A = ((int) pixels[pixel] & 0xff);
            B = ((int) pixels[pixel] & 0xff); // blue
            G = ((int) pixels[pixel + 1] & 0xff); // green
            R = ((int) pixels[pixel + 2] & 0xff); // red
            //System.out.println("(" + row + ", " + col + "): " + R + ", " + G + ", " + B);
            rsum += R;
            gsum += G;
            bsum += B; // 140-363    424-673      697-938
            col++;
            if (col == img.getWidth()){
                if(row > 105 && rsum/img.getWidth()+gsum/img.getWidth()+bsum/img.getWidth() < 760) {
                    importantRows.add(row);
                }
                System.out.println("ROW " + row + ":\t\t" + rsum/img.getWidth() + ", " + gsum/img.getWidth() + ", " + bsum / img.getWidth());

                col = 0;
                row++;
                rsum = 0;
                gsum = 0;
                bsum = 0;
                //System.out.println();
            }
        }
        for (int i = 0; i < importantRows.size(); i++) {
            if(!importantRows.contains(importantRows.get(i)-1)) {
                importantRows2.add(importantRows.get(i));
            }
            if(!importantRows.contains(importantRows.get(i)+1)) {
                importantRows2.add(importantRows.get(i));
            }
        }
        importantRows2.remove(2);
        importantRows2.remove(2);
        importantRows2.remove(4);
        importantRows2.remove(4);
        importantRows2.remove(6);
        importantRows2.remove(6);

        ArrayList<Integer> importantColumns = new ArrayList<>();
        ArrayList<Integer> importantColumns2 = new ArrayList<>();
        for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += 3) {
            int R = 0;
            int G = 0;
            int B = 0;
            B = ((int) pixels[pixel] & 0xff); // blue
            G = ((int) pixels[pixel + 1] & 0xff); // green
            R = ((int) pixels[pixel + 2] & 0xff); // red
            if((row>=importantRows2.get(0)&&row<=importantRows2.get(1))||(row>=importantRows2.get(2)&&row<=importantRows2.get(3))||(row>=importantRows2.get(4)&&row<=importantRows2.get(5))) {
                //System.out.println(row);
                if(R+G+B < 700 && !importantColumns.contains(col)) {
                    importantColumns.add(col);
                }
            }
            rsum += R;
            gsum += G;
            bsum += B;
            col++;
            if (col == img.getWidth()){
                col = 0;
                row++;
                rsum = 0;
                gsum = 0;
                bsum = 0;
                //System.out.println();
            }
        }

        for (int i = 0; i < importantColumns.size(); i++) {
            if(!importantColumns.contains(importantColumns.get(i)-1)) {
                importantColumns2.add(importantColumns.get(i));
            }
            if(!importantColumns.contains(importantColumns.get(i)+1)) {
                importantColumns2.add(importantColumns.get(i));
            }
        }

        for (int i = 0; i < importantColumns2.size(); i++) {
            System.out.println(importantColumns2.get(i));
        }
        g2.drawLine(0, importantRows2.get(0), img.getWidth(), importantRows2.get(0));
        g2.drawLine(0, importantRows2.get(1), img.getWidth(), importantRows2.get(1));
        g2.drawLine(0, importantRows2.get(2), img.getWidth(), importantRows2.get(2));
        g2.drawLine(0, importantRows2.get(3), img.getWidth(), importantRows2.get(3));
        g2.drawLine(0, importantRows2.get(4), img.getWidth(), importantRows2.get(4));
        g2.drawLine(0, importantRows2.get(5), img.getWidth(), importantRows2.get(5));

        g2.drawLine(importantColumns2.get(1), 0, importantColumns2.get(1), img.getHeight());
        g2.drawLine(importantColumns2.get(2), 0, importantColumns2.get(2), img.getHeight());
        g2.drawLine(importantColumns2.get(3), 0, importantColumns2.get(3), img.getHeight());
        g2.drawLine(importantColumns2.get(4), 0, importantColumns2.get(4), img.getHeight());
        g2.drawLine(importantColumns2.get(5), 0, importantColumns2.get(5), img.getHeight());
        g2.drawLine(importantColumns2.get(0), 0, importantColumns2.get(0), img.getHeight());





        //System.out.println(Arrays.toString(pixels));
        //int[][] startingValues =   {{90, 146, 165, 216}, {318, 136, 156, 220}, {535, 146, 154, 218},
        //                            {94, 420, 165, 216}, {310, 420, 165, 216}, {530, 430, 165, 216}};
        //for (int i = 0; i < 6; i++) {
            //g2.drawRect(startingValues[i][0], startingValues[i][1], startingValues[i][2], startingValues[i][3]);
        //}
        //for (int i = 0; i < 3; i++) {
        //    for (int j = 0; j < 3; j++) {
        //        g2.drawRect(i*220+90, j*275+136, 165, 220);
        //    }
        //}

    }

    private static void createAndShowGUI() {
        ImageCropper panel = new ImageCropper();

        JFrame frame = new JFrame("TestFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public Dimension getPreferredSize() {
        return new Dimension(791, 1024);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
