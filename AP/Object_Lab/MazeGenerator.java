package HighSchool.AP.Object_Lab;

//import java.util.ArrayList;
//import java.util.Random;
//
//// Part C1: Nithin, David
//public class MazeGenerator {
//    private static int width;
//    private static int height;
//
//    private static int startX;
//    private static int startY;
//
//    private static int endX;
//    private static int endY;
//
//    public static final int OPEN = 0;
//    public static final int CLOSED = 1;
//    public static final int END = -1;
//
//    public static final int UP_WALL = 0;
//    public static final int LEFT_WALL = 1;
//    public static final int DOWN_WALL = 2;
//    public static final int RIGHT_WALL = 3;
//
//    private static ArrayList<Cell> FRONTIER_CELLS = new ArrayList<>();
//
//    private static Cell[][] maze;
//
//    public static void generateMaze(int w, int h) {
//        width = w;
//        height = h;
//        maze = new Cell[width][height];
//
//        Random r = new Random(System.currentTimeMillis());
//
//        for (int i=0; i < width; i++) {
//            for (int j=0; j < height; j++) {
//                Cell cell = new Cell(i, j);
//
//                // Permanently seal outer walls
//                if (i==0) {
//                    cell.leftWall = END;
//                } else if (i==width-1) {
//                    cell.rightWall = END;
//                }
//                if (j==0) {
//                    cell.upWall = END;
//                } else if (j==height-1) {
//                    cell.downWall = END;
//                }
//
//                maze[i][j] = cell;
//            }
//        }
//
//        Cell cellToOpen;
//        int cellsOpened = 0;
//
//        while (cellsOpened < width*height) {
//            // if no cells open yet, choose random x and y to open
//            if (cellsOpened == 0) {
//                //startX = r.nextInt(width);
//                //startY = r.nextInt(height);
//                cellToOpen = maze[startX][startY];
//            }
//            // if cells are open, choose random frontier cell and open a wall that leads to an already opened cell
//            else {
//                cellToOpen = FRONTIER_CELLS.get(r.nextInt(FRONTIER_CELLS.size()));
//            }
//
//            // if wall successfully opened
//            if (cellToOpen.openWall(r, cellsOpened)) {
//                if (FRONTIER_CELLS.size() > 0) FRONTIER_CELLS.remove(cellToOpen);
//                updateFrontier(cellToOpen);
//                cellsOpened++;
//                //endX = cellToOpen.x;
//                //endY = cellToOpen.y;
//            }
//
//            startX = maze[0][0].x;
//            startY = maze[width-1][0].y;
//
//            endX = maze[width-1][height-1].x;
//            endY = maze[width-1][height-1].y;
//
//        }
//    }
//
//    public static void updateFrontier(Cell cell) {
//        try {
//            if (!maze[cell.x+1][cell.y].getVisited() && !FRONTIER_CELLS.contains(maze[cell.x+1][cell.y]))
//                FRONTIER_CELLS.add(maze[cell.x+1][cell.y]);
//        } catch (Exception e) { }
//
//        try {
//            if (!maze[cell.x-1][cell.y].getVisited() && !FRONTIER_CELLS.contains(maze[cell.x-1][cell.y]))
//                FRONTIER_CELLS.add(maze[cell.x-1][cell.y]);
//        } catch (Exception e) { }
//
//        try {
//            if (!maze[cell.x][cell.y-1].getVisited() && !FRONTIER_CELLS.contains(maze[cell.x][cell.y-1]))
//                FRONTIER_CELLS.add(maze[cell.x][cell.y-1]);
//        } catch (Exception e) { }
//
//        try {
//            if (!maze[cell.x][cell.y+1].getVisited() && !FRONTIER_CELLS.contains(maze[cell.x][cell.y+1]))
//                FRONTIER_CELLS.add(maze[cell.x][cell.y+1]);
//        } catch (Exception e) { }
//    }
//
//    public static Cell getCell(int x, int y) {
//        return maze[x][y];
//    }
//
//    public static Cell[][] getMaze() {
//        return maze;
//    }
//
//    public static int getWidth() {
//        return width;
//    }
//    public static int getHeight() {
//        return height;
//    }
//
//    public static int getStartX() {
//        return startX;
//    }
//    public static int getStartY() {
//        return startY;
//    }
//    public static int getEndX() {
//        return endX;
//    }
//    public static int getEndY() {
//        return endY;
//    }
//
//    // DEBUGGER
//    /*
//    public static void main(String[] args) {
//        MazeGenerator.generateMaze(10,15);
//        for (int i = 0; i<height; i++) {
//            for (int j = 0; j<width; j++) {
//                String temp = MazeGenerator.getCell(j, i).rightWall + " (" + MazeGenerator.getCell(j, i).x + ", " + MazeGenerator.getCell(j, i).y + ") " + MazeGenerator.getCell(j, i).leftWall;
//                System.out.printf("%12s", temp);
//            }
//            System.out.println();
//        }
//    }
//     */
//}
//
//class Cell {
//    public int x;
//    public int y;
//
//    public static final int OPEN = 0;
//    public static final int CLOSED = 1;
//    public static final int END = -1;
//
//    public static final int UP_WALL = 0;
//    public static final int LEFT_WALL = 1;
//    public static final int DOWN_WALL = 2;
//    public static final int RIGHT_WALL = 3;
//
//    public int upWall;
//    public int leftWall;
//    public int downWall;
//    public int rightWall;
//
//    private boolean visited;
//
//    public Cell(int x, int y) {
//        this.x = x;
//        this.y= y;
//        leftWall = CLOSED;
//        rightWall = CLOSED;
//        upWall = CLOSED;
//        downWall = CLOSED;
//        visited = false;
//    }
//
//    public boolean openWall(Random r, int cellsOpened) {
//        int openWall = r.nextInt(4);
//        switch (openWall) {
//            case UP_WALL:
//                if (upWall == END || (cellsOpened>0 && y>0 && !MazeGenerator.getCell(x, y-1).getVisited()) )
//                    return false;
//                setUpWall(OPEN);
//                break;
//
//            case LEFT_WALL:
//                if (leftWall == END || (cellsOpened>0 && x>0 && !MazeGenerator.getCell(x-1, y).getVisited()) )
//                    return false;
//                setLeftWall(OPEN);
//                break;
//
//            case DOWN_WALL:
//                if (downWall == END || (cellsOpened>0 && y<MazeGenerator.getHeight()-1 && !MazeGenerator.getCell(x, y+1).getVisited() ) )
//                    return false;
//                setDownWall(OPEN);
//                break;
//
//            case RIGHT_WALL:
//                if (rightWall == END || (cellsOpened>0 && x<MazeGenerator.getWidth()-1 && !MazeGenerator.getCell(x+1, y).getVisited()) )
//                    return false;
//                setRightWall(OPEN);
//                break;
//        }
//
//        setVisitCell();
//        return true;
//    }
//
//    public void setLeftWall(int state) {
//        this.leftWall = state;
//        try {
//            MazeGenerator.getCell(x-1, y).rightWall = state;
//        } catch (Exception e) { }
//    }
//
//    public void setRightWall(int state) {
//        this.rightWall = state;
//        try {
//            MazeGenerator.getCell(x+1, y).leftWall = state;
//        } catch (Exception e) { }
//    }
//
//    public void setUpWall(int state) {
//        this.upWall = state;
//        try {
//            MazeGenerator.getCell(x, y-1).downWall = state;
//        } catch (Exception e) { }
//    }
//
//    public void setDownWall(int state) {
//        this.downWall = state;
//        try {
//            MazeGenerator.getCell(x,  y+1).upWall = state;
//        } catch (Exception e) { }
//    }
//
//    public void setVisitCell() {
//        this.visited = true;
//    }
//
//    public boolean getVisited() {
//        return this.visited;
//    }
//
//    public int getX() {
//        return this.x;
//    }
//    public int getY() {
//        return this.y;
//    }
//}

