package test;

import fit5171.monash.edu.*;
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
    private static Ticket ticket99 = new Ticket(123, 700, flight, false, null);
    BuyTicket buyTicket;

    public BuyTicketTest() {}

    @BeforeAll
    static void initAll() {
        BuyTicketTest tester = new BuyTicketTest();
    }

    @BeforeEach
    void init(){
        this.buyTicket = new BuyTicket(){};

        //mock static class TicketCollection
        MockedStatic<TicketCollection> mocked = mockStatic(TicketCollection.class, CALLS_REAL_METHODS);

        // mock static method TicketCollection.getTicketInfo
        mocked.when(() -> TicketCollection.getTicketInfo(123)).thenReturn(ticket99);

        //mock static class FlightCollection
        MockedStatic<FlightCollection> mockedFlight = mockStatic(FlightCollection.class, CALLS_REAL_METHODS);

        // mock static method FlightCollection.getFlightInfo
        mockedFlight.when(() -> FlightCollection.getFlightInfo(1)).thenReturn(flight);

        //mock static method in non-static class Airplane.getAirPlaneInfo()
        MockedStatic<Airplane> airplaneMockedStatic = mockStatic(Airplane.class, CALLS_REAL_METHODS);
        airplaneMockedStatic.when(() -> Airplane.getAirPlaneInfo(3343)).thenReturn(airplane);
    }

    @Test
    @ParameterizedTest
    @ValueSource(strings= {"@test.com"})
    void testBuyTicketEnterInvalidEmail(String input) {

        ticket99 = new Ticket(123, 700, flight, false, null);

        try {
            buyTicket.buyTicket(123);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // Assert null because an invalid email cannot create a passenger success
        assertNull(ticket99.getPassenger());
    }
}
