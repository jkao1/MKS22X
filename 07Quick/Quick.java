public class Quick {

    public static int quickselect(int[] ary, int k)
    {
        return quickselectH(ary, k, 0, ary.length-1,0 );
    }

    public static int quickselectH(int[] ary, int k, int left, int right, int t)
    {return 0;}
    public static void part(int[] ary, int start, int end)
    {
        int randomIndex = start + (int) ( Math.random() * ( end - start + 1 ));
        swap(randomIndex, start, ary);
        int v = ary[start];
        System.out.println(v);
        int i = start + 1, lt = start, gt = end - 1;
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
        print(ary);
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

    public static void main(String[] args) {
        int[] ary = { 0,1,2,3,4,5,6,7,8,9};
        part(ary,0,ary.length);
    }
}
