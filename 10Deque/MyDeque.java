import java.util.*;

public class MyDeque {

    private String[] ary;
    private int size;
    private int front, back;

    public MyDeque()
    {
        ary = new String[10];
        size = 0;
        front = 0;
        back = 0;
    }

    public void addFirst(String value)
    {
	if (value == null) {
	    throw new NullPointerException();
	}
	if (size == ary.length) {
	    resize();
	}
	if (size != 0) {
	    if (front == 0) {
		front = ary.length - 1;
	    } else {
		front--;
	    }
	}
	ary[front] = value;
	size++;
    }

    public void addLast(String value)
    {
	if (value == null) {
	    throw new NullPointerException();
	}
	if (size == ary.length) {
	    resize();
	}
	if (size != 0) {
	    back = (back + 1) % ary.length;
	}
	ary[back] = value;
	size++;
    }

    public String removeFirst()
    {	
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	String output = ary[front];
	front = (front + 1) % ary.length;
	size--;
	return output;
    }

    public String removeLast()
    {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	String output = ary[back];
	if (back == 0) {
	    back = ary.length - 1;
	} else {
	    back--;
	}
	size--;
	return output;
    }

    public String getFirst()
    {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	return ary[front];
    }

    public String getLast()
    {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	return ary[back];
    }

    private void resize()
    {
	String[] biggerAry = new String[ary.length * 2];
	int i = 0;
	for (int j = front; j < front + size; j++) {
	    biggerAry[j] = ary[i % ary.length];
	    i++;
	}
	ary = biggerAry;
	front = 0;
	back = size - 1;
    }

    public String toString()
    {
	String output = "[";
	for (int i = 0; i < ary.length; i++) {
	    output += ary[i] + ", ";
	}
	output = output.substring(0, output.length() - 2) + "] - [";
        for (int i = front; i < front + size; i++) {
	    output += ary[i % ary.length] + ", ";
	}
	return output.substring(0, output.length() - 2) + "]";
    }

    public static void main(String[] args) {
	MyDeque d = new MyDeque();
        for (int i = 0; i < 11; i++) {
	    d.addLast(String.valueOf((char) ('a' + i)));
System.out.println(d);
	}
	
    }

}
