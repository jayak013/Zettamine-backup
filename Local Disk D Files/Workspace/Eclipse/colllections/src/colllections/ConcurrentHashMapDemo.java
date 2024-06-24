package colllections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
	
	public static void main(String[] args) {
		
		
		ConcurrentHashMap<String, String> ctryCodeMap = 
				new ConcurrentHashMap<String, String>();
		
		ctryCodeMap.put("IN", "India");
		ctryCodeMap.put("INR", "India");
		ctryCodeMap.put("AF", "Afganistan");
		ctryCodeMap.put("AFG", "Afganistan");
		ctryCodeMap.put("RU", "Russia");
		ctryCodeMap.put("RUS", "Russia");
		
		System.out.println(ctryCodeMap);
		
		if(args.length!=0)
			System.out.println("The ISO Code for "+args[0]+" is "+ctryCodeMap.get(args[0]));
		else
			System.out.println("not provided any command line argument");
		
		
	}
	
}
