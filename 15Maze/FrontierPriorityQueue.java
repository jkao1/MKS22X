import java.util.*;

public class FrontierPriorityQueue implements Frontier {

    private MyHeap hp;

    public FrontierPriorityQueue() {
        hp = new MyHeap();
    }

    public void add(Location l) {
        hp.add(l);
    }

    public Location next() {
        return hp.remove();
    }

    public int size() {
        return hp.size();
    }

    public String toString()
    {
        return hp.toString();
    }
}
