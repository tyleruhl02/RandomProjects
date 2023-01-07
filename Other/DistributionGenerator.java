package HighSchool.Other;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class DistributionGenerator extends JPanel implements MouseListener, KeyListener {
    private static ArrayList<CriticalPoint> criticalPoints = new ArrayList<>();
    private static int hoverPoint = -1;
    private static int hoverLine = -1;
    private static boolean lock = false;
    private static boolean endgame = false;

    int mouseX;
    int mouseY;

    public DistributionGenerator() {
        addMouseListener(this);
        this.setBackground(Color.WHITE);
        this.setFocusable(true);
    }

    private static double distanceBetweenTwoPoints(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
    }

    private static int findIndex(int x) {
        for (int i = 0; i < criticalPoints.size()-1; i++) {
            if(x > criticalPoints.get(i).getX() && x < criticalPoints.get(i+1).getX()) {
                return i+1;
            }
        }
        return -1;
    }

    private static void createAndShowGUI() {
        DistributionGenerator panel = new DistributionGenerator();

        JFrame frame = new JFrame("TestFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public Dimension getPreferredSize() {
        return new Dimension(1600, 900);
    }

    public static CriticalPoint[] sort (CriticalPoint[] c) {
        int tempX;
        int tempY;

        for (int i = 0; i < c.length; i++) {
            for (int j = i; j < c.length; j++) {
                if(c[j].getX() > c[i].getX()) {
                    tempX = c[j].getX();
                    tempY = c[j].getY();
                    c[j].setX(c[i].getX());
                    c[j].setY(c[i].getY());
                    c[i].setX(tempX);
                    c[i].setY(tempY);
                }
            }
        }

        return c;
    }

    protected void paintComponent(Graphics g) {
        //super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.LIGHT_GRAY);
        if(endgame) {
            g2.setColor(Color.BLACK);
        }

        g2.fillRect(-10, -10, 1620, 920);

        g2.setColor(Color.RED);
        g2.setStroke(new BasicStroke(10));

        mouseX = getMousePosition().x;
        mouseY = getMousePosition().y;

        //CriticalPoint[] c = new CriticalPoint[criticalPoints.size()];
        //c = sort(criticalPoints.toArray(c));
        //c = criticalPoints.toArray(c);
        //double ratio;
        //double MAGICNUMBER = 2;
        boolean usedBlue = false;

        double seg1;
        double seg2;
        double seg3;

        int blueInt = -1;

        for (int i = 0; i < criticalPoints.size(); i++) {
            if (Math.abs(mouseX - criticalPoints.get(i).getX()) < 20 && Math.abs(mouseY - criticalPoints.get(i).getY()) < 20 && !usedBlue) {
                g2.setColor(Color.BLUE);
                blueInt = i;
                usedBlue = true;
                if(hoverPoint == i) {
                    g2.fillOval(mouseX - 10, mouseY - 10, 20, 20);
                }
                else {
                    g2.fillOval(criticalPoints.get(i).getX() - 10, criticalPoints.get(i).getY() - 10, 20, 20);
                }
            }
        }

        for (int i = 0; i < criticalPoints.size()-1; i++) {
            seg1 = distanceBetweenTwoPoints(criticalPoints.get(i).getX(), criticalPoints.get(i).getY(), mouseX, mouseY);
            seg2 = distanceBetweenTwoPoints(mouseX, mouseY, criticalPoints.get(i+1).getX(), criticalPoints.get(i+1).getY());
            seg3 = distanceBetweenTwoPoints(criticalPoints.get(i).getX(), criticalPoints.get(i).getY(), criticalPoints.get(i+1).getX(), criticalPoints.get(i+1).getY());
            //ratio = seg1 / seg2 * MAGICNUMBER;
            //ratio = ratio < 1 ? 5 * (1 / ratio) : ratio * 5;
            if(seg1 + seg2 < 10 + seg3 && !usedBlue) {
                g2.setColor(Color.BLUE);
                hoverLine = i;
                usedBlue = true;
            }
            else {
                g2.setColor(Color.RED);
            }
            if(hoverPoint == i) {
                g2.drawLine(mouseX, mouseY, criticalPoints.get(i+1).getX(), criticalPoints.get(i+1).getY());
            }
            else if(hoverPoint == i+1) {
                g2.drawLine(criticalPoints.get(i).getX(), criticalPoints.get(i).getY(), mouseX, mouseY);
            }
            else {
                g2.drawLine(criticalPoints.get(i).getX(), criticalPoints.get(i).getY(), criticalPoints.get(i + 1).getX(), criticalPoints.get(i + 1).getY());
            }
        }

        g2.setColor(Color.RED);

        for (int i = 0; i < criticalPoints.size(); i++) {
            if (i == blueInt) {
                continue;
            }
            if(hoverPoint == i) {
                g2.fillOval(mouseX - 10, mouseY - 10, 20, 20);
            }
            else {
                g2.fillOval(criticalPoints.get(i).getX() - 10, criticalPoints.get(i).getY() - 10, 20, 20);
            }
        }

        for (int i = 1; i < criticalPoints.size(); i++) {
            if(criticalPoints.get(i).getX() < criticalPoints.get(i-1).getX()) {
                criticalPoints.get(i).setX(criticalPoints.get(i-1).getX()+1);
            }
        }


        repaint();
    }

    public static void main(String[] args) {
        criticalPoints.add(new CriticalPoint(100, 800));
        criticalPoints.add(new CriticalPoint(800, 100));
        criticalPoints.add(new CriticalPoint(1500, 800));

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(lock) {
            if(hoverPoint != -1) {
                criticalPoints.get(hoverPoint).setX(mouseX);
                criticalPoints.get(hoverPoint).setY(mouseY);
                hoverPoint = -1;
            }
            lock = false;
        }
        else if(!lock) {
            hoverPoint = -1;
            for (int i = 0; i < criticalPoints.size(); i++) {
                if (Math.abs(criticalPoints.get(i).getX() - e.getX()) < 20 && Math.abs(criticalPoints.get(i).getY() - e.getY()) < 20) {
                    hoverPoint = i;
                    hoverLine = -1;
                }
            }
            if(hoverLine != -1) {
                double slope = -1*(criticalPoints.get(hoverLine+1).getY()-criticalPoints.get(hoverLine).getY()) / (1.0*(criticalPoints.get(hoverLine+1).getX()-criticalPoints.get(hoverLine).getX()));
                System.out.println(slope);
                System.out.println((int) (slope * (mouseX - criticalPoints.get(findIndex(mouseX)-1).getX())));
                System.out.println(findIndex(mouseX));
                System.out.println();
                criticalPoints.add(findIndex(mouseX), new CriticalPoint(mouseX, mouseY));
                /*if(slope > 0) {
                    System.out.println("mouseX: " + criticalPoints.get(findIndex(mouseX)).getX());
                    System.out.println("slope:  " + slope);
                    System.out.println("otherX: " + criticalPoints.get(findIndex(mouseX)-1).getX());
                    System.out.println();
                    criticalPoints.add(findIndex(mouseX), new CriticalPoint(mouseX, mouseY));//mouseX*((int) (slope * (criticalPoints.get(findIndex(mouseX)).getX() - criticalPoints.get(findIndex(mouseX)-1).getX())))));
                }
                else {
                    criticalPoints.add(findIndex(mouseX), new CriticalPoint(mouseX, mouseY));//(int) (slope * (mouseX - criticalPoints.get(findIndex(mouseX)).getX()))));
                }*/
            }
            lock = true;

        }
        //System.out.println(hoverPoint);
        //System.out.println(hoverLine);
        //System.out.println();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public Point getMousePosition(boolean allowChildren) throws HeadlessException {
        return super.getMousePosition(allowChildren);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //if(e.getKeyCode() == 13) {
            endgame = true;
        //}
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
