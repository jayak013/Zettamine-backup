package com.zettamine.java.day02;

public class TicketPriceCalculation {
	
	private int ticketId;
	private int price;
	private static int availableTickets;
	
	public TicketPriceCalculation() {
		
	}
	
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public static int getAvailableTickets() {
		return availableTickets;
	}
	public static void setAvailableTickets(int availableTickets) throws InvalidTicketCount {
		if(availableTickets<=0) {
			throw new InvalidTicketCount("Book atleast ONE Ticket");
		}
		TicketPriceCalculation.availableTickets = availableTickets;
	}
	
	public int calculateTicketCost(int noOfTickets) {
		if(noOfTickets<=availableTickets) {
			availableTickets-=noOfTickets;
			return noOfTickets*getPrice();
		}
		return -1;
	}
	
}
