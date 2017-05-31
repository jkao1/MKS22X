public class Merge {

    public static void mergesort(int[] ary)
    {
        int[] left = new int[ary.length / 2];
        int[] right = new int[ary.length - left.length];
        for (int i = 0; i < ary.length; i++) {
            if (i < left.length) {
                left[i] = ary[i];
            } else {
                right[i - left.length] = ary[i];
            }
        }
        if (ary.length > 1) {
            mergesort(left);
            mergesort(right);
            merge(left, right, ary);
        }
    }

    private static void merge(int[] aryA, int[] aryB, int[] destination)
    {
        int a = 0, b = 0;
        while (a < aryA.length && b < aryB.length) {
            if (aryA[a] < aryB[b]) {
                destination[a + b] = aryA[a];
                a++;
            } else {
                destination[a + b] = aryB[b];
                b++;
            }
        }

        for (int i = a; i < aryA.length; i++) {
            destination[i + b] = aryA[i];
        }

        for (int i = b; i < aryB.length; i++) {
            destination[i + a] = aryB[i];
        }
    }

    public static void print(int[] ary) {
        String o = "[ ";
        for (int i : ary) {
            o += i + ", ";
        }
        System.out.println(o.substring(0, o.length() - 2) + " ]");
    }

    public static void main(String[] args) {
        int[] a = { 3,123,34,23,234,2341,123,12,3 };
        int[] b = { 0, 2, 4, 6, 8 };
        int[] destination = new int[a.length + b.length];
        mergesort(a);
        print(a);
    }
}
