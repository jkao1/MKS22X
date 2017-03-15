public class QuickSelect {

    public static void quickselect(int[] ary, int k) {
        System.out.println(quickselectH( ary, k, 0, ary.length ));
    }

    public static int quickselectH(int[] ary, int k, int start, int end)
    {
	int wall = part( ary, 0, ary.length );
        if ( wall == k ) { // if wall, where the original array was, is = to k
            return ary[wall];
        } else if ( wall > k ) {
            return quickselectH( ary, k, wall-1, end );
        }
	return quickselectH( ary, k, start, wall-1 );

    }

    public static int part(int[] ary, int start, int end)
    {
        int randomIndex = (int) ( Math.random() * ary.length );
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
        int[]ary = { 2, 10, 15, 23, 0,  5};
        for (int i = 0; i < ary.length; i++) {
	    quickselect(ary,i);
	}
    }
}
