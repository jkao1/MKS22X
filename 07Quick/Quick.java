public class Quick {

    public static void quickselect(int[] ary, int k)
    {
        int left = 0, right = ary.length - 1;
        int wall = part( ary, left, right );
        while (wall != k) {
            if ( wall > k ) {
                wall = part( ary, wall+1, right );
            } else {
                wall = part( ary, left, wall-1 );
            }
        }

    }

    public static int part(int[] ary, int left, int right)
    {
        print(ary);
        int randomIndex = left + (int) ( Math.random() * ( right - left + 1 ));
        System.out.println("random index: " + randomIndex);
        int pivot = ary[ randomIndex ];
        swap( randomIndex, left, ary );
        int wall = left + 1;
        for (int i = left + 1; i <= right; i++) {
            coolPrint(ary,wall);
            if ( ary[i] < pivot ) {
                swap( wall, i, ary );
                wall++;
            }
        }
        swap( wall-1, left , ary );
        print(ary);
        System.out.println(wall-1);
        return wall-1;
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
