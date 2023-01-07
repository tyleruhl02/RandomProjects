package HighSchool.AP.Object_Lab;
//import java.util.ArrayList;
//
//// Part C2: Aidan, Patrick
//public class MazeSolver {
//    private static final boolean DEBUG = true;
//
//    public static final int MOVE_UP = 0;
//    public static final int MOVE_RIGHT = 1;
//    public static final int MOVE_DOWN = 2;
//    public static final int MOVE_LEFT = 3;
//
//    /*Returns an int array with each consecutive move
//    IMPORTANT: MazeGenerator.generateMaze(w, h) must be called before this!*/
//    public static int[] solveMaze() {
//        int[] solution = null;
//        int[][] steps = new int[MazeGenerator.getWidth()][MazeGenerator.getHeight()];
//        steps[MazeGenerator.getStartX()][MazeGenerator.getStartY()] = -1;
//
//        int step = 1;
//        ArrayList<Cell> toCheck = new ArrayList<Cell>();
//        toCheck.add(MazeGenerator.getCell(MazeGenerator.getStartX(), MazeGenerator.getStartY()));
//
//        if(DEBUG) {
//            System.out.println("Trying to find: ");
//            System.out.println(MazeGenerator.getEndX() + " " + MazeGenerator.getEndY());
//            System.out.println();
//        }
//
//        boolean searching = true;
//        while(searching) {
//            ArrayList<Cell> checkBuffer = new ArrayList<Cell>();
//
//            if(DEBUG) {
//                if(toCheck.size() == 0) {
//                    System.out.println("No paths left, maze is unsolvable!");
//                    break;
//                }
//
//                System.out.printf("New Cycle To Check: %d cells to check\n", toCheck.size());
//            }
//
//            for(Cell c : toCheck) {
//
//                if(DEBUG) {
//                    System.out.println("Checking: " + "(" + c.x + ", " + c.y + ") ");
//                    System.out.println();
//                }
//
//                if(c.x == MazeGenerator.getEndX() && c.y == MazeGenerator.getEndY()) {
//                    if(DEBUG)
//                        System.out.println("Made it!");
//                    searching = false;
//                    break;
//                }
//
//                boolean[] options = getViableMoves(steps, c.x, c.y);
//                if(options[MOVE_UP]) {
//                    if(DEBUG)
//                        System.out.println("\tUP Viable");
//                    steps[c.x][c.y-1] = step;
//                    checkBuffer.add(MazeGenerator.getCell(c.x, c.y-1));
//                }
//                if(options[MOVE_RIGHT]) {
//                    if(DEBUG)
//                        System.out.println("\tRIGHT Viable");
//                    steps[c.x+1][c.y] = step;
//                    checkBuffer.add(MazeGenerator.getCell(c.x+1, c.y));
//                }
//                if(options[MOVE_DOWN]) {
//                    if(DEBUG)
//                        System.out.println("\tDOWN Viable");
//                    steps[c.x][c.y+1] = step;
//                    checkBuffer.add(MazeGenerator.getCell(c.x, c.y+1));
//                }
//                if(options[MOVE_LEFT]) {
//                    if(DEBUG)
//                        System.out.println("\tLEFT Viable");
//                    steps[c.x-1][c.y] = step;
//                    checkBuffer.add(MazeGenerator.getCell(c.x-1, c.y));
//                }
//
//                if(DEBUG) {
//                    for(int i = 0; i < steps.length; i++) {
//                        for(int j = 0; j < steps[i].length; j++) {
//                            if(j == c.x && i == c.y)
//                                System.out.printf(" %2c ", 'x');
//                            else if(j == MazeGenerator.getEndX() && i == MazeGenerator.getEndY())
//                                System.out.printf(" %2c ", '!');
//                            else
//                                System.out.printf(" %2d ", steps[j][i]);
//                        }
//                        System.out.println("");
//                    }
//                }
//            }
//            step++;
//            toCheck = checkBuffer;
//        }
//
//        if(DEBUG) {
//            System.out.println("Final Map:");
//            for(int i = 0; i < steps.length; i++) {
//                for(int j = 0; j < steps[i].length; j++) {
//                    System.out.printf(" %2d ", steps[j][i]);
//                }
//                System.out.println("");
//            }
//        }
//
//        solution = getRoute(steps);
//        return solution;
//    }
//
//    //Takes an array with a completed path of steps from start to end, returns a set of directions
//    private static int[] getRoute(int[][] steps) {
//
//        int currX = MazeGenerator.getEndX();
//        int currY = MazeGenerator.getEndY();
//
//        int step = steps[currX][currY];
//        int[] route = new int[step];
//
//
//        for(int index = step-1; index >= 0; index--) {
//            int prevStep = (step != 1) ? step - 1 : -1;
//
//            int top = (currY > 0) ? steps[currX][currY-1] : 0;
//            int right = (currX < steps.length - 1) ? steps[currX+1][currY] : 0;
//            int bottom = (currY < steps[0].length - 1) ? steps[currX][currY+1] : 0;
//            int left = (currX > 0) ? steps[currX-1][currY] : 0;
//
//            if(top == prevStep) {
//                route[index] = MOVE_DOWN;
//                currY = currY-1;
//            }
//            else if(right == prevStep) {
//                route[index] = MOVE_LEFT;
//                currX = currX + 1;
//            }
//            else if(bottom == prevStep) {
//                route[index] = MOVE_UP;
//                currY = currY + 1;
//            }
//            else if(left == prevStep) {
//                route[index] = MOVE_RIGHT;
//                currX = currX - 1;
//            }
//            else {
//                System.out.println("Error backtracking solution");
//                return null;
//            }
//
//            step = steps[currX][currY];
//        }
//
//        return route;
//    }
//
//    //Takes the array of steps previously taken and a position, returns steps available from that position
//    private static boolean[] getViableMoves(int[][] steps, int x, int y) {
//        boolean[] moves = new boolean[4];
//
//        Cell top = (y > 0 && steps[x][y-1] == 0) ? MazeGenerator.getCell(x, y-1) : null;
//        Cell right = (x < steps.length - 1 && steps[x+1][y] == 0) ? MazeGenerator.getCell(x+1, y) : null;
//        Cell bottom = (y < steps[0].length - 1 && steps[x][y+1] == 0) ? MazeGenerator.getCell(x, y+1) : null;
//        Cell left = (x > 0 && steps[x-1][y] == 0) ? MazeGenerator.getCell(x-1, y) : null;
//
//        if(top != null && top.downWall == 0)
//            moves[MOVE_UP] = true;
//        if(right != null && right.leftWall == 0)
//            moves[MOVE_RIGHT] = true;
//        if(bottom != null && bottom.upWall == 0)
//            moves[MOVE_DOWN] = true;
//        if(left != null && left.rightWall == 0)
//            moves[MOVE_LEFT] = true;
//
//        return moves;
//    }
//
//    /*  An example of how to use this solver, and how to interpret the solution array
//    public static void main(String[] args) {
//        MazeGenerator.generateMaze(50, 50);
//        int[] solution = solveMaze();
//        for(int i = 0; i < solution.length; i++) {
//            switch (solution[i]) {
//                case MOVE_DOWN:
//                    System.out.println("DOWN");
//                    break;
//                case MOVE_LEFT:
//                    System.out.println("LEFT");
//                    break;
//                case MOVE_RIGHT:
//                    System.out.println("RIGHT");
//                    break;
//                case MOVE_UP:
//                    System.out.println("UP");
//                    break;
//                default:
//                    System.out.println("Invalid syntax in solution!");
//            }
//        }
//    }
//    */
//}

