public class MyLinkedList {

    private LNode head, tail;
    private int size;

    public MyLinkedList() {
	head = null;
	tail = null;
	size = 0;
    }

    public boolean add(int value)
    {	
	add( size(), value );
	return true;
    }

    private LNode getNthNode(int index)
    {
	if (index < 0 || index >= size()) {
	    throw new IndexOutOfBoundsException();
	}
	LNode current = head;
	int upTo = 0;
	while (upTo < index) {	    
	    current = current.next;
	    upTo++;
	}
	return current;
    }

    public boolean add(int index, int value)
    {
        LNode tBA = new 
    }
	    
    public void addAfter(LNode location, LNode tBA)
    {
	tBA.next = location.next;
	tBA.prev = location;
	location.next = tBA;
	tBA.next.prev = tBA;
    }

    public int get(int index)
    {
        return getNthNode(index).value;
    }

    public int size()
    {
	int output = 0;;
	LNode current = head;
	while (current != null) {
	    output++;
	    current = current.next;
	}
	return output;
    }	    

    public String toString()
    {
	String output = "[";
	LNode current = head;
	while (current != null) {
	    output += current.value + ", ";
	    current = current.next;
	}
	return output.substring(0, output.length() - 2) + "]";
    }

    public String toString(boolean DEBUG)
    {
	LNode current = head;
	String output = "[(null) " + current.value + " (" + current.next.value + "), ";
	current = current.next;
	int tt = 0;
	while (current.next != null) {
	    System.out.println(current.prev.value);
	    System.out.println(output);
	    output += "(" + current.prev.value + ") " + current.value + " (" + current.next.value + "), ";
	    current = current.next;
	    tt++;
	}
	return output + "(" + current.prev.value + "(null)";
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
    }
}
