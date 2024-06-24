package newassignments;

import java.util.Scanner;

public class TicketBooking {
	
	static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		movieTicketsCost();
	}

	private static void movieTicketsCost() {
		System.out.print("Enter the no of tickets: ");
		float totalCost = 0;
		int ticketCount = scn.nextInt();
		if(ticketCount>=5 && ticketCount<=40) {
			System.out.print("Do you want refreshment(Y/N): ");
			char refreshmentConfirmation = scn.next().charAt(0);
			System.out.print("Do you have coupon code(Y/N): ");
			char couponConfirmation = scn.next().charAt(0);
			System.out.print("Enter the circle:");
			char classCheck = scn.next().charAt(0);
			
			if(classCheck=='K'||classCheck=='k') {
				totalCost+=ticketCount*75;
			}else if(classCheck=='Q'||classCheck=='q') {
				totalCost+=ticketCount*150;
			}else {
				System.out.println("\u001B[31mInvalid Input\u001B[0m");
				return;
			}
			totalCost = (float)(ticketCount>20?(totalCost*0.9):
					(totalCost));
			totalCost = (float) (couponConfirmation=='Y' || couponConfirmation=='y'?
					(totalCost*0.98):(totalCost));
			totalCost = (float)(refreshmentConfirmation=='Y' || refreshmentConfirmation=='y'?
					(totalCost+(ticketCount*50)):(totalCost));
			
			System.out.printf("Ticket Cost:%.2f",totalCost);
		}else {
			System.out.println("\u001B[31mMinimum of 5 and Maximum of 40\u001B[0m");
			return;
		}
	}
	
}
