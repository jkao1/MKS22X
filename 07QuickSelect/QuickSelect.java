public class QuickSelect {

    public static void kthSmallest(int[] ary, int k, int start, int end) {
        int wall = partition( ary, 0, ary.length );
        if (wall - start == k - 1) { // if wall, where the original array was, is = to k
            return ary[wall];
        } else if (wall - start > k - 1) {
            return kthSmallest(ary, k, wall-1, )
        }
    }

    public static int partition(int[] ary, int start, int end)
    {
        printAry( ary );
        int randomIndex = (int) ( Math.random() * ary.length );
        System.out.println(randomIndex);
        int pivot = ary[ randomIndex ];
        swap( randomIndex, end-1, ary );

        int wall = start;
        for (int i = start; i < end - 1; i++) // end - 1 makes room for the pivot
            {
                if ( ary[i] < ary[end-1] ) {
                    swap( wall, i, ary );
                    wall++;
                }
            }
        swap( wall, end-1, ary );
        printAry( ary );
        return wall;
    }

    private static void swap(int x, int y, int[] ary) {
        int temp = ary[x];
        ary[x] = ary[y];
        ary[y] = temp;
    }

    private static void printAry(int[] ary) {
        String o = "";
        for (int i : ary) {
            o += i + " ";
        }
        System.out.println(o);
    }

    public static void main(String[] args) {
        int[] ary = { 4, 6, 3, 9 ,8 ,1, 5, 2, 0, 7 };
        kthSmallest(ary, 2, 0, ary.length);
    }
}