import java.util.ArrayList;

// Part C2: Aidan, Patrick
public class MazeSolver {
    private static final boolean DEBUG = false;

    public static final int MOVE_UP = 0;
    public static final int MOVE_RIGHT = 1;
    public static final int MOVE_DOWN = 2;
    public static final int MOVE_LEFT = 3;

    /*Returns an int array with each consecutive move
    IMPORTANT: MazeGenerator.generateMaze(w, h) must be called before this!*/
    public static int[] solveMaze() {
        int[] solution = null;
        int[][] steps = new int[MazeGenerator.getWidth()][MazeGenerator.getHeight()];
        steps[MazeGenerator.getStartX()][MazeGenerator.getStartY()] = -1;
        int step = 1;
        ArrayList<Cell> toCheck = new ArrayList<Cell>();
        toCheck.add(MazeGenerator.getCell(MazeGenerator.getStartX(), MazeGenerator.getStartY()));

        if(DEBUG) {
            System.out.println("Trying to find: ");
            System.out.println(MazeGenerator.getEndX() + " " + MazeGenerator.getEndY());
            System.out.println();
        }

        boolean searching = true;
        while(searching) {
            ArrayList<Cell> checkBuffer = new ArrayList<Cell>();

            if(DEBUG) {
                if(toCheck.size() == 0) {
                    System.out.println("No paths left, maze is unsolvable!");
                    break;
                }

                System.out.printf("New Cycle To Check: %d cells to check\n", toCheck.size());
            }

            for(Cell c : toCheck) {

                if(DEBUG) {
                    System.out.println("Checking: " + "(" + c.x + ", " + c.y + ") ");
                    System.out.println();
                }

                if(c.x == MazeGenerator.getEndX() && c.y == MazeGenerator.getEndY()) {
                    if(DEBUG)
                        System.out.println("Made it!");
                    searching = false;
                    break;
                }

                boolean[] options = getViableMoves(steps, c.x, c.y, false);
                if(options[MOVE_UP]) {
                    if(DEBUG)
                        System.out.println("\tUP Viable");
                    steps[c.x][c.y-1] = step;
                    checkBuffer.add(MazeGenerator.getCell(c.x, c.y-1));
                }
                if(options[MOVE_RIGHT]) {
                    if(DEBUG)
                        System.out.println("\tRIGHT Viable");
                    steps[c.x+1][c.y] = step;
                    checkBuffer.add(MazeGenerator.getCell(c.x+1, c.y));
                }
                if(options[MOVE_DOWN]) {
                    if(DEBUG)
                        System.out.println("\tDOWN Viable");
                    steps[c.x][c.y+1] = step;
                    checkBuffer.add(MazeGenerator.getCell(c.x, c.y+1));
                }
                if(options[MOVE_LEFT]) {
                    if(DEBUG)
                        System.out.println("\tLEFT Viable");
                    steps[c.x-1][c.y] = step;
                    checkBuffer.add(MazeGenerator.getCell(c.x-1, c.y));
                }

                if(DEBUG) {
                    for(int i = 0; i < steps.length; i++) {
                        for(int j = 0; j < steps[i].length; j++) {
                            if(j == c.x && i == c.y)
                                System.out.printf(" %2c ", 'x');
                            else if(j == MazeGenerator.getEndX() && i == MazeGenerator.getEndY())
                                System.out.printf(" %2c ", '!');
                            else
                                System.out.printf(" %2d ", steps[j][i]);
                        }
                        System.out.println("");
                    }
                }
            }
            step++;
            toCheck = checkBuffer;
        }

        if(DEBUG) {
            System.out.println("Final Map:");
            for(int i = 0; i < steps.length; i++) {
                for(int j = 0; j < steps[i].length; j++) {
                    System.out.printf(" %2d ", steps[j][i]);
                }
                System.out.println("");
            }
        }

        solution = getRoute(steps);
        return solution;
    }

