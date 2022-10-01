package fit5171.monash.edu;

import java.util.Scanner;

public class ChooseTicket{
   
	BuyTicket buyTicket = new BuyTicket();
    
	Scanner in = new Scanner(System.in);

	public void chooseTicket(String city1, String city2) throws Exception
	{
		int counter = 1;
		int idFirst = 0;
		int idSecond = 0;

		Flight flight = new Flight();

		//search for direct flight from city1 to city2
		if (city1 != null && city2 != null && validateCity(city1) && validateCity(city2)) {
			try {
				flight = FlightCollection.getFlightInfo(city1, city2);
			}
			catch (NullPointerException e) {
				System.out.println("No flight found");
			}
		}
		else {
			throw new Exception("Invalid city");
		}


		if(flight != null) {

			TicketCollection.getAllTickets();

			//Check how many valid tickets are inside the db
			int ticket_count = TicketCollection.tickets.size();

			System.out.println("\nEnter ID of ticket you want to choose:");

			int ticket_id = in.nextInt();
			int validated_ticket_id = 0;

			//validate ticket here
			if (validateTicket(ticket_id, ticket_count)){
				validated_ticket_id = ticket_id;
			} else {
				throw new Exception("Enter a valid ticket option");
			}

			//buy ticket here
			buyTicket.buyTicket(validated_ticket_id);
		}
		else
		//in case there is no direct ticket from city1 to city2
		{
			//SELECT a flight where depart_to = city2

			Flight depart_to = FlightCollection.getFlightInfo(city2);

			//and search for city with depart_from as connector city

			String connectCity = depart_to.getDepartFrom();

			//SELECT * from flight where depart_to = '" + connectCity + "' and depart_from = '" + city1+"'"

			Flight flightConnectingTwoCities = FlightCollection.getFlightInfo(city1, connectCity);

			if(flightConnectingTwoCities != null){

				System.out.println("There is special way to go there. And it is transfer way, like above. Way №" + counter);

				idFirst = depart_to.getFlightID();

				idSecond = flightConnectingTwoCities.getFlightID();


			}

			counter++;

			buyTicket.buyTicket(idFirst, idSecond); //pass two tickets and buy them

			if(counter == 1)
			{
				System.out.println("There is no possible variants.");
			}
			return;
		}

	}

	public Boolean validateCity(String city) {
		return city.matches("^[a-zA-Z]*$");
	}

	public Boolean validateTicket(int selected_input, int ticket_count) {
		return selected_input <= ticket_count;
	}
	
}