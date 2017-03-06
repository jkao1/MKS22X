import java.util.*;
import java.io.*;

public class Maze {

    private int[][] POSSIBLE = { { 0,1 }, { 0,-1 }, { 1,0 }, { -1,0 } };
    private char[][] maze;
    private boolean animate;

    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.

    */

    public Maze(String filename)
    {
        try
            {
                File file = new File( filename );
                Scanner in = new Scanner( file );
                int rows = 1, cols = in.nextLine().length();
                while ( in.hasNextLine() ) {
                    in.nextLine();
                    rows++;
                }
                maze = new char[ rows ][ cols ];
                in = new Scanner( file );
                int upTo = 0;
                while ( in.hasNextLine() ) {
                    String line = in.nextLine();
                    char[] charArray = line.toCharArray();
                    maze[ upTo ] = charArray;
                    upTo++;
                }
                String checkMe = toString();
                if (checkMe.indexOf('S') == -1 || checkMe.indexOf('E') == -1)
                    throw new IllegalArgumentException("Maze has no start or has no end");
            }
        catch (Exception e) {
            System.out.println("File error.");
            System.exit(0);
        }
        animate = false;
    }

    private void checkStartAndEnd() {
        String check = toString();
        if (check.indexOf('S') == -1 || check.indexOf('E') == -1) {
            System.out.println("uhm no");
        }
    }

    public void setAnimate(boolean b) {
        animate = b;
    }

    public void clearTerminal() {
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }

    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve()
    {
        int[] startLocation = initializeStart();
        maze[ startLocation[0] ][ startLocation[1] ] = ' ';
        return solve( startLocation[0],startLocation[1]);
    }

    private int[] initializeStart()
    {
        for (int r = 0; r < maze.length; r++) {
            for (int c = 0; c < maze[r].length; c++) {
                if (maze[r][c] == 'S') {
                    int[] startLocation = new int[2];
                    startLocation[0] = r;
                    startLocation[1] = c;
                    return startLocation;
                }
            }
        }
        int[] wow = {-1,-1};
        return wow;
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.


      Postcondition:

      The S is replaced with '@' but the 'E' is not.

      All visited spots that were not part of the solution are changed to '.'
      All visited spots that are part of the solution are changed to '@'
    */
    private boolean solve(int row, int col){
        if (animate) {
            System.out.println("\033[2J\033[1;1H"+this);
            wait(20);
        }

        if ( maze[ row ][ col ] == 'E' )
            return true;

        if ( walkable( row,col )) {
            maze[ row ][ col ] = '@';
            // go through all posibilities
            for (int[] move : POSSIBLE) {
                int goRow = row + move[0];
                int goCol = col + move[1];
                if ( walkable( goRow,goCol )) {
                    if ( solve( goRow,goCol )) {
                        return true;
                    }
                }
            }
            maze[ row ][ col ] = '.';
        }
        return false; //so it compiles
    }

    private boolean walkable(int row, int col) {
        return maze[ row ][ col ] == ' ' || maze[ row ][ col ] == 'S' || maze[ row ][ col ] == 'E';
    }

    private void wait(int millis){ //ADDED SORRY!
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {}
    }

    public String toString()
    {
        String o = "";
        for (char[] ary : maze) {
            for (char c : ary)
                o += c;
            o += "\n";
        }
        return o;
    }

}
