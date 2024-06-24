package arrays;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeCustomers {
	private static final String FILE_NAME = "C:\\Users\\S Jaya Krishna\\Desktop\\Customer Data\\Customer.ser";

	public static void main(String[] args) {
		Customer c1 = new Customer(1001,"Hindware Ltd.",3647);
		Customer c2 = new Customer(1008,"Wipro",6778);
		
		
		try(FileOutputStream fos = new FileOutputStream(FILE_NAME);
				ObjectOutputStream oos = new ObjectOutputStream(fos);){
			
			oos.writeObject(c1);
			oos.writeObject(c2);
			System.out.println("Program execution completed");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