import java.util.ArrayList;
import java.util.Random;

// Part C1: Nithin, David
public class MazeGenerator {
    private static int width;
    private static int height;

    private static int startX;
    private static int startY;

    private static int endX;
    private static int endY;

    public static final int OPEN = 0;
    public static final int CLOSED = 1;
    public static final int END = -1;

    public static final int UP_WALL = 0;
    public static final int LEFT_WALL = 1;
    public static final int DOWN_WALL = 2;
    public static final int RIGHT_WALL = 3;

    private static ArrayList<Cell> FRONTIER_CELLS = new ArrayList<>();

    private static Cell[][] maze;

    public static void generateMaze(int w, int h) {
        width = w;
        height = h;
        maze = new Cell[width][height];

        Random r = new Random(System.currentTimeMillis());

        for (int i=0; i < width; i++) {
            for (int j=0; j < height; j++) {
                Cell cell = new Cell(i, j);

                // Permanently seal outer walls
                if (i==0) {
                    cell.leftWall = END;
                } else if (i==width-1) {
                    cell.rightWall = END;
                }
                if (j==0) {
                    cell.upWall = END;
                } else if (j==height-1) {
                    cell.downWall = END;
                }

                maze[i][j] = cell;
            }
        }

        Cell cellToOpen;
        int cellsOpened = 0;

        while (cellsOpened < width*height) {
            // if no cells open yet, choose random x and y to open
            if (cellsOpened == 0) {
                //startX = r.nextInt(width);
                //startY = r.nextInt(height);
                cellToOpen = maze[startX][startY];
            }
            // if cells are open, choose random frontier cell and open a wall that leads to an already opened cell
            else {
                cellToOpen = FRONTIER_CELLS.get(r.nextInt(FRONTIER_CELLS.size()));
            }

            // if wall successfully opened
            if (cellToOpen.openWall(r, cellsOpened)) {
                if (FRONTIER_CELLS.size() > 0) FRONTIER_CELLS.remove(cellToOpen);
                updateFrontier(cellToOpen);
                cellsOpened++;
                //endX = cellToOpen.x;
                //endY = cellToOpen.y;
            }



            //startX = maze[0][0].x;
            //startY = maze[width-1][0].y;

            //endX = maze[width-1][height-1].x;
            //endY = maze[width-1][height-1].y;

        }

        boolean setStartEnd = false;

        while (!setStartEnd) {
            int startWall = r.nextInt(4);

            setStartEnd = true;

            switch (startWall) {
                case 0:
                    startX = maze[r.nextInt(width)][0].x;
                    startY = maze[0][0].y;
                    break;
                case 1:
                    startX = maze[0][0].x;
                    startY = maze[r.nextInt(width)][0].y;
                    break;
                case 2:
                    startX = maze[r.nextInt(width)][height-1].x;
                    startY = maze[0][height-1].y;
                    break;
                case 3:
                    startX = maze[width-1][0].x;
                    startY = maze[width-1][r.nextInt(height-1)].y;
                    break;
            }

            int endWall = r.nextInt(4);

            switch (endWall) {
                case 0:
                    endX = maze[r.nextInt(width)][0].x;
                    endY = maze[0][0].y;
                    break;
                case 1:
                    endX = maze[0][0].x;
                    endY = maze[r.nextInt(width)][0].y;
                    break;
                case 2:
                    endX = maze[r.nextInt(width)][height-1].x;
                    endY = maze[0][height-1].y;
                    break;
                case 3:
                    endX = maze[width-1][0].x;
                    endY = maze[width-1][r.nextInt(height-1)].y;
                    break;
            }

            if (!maze[endX][endY].getVisited() || !maze[startX][startY].getVisited() || (endX == startX && endY == startY)) {
                setStartEnd = false;
            }
        }




    }

    public static void updateFrontier(Cell cell) {
        try {
            if (!maze[cell.x+1][cell.y].getVisited() && !FRONTIER_CELLS.contains(maze[cell.x+1][cell.y]))
                FRONTIER_CELLS.add(maze[cell.x+1][cell.y]);
        } catch (Exception e) { }

        try {
            if (!maze[cell.x-1][cell.y].getVisited() && !FRONTIER_CELLS.contains(maze[cell.x-1][cell.y]))
                FRONTIER_CELLS.add(maze[cell.x-1][cell.y]);
        } catch (Exception e) { }

        try {
            if (!maze[cell.x][cell.y-1].getVisited() && !FRONTIER_CELLS.contains(maze[cell.x][cell.y-1]))
                FRONTIER_CELLS.add(maze[cell.x][cell.y-1]);
        } catch (Exception e) { }

        try {
            if (!maze[cell.x][cell.y+1].getVisited() && !FRONTIER_CELLS.contains(maze[cell.x][cell.y+1]))
                FRONTIER_CELLS.add(maze[cell.x][cell.y+1]);
        } catch (Exception e) { }
    }

    public static Cell getCell(int x, int y) {
        return maze[x][y];
    }

    public static Cell[][] getMaze() {
        return maze;
    }

    public static int getWidth() {
        return width;
    }
    public static int getHeight() {
        return height;
    }

