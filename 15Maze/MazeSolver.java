import java.util.*;
import java.io.*;

public class MazeSolver {

    private boolean animate;
    private Maze m;

    public static void main(String[] args)
    {
        MazeSolver ms = new MazeSolver( "A-maze.in" );
        ms.solve();
    }

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
        f = new FrontierPriorityQueue();
        f.add( m.getStart() );

        while ( f.size() > 0 ) {

            Location l = f.next();
            m.set( l.getRow(), l.getCol(), )
            int[] hi = { l.getRow(), l.getCol() };
            if (distToGoal(hi) == 0) {
                System.out.println(l);
                return;
            }
            for ( int[] path : findPaths(l) ) {
                f.add( new Location( path[0], path[1], l, distToStart(path), distToGoal(path), false) );
            }

            

        }
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
        System.out.println(path[0] + ", " + path[1]);
        System.out.println(m.getEnd());
        int output = Math.abs( path[0] - m.getEnd().getRow() ) +
            Math.abs( path[1] - m.getEnd().getCol() );
        System.out.println(output);
        return output;
    }
}
