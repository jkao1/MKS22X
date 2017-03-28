public class MyLinkedList {

    private LNode start, end;
    private int size;

    public MyLinkedList() {
	start = null;
	end = null;
	size = 0;
    }

    public boolean add(int value)
    {
	try {
	    if (end == null) {
		end = new LNode(value);
		start = end;
	    } else {
		end.next = new LNode(value);
		end = end.next;
		size++;
	    }
	    return true;
	} catch (Exception e) {
	    return false;
	}
    }

    public int get(int index)
    {
	if (index < 0 || index >= size()) {
	    throw new IndexOutOfBoundsException();
	}
	LNode current = start;
	int countdown = index;
	while (countdown > 0) {
	    current = current.next;
	    countdown--;
	}
	return current.value;
    }

    public int size()
    {
	String output = 0;
	LNode current = start;
	while (current != null) {
	    output++;
	    current = current.next;
	}
	return output;
    }	    

    public String toString()
    {
	String output = "[ ";
	LNode current = start;
	while (current != null) {
	    output += current.value + " ";
	    current = current.next;
	}
	return output + "]";
    }

    private class LNode {
	
	private LNode next;
	private int value;

	public LNode(int value) {
	    this.value = value;
	    next = null;
	}

	public LNode(int value, LNode next) {
	    this.value = value;
	    this.next = next;
	}
    }
}
