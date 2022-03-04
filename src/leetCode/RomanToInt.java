package leetCode;

import java.util.HashMap;
import java.util.Map;

// Symbol       Value
// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000

public class RomanToInt {
	
    public int romanToInt(String s) {
    	Map<Character, Integer> roMap = initMap();
    	int highestSeen = Integer.MIN_VALUE;
    	int sum = 0;
    	for (int i = s.length() - 1; i >= 0; i--) {
    		int current = roMap.get(s.charAt(i));
    		if (current >= highestSeen) {
    			highestSeen = current;
    			sum += current;
    		} else {
    			sum -= current;
    		}
    	}
        return sum;
    }
    
	private Map<Character, Integer> initMap() {
		Map<Character, Integer> roMap = new HashMap<Character, Integer>();
		roMap.put('I', 1);
		roMap.put('V', 5);
		roMap.put('X', 10);
		roMap.put('L', 50);
		roMap.put('C', 100);
		roMap.put('D', 500);
		roMap.put('M', 1000);
		return roMap;
	}
}
