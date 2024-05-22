
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

// a class representing a dictionary of entries
public class Dictionary {
	private final String SEPARATOR = "::";
	// hashMap representing the dictionary entries
	// each listing contains a key and a dictionary listing
	HashMap<String, Entry> dictionary = new HashMap<String, Entry>(); 
	List<String> order ; // A list of the dictionary keys to keep the dictionary organized
	
	// an empty dictionary constructor
	public Dictionary()
	{
		order = new LinkedList<String>();
	}
	
	// constructs a new dictionary with values scanned from a given file
	public Dictionary(File file)  throws FileNotFoundException  
	{
			Scanner sc = new Scanner(file);
			String[] value;
			Entry tmpEntry;
			
			// get the values from the dictionary file 
			while (sc.hasNext())
			{
				String input = sc.nextLine();
				value = input.split(SEPARATOR);
				
				// in case the value does not exist in the dictionary add it
				if (!dictionary.containsKey(value[0]))
				{
					tmpEntry = new Entry(value[0],value[1]);
					dictionary.put(tmpEntry.getKey(), tmpEntry);
				}
			}
			sc.close();
			
			// save and sort a list of the dictionary keys
			order = new LinkedList<String>(dictionary.keySet());
			Collections.sort(order);		
	}
	
	// adds a value to the dictionary while keeping the keys list organized
	public void add(String item,String description){
		if (!dictionary.containsKey(item))
		{
			Entry tmpEntry = new Entry(item,description);
			dictionary.put(tmpEntry.getKey(),tmpEntry );
			order.add(tmpEntry.getKey());
		}
		Collections.sort(order);
	}
	
	// removes a value from the dictionary and keys list
	public void remove(String item){
		dictionary.remove(item);
		order.remove(item);
	}
	
	// updates a dictionary value by removing the item and placing an updated one
	public void update(String item,String description){
		remove(item);
		add(item,description);
	}
	
	// searches for a dictionary value, if not exists returns null
	public String search(String str){
		if (dictionary.get(str) != null)
			return dictionary.get(str).getValue();
		else 
			return null;
	}
	

	@Override
	// returns a string representation of the current dictionary listings
	public String toString() {
		String str = "";
		for (int i = 0; i < order.size() ; i++)
			str += dictionary.get(order.get(i));
		return str;
	}	
}
