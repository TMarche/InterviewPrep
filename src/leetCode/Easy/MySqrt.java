package leetCode.Easy;

public class MySqrt {
    public int mySqrt(int x) {
    	long lx = x;
        long square = 0;
        while(square * square <= lx)
            square++;
        return (int)square - 1;
    }
    
    public int mySqrt2(int x) {
    	// Perform binary search
    	if (x <= 1) return x;
    	int min = 1;
    	int max = x;
    	while (true) {
    		int guess = (min + max) / 2;
    		if (x / guess >= guess && x / (guess + 1) < (guess + 1) ) {
    			return guess;
    		} else if ( x / guess < guess ) { // Too high
    			max = guess - 1;
    		} else { // Too low
    			min = guess + 1;
    		}
    	}
    }
}
