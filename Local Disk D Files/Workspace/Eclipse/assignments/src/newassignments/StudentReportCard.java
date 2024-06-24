package newassignments;

import java.util.Scanner;

public class StudentReportCard {
	
	static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.print("Enter Student Name: ");
		String sName = scn.nextLine();
		System.out.print("Enter number of subjects: ");
		int numberOfSubs = scn.nextInt();
		marksEntry(sName,new String[numberOfSubs],new int[numberOfSubs]);
	}
	
	private static void marksEntry(String sName,String[] subs,int[] studentMarks) {
		for(int i = 0;i<studentMarks.length;i++) {
			System.out.print("Enter Subject-"+(i+1)+" name: ");
			scn.nextLine();
			String subName = scn.nextLine();
			subs[i] = subName;
			System.out.print("Enter the marks for subject "+subs[i]+" : ");
			studentMarks[i] = scn.nextInt();
		}
		for(String s:subs) {
			System.out.println(s);
		}
		printReport(sName, subs, studentMarks);
	}
	
	private static void printReport(String sName,String[] subs,int[] studentMarks) {
		System.out.println("-".repeat(40));
		System.out.println("\t REPORT CARD");
		System.out.println("Student Name: "+sName);
		System.out.println("-".repeat(40));
		System.out.print("SUBJECT \t \t");
		System.out.println("  MARKS");
		System.out.println("-".repeat(40));
		int totalMarks = 0;
			for(int i = 0;i<studentMarks.length;i++) {
				System.out.print(subs[i]+"\t \t \t   ");
				System.out.println(studentMarks[i]);
				totalMarks+=studentMarks[i];
			}
			System.out.println("-".repeat(40));
			float avg = (float)totalMarks/studentMarks.length;
			System.out.printf("Total Marks :%d",totalMarks);
			System.out.printf("\t Average :%.2f \n",avg);
			System.out.println("-".repeat(40));
			scn.close();
		}
		

	
}
