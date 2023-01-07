package HighSchool.Other;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class HandwritingEmulator extends JPanel implements KeyListener {
    private TylerFont font1;
    private int index1;
    private int index2;
    private String text;
    private ArrayList<BufferedImage> outputText;

    public HandwritingEmulator() {
        this.setBackground(Color.WHITE);
        font1 = new TylerFont("FontData\\Capture07.PNG");
        this.setFocusable(true);
        this.addKeyListener(this);
        index1 = 0;
        index2 = 0;
        outputText = new ArrayList<BufferedImage>();
        getText();
        setOutputText();
    }

    public String getText() {
        text = JOptionPane.showInputDialog("ENTER YOUR TEXT:");
        return text;
    }

    public String getFolderName(char character) {
        switch (character) {
            case '*':   return "AK";
            case '\\':  return "BS";
            case ':':   return "CO";
            case '"':   return "DQ";
            case '/':   return "FS";
            case '>':   return "GT";
            case '<':   return "LT";
            case '.':   return "PD";
            case '?':   return "QM";
            case '\'':  return "SQ";
            case '|':   return "SS";
        }
        if (Character.isUpperCase(character)) return "_" + character;
        return character + "";
    }

    public void setOutputText() {
        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            //String filePath = "letters\\" + getFolderName(letter) + "\\" + getFolderName(letter) + ((int) (Math.random() * 19));
            try {
                outputText.add(font1.getPostFont()[font1.getIndexFromFolder(getFolderName(letter))][(int) (Math.random() * 19)]);
            }
            catch(java.lang.ArrayIndexOutOfBoundsException e) {
                outputText.add(null);
            }
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        System.out.println(outputText.size());
        int x = 50;
        int y = 100;
        for (BufferedImage bi : outputText) {
            try {
                g2.drawImage(bi, x, y+50-bi.getHeight(), this);
                x += bi.getWidth() + (int) (Math.random() * 5) + 2;
            }
            catch (java.lang.NullPointerException e) {
                x += 20;
                if (x > 600) {
                    x = 50;
                    y += 50;
                }
            }
        }
            //font1.drawCharacter(g2, index1, index2, 100, 100, this);
    }

    private static void createAndShowGUI() {
        HandwritingEmulator panel = new HandwritingEmulator();

        JFrame frame = new JFrame("TestFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            index1 = ((--index1) + 93) % 93;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            index1 = (++index1) % 93;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            index2 = (++index2) % 19;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            index2 = ((--index2) + 19) % 19;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
