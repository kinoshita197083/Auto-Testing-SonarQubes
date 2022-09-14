package test.java.fit5171.monash.edu;



import main.java.fit5171.monash.edu.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import static org.mockito.Mockito.*;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class ChooseTicketTest {

    ChooseTicket chooseTicket;

    public ChooseTicketTest() {}

    @BeforeAll
    static void initAll() {
        ChooseTicketTest tester = new ChooseTicketTest();
    }

    @BeforeEach
    void init(){
        this.chooseTicket = new ChooseTicket(){};
    }

    @DisplayName("Input city are nulls")
    @Test
    void testChooseTicketWithNullInputAsCityName() {

        Throwable exception = assertThrows(Exception.class, () -> {
            chooseTicket.chooseTicket(null, null);
        });

        assertTrue(exception.getMessage().contains("Invalid city"));
    }

    @DisplayName("Input city are valid values")
    @Test
    void testChooseTicketWithValidValues() {
        String city1 = "Tokyo";
        String city2 = "Taipei";

        Throwable exception = assertThrows(Exception.class, () -> {
            chooseTicket.chooseTicket(city1, city2);
        });

        assertFalse(exception.getMessage().contains("Invalid city"));
    }

    @DisplayName("Input city are invalid values")
    @ParameterizedTest
    @NullSource
    @Test
    void testChooseTicketWithInValidValues() {
        String city1 = "123";
        String city2 = "Taipei";

        Throwable exception = assertThrows(Exception.class, () -> {
            chooseTicket.chooseTicket(city1, city2);
        });

        assertTrue(exception.getMessage().contains("Invalid city"));
    }

    @Test
    void testBuyTicketWithInvalidFlight() {
        //A dummy data for testing: no fight for two depart cities
        Passenger passenger = new Passenger("Lee", "Bruce", 35, "Male", "test@email.com", "0400000000", "Q1234567", "asd", 123);
        Airplane airplane = new Airplane(3343, "A330", 8, 72, 6);
        Flight flight = new Flight(99, "Osaka", "Okinawa", "OK9900", "OSK Airline",
                Timestamp.valueOf("2022-09-03 10:10:10.0"), Timestamp.valueOf("2022-09-03 10:10:10.0"), airplane);
        Ticket ticket99 = new Ticket(123, 700, flight, false, passenger);

        //Two cities user would enter
        String city1 = "Sydney";
        String city2 = "Melbourne";

        //Mock ticket collection for returning a dummy ticket_id
        MockedStatic<FlightCollection> mockedFlightCollection = mockStatic(FlightCollection.class, CALLS_REAL_METHODS);
        mockedFlightCollection.when(() -> FlightCollection.getFlightInfo(city1, city2)).thenReturn(flight);

        //Null flight should trigger a NullPointerException with specified message
        try {
            chooseTicket.chooseTicket(city1, city2);
        } catch(Exception e) {
            System.out.println(e);
            assertTrue(e.getMessage().contains("No"));
        }
    }

    @Test
    void testBuyTicketWithValidFlight() {
        //A dummy data for testing: valid fight for two depart cities
        Passenger passenger = new Passenger("Lee", "Bruce", 35, "Male", "test@email.com", "0400000000", "Q1234567", "asd", 123);
        Airplane airplane = new Airplane(3343, "A330", 8, 72, 6);
        Flight flight = new Flight(99, "Osaka", "Okinawa", "OK9900", "OSK Airline",
                Timestamp.valueOf("2022-09-03 10:10:10.0"), Timestamp.valueOf("2022-09-03 10:10:10.0"), airplane);
        Ticket validTicket = new Ticket(999, 700, flight, false, passenger);

        //Two cities user would enter
        String city1 = "Osaka";
        String city2 = "Okinawa";

        //Mock ticket collection for returning a dummy ticket_id
        MockedStatic<FlightCollection> mockedFlightCollection = mockStatic(FlightCollection.class, CALLS_REAL_METHODS);
        mockedFlightCollection.when(() -> FlightCollection.getFlightInfo(city1, city2)).thenReturn(flight);

        try {
            chooseTicket.chooseTicket(city1, city2);
        } catch(Exception e) {
            System.out.println(e);
            assertTrue(e.getMessage().contains("No"));
        }

        //Valid flight info should be found
        assertEquals(99, validTicket.getFlight().getFlightID());
        assertEquals("Okinawa", validTicket.getFlight().getDepartFrom());
        assertEquals("Osaka", validTicket.getFlight().getDepartTo());
        assertEquals("OK9900", validTicket.getFlight().getCode());
        assertEquals("OSK Airline", validTicket.getFlight().getCompany());
    }

//    @DisplayName("Choose an already booked ticket")
//    @Test
//    void testChoosingAnAlreadyBookedTicket() {
//        int
//
//        Throwable exception = assertThrows(Exception.class, () -> {
//            chooseTicket.chooseTicket(city1, city2);
//        });
//
//        assertTrue(exception.getMessage().contains("Invalid city"));
//    }
}
