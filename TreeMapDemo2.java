// Use a comparator to sort accounts by last name.
import java.util.*;

// Compare last whole words in two strings.
class TComp implements Comparator<String> {
	public int compare(String a, String b) {
		int i, j, k;
		String aStr, bStr;
		aStr = a;
		bStr = b;
		
		// Find index of beginning of last name.
		i = aStr.lastIndexOf(' ');
		j = bStr.lastIndexOf(' ');
		k = aStr.substring(i).compareTo(bStr.substring(j));
		if(k==0) // last names match, check entire name
			return aStr.compareTo(bStr);
		else
			return k;
	}	
	// No need to override equals.
}

class TreeMapDemo2 {
	public static void main(String args[]) {
		// Create a tree map.
		TreeMap<String, Double> tm = new TreeMap<String, Double>(new TComp());
		
		// Put elements to the map.
		tm.put("John Doe", new Double(3434.34));
		tm.put("Tom Smith", new Double(123.22));
		tm.put("Jane Baker", new Double(1378.00));
		tm.put("Tod Hall", new Double(99.22));
		tm.put("Ralph Smith", new Double(-19.08));

		// Get a set of the entries.
		Set<Map.Entry<String, Double>> set = tm.entrySet();
		
		// Display the elements.
		for(Map.Entry<String, Double> me : set) {
			System.out.print(me.getKey() + ": ");
		System.out.println(me.getValue());
	}
	System.out.println();
	
	// Deposit 1000 into John Doe's account.
	double balance = tm.get("John Doe");
	tm.put("John Doe", balance + 1000);
	System.out.println("John Doe's new balance: " +
	tm.get("John Doe"));
	}
}