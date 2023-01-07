// MADE BY MARCUS SANANTONIO AND TYLER UHL

package HighSchool.AP.Game_of_Life;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Life {
  public static final int MAX_ROWS = 40;
  public static final int MAX_COLUMNS = 60;
  private boolean[][] grid;     // MAX_ROWS by MAX_COLUMNS
  private int generation = 0;   // "generation" counts the number of times passTime() has been called
    
  /** Default constructor that creates an empty grid. */
  public Life () {
    grid = new boolean[MAX_ROWS][MAX_COLUMNS];
    // TODO DONE I THINK
  }
  
  /** This constructor loads the starting configuration of the grid from "filename".  
    * A "*" in the file indicates a "true" location in 
    * the grid.  Any other character indicates a "false" location.
    * The file should load so that it is centered horizontally 
    * and vertically in the grid. 
    *
    * This method should not throw an exception.  If the file is not found, 
    * the method should print something like: File, xxxxxx, not found.
    */
  public Life (String fileName) {
    System.out.println(fileName);
    String s = "";
    int longestLine = 0;
    int numOfLines = 0;
    try {
      Scanner reader = new Scanner(new File(fileName));
      while (reader.hasNext()){                     // http://home.wlu.edu/~lambertk/hsjava/whatsnew/input.html
        String newLine = reader.nextLine();
        if(longestLine < newLine.length()) {
          longestLine = newLine.length();
        }
        s += "\n" + newLine;
        numOfLines++;
      }
    }
    catch (FileNotFoundException e) {
      System.out.println("File, " + fileName + ", not found.");
    }
    grid = new boolean[MAX_ROWS][MAX_COLUMNS];
    int startRow = MAX_ROWS/2 - (numOfLines/2);
    int startColumn = MAX_COLUMNS/2 - (longestLine / 2);
    int currentRow = startRow;
    int currentColumn = startColumn;

    System.out.println("|\n" + s + "\n|");

    for (int i = 0; i < s.length(); i++) {
      if(s.charAt(i) == '*') {
        grid[currentRow][currentColumn] = true;
      }
      else if(s.charAt(i) == '\n') {
        currentRow++;
        currentColumn = startColumn-1;
      }
      currentColumn++;
    }

    for (int i = 0; i < grid.length; i++) {
      System.out.println(Arrays.toString(grid[i]));
    }

    // TODO
  }

  private int numOfSurroundingCells (int row, int column) {
    int count = 0;
    int[][] changers = {{-1, -1, -1, 0, 1, 1, 1, 0}, {1, 0, -1, -1, -1, 0, 1, 1}};
    for (int i = 0; i < 8; i++) {
      if (grid[(row + MAX_ROWS + changers[0][i]) % MAX_ROWS][(column + MAX_COLUMNS + changers[1][i]) % MAX_COLUMNS]) {
        count++;
      }
    }

    return count;
  }


  /** Pass time by 1 generation:
    * 
    * For a given cell, determine the number of neighbors that are alive. (All 8 cells 
    * touching the given cell are its neighbors.) Note that the grid wraps around the edge 
    * of the screen, so cells on the edges of the grid have neighbors on the far side of 
    * the grid.
    * 
    * For a given cell that is currently alive(true) and has exactly 2 or 3 neighbors that 
    * are alive, the cell will live in the next generation.  Otherwise, it will die. 
    * 
    * For a given cell that is currently dead(false) if it has exactly 3 neighbors that are 
    * alive, it will come alive in the next generation.  Otherwise, it remains dead.
    * 
    * It is important to note that all changes from time = t to time = t + 1 are 
    * considered to occur simultaneously, so that, for instance, if a cell is going 
    * to die at the next time step, it still counts as "alive" when computing 
    * any of its neighbors’ state changes.
    */
  public void passTime() {
    boolean[][] newGrid = new boolean[MAX_ROWS][MAX_COLUMNS];
    for (int i = 0; i < MAX_ROWS; i++) {
      for (int j = 0; j < MAX_COLUMNS; j++) {
        if(grid[i][j]) {
          if(numOfSurroundingCells(i, j) == 0 || numOfSurroundingCells(i, j) == 1 || numOfSurroundingCells(i, j) >= 4) {
            newGrid[i][j] = false;
          }
          else {
            newGrid[i][j] = true;
          }
        }
        else {
          if (numOfSurroundingCells(i, j) == 3) {
            newGrid[i][j] = true;
          }
        }
      }
    }

    grid = newGrid.clone();

    generation++;
    // TODO
  }

  /** Accessor method for locations on the grid.  LifeController uses this method to 
    * determine if a current cell is alive or dead. */
  public boolean isAlive (int row, int column) {
    return grid[row][column];
    // TODO
    //return false;
  }

  /** Accessor method -- returns the number of times passTime has been called. */
  public int getGeneration() {
    // TODO
    return generation;
  }
  
  /** Resets the generation count to 0. */
  public void resetGeneration() {
    generation = 0;
    // TODO
  }
  
  /** Inverts the value of the grid at the given location. */
  public void toggleGridValue(int row, int column) {
    grid[row][column] = !grid[row][column];
    // TODO
  }
}
