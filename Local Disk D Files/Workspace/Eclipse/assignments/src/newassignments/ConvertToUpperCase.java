package newassignments;

import java.util.Scanner;

public class ConvertToUpperCase {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String personName = "";
		System.out.print("Enter Inmate's name: ");
		personName = personName.concat(scn.nextLine()+" ");
		System.out.print("Enter Inmate's father's name: ");
		personName = personName.concat(scn.nextLine());
		convertToUpperCase(personName);
	}

	private static void convertToUpperCase(String personName) {
		String[] split = personName.split(" ");
		String upperCaseName = "";
		for(String name:split) {
			for(int i = 0;i<name.length();i++) {
				char ch = name.charAt(i);
				if(ch>='a' && ch<='z') {
					upperCaseName+=(char)(ch-32);
				}else if(ch>='A' && ch<='Z') {
					upperCaseName+=ch;
				}else {
					System.out.println("Invalid Name");
					return;
				}
			}
			upperCaseName+=" ";
		}
		System.out.println(upperCaseName);
	}
	
	
}
