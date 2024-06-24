package com.zettamine.java.day02;

import java.util.Scanner;

public class CalculateTicketPrice {
	
	public static void main(String[] args) throws InvalidTicketCount {
		Scanner scn = new Scanner(System.in);
		TicketPriceCalculation t = new TicketPriceCalculation();
		System.out.print("Enter the number of Bookings: ");
		int noOfBookings = scn.nextInt();
		System.out.print("Enter the available tickets: ");
		t.setAvailableTickets(scn.nextInt());
		while(noOfBookings>0) {
			System.out.print("Enter the Ticket id: ");
			t.setTicketId(scn.nextInt());
			System.out.print("Enter the ticket price: ");
			t.setPrice(scn.nextInt());
			System.out.print("Enter the no of tickets: ");
			int noOfTickets = scn.nextInt();
			int printTicketCal = printTicketCal(t, noOfTickets);
			if(printTicketCal==-1) {
				noOfBookings++;
				System.out.println("Available tickets are [ "+t.getAvailableTickets()+" ]\n---Book Again---");
			}
			noOfBookings--;
		}
	}
	private static int printTicketCal(TicketPriceCalculation t,int noOfTickets) {
		System.out.println("Available Tickets: "+
					t.getAvailableTickets());
		System.out.println("Total Amount: "+ t.calculateTicketCost(noOfTickets));
		System.out.println("Available Tickets after booking: "+t.getAvailableTickets());
		return t.calculateTicketCost(noOfTickets);
	}
	
}
