public class Quick {

    public static void quickselect(int[] ary, int k)
    {
        quickselectH(ary, k, 0, ary.length );
    }

    public static int quickselectH(int[] ary, int k, int left, int right)
    {
        int randomIndex = left + (int) ( Math.random() * ( right - left + 1 ));
        swap(randomIndex, left, ary);
        int v = ary[left];

        int i = left + 1, lt = left, gt = right - 1;

        while (i <= gt) {
            if (ary[i] < v) {
                swap(i, lt, ary);
                i++;
                lt++;
            } else if (ary[i] > v) {
                swap(i, gt, ary);
                gt--;
            } else {
                i++;
            }
        }
    }

    private static void swap(int x, int y, int[] ary) {
        int temp = ary[x];
        ary[x] = ary[y];
        ary[y] = temp;
    }

    private static void print(int[] ary) {
        String o = "";
        for (int i : ary) {
            o += i + " ";
        }
        System.out.println(o);
    }

    private static void coolPrint(int[] ary, int wall) {
        String o = "";
        for (int i = 0; i < ary.length; i++) {
            if (i == wall)
                o += "| " + ary[i] + " ";
            else
                o += ary[i] + " ";
        }
        System.out.println(o);
    }

    public static void main(String[] args) {
        int[] ary = { 5, 15, 12, 18 ,5, 0, 13, 3, 20 ,19 };
        part(ary,0,ary.length-1);
        /*
        System.out.println("random array testing-----");
        for (int i = 0; i < 2; i++) {
            System.out.println("array #" + i);
            int[] ary = new int[10];
            for (int j = 0; j < 10; j++) {
                int randomNum = (int) ( Math.random() * 20 );
                ary[j] = randomNum;
            }
            part( ary, 0, ary.length-1);
            }*/
    }
}
