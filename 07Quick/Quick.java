public class Quick {

    public static int quickselect(int[] ary, int k)
    {
        return quickselectH(ary, k, 0, ary.length-1,0 );
    }

    public static int quickselectH(int[] ary, int k, int left, int right, int t)
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

	if (t > 20) return 0;
	System.out.println(v);
	if (k < lt) {
	    System.out.println("taking the left side." + left + "," +(lt-1));
	    print(ary);
	    return quickselectH(ary, k, left, lt - 1,t+1);
	} else if (k > gt) {
	    System.out.println("taking the right side." + gt+1 + "," +right);
	    print(ary);
	    return quickselectH(ary, k, gt + 1, right, t+1);
	}
	return ary[k];
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
        int[] ary = { 50, 15, 12, 18 ,5, 0, 13, 3, 20 ,19 };
        System.out.println(quickselect(ary,0));
    }
}
