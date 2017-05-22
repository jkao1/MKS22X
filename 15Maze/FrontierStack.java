import java.util.Stack;

public class FrontierStack implements Frontier {

    private Stack<Location> s;

    public FrontierStack() {
        s = new Stack<Location>();
    }

    public void add(Location l) {
        s.add(l);
    }

    public Location next() {
        return s.pop();
    }

    public int size() {
        return s.size();
    }

    public String toString() {
        return s.toString();
    }
}
