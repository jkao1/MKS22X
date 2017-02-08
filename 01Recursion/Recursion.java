public class Recursion {

    public static String name() {
	return "Kao,Jason";
    }
    
    public static double sqrt(double n) {
	if (n < 0) {
	    throw new IllegalArgumentException();
	}
	if (n == 0) {
	    return n;
	}
	return guess(1, n);
    }
   
    private static double guess(double g, double o) {
	if ( Math.abs( (g*g - o)/o) < 0.0000000001 )
	    return g;
        double better_guess = ( o / g + g ) / 2;
	return guess( better_guess, o);	
    }
}
	
