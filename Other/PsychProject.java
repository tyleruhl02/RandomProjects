package HighSchool.Other;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class PsychProject extends JPanel {
    public static final double TRI1MEAN = 91.2;
    public static final double TRI2MEAN = 87.8;
    public static final double TRI3MEAN = 82.3;
    public static final double TRI1SD = 3;
    public static final double TRI2SD = 4;
    public static final double TRI3SD = 5;
    public static final int NUMBEROFTRIALS = 71;
    public static Student[] students = new Student[NUMBEROFTRIALS];

    public PsychProject() {
        this.setBackground(Color.WHITE);
        this.setFocusable(true);
    }

    private static void createAndShowGUI() {
        PsychProject panel = new PsychProject();

        JFrame frame = new JFrame("TestFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public Dimension getPreferredSize() {
        return new Dimension(25*30+100, 950);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int[] tri1Grades = new int[30];
        int[] tri2Grades = new int[30];
        int[] tri3Grades = new int[30];
        int index = 0;
        for (int i = 0; i < NUMBEROFTRIALS; i++) {
            index = (int) (students[i].getTri1Grade())-70;
            if(index > 29) {
                index = 29;
            }
            if(index < 0) {
                index = 0;
            }
            tri1Grades[index]++;
            index = (int) (students[i].getTri2Grade())-70;
            if(index > 29) {
                index = 29;
            }
            if(index < 0) {
                index = 0;
            }
            tri2Grades[index]++;
            index = (int) (students[i].getTri3Grade())-70;
            if(index > 29) {
                index = 29;
            }
            if(index < 0) {
                index = 0;
            }
            tri3Grades[index]++;
        }

        //System.out.println(Arrays.toString(tri1Grades));

        int size = 25;
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.PLAIN, size));
        for (int j = 0; j < 30; j++) {
            g.fillRect(50+(j*size), 300-size*tri1Grades[j], size, size*tri1Grades[j]);
        }
        g.setColor(Color.BLACK);
        g.drawString("1", 40, 300-size);
        g.drawString("2", 40, 300-size*2);
        g.drawString("3", 40, 300-size*3);
        g.drawString("4", 40, 300-size*4);
        g.drawString("5", 40, 300-size*5);
        g.drawString("6", 40, 300-size*6);
        g.drawString("7", 40, 300-size*7);
        g.drawString("8", 40, 300-size*8);
        g.drawString("9", 40, 300-size*9);

        g.drawString("70", 40, 300+size);
        g.drawString("75", 40+size*5, 300+size);
        g.drawString("80", 40+size*10, 300+size);
        g.drawString("85", 40+size*15, 300+size);
        g.drawString("90", 40+size*20, 300+size);
        g.drawString("95", 40+size*25, 300+size);
        g.drawString("100", 40+size*30, 300+size);
        g.setColor(Color.RED);
        for (int j = 0; j < 30; j++) {
            g.fillRect(50+(j*size), 600-size*tri2Grades[j], size, size*tri2Grades[j]);
        }
        g.setColor(Color.BLACK);
        g.drawString("1", 40, 600-size);
        g.drawString("2", 40, 600-size*2);
        g.drawString("3", 40, 600-size*3);
        g.drawString("4", 40, 600-size*4);
        g.drawString("5", 40, 600-size*5);
        g.drawString("6", 40, 600-size*6);
        g.drawString("7", 40, 600-size*7);
        g.drawString("8", 40, 600-size*8);
        g.drawString("9", 40, 600-size*9);

        g.drawString("70", 40, 600+size);
        g.drawString("75", 40+size*5, 600+size);
        g.drawString("80", 40+size*10, 600+size);
        g.drawString("85", 40+size*15, 600+size);
        g.drawString("90", 40+size*20, 600+size);
        g.drawString("95", 40+size*25, 600+size);
        g.drawString("100", 40+size*30, 600+size);
        g.setColor(Color.RED);
        for (int j = 0; j < 30; j++) {
            g.fillRect(50+(j*size), 900-size*tri3Grades[j], size, size*tri3Grades[j]);
        }
        g.setColor(Color.BLACK);
        g.drawString("1", 40, 900-size);
        g.drawString("2", 40, 900-size*2);
        g.drawString("3", 40, 900-size*3);
        g.drawString("4", 40, 900-size*4);
        g.drawString("5", 40, 900-size*5);
        g.drawString("6", 40, 900-size*6);
        g.drawString("7", 40, 900-size*7);
        g.drawString("8", 40, 900-size*8);
        g.drawString("9", 40, 900-size*9);

        g.drawString("70", 40, 900+size);
        g.drawString("75", 40+size*5, 900+size);
        g.drawString("80", 40+size*10, 900+size);
        g.drawString("85", 40+size*15, 900+size);
        g.drawString("90", 40+size*20, 900+size);
        g.drawString("95", 40+size*25, 900+size);
        g.drawString("100", 40+size*30, 900+size);
    }

    public static void main(String[] args) {
        Random r = new Random();

        boolean sweat = false;
        double studentSkill = 0;
        double baseGrade = 0;

        for (int i = 0; i < NUMBEROFTRIALS; i++) {
            if(r.nextInt(10) == 5) {
                sweat = true;
            }
            else {
                sweat = false;
            }

            studentSkill = r.nextGaussian();
            if(studentSkill <= 1 && studentSkill >= -1) {
                baseGrade = r.nextGaussian()*TRI1SD+TRI1MEAN;
            }
            else if(studentSkill <= 2 && studentSkill >= -2) {
                baseGrade = r.nextGaussian()*TRI1SD+TRI1MEAN+1;
            }
            else {
                baseGrade = r.nextGaussian()*TRI1SD+TRI1MEAN+2;
            }

            if(sweat) {
                students[i] = new Student(baseGrade, baseGrade+r.nextGaussian()*TRI2SD, baseGrade+r.nextGaussian()*TRI3SD, sweat);
            }
            else {
                students[i] = new Student(baseGrade, baseGrade-r.nextGaussian()*TRI2SD-(TRI1MEAN-TRI2MEAN), baseGrade-r.nextGaussian()*TRI3SD-(TRI1MEAN-TRI3MEAN), sweat);
            }
        }

        double tri1sum = 0;
        double tri2sum = 0;
        double tri3sum = 0;
        double tri1mean = 0;
        double tri2mean = 0;
        double tri3mean = 0;
        double tri1SD = 0;
        double tri2SD = 0;
        double tri3SD = 0;
        double[] standardDeviationsTri1 = new double[NUMBEROFTRIALS];
        double[] standardDeviationsTri2 = new double[NUMBEROFTRIALS];
        double[] standardDeviationsTri3 = new double[NUMBEROFTRIALS];

        for (int i = 0; i < NUMBEROFTRIALS; i++) {
            System.out.println(students[i]);
            tri1sum+=students[i].getTri1Grade();
            tri2sum+=students[i].getTri2Grade();
            tri3sum+=students[i].getTri3Grade();
        }

        tri1mean = tri1sum/NUMBEROFTRIALS;
        tri2mean = tri2sum/NUMBEROFTRIALS;
        tri3mean = tri3sum/NUMBEROFTRIALS;

        for (int i = 0; i < NUMBEROFTRIALS; i++) {
            standardDeviationsTri1[i] = Math.pow(tri1mean-students[i].getTri1Grade(), 2);
            standardDeviationsTri2[i] = Math.pow(tri2mean-students[i].getTri2Grade(), 2);
            standardDeviationsTri3[i] = Math.pow(tri3mean-students[i].getTri3Grade(), 2);
        }

        tri1sum = 0;
        tri2sum = 0;
        tri3sum = 0;

        for (int i = 0; i < NUMBEROFTRIALS; i++) {
            tri1sum += standardDeviationsTri1[i];
            tri2sum += standardDeviationsTri2[i];
            tri3sum += standardDeviationsTri3[i];
        }

        tri1sum = tri1sum / NUMBEROFTRIALS;
        tri2sum = tri2sum / NUMBEROFTRIALS;
        tri3sum = tri3sum / NUMBEROFTRIALS;

        tri1SD = Math.sqrt(tri1sum);
        tri2SD = Math.sqrt(tri2sum);
        tri3SD = Math.sqrt(tri3sum);

        System.out.println("TRI 1 MEAN: " + tri1mean + "\tTRI 1 SD: " + tri1SD);
        System.out.println("TRI 2 MEAN: " + tri2mean + "\tTRI 2 SD: " + tri2SD);
        System.out.println("TRI 3 MEAN: " + tri3mean + "\tTRI 3 SD: " + tri3SD);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

    }
}
