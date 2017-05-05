public class Driver {

    public static void main(String[] args)
    {
        MyHeap h = new MyHeap(true);
        h.add("1");
        p(h);
        h.add("2");
        p(h);
        h.add("3");
        p(h);
        h.add("9");
        p(h);
        h.add("3");
        p(h);
    }

    public static void p(MyHeap h) {
        System.out.println(h);
    }

}
