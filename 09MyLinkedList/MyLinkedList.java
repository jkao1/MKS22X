import java.util.*;

public class MyLinkedList implements Iterable<Integer>{

    private LNode head, tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean add(int value)
    {
        addAfter(tail, new LNode(value));
        return true;
    }

    private void addAfter(LNode location, LNode toBeAdded)
    {
        if (size == 0) {
            head = toBeAdded;
            tail = toBeAdded;
        } else if (location.next == null) {
            toBeAdded.prev = location;
            location.next = toBeAdded;
            tail = location.next;
        } else {
            toBeAdded.prev = location;
            toBeAdded.next = location.next;
            location.next = toBeAdded;
            toBeAdded.next.prev = toBeAdded;
        }
        size++;
    }

    public void add(int index, int value)
    {
        if (index == size) {
            add(value);
        } else {
            addBefore(getNthNode(index), new LNode(value));
        }
    }

    public void addBefore(LNode location, LNode toBeAdded)
    {
        if (size == 0) {
            head = toBeAdded;
            tail = toBeAdded;
        } else if (location.prev == null) {
            toBeAdded.next = location;
            location.prev = toBeAdded;
            head = location.prev;
        } else {
            toBeAdded.next = location;
            toBeAdded.prev = location.prev;
            location.prev = toBeAdded;
            toBeAdded.prev.next = toBeAdded;
        }
        size++;
    }

    public int remove(int index)
    {
        LNode target = getNthNode(index);
        remove(target);
        return target.value;
    }

    private void remove(LNode target)
    {
        if (target.prev == null && target.next == null) {
            head = null;
            tail = null;
        } else if (target.prev == null) {
            target.next.prev = null;
            head = target.next;
        } else if (target.next == null) {
            target.prev.next = null;
            tail = target.prev;
        } else {
            target.prev.next = target.next;
            target.next.prev = target.prev;
        }
        size--;
    }

    public int get(int index)
    {
        return getNthNode(index).value;
    }

    public int set(int index, int value)
    {
        LNode target = getNthNode(index);
        int output = target.value;
        target.value = value;
        return output;
    }

    public int indexOf(int value)
    {
        LNode currentNode = head;
        int index = 0;
        while (index < size) {
            if (currentNode.value == value) {
                return index;
            } else {
                currentNode = currentNode.next;
                index++;
            }
        }
        return -1;
    }

    private LNode getNthNode(int index)
    {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        LNode currentNode;
        int upTo;
        if (index > size / 2) {
            currentNode = tail;
            upTo = size - 1;
            while (upTo > index) {
                currentNode = currentNode.prev;
                upTo--;
            }
        } else {
            currentNode = head;
            upTo = 0;
            while (upTo < index) {
                currentNode = currentNode.next;
                upTo++;
            }
        }
        return currentNode;
    }

    public int size()
    {
        return size;
    }

    public String toString()
    {
        String output = "[";
        LNode current = head;
        while (current != null) {
            if (current != head) {
                output += ", ";
            }
            output += current.value;
            current = current.next;
        }
        return output + "]";
    }

    public String toString(boolean DEBUG)
    {
        String output = "[";
        LNode current = head;
        while (current != null) {
            if (current != head) {
                output += ", ";
            }
            output += current.toString(true);
            current = current.next;
        }
        return output + "]";
    }

    public Iterator<Integer> iterator()
    {
        return new MyLinkedListIterator(this);
    }

    private class LNode {

        private LNode prev, next;
        private int value;

        public LNode(int value) {
            this.value = value;
            prev = null;
            next = null;
        }

        public LNode(int value, LNode prev, LNode next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        public String toString() {
            return "" + value;
        }

        public String toString(boolean DEBUG) {
            return "(" + prev + ")" + value + "(" + next + ")";
        }
    }

    private class MyLinkedListIterator implements Iterator<Integer> {

        private MyLinkedList mll;
        private LNode currentNode;

        public MyLinkedListIterator(MyLinkedList mll) {
            this.mll = mll;
            currentNode = head;
        }

        public boolean hasNext()
        {
            return currentNode != null;
        }

        public Integer next()
        {
            if (hasNext()) {
                int output = currentNode.value;
                currentNode = currentNode.next;
                return output;
            } else {
                throw new NoSuchElementException();
            }
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

    }
}
