public class Driver {

    public static void main(String[] args)
    {
	MyLinkedList ml = new MyLinkedList();
	ml.add(5);
	ml.add(8);
	ml.add(99);
	System.out.println(ml);
	ml.remove(0);
	System.out.println(ml);
	ml.add(123);
	System.out.println(ml);
	ml.set(0,123);
	System.out.println(ml);
	
    }

}
