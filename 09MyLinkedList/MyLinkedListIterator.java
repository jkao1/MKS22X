import java.util.*;

public class MyLinkedListIterator implements Iterator<Integer> {

    private MyLinkedList mll;
    private int current = 0;

    public MyLinkedListIterator(MyLinkedList mll) {
        this.mll = mll;
    }

    public boolean hasNext()
    {
        return current < mll.size();
    }

    public Integer next()
    {
        if (hasNext()) {
            current++;
            return mll.get(current - 1);
        } else {
            throw new NoSuchElementException();
        }
    }

    public void remove()
    {
        throw new UnsupportedOperationException();
    }

}
