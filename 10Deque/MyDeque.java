public class MyDeque {

    private int[] ary;
    private int size;
    private int front, back;

    public MyDeque()
    {
        ary = new int[10];
        size = 0;
        front = 0;
        back = 0;
    }

    public void addFirst(int value)
    {
	if (size == ary.length) {
	    //resize();
	}
	System.out.println(size);
	System.out.println(-1 % ary.length);
	if (size != 0) {
	    front = (front - 1) % ary.length;
	}
	System.out.println(front);
	ary[front] = value;
	size++;
    }

    public void addLast(int value)
    {
	if (size == ary.length) {
	    //resize();
	}
	if (size != 0) {
	    back = (back + 1) % ary.length;
	}
	ary[back] = value;
	size++;
    }    

    public String toString()
    {
	String output = "[";
	for (int i = front; i % ary.length < back; i++) {
	    output += ary[i] + ", ";
	}
	return output.substring(0, output.length() - 2) + "]";
    }

    public static void main(String[] args) {
	MyDeque d = new MyDeque();
	d.addLast(4);d.addLast(4);
	d.addFirst(0);
	System.out.println(d);
    }

}
