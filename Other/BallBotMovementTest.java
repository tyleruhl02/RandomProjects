package HighSchool.Other;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BallBotMovementTest extends JPanel implements KeyListener {
    private static double x = 10;
    private static double y = 10;
    private static double motor1 = 0;
    private static double motor2 = 0;
    private static double motor3 = 0;

    public BallBotMovementTest() {
        this.setBackground(Color.WHITE);
        this.setFocusable(true);
        this.addKeyListener(this);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        double sqrt2 = Math.sqrt(2);

        y += motor1;
        y -= motor2/2.0;
        y -= motor3/2.0;
        x += motor2/2.0*Math.sqrt(3);
        x -= motor3/2.0*Math.sqrt(3);

        //int xCenter = (int) (((x+10*sqrt2/2)*5) + (((x+10*sqrt2/2+10)*5)))/2;
        //int yCenter = (int) (((y+10*sqrt2/2)*5) + (((y+10*sqrt2/2+10)*5)))/2;

        g.drawOval((int) (x*5+110), (int) (y*5+90), 10, 10);
        g.drawOval((int) (x*5), (int) (y*5+90), 10, 10);
        g.drawOval((int) (x*5+55), (int) (y*5-10), 10, 10);

        int[] xArray = {(int) (x+10*sqrt2/2)*5, (int) (x+10*sqrt2/2+10)*5, (int) (x+20*sqrt2/2+10)*5, (int) (x+20*sqrt2/2+10)*5, (int) (x+10*sqrt2/2+10)*5, (int) (x+10*sqrt2/2)*5, (int) (x*5), (int) (x*5), (int) (x+10*sqrt2/2)*5};
        int[] yArray = {(int) (y*5), (int) (y*5), (int) (y+10*sqrt2/2)*5, (int) (y+10*sqrt2/2+10)*5, (int) (y+20*sqrt2/2+10)*5, (int) (y+20*sqrt2/2+10)*5, (int) (y+10*sqrt2/2+10)*5, (int) (y+10*sqrt2/2)*5, (int) (y*5)};

        g.drawPolygon(xArray, yArray, 9);

        System.out.printf("X: %f\nY: %f\nMotor1: %f\nMotor2: %f\n Motor3: %f\n\n\n", x, y, motor1, motor2, motor3);
    }

    private static void createAndShowGUI() {
        BallBotMovementTest panel = new BallBotMovementTest();

        JFrame frame = new JFrame("TestFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public Dimension getPreferredSize() {
        return new Dimension(600, 600);
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
        if(e.getKeyCode() == KeyEvent.VK_1)
            motor1 = 1;
        else
            motor1 = 0;
        if(e.getKeyCode() == KeyEvent.VK_2)
            motor2 = 1;
        else
            motor2 = 0;
        if(e.getKeyCode() == KeyEvent.VK_3)
            motor3 = 1;
        else
            motor3 = 0;

        if(e.getKeyCode() == KeyEvent.VK_UP) {
            motor2 = 1;
            motor3 = 1;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            motor1 = 1;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            motor2 = Math.sqrt(3)*2/3;
            motor1 = Math.sqrt(3)/3;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            motor3 = Math.sqrt(3)*2/3;
            motor1 = Math.sqrt(3)/3;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
