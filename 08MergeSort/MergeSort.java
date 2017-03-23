public class MergeSort {


    public static void merge(int[] aryA, int[] aryB, int[] destination)
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
	int[] a = { 1, 3, 5, 7, 9 };
	int[] b = { 0, 2, 4, 6, 8 };
	int[] destination = new int[a.length + b.length];
	merge(a, b, destination);
    }
}
