package HighSchool.AP.Object_Lab;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class MazeAnimator extends JPanel {
    public final int PREF_W = 1000;
    public final int PREF_H = 800;
    public final int MAZE_WIDTH = 69;
    public final int MAZE_HEIGHT = 69;
    public final int MAZE_SIZE = 800;
    public final int CELL_WIDTH = (MAZE_HEIGHT > MAZE_WIDTH) ? (MAZE_SIZE / (MAZE_HEIGHT * 2 + 1)) : (MAZE_SIZE / (MAZE_WIDTH * 2 + 1));
    public final int CELL_HEIGHT = (MAZE_HEIGHT > MAZE_WIDTH) ? (MAZE_SIZE / (MAZE_HEIGHT * 2 + 1)) : (MAZE_SIZE / (MAZE_WIDTH * 2 + 1));
    public final int UP = 0;
    public final int RIGHT = 1;
    public final int DOWN = 2;
    public final int LEFT = 3;
    public final Font FONT = new Font("Georgia", Font.PLAIN, 20);
    public static final Color BACKGROUND_COLOR = new Color(200, 200, 200);
    public final Color MAZE_WALL_COLOR = new Color(50, 50, 50);
    public final Color MAZE_SOLVER_COLOR = Color.RED;
    public final Color MAZE_START_COLOR = Color.GREEN;
    public final Color MAZE_END_COLOR = Color.BLUE;
    public final int MOVEMENT_SPEED = 10; // in milliseconds
    private MazeGenerator m;
    private MazeSolver s;
    private boolean[][] leftWalls, topWalls;
    private int[] solution;
    private Timer timer;
    private ArrayList<Rectangle> path;
    private int moves;
    private JButton exitButton, restartButton;
    private int startX;
    private int startY;
    private int endX;
    private int endY;

    public MazeAnimator() {
        this.setLayout(null);

        m = new MazeGenerator();
        s = new MazeSolver();

        setupMaze();

        restartButton = new JButton("NEW MAZE");
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setupMaze();
            }
        });

        restartButton.setFont(FONT);
        restartButton.setLocation(825, 100);
        restartButton.setSize(150, 150);

        this.add(restartButton);

        exitButton = new JButton("EXIT");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        exitButton.setFont(FONT);
        exitButton.setLocation(825, 550);
        exitButton.setSize(150, 150);

        this.add(exitButton);

        timer = new Timer(MOVEMENT_SPEED, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
                repaint();
            }
        });

        timer.start();


        //for(String s : GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames())
        //    System.out.println(s);
    }

    private void setupMaze() {
        moves = 0;

        m.generateMaze(MAZE_WIDTH, MAZE_HEIGHT);

        startX = m.getStartX();
        startY = m.getStartY();

        endX = m.getEndX();
        endY = m.getEndY();

        System.out.println(m.getStartX());
        System.out.println(m.getStartY());

        System.out.println(m.getEndX());
        System.out.println(m.getEndY());

        Cell[][] c =  m.getMaze();
        //System.out.println(c.length);
        //System.out.println(c[0].length);

        leftWalls = new boolean[c.length][c[0].length];
        topWalls = new boolean[c.length][c[0].length];

        for (int i = 0; i < c[0].length; i++) {
            for (int j = 0; j < c.length; j++) {
                if(c[j][i].upWall != 0) {
                    topWalls[j][i] = true;
                    System.out.print("---");
                }
                else {
                    System.out.print("   ");
                }
            }
            System.out.println("-");
            for (int j = 0; j < c.length; j++) {
                if(c[j][i].leftWall != 0) {
                    leftWalls[j][i] = true;
                    System.out.print("|  ");
                }
                else {
                    System.out.print("   ");
                }
            }
            System.out.println("|");
        }
        System.out.println("----------------");


        System.out.println("LEFT WALLS");
        for (int i = 0; i < c[0].length; i++) {
            for (int j = 0; j < c.length; j++) {
                System.out.print(leftWalls[j][i] + ",\t");
            }
            System.out.println();
        }

        System.out.println("TOP WALLS");
        for (int i = 0; i < c[0].length; i++) {
            for (int j = 0; j < c.length; j++) {
                System.out.print(topWalls[j][i] + ",\t");
            }
            System.out.println();
        }

        solution = s.solveMaze();
        for(int i = 0; i < solution.length; i++) {
            switch (solution[i]) {
                case 2:
                    System.out.println("DOWN");
                    break;
                case 3:
                    System.out.println("LEFT");
                    break;
                case 1:
                    System.out.println("RIGHT");
                    break;
                case 0:
                    System.out.println("UP");
                    break;
                default:
                    System.out.println("Invalid syntax in solution!");
            }
        }

        path = new ArrayList<Rectangle>(); // Sets starting spot
        path.add(new Rectangle(CELL_WIDTH+((CELL_WIDTH*2)*startX), CELL_HEIGHT+((CELL_HEIGHT*2)*startY), CELL_WIDTH, CELL_HEIGHT));
    }

    private void update() {
        if(moves < solution.length) { // Finds the next move and makes a location there
            int rectX = path.get(path.size()-1).x;
            int rectY = path.get(path.size()-1).y;
            if(solution[moves] == UP) {
                rectY -= CELL_HEIGHT;
                path.add(new Rectangle(rectX, rectY, CELL_WIDTH, CELL_HEIGHT));
                    rectY -= CELL_HEIGHT;
                    path.add(new Rectangle(rectX, rectY, CELL_WIDTH, CELL_HEIGHT));
            }
            else if(solution[moves] == RIGHT) {
                rectX += CELL_WIDTH;
                path.add(new Rectangle(rectX, rectY, CELL_WIDTH, CELL_HEIGHT));
                    rectX += CELL_WIDTH;
                    path.add(new Rectangle(rectX, rectY, CELL_WIDTH, CELL_HEIGHT));
            }
            else if(solution[moves] == DOWN) {
                rectY += CELL_HEIGHT;
                path.add(new Rectangle(rectX, rectY, CELL_WIDTH, CELL_HEIGHT));
                    rectY += CELL_HEIGHT;
                    path.add(new Rectangle(rectX, rectY, CELL_WIDTH, CELL_HEIGHT));
            }
            else if(solution[moves] == LEFT) {
                rectX -= CELL_WIDTH;
                path.add(new Rectangle(rectX, rectY, CELL_WIDTH, CELL_HEIGHT));
                    rectX -= CELL_WIDTH;
                    path.add(new Rectangle(rectX, rectY, CELL_WIDTH, CELL_HEIGHT));
            }
            moves++;
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(PREF_W, PREF_H);
    }

    public static void main(String[] args)
    {
        JFrame f = new JFrame("Maze Animator"); // Sets up JFrame

        JPanel P = new MazeAnimator();

        P.setBackground(BACKGROUND_COLOR);

        f.getContentPane().add(P);

        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public void paintComponent (Graphics g) { // Paints
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(MAZE_WALL_COLOR);

        int heightSpaceAccounter = CELL_HEIGHT;
        int widthSpaceAccounter = CELL_WIDTH;

        for (int r = 0; r < MAZE_HEIGHT; r++) { // Paints walls
            widthSpaceAccounter = 0;
            for (int c = 0; c < MAZE_WIDTH; c++) {
                if(topWalls[c][r]) {
                    g2.fillRect((int)(c*CELL_WIDTH+widthSpaceAccounter+CELL_WIDTH), (int)(r*CELL_HEIGHT+heightSpaceAccounter-CELL_HEIGHT), (int)(CELL_WIDTH), (int)(CELL_HEIGHT));
                }
                if(leftWalls[c][r]) {
                    g2.fillRect((int)(c*CELL_WIDTH+widthSpaceAccounter), (int)(r*CELL_HEIGHT+heightSpaceAccounter), (int)(CELL_WIDTH), (int)(CELL_HEIGHT));
                }
                g2.fillRect((int)(c*CELL_WIDTH+widthSpaceAccounter), (int)(r*CELL_HEIGHT+heightSpaceAccounter-CELL_HEIGHT), (int)(CELL_WIDTH), (int)(CELL_HEIGHT)); // Paints corner walls
                widthSpaceAccounter += CELL_WIDTH;
            }
            heightSpaceAccounter += CELL_HEIGHT;
        }
        g2.fillRect(CELL_WIDTH*(MAZE_WIDTH * 2), 0, CELL_WIDTH, CELL_HEIGHT*(MAZE_HEIGHT * 2));
        g2.fillRect(0, CELL_HEIGHT*(MAZE_HEIGHT * 2), CELL_WIDTH*(MAZE_WIDTH * 2 + 1), CELL_HEIGHT);

        g2.setColor(MAZE_SOLVER_COLOR);
        for(Rectangle r : path) { // Paints the circles
            g2.fillRect(r.x, r.y, r.width, r.height);
        }

        g2.setColor(MAZE_START_COLOR); // Paints Start and Finish
        g2.fill(new Rectangle(CELL_WIDTH+(CELL_WIDTH*2)*startX, CELL_HEIGHT+(CELL_HEIGHT*2)*startY, CELL_WIDTH, CELL_HEIGHT));
        g2.setColor(MAZE_END_COLOR);
        g2.fill(new Rectangle(CELL_WIDTH+(CELL_WIDTH*2)*endX, CELL_HEIGHT+(CELL_HEIGHT*2)*endY, CELL_WIDTH, CELL_HEIGHT));
    }
}
