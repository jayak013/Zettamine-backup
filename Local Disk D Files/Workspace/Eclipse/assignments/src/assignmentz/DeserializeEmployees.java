package assignmentz;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class DeserializeEmployees {
	
	private static final String MY_FILE = "C:\\Users\\S Jaya Krishna\\Desktop\\Customer Data\\EmployeeAndCertificates.ser";
	public static void main(String[] args){
		Map<Employee,Set<Certification>> empMap = null;
		try(FileInputStream fis = new FileInputStream(MY_FILE);
			ObjectInputStream ois = new ObjectInputStream(fis);) {
			Object obj = ois.readObject();
			if(obj instanceof LinkedHashMap<?,?>) {
				empMap = (LinkedHashMap<Employee,Set<Certification>>)obj;
				Iterator<Employee> iterator = empMap.keySet().iterator();
				if(iterator.next() instanceof Employee){
					System.out.println(empMap);
				}
				
			}
				
//			try {
//				while(true) {
//					empMap = (LinkedHashMap<Employee,Set<Certification>>)ois.readObject();
//				}
//			}catch(EOFException e) {
//				for(Entry<Employee, Set<Certification>> entrySet:empMap.entrySet()) {
//					System.out.println(entrySet.getKey()+" : \n"+entrySet.getValue());
//				}
//				System.out.println("REACHED THE END OF THE FILE");
//			}
			
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
