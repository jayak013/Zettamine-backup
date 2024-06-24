 package assignmentz;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ProcessAndSerializeEmployees {
	
	private static final String MY_FILE = "C:\\Users\\S Jaya Krishna\\Desktop\\Customer Data\\EmployeeAndCertificates.ser";

	public static void main(String[] args) {
		
		Map<Employee, Set<Certification>> empMap = new LinkedHashMap<>();
		
		Certification c0 = new Certification(-1, "No Certifications", -1);
		Certification c1 = new Certification(101, "Java", 1);
		Certification c2 = new Certification(102, "Python", 3);
		Certification c3 = new Certification(103, "Angular", 2);
		Certification c4 = new Certification(104, "React", 2);
		Certification c5 = new Certification(105, "MySQL", 3);
		
		Employee ce1 = new ContractEmployee(671,510, "Jaya", 10);
		Employee ce2 = new ContractEmployee(672, 511, "Krishna", 20);
		Employee ce3 = new ContractEmployee(673, 512, "Seetha", 30);
		
		Employee re1 = new RegularEmployee("E893U", 411, "Hema", 10);
		Employee re2 = new RegularEmployee("T943L", 412, "Varma", 20);
		Employee re3 = new RegularEmployee("O803J", 413, "Simha", 30);
		
		Set<Certification> setOfCertifications1 =  new HashSet<>();
		Set<Certification> setOfCertifications2 =  new HashSet<>();
		Set<Certification> setOfCertifications3 =  new HashSet<>();
		Set<Certification> setOfCertifications4 =  new HashSet<>();
		
		setOfCertifications1.add(c0);
		
		setOfCertifications2.add(c1);
		
		setOfCertifications3.add(c2);
		setOfCertifications3.add(c4);
		
		setOfCertifications4.add(c1);
		setOfCertifications4.add(c3);
		setOfCertifications4.add(c5);
		setOfCertifications4.add(c4);
		
		empMap.put(ce1, setOfCertifications1);
		empMap.put(ce2, setOfCertifications3);
		empMap.put(ce3, setOfCertifications2);
		empMap.put(re1, setOfCertifications1);
		empMap.put(re2, setOfCertifications4);
		empMap.put(re3, setOfCertifications2);
		
		
		for(Entry<Employee, Set<Certification>> entrySet:empMap.entrySet()) {
			System.out.println(entrySet.getKey()+" : \n"+entrySet.getValue());
		}
		
		try(FileOutputStream fos = new FileOutputStream(MY_FILE);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(empMap);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
