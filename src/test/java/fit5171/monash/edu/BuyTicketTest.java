package test.java.fit5171.monash.edu;

import main.java.fit5171.monash.edu.*;
import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

import java.io.ByteArrayInputStream;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BuyTicketTest {

    private static Airplane airplane = new Airplane(3343, "A330", 8, 72, 6);
    private static Flight flight = new Flight(99, "Osaka", "Okinawa", "OK9900", "OSK Airline",
            Timestamp.valueOf("2022-09-03 10:10:10.0"), Timestamp.valueOf("2022-09-03 10:10:10.0"), airplane);
    private static Passenger passenger = new Passenger("Lee", "secondName", 20, "Male", "test@email.com", "", "", "", 0);
    private static Ticket ticket99 = new Ticket(123, 700, flight, false, passenger);
    BuyTicket buyTicket;

    public BuyTicketTest() {}

    @BeforeAll
    static void initAll() {
        BuyTicketTest tester = new BuyTicketTest();
    }

    @BeforeEach
    void init(){
        this.buyTicket = new BuyTicket(){};

//        //mock static class TicketCollection
//        MockedStatic<TicketCollection> mockedTicketCollection = mockStatic(TicketCollection.class, CALLS_REAL_METHODS);
//
//        // mock static method TicketCollection.getTicketInfo
//        mockedTicketCollection.when(() -> TicketCollection.getTicketInfo(123)).thenReturn(ticket99);

        //mock static class FlightCollection
        MockedStatic<FlightCollection> mockedFlight = mockStatic(FlightCollection.class, CALLS_REAL_METHODS);

        // mock static method FlightCollection.getFlightInfo
        mockedFlight.when(() -> FlightCollection.getFlightInfo(1)).thenReturn(flight);

        //mock static method in non-static class Airplane.getAirPlaneInfo()
        MockedStatic<Airplane> airplaneMockedStatic = mockStatic(Airplane.class, CALLS_REAL_METHODS);
        airplaneMockedStatic.when(() -> Airplane.getAirPlaneInfo(3343)).thenReturn(airplane);
    }

    @Test
    void testBuyTicketWithInvalidTicketId() {
        //Invalid ticket_id
        int ticket_id = 0;

        //Invalid id should immediately trigger an exception with specified message
        try {
            buyTicket.buyTicket(ticket_id);
        } catch(Exception e) {
            assertTrue(e.getMessage().contains("Invalid"));
        }
    }

    @Test
    void testBuyTicketWithInvalidFlight() {
        //A dummy ticket for testing: no flight is attached
        Ticket invalidTicket = new Ticket(999, 700, null, false, passenger);

        //Mock ticket collection for returning a dummy ticket_id
        MockedStatic<TicketCollection> mockedTicketCollection = mockStatic(TicketCollection.class, CALLS_REAL_METHODS);
        mockedTicketCollection.when(() -> TicketCollection.getTicketInfo(999)).thenReturn(invalidTicket);

        //Null flight should trigger a NullPointerException with specified message
        try {
            buyTicket.buyTicket(invalidTicket.getTicket_id());
        } catch(Exception e) {
            System.out.println(e);
            assertTrue(e.getMessage().contains("No"));
        }
    }
}
