public class Driver {

    public static void main(String[] args)
    {
        MyLinkedList ml = new MyLinkedList();
        System.out.println(ml);
        ml.add(3);
        ml.add(4);
        System.out.println(ml.toString(true));
        ml.add(5);
        System.out.println(ml.toString(true));
        ml.add(0,2);
        System.out.println(ml.toString(true));
        ml.add(4,3);
        System.out.println(ml.toString(true));
        for (Integer i : ml) {
            System.out.println(i);
        }
    }
}
