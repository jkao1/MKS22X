import java.util.*;
import java.io.*;

public class MazeSolver {

    private static int DELAY = 5;

    private boolean animate;
    private Maze m;

    public MazeSolver(String filename)
    {
        this( filename, false );
    }
    public MazeSolver(String filename, boolean animate)
    {
        this.animate = animate;
        m = new Maze( filename );
    }

    public void solve() {
        solve(1);
    }

    public void solve(int style)
    {
        Frontier f = null;
        if (style == 0) {
            f = new FrontierStack();
        }
        if (style == 1) {
            f = new FrontierQueue();
        }
        if (style == 2) {
            f = new FrontierPriorityQueue(); // ?
        }
        if (style == 3) {
            f = new FrontierPriorityQueue(); // ?
        }
        f.add( m.getStart() );

        Location l = null;
        while ( f.size() > 0 ) {

            l = f.next();
            m.set( l.getRow(), l.getCol(), '.');

            int[] hi = { l.getRow(), l.getCol() };
            if (distToGoal(hi) == 0) {
                break;
            }

            for ( int[] path : findPaths(l) ) {
                f.add( new Location( path[0],
                                     path[1],
                                     l, // previous
                                     distToStart(path),
                                     distToGoal(path),
                                     style == 3 // astar
                                     ));
                m.set( path[0], path[1], '?' );
            }
            if (animate) {
                System.out.println(m.toString(DELAY));
            }
        }

        m.set( l.getRow(), l.getCol(), 'E' );
        l = l.previous;

        while ( l.hasPrevious() ) {
            m.set( l.getRow(), l.getCol(), '@' );
            l = l.previous;
        }

        m.set( l.getRow(), l.getCol(), 'S' );
    }

    private ArrayList<int[]> findPaths(Location l)
    {
        ArrayList<int[]> output = new ArrayList<int[]>();
        int[][] possiblePaths = {
            {0, -1},
            {0, 1},
            {1, 0},
            {-1, 0}
        };
        for ( int[] path : possiblePaths ) {
            if ( m.get( l.getRow() + path[0], l.getCol() + path[1] ) == ' ' ) {
                output.add( new int[] {l.getRow() + path[0], l.getCol() + path[1]} );
            }
        }
        return output;
    }

    private int distToStart(int[] path)
    {
        return Math.abs( path[0] - m.getStart().getRow() ) +
            Math.abs( path[1] - m.getStart().getRow() );
    }

    private int distToGoal(int[] path)
    {
        int output = Math.abs( path[0] - m.getEnd().getRow() ) +
            Math.abs( path[1] - m.getEnd().getCol() );
        return output;
    }

    public String toString() {
        return m.toString();
    }

    public String toString(int n) {
        return m.ToString(n);
    }
}
