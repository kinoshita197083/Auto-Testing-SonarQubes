package fit5171.monash.edu;

import java.util.ArrayList;

public class TicketCollection {
	
	public static ArrayList<Ticket> tickets = new ArrayList<>();

	public static ArrayList<Ticket> getTickets() {
		return tickets;
	}

	public static void addTickets(ArrayList<Ticket> tickets_db) {
		//check each ticket
		for (Ticket t:tickets_db) {
			if (t == null) {
				tickets_db.remove(t);
				throw new NullPointerException("Invalid Ticket has been found");
			}
		}
		TicketCollection.tickets.addAll(tickets_db);
	}

	public static void getAllTickets() {
		//display all available tickets from the Ticket collection
		for (int i = 0; i < tickets.size(); i++ ) {
			System.out.println(i + ": " + tickets.get(i));
		}
	}

	public static Ticket getTicketInfo(int ticket_id) throws Exception {
    	//SELECT a ticket where ticket id = ticket_id
		Ticket returnTicket = null;

		for(Ticket t : tickets) {
			if (t.getTicket_id() == ticket_id) {
				returnTicket = t;
				return t;
			} else {
				throw new Exception("The ticket does not exist");
			}
		}
		return returnTicket;
    }
	

}
