import java.util.*;

public class FrontierQueue implements Frontier {

    private ArrayDeque<Location> q;

    public FrontierQueue() {
        q = new ArrayDeque<Location>();
    }

    public void add(Location l) {
        q.add(l);
    }

    public Location next() {
        return q.remove();
    }

    public int size() {
        return q.size();
    }

    public String toString() {
        return q.toString();
    }
}

// suggest use heap for priority queue
// why stack & queue frontiers?