    //Takes an array with a completed path of steps from start to end, returns a set of directions
    private static int[] getRoute(int[][] steps) {

        int currX = MazeGenerator.getEndX();
        int currY = MazeGenerator.getEndY();

        int step = steps[currX][currY];
        boolean[] viable = getViableMoves(steps, currX, currY, true);

        int[] route = new int[step];


        for(int index = step-1; index >= 0; index--) {
            int prevStep = (step != 1) ? step - 1 : -1;

            int top = (currY > 0) ? steps[currX][currY-1] : 0;
            int right = (currX < steps.length - 1) ? steps[currX+1][currY] : 0;
            int bottom = (currY < steps[0].length - 1) ? steps[currX][currY+1] : 0;
            int left = (currX > 0) ? steps[currX-1][currY] : 0;

            if(top == prevStep && viable[MOVE_UP]) {
                route[index] = MOVE_DOWN;
                currY = currY-1;
            }
            else if(right == prevStep && viable[MOVE_RIGHT]) {
                route[index] = MOVE_LEFT;
                currX = currX + 1;
            }
            else if(bottom == prevStep  && viable[MOVE_DOWN]) {
                route[index] = MOVE_UP;
                currY = currY + 1;
            }
            else if(left == prevStep && viable[MOVE_LEFT]) {
                route[index] = MOVE_RIGHT;
                currX = currX - 1;
            }
            else {
                System.out.println("Error backtracking solution");
                return null;
            }

            step = steps[currX][currY];
            viable = getViableMoves(steps, currX, currY, true);
        }

        return route;
    }

    //Takes the array of steps previously taken and a position, returns steps available from that position
    private static boolean[] getViableMoves(int[][] steps, int x, int y, boolean backTracking) {
        boolean[] moves = new boolean[4];

        Cell top = (y > 0 && (backTracking || steps[x][y-1] == 0)) ? MazeGenerator.getCell(x, y-1) : null;
        Cell right = (x < steps.length - 1 && (backTracking || steps[x+1][y] == 0)) ? MazeGenerator.getCell(x+1, y) : null;
        Cell bottom = (y < steps[0].length - 1 && (backTracking || steps[x][y+1] == 0)) ? MazeGenerator.getCell(x, y+1) : null;
        Cell left = (x > 0 && (backTracking || steps[x-1][y] == 0)) ? MazeGenerator.getCell(x-1, y) : null;

        if(top != null && top.downWall == 0)
            moves[MOVE_UP] = true;
        if(right != null && right.leftWall == 0)
            moves[MOVE_RIGHT] = true;
        if(bottom != null && bottom.upWall == 0)
            moves[MOVE_DOWN] = true;
        if(left != null && left.rightWall == 0)
            moves[MOVE_LEFT] = true;

        return moves;
    }


    /*  An example of how to use this solver, and how to interpret the solution array
    public static void main(String[] args) {
        MazeGenerator.generateMaze(50, 50);
        int[] solution = solveMaze();
        for(int i = 0; i < solution.length; i++) {
            switch (solution[i]) {
                case MOVE_DOWN:
                    System.out.println("DOWN");
                    break;
                case MOVE_LEFT:
                    System.out.println("LEFT");
                    break;
                case MOVE_RIGHT:
                    System.out.println("RIGHT");
                    break;
                case MOVE_UP:
                    System.out.println("UP");
                    break;
                default:
                    System.out.println("Invalid syntax in solution!");
            }
        }
    }
    */
}