public class Quick {

    public static int quickselect(int[] ary, int k)
    {
        int start = 0, end = ary.length - 1, pivot = 0;
        while (k != pivot) {
            pivot = part(ary, start, end);
            if (k < pivot) {
                end = pivot - 1;
            } else if (k > pivot) {
                start = pivot + 1;
            }
        }
        return ary[k];
    }

    public static int part(int[] ary, int start, int end)
    {
        int randomIndex = start + (int) ( Math.random() * ( end - start + 1 ));
        swap(randomIndex, start, ary);
        int v = ary[start];
        int i = start, lt = start, gt = end;
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
        return lt;
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

    private static void print(int[] ary, int s, int e) {
        String o = "";
        for (int i = 0; i < ary.length; i++) {
            if (i == s) {
                o += "| " + ary[i] + " ";
            } else if (i == e) {
                o += ary[i] + " | ";
            } else {
                o += ary[i] + " ";
            }
        }
        System.out.println(o);
    }

    public static void main(String[] args) {
        int[] ary = { 0,1,2,3,4,5,6,7,8,9};
        int[] d = {999,999,999,5,7,3,8,4,9,1,2,0,999,999,999};
        System.out.println(quickselect(d, Integer.parseInt(args[0])));
    }
}
