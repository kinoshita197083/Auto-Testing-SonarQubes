package test.java.fit5171.monash.edu;

import main.java.fit5171.monash.edu.*;
import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BuyTicketTest {

    private BuyTicket buyTicket;

    public BuyTicketTest() {}

    @BeforeAll
    static void initAll() {
        BuyTicketTest tester = new BuyTicketTest();
    }

    @BeforeEach
    void init() {
        this.buyTicket = new BuyTicket();
    }

    @AfterEach
    public void tearDown(){
        buyTicket = null;
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
    void testBuyTicketWithValidTicketId(){
        Passenger passenger = new Passenger("Lee", "Bruce", 35, "Male", "test@email.com", "0400000000", "Q1234567", "asd", 123);
        Airplane airplane = new Airplane(3343, "A330", 8, 72, 6);
        Flight flight = new Flight(99, "Osaka", "Okinawa", "OK9900", "OSK Airline",
                Timestamp.valueOf("2022-09-03 10:10:10.0"), Timestamp.valueOf("2022-09-03 10:10:10.0"), airplane);
        Ticket ticket99 = new Ticket(123, 700, flight, false, passenger);

        //Mock ticket collection for returning a dummy ticket_id
        MockedStatic<TicketCollection> mockedTicketCollection = mockStatic(TicketCollection.class, CALLS_REAL_METHODS);
        mockedTicketCollection.when(() -> TicketCollection.getTicketInfo(anyInt())).thenReturn(ticket99);

        //Valid ticket info should be display
        assertEquals(123, ticket99.getTicket_id());
        assertEquals(700, ticket99.getPrice());
    }

    @Test
    void testBuyTicketWithInvalidFlight() {
        //A dummy ticket for testing: no flight is attached
        Passenger passenger = new Passenger("Lee", "Bruce", 35, "Male", "test@email.com", "0400000000", "Q1234567", "asd", 123);
        Airplane airplane = new Airplane(3343, "A330", 8, 72, 6);
        Flight flight = new Flight(99, "Osaka", "Okinawa", "OK9900", "OSK Airline",
                Timestamp.valueOf("2022-09-03 10:10:10.0"), Timestamp.valueOf("2022-09-03 10:10:10.0"), airplane);
        Ticket ticket99 = new Ticket(123, 700, flight, false, passenger);
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

    @Test
    void testBuyTicketWithValidFlight() {
        //A dummy ticket for testing: valid flight is attached
        Passenger passenger = new Passenger("Lee", "Bruce", 35, "Male", "test@email.com", "0400000000", "Q1234567", "asd", 123);
        Airplane airplane = new Airplane(3343, "A330", 8, 72, 6);
        Flight flight = new Flight(99, "Osaka", "Okinawa", "OK9900", "OSK Airline",
                Timestamp.valueOf("2022-09-03 10:10:10.0"), Timestamp.valueOf("2022-09-03 10:10:10.0"), airplane);
        Ticket validTicket = new Ticket(999, 700, flight, false, passenger);

        //Mock ticket collection for returning a dummy ticket_id
        MockedStatic<TicketCollection> mockedTicketCollection = mockStatic(TicketCollection.class, CALLS_REAL_METHODS);
        mockedTicketCollection.when(() -> TicketCollection.getTicketInfo(999)).thenReturn(validTicket);

        //Valid flight info should be found
        assertEquals(99, validTicket.getFlight().getFlightID());
        assertEquals("Okinawa", validTicket.getFlight().getDepartFrom());
        assertEquals("Osaka", validTicket.getFlight().getDepartTo());
        assertEquals("OK9900", validTicket.getFlight().getCode());
        assertEquals("OSK Airline", validTicket.getFlight().getCompany());
    }

    @Test
    void testBuyTicketWithInvalidPassenger() {
        //A dummy ticket for testing: no passenger is attached
        Airplane airplane = new Airplane(3343, "A330", 8, 72, 6);
        Flight flight = new Flight(99, "Osaka", "Okinawa", "OK9900", "OSK Airline",
                Timestamp.valueOf("2022-09-03 10:10:10.0"), Timestamp.valueOf("2022-09-03 10:10:10.0"), airplane);
        Ticket invalidTicket = new Ticket(999, 700, flight, false, null);

        //Mock ticket collection for returning a dummy ticket_id
        MockedStatic<TicketCollection> mockedTicketCollection = mockStatic(TicketCollection.class, CALLS_REAL_METHODS);
        mockedTicketCollection.when(() -> TicketCollection.getTicketInfo(999)).thenReturn(invalidTicket);

        //Passenger info should be null
        assertNull(invalidTicket.getPassenger());
    }

    @Test
    void testBuyTicketWithValidPassenger() {
        //A dummy ticket for testing: valid passenger is attached
        Passenger passenger = new Passenger("Lee", "Bruce", 35, "Male", "test@email.com", "0400000000", "Q1234567", "asd", 123);
        Airplane airplane = new Airplane(3343, "A330", 8, 72, 6);
        Flight flight = new Flight(99, "Osaka", "Okinawa", "OK9900", "OSK Airline",
                Timestamp.valueOf("2022-09-03 10:10:10.0"), Timestamp.valueOf("2022-09-03 10:10:10.0"), airplane);
        Ticket validTicket = new Ticket(999, 700, flight, false, passenger);

        //Mock ticket collection for returning a dummy ticket_id
        MockedStatic<TicketCollection> mockedTicketCollection = mockStatic(TicketCollection.class, CALLS_REAL_METHODS);
        mockedTicketCollection.when(() -> TicketCollection.getTicketInfo(999)).thenReturn(validTicket);

        //Valid passenger info should be found
        assertEquals("Lee", validTicket.getPassenger().getFirstName());
        assertEquals("Bruce", validTicket.getPassenger().getSecondName());
        assertEquals(35, validTicket.getPassenger().getAge());
        assertEquals("Q1234567", validTicket.getPassenger().getPassport());
        assertEquals("0400000000", validTicket.getPassenger().getPhoneNumber());
        assertEquals("Male", validTicket.getPassenger().getGender());
    }

    @Test
    void testBuyTicketWithValidBill(){
        Passenger passenger = new Passenger("Lee", "Bruce", 35, "Male", "test@email.com", "0400000000", "Q1234567", "asd", 123);
        Airplane airplane = new Airplane(3343, "A330", 8, 72, 6);
        Flight flight = new Flight(99, "Osaka", "Okinawa", "OK9900", "OSK Airline",
                Timestamp.valueOf("2022-09-03 10:10:10.0"), Timestamp.valueOf("2022-09-03 10:10:10.0"), airplane);
        Ticket ticket99 = new Ticket(123, 700, flight, false, passenger);

        //Mock ticket collection for returning a dummy ticket_id
        MockedStatic<TicketCollection> mockedTicketCollection = mockStatic(TicketCollection.class, CALLS_REAL_METHODS);
        mockedTicketCollection.when(() -> TicketCollection.getTicketInfo(anyInt())).thenReturn(ticket99);

        //Valid ticket & can retrieve all info related to the ticket
        assertEquals(123, ticket99.getTicket_id());
        assertEquals("Osaka", ticket99.getFlight().getDepartTo());
        assertEquals("Okinawa", ticket99.getFlight().getDepartFrom());
        assertEquals(false, ticket99.getClassVip());
        assertEquals("Lee", ticket99.getPassenger().getFirstName());

        //display valid bill to customer
        assertEquals(700, ticket99.getPrice());
    }
}
