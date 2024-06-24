package arrays;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeCustomers {
	private static final String FILE_NAME = "C:\\Users\\S Jaya Krishna\\Desktop\\Customer Data\\Customer.ser";

	public static void main(String[] args) {
		
		Customer c;
		
		try(FileInputStream fis = new FileInputStream(FILE_NAME);
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			
			
//			c = (Customer)ois.readObject();
//			System.out.println(c);
//			
//			c = (Customer)ois.readObject();
//			System.out.println(c); 
			
			try {
				while(true) {
					System.out.println((Customer)ois.readObject());
				}
			}catch(EOFException e) {
				System.out.println("End of the file reached");
			}
	
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
