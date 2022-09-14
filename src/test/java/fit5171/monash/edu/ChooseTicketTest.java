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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
    @Test
    void testChooseTicketWithInValidValues() {
        String city1 = "123";
        String city2 = "Taipei";

        Throwable exception = assertThrows(Exception.class, () -> {
            chooseTicket.chooseTicket(city1, city2);
        });

        assertTrue(exception.getMessage().contains("Invalid city"));
    }

    @DisplayName("Choose an already booked ticket")
    @Test
    void testChoosingAnAlreadyBookedTicket() {
        String city1 = "Tokyo";
        String city2 = "Taipei";
        int input = 1;

        try {
            Throwable exception = assertThrows(Exception.class, () -> {
                chooseTicket.chooseTicket(city1, city2);
                IntegerAsker asker = mock(IntegerAsker.class);
                when(asker.ask(anyString())).thenReturn(input);
            });

            assertFalse(exception.getMessage().contains("Enter a valid"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @DisplayName("Choose a not booked ticket")
    @Test
    void testChoosingAnNotBookedTicket() {
        String city1 = "Tokyo";
        String city2 = "Taipei";
        String userInput = "99";

        try {
            Throwable exception = assertThrows(Exception.class, () -> {
                InputStream input = new ByteArrayInputStream(userInput.getBytes());
                System.setIn(input);
                chooseTicket.chooseTicket(city1, city2);
            });
            assertTrue(exception.getMessage().contains("Enter"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @Test
    void testChooseTicketWithInvalidFlight() {
        //A dummy data for testing: no fight for two depart cities
        Passenger passenger = new Passenger("Lee", "Bruce", 35, "Male", "test@email.com", "0400000000", "Q1234567", "asd", 123);
        Airplane airplane = new Airplane(3343, "A330", 8, 72, 6);
        Flight flight = new Flight(99, "Osaka", "Okinawa", "OK9900", "OSK Airline",
                Timestamp.valueOf("2022-09-03 10:10:10.0"), Timestamp.valueOf("2022-09-03 10:10:10.0"), airplane);
        Ticket ticket99 = new Ticket(123, 700, flight, false, passenger);

        //Two cities user would enter
        String city1 = "Sydney";
        String city2 = "Melbourne";

        //Mock flight collection for returning a dummy ticket_id
        MockedStatic<FlightCollection> mockedFlightCollection = mockStatic(FlightCollection.class, CALLS_REAL_METHODS);
        mockedFlightCollection.when(() -> FlightCollection.getFlightInfo(city1, city2)).thenReturn(flight);

        //Null flight should trigger a NullPointerException with specified message
        try {
            assertNotNull(FlightCollection.getFlightInfo(city1, city2));
            System.out.println("No flight found");
        } catch(Exception e) {
        }
    }

    @Test
    void testChooseTicketWithValidFlight() {
        //A dummy data for testing: valid fight for two depart cities
        Passenger passenger = new Passenger("Lee", "Bruce", 35, "Male", "test@email.com", "0400000000", "Q1234567", "asd", 123);
        Airplane airplane = new Airplane(3343, "A330", 8, 72, 6);
        Flight flight = new Flight(99, "Osaka", "Okinawa", "OK9900", "OSK Airline",
                Timestamp.valueOf("2022-09-03 10:10:10.0"), Timestamp.valueOf("2022-09-03 10:10:10.0"), airplane);
        Ticket validTicket = new Ticket(999, 700, flight, false, passenger);

        //Two cities user would enter
        String city1 = "Osaka";
        String city2 = "Okinawa";

        //Mock flight collection for returning a dummy ticket_id
        MockedStatic<FlightCollection> mockedFlightCollection = mockStatic(FlightCollection.class, CALLS_REAL_METHODS);
        mockedFlightCollection.when(() -> FlightCollection.getFlightInfo(city1, city2)).thenReturn(flight);

        //Valid flight info should be found
        assertEquals(99, validTicket.getFlight().getFlightID());
        assertEquals("Okinawa", validTicket.getFlight().getDepartFrom());
        assertEquals("Osaka", validTicket.getFlight().getDepartTo());
        assertEquals("OK9900", validTicket.getFlight().getCode());
        assertEquals("OSK Airline", validTicket.getFlight().getCompany());
    }

}
