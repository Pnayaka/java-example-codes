// Use a default property list.
import java.util.*;

class PropDemoDef {
	public static void main(String args[]) {
		Properties defList = new Properties();
		defList.put("Florida", "Tallahassee");
		defList.put("Wisconsin", "Madison");
		Properties capitals = new Properties(defList);
		capitals.put("Illinois", "Springfield");
		capitals.put("Missouri", "Jefferson City");
		capitals.put("Washington", "Olympia");
		capitals.put("California", "Sacramento");
		capitals.put("Indiana", "Indianapolis");
	
		// Get a set-view of the keys.
		Set states = capitals.keySet();

		// Show all of the states and capitals.
		for(Object name : states)
			System.out.println("The capital of " +
			name + " is " +
			capitals.getProperty((String)name)
			+ ".");
		System.out.println();
		
		// Florida will now be found in the default list.
		String str = capitals.getProperty("Florida");
		System.out.println("The capital of Florida is "
			+ str + ".");
	}
}