package fit5171.monash.edu;

import java.util.ArrayList;

public class FlightCollection {
	
	public static ArrayList<Flight> flights = new ArrayList<>();

	public static ArrayList<Flight> getFlights() {
		return flights;
	}

	public static void addFlights(ArrayList<Flight> flights_db) {
		for (Flight f:flights_db) {
			if (f == null) {
				flights_db.remove(f);
				throw new NullPointerException("Invalid flight has been found");
			}
		}
		FlightCollection.flights.addAll(flights_db);
	}
	
	public static Flight getFlightInfo(String city1, String city2) throws Exception {
    	//display the flights where there is a direct flight from city 1 to city2
		Flight returnFlight = null;

		for(Flight f : flights) {
			if (f.getDepartFrom() == city1 && f.getDepartTo() == city2) {
				returnFlight = f;
				return f;
			} else {
				throw new Exception("This flight does not exist");
			}
		}
    	return returnFlight;
    }
    
    public static Flight getFlightInfo(String city) throws NullPointerException {
    	//SELECT a flight where depart_to = city
		Flight returnFlight = null;

		for(Flight f : flights) {
			if (f.getDepartTo() == city) {
				returnFlight = f;
				return f;
			} else {
				throw new NullPointerException("This flight does not exist");
			}
		}
		return returnFlight;

    }

	public static Flight getFlightInfo(int flight_id) throws Exception {
		//SELECT a flight with a particular flight id
		Flight returnFlight = null;

		for(Flight f : flights) {
			if (f.getFlightID() == flight_id) {
				returnFlight = f;
				return f;
			} else {
				throw new Exception("This flight does not exist");
			}
		}
		return returnFlight;
	}

}
