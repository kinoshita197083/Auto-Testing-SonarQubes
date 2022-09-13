package test;


import fit5171.monash.edu.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.sql.Timestamp;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TicketCollectionTest {

    TicketCollection ticketCollection;
    private static Airplane airplane = new Airplane(7777, "A380", 4, 49, 7);
    private static Flight flight = new Flight(1, "Tokyo", "Sydney", "SY7700", "OSX Airline",
            Timestamp.valueOf("2001-09-23 10:10:10.0"), Timestamp.valueOf("2001-09-23 10:10:10.0"), airplane);
    private static Passenger passenger1 = new Passenger("Lee", "secondName", 20, "Male", "test@email.com", "", "", "", 0);
    private static Ticket ticket1 = new Ticket(1111, 700, flight, false, passenger1);

    public TicketCollectionTest() {}

    @BeforeAll
    static void initAll() {
        TicketCollectionTest tester = new TicketCollectionTest();
    }

    @BeforeEach
    void init(){
//        MockedStatic<Airplane> airplaneMockedStatic = mockStatic(Airplane.class, CALLS_REAL_METHODS);
        Ticket mockedTicket = mock(Ticket.class);
    }

    @DisplayName("Add Valid Ticket into db")
    @Test
    void validTicketAddedIntoTicketCollection() {
        //Initiate a test ticket array
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        tickets.add(ticket1);

        TicketCollection.addTickets(tickets);
    }

    @DisplayName("Add Invalid Ticket into db")
    @Test
    void invalidateTicketIntoTicketCollection() {
        //Initiate a test ticket array
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        tickets.add(null);

        Throwable exception = assertThrows(java.lang.NullPointerException.class, () -> {
            TicketCollection.addTickets(tickets);
        });

        assertEquals(NullPointerException.class, exception.getMessage());
    }
}
