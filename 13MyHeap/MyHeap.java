import java.util.*;

public class MyHeap {

    private static int HEAP_ORDER; // 1 if MaxHeap, -1 if MinHeap

    private String[] ary;
    private int size;

    public MyHeap()
    {
	ary = new String[10];
	size = 0;
    }

    public MyHeap(boolean HEAP_ORDER)
    {
	this();
	if (HEAP_ORDER) {
	    this.HEAP_ORDER = 1;
	} else {
	    this.HEAP_ORDER = -1;
	}
    }

    public void add(String s)
    {	
	size++;
	ary[size] = s;
	pushUp();
    }

    private void pushUp()
    {
	int i = size;
	if (size == 1) {
	    return;
	}
	while (ary[i].compareTo(ary[ i / 2]) * HEAP_ORDER > 0) {
	    swap(i, i / 2);
	}
    }

    public String remove()
    {
	String output = ary[1];
	ary[1] = ary[size];
	size--;
	pushDown();
	return output;
    }

    private void pushDown()
    {
	int i = 1;
	// if should be pushed down
	boolean left = ary[i].compareTo(ary[i * 2]) * HEAP_ORDER < 0;
	boolean right = ary[i].compareTo(ary[i * 2 + 1]) * HEAP_ORDER < 0;
	while (left || right) {
	    if (left) {
		swap(i, i * 2);
	    } else if (right) {
		swap(i, i * 2 + 1);
	    }
	    left = ary[i].compareTo(ary[i * 2]) * HEAP_ORDER < 0;
	    right =  ary[i].compareTo(ary[i * 2 + 1]) * HEAP_ORDER < 0;
	}
    }

    private void swap(int a, int b) 
    {
	String temp = ary[a];
	ary[a] = ary[b];
	ary[b] = temp;
    }

    public String toString()
    {
	return Arrays.toString(ary);
    }

}
	
