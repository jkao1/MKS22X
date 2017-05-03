public class MyHeap {

    private static int HEAP_ORDER; // 1 if MaxHeap, -1 if MinHeap

    private ArrayList<String> ary;
    private int size;

    public MyHeap()
    {
	ary = new ArrayList<>();
	ary.add(""); // placeholder for math stuff;
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
	ary.add(s);
	size++;
    }

    public 
	
