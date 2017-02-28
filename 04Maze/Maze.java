import java.util.*;
import java.io.*;

public class Maze {

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
                int rows = 0, cols = 0;
                while ( in.hasNextLine() ) {
                    if (rows == 0)
                        cols = in.nextLine().length();
                    else
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
            } catch (Exception e) {
            System.out.println("There was an exception in Maze(String filename).");
        }
        animate = false;
    }

    private void checkStartAndEnd() throws Exception {
        String check = toString();
        if (check.indexOf('S') == -1)
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
        int startR = -1, startC = -1;

        //Initialize starting row and startint col with the location of the S.

        maze[ startR ][ startC ] = ' ';//erase the S, and start solving!
        return solve(startr,startc);
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
        if(animate){
            System.out.println("\033[2J\033[1;1H"+this);
            try {
                wait(20);
            } catch (Exception e) {}
        }

        //COMPLETE SOLVE

        return false; //so it compiles
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
