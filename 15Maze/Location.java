public class Location implements Comparable<Location> {

    private int row, col;
    private int distToGoal, distToStart;
    private boolean aStar; // if (astar), distToStart + distToGoal. else, distToGoal only
    private Location previous; // used to trace the solution

    public Location(int r, int c, Location previous, int distToStart, int distToGoal, boolean aStar)
    {
        row = r;
        col = c;
        this.previous = previous;
        this.distToStart = distToStart;
        this.distToGoal = distToGoal;
        this.aStar = aStar;
    }

    public int getDistToGoal() {
        return distToGoal;
    }

    public int getDistToStart() {
        return distToStart;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public String toString()
    {
        return "(" + row + ", " + col + ")";
    }

    public int compareTo(Location o)
    {
        int me = getDistToGoal();
        int you = o.getDistToGoal();
        if (aStar) {
            me += getDistToStart();
            you += o.getDistToStart();
        }
        return me - you;
    }
}
