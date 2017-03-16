public class Quick {

    public static int quickselect(int[] ary, int k) {
	int wall = part( ary, 0, ary.length-1 );
	while (wall != k) {
	    if (wall > k) {
		wall = part( ary, wall, end );
	    } else {
		wall = part( ary, start, wall );
	    }
	}
	return ary[k];
    }

    public static int part(int[] ary, int start, int end)
    {
        int randomIndex = (int) ( Math.random() * (end - start) + start);
        int pivot = ary[ randomIndex ];
        swap( randomIndex, end, ary );

        int wall = start;
        for (int i = start; i < end - 1; i++) // end - 1 makes room for the pivot
            {
                if ( ary[i] < ary[end-1] ) {
                    swap( wall, i, ary );
                    wall++;
                }
            }
        swap( wall, end, ary );
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
	int[] ary = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	for (int i = 0; i < 10; i++){
	    quickselect(ary,i);
	}
    }
}
