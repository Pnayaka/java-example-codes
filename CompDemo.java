// Use a custom comparator.
import java.util.*;

// A reverse comparator for strings.
class MyComp implements Comparator<String> {
	public int compare(String a, String b) {
		String aStr, bStr;
		aStr = a;
		bStr = b;
		// Reverse the comparison.
		return bStr.compareTo(aStr);
	}
	
	// No need to override equals.
}

class CompDemo {
	public static void main(String args[]) {
		// Create a tree set.
		TreeSet<String> ts = new TreeSet<String>(new MyComp());
		
		// Add elements to the tree set.
		ts.add("C");
		ts.add("A");
		ts.add("B");
		ts.add("E");
		ts.add("F");
		ts.add("D");
		
		// Display the elements.
		for(String element : ts)
			System.out.print(element + " ");
		System.out.println();
	}
}