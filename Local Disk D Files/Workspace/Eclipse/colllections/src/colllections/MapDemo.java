package colllections;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapDemo {
	
	public static void main(String[] args) {
		
		Hashtable<String, String> currencyTable = new Hashtable<String, String>();
		
		currencyTable.put("INR", "Indian Rupee");
		currencyTable.put("LKR", "Sri Lanka Rupee");
		currencyTable.put("IQD", "Iraqi Dinar");
		currencyTable.put("BHD", "Bharain Dinar");
		currencyTable.put("USD", "US Dollar");
		currencyTable.put("SGD", "Singapore Dollar");
		
		System.out.println(currencyTable);
		
		String currDesc = currencyTable.get("SGD");
		System.out.println("Value for SGD is: " + currDesc);
		
		currDesc = currencyTable.get("XYZ");
		System.out.println("Value of XYZ is: " + currDesc);
		System.out.println("~".repeat(30));
		
		//Enumeration<K> is present in HashTable but not in the Map Interface
		Enumeration<String> enumKeys = currencyTable.keys();
		String key = "";
		String value = "";
		while(enumKeys.hasMoreElements()) {
			key = enumKeys.nextElement();
			value = currencyTable.get(key);
			System.out.println(key + " : " + value);
		}
		System.out.println("~".repeat(30));
		
		//by using keySet()
		Set<String> keySet = currencyTable.keySet();
		System.out.println("Key Set: " + keySet);
		Iterator<String> keyItr = keySet.iterator();
		
		while(keyItr.hasNext()) {
			key = keyItr.next();
			value = currencyTable.get(key);
			System.out.println(key + " : " + value);
		}
		System.out.println("~".repeat(30));
		
		//checking for existence of a key
		System.out.println("LKR key exists: " 
					+ currencyTable.containsKey("LKR"));
		System.out.println("AUD key exists: " 
					+ currencyTable.containsKey("AUD"));
		
		//checking for existence of a value
		System.out.println("Indian rupee exists: " 
					+ currencyTable.containsValue("Indian Rupee"));
		//Values are case-sensitive in Maps
		System.out.println("INDIAN RUPEE exists: " 
					+ currencyTable.containsValue("INDIAN RUPEE"));
		System.out.println("~".repeat(30));
		
		//By using entrySet()
		Set<Entry<String, String>> 
			entrySet = currencyTable.entrySet();
		Iterator<Entry<String,String>> 
			entrySetItr = entrySet.iterator();
		while(entrySetItr.hasNext()) {
			Entry<String,String> entry = entrySetItr.next();
			System.out.println(entry.getKey() 
					+ " : " + entry.getValue());
		}
		System.out.println("~".repeat(30));
	}
	
}
