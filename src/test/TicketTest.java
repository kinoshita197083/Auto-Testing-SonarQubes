package test;

import fit5171.monash.edu.Passenger;
import fit5171.monash.edu.Ticket;
import org.junit.jupiter.api.Test;
import java.util.regex.PatternSyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class TicketTest {

    @Test
    void testTicketStatusInBoolean() {
        Ticket ticket = new Ticket();
        Boolean status = false;
        ticket.setTicketStatus(status);
        assertEquals(status, ticket.ticketStatus());
    }

//    @Test
//    void testTicketStatusInNonBoolean() {
//        Ticket ticket = new Ticket();
//        String status = "false";
//        ticket.setTicketStatus(status);
//        assertEquals(status, ticket.ticketStatus());
//    }



}