    public static int getStartX() {
        return startX;
    }
    public static int getStartY() {
        return startY;
    }
    public static int getEndX() {
        return endX;
    }
    public static int getEndY() {
        return endY;
    }

    // DEBUGGER
    /*
    public static void main(String[] args) {
        MazeGenerator.generateMaze(10,15);
        for (int i = 0; i<height; i++) {
            for (int j = 0; j<width; j++) {
                String temp = MazeGenerator.getCell(j, i).rightWall + " (" + MazeGenerator.getCell(j, i).x + ", " + MazeGenerator.getCell(j, i).y + ") " + MazeGenerator.getCell(j, i).leftWall;
                System.out.printf("%12s", temp);
            }
            System.out.println();
        }
    }
     */
}

class Cell {
    public int x;
    public int y;

    public static final int OPEN = 0;
    public static final int CLOSED = 1;
    public static final int END = -1;

    public static final int UP_WALL = 0;
    public static final int LEFT_WALL = 1;
    public static final int DOWN_WALL = 2;
    public static final int RIGHT_WALL = 3;

    public int upWall;
    public int leftWall;
    public int downWall;
    public int rightWall;

    private boolean visited;

    public Cell(int x, int y) {
        this.x = x;
        this.y= y;
        leftWall = CLOSED;
        rightWall = CLOSED;
        upWall = CLOSED;
        downWall = CLOSED;
        visited = false;
    }

    public boolean openWall(Random r, int cellsOpened) {
        int openWall = r.nextInt(4);
        switch (openWall) {
            case UP_WALL:
                if (upWall == END || (cellsOpened>0 && y>0 && !MazeGenerator.getCell(x, y-1).getVisited()) )
                    return false;
                setUpWall(OPEN);
                break;

            case LEFT_WALL:
                if (leftWall == END || (cellsOpened>0 && x>0 && !MazeGenerator.getCell(x-1, y).getVisited()) )
                    return false;
                setLeftWall(OPEN);
                break;

            case DOWN_WALL:
                if (downWall == END || (cellsOpened>0 && y<MazeGenerator.getHeight()-1 && !MazeGenerator.getCell(x, y+1).getVisited() ) )
                    return false;
                setDownWall(OPEN);
                break;

            case RIGHT_WALL:
                if (rightWall == END || (cellsOpened>0 && x<MazeGenerator.getWidth()-1 && !MazeGenerator.getCell(x+1, y).getVisited()) )
                    return false;
                setRightWall(OPEN);
                break;
        }

        setVisitCell();
        return true;
    }

    public void setLeftWall(int state) {
        this.leftWall = state;
        try {
            MazeGenerator.getCell(x-1, y).rightWall = state;
        } catch (Exception e) { }
    }

    public void setRightWall(int state) {
        this.rightWall = state;
        try {
            MazeGenerator.getCell(x+1, y).leftWall = state;
        } catch (Exception e) { }
    }

    public void setUpWall(int state) {
        this.upWall = state;
        try {
            MazeGenerator.getCell(x, y-1).downWall = state;
        } catch (Exception e) { }
    }

    public void setDownWall(int state) {
        this.downWall = state;
        try {
            MazeGenerator.getCell(x,  y+1).upWall = state;
        } catch (Exception e) { }
    }

    public void setVisitCell() {
        this.visited = true;
    }

    public boolean getVisited() {
        return this.visited;
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
}