import java.util.*;

public class Quick {

    public static void quicksort(int[] ary)
    {
        quicksortH(ary, 0, ary.length - 1);
    }

    public static void quicksortH(int[] ary, int start, int end)
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

        // here marks the end of partition and the beginning of recursion

        if (end > start) {
            quicksortH(ary, gt, end);
            quicksortH(ary, start, lt - 1);
        }
    }

    public static int quickselect(int[] ary, int k)
    {
        return quickselectH(ary, k, 0, ary.length-1);
    }

    public static int quickselectH(int[] ary, int k, int start, int end)
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

        // here marks the end of partition and the beginning of recursion

        if (k < lt) {
            return quickselectH(ary, k, start, lt - 1);
        } else if (k > gt) {
            return quickselectH(ary, k, gt + 1, end);
        } else {
            return ary[lt];
        }
    }

    private static void swap(int x, int y, int[] ary) {
        int temp = ary[x];
        ary[x] = ary[y];
        ary[y] = temp;
    }

}
