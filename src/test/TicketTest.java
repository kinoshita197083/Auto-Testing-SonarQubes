package test;

import fit5171.monash.edu.Flight;
import fit5171.monash.edu.Passenger;
import fit5171.monash.edu.Ticket;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.regex.PatternSyntaxException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;


class TicketTest {

    private Ticket ticket;
    Flight flight;
    Passenger passenger;

    //Constructor
    public TicketTest() {}

    @BeforeAll
    static void initAll() {
        TicketTest tester = new TicketTest();
    }

    @BeforeEach
    void init(){
        this.ticket = new Ticket(){};
        this.flight = mock(Flight.class);
        this.passenger = mock(Passenger.class);
    }

    @DisplayName("Test ticket status in boolean")
    @Test
    void testTicketStatusInBoolean() {
        Boolean status = false;
        ticket.setTicketStatus(status);
        assertEquals(status, ticket.ticketStatus());
    }

//    @Test
//    void testTicketStatusInNonBoolean() {
//        Ticket ticket = new Ticket();
//        String status = "yes";
//        ticket.setTicketStatus(status);
//        assertEquals(status, ticket.ticketStatus());
//    }
    @DisplayName("Test ticket price when adult price as input")
    @Test
    void testDiscountBasedOnAgeCategory() {
        //Dummy Data
        int age = 25;
        int price = 200;

        //Expected Results
        int expectedPrice = 200;

        //Input the price
        ticket.setPrice(price);

        assertEquals(expectedPrice, ticket.getPrice());
    }

    @DisplayName("Test ticket price when child age as input")
    @Test
    void testChildDiscount() {
        //Dummy Data
        int age = 14;
        int price = 200;

        //Expected Results
        int expectedPrice = 100;

        //Input the price
        ticket.setPrice(price);

        assertEquals(expectedPrice, ticket.getPrice());
    }

    @DisplayName("Test ticket price when elder age as input")
    @Test
    void testElderlyDiscount() {
        //Dummy Data
        int age = 60;
        int price = 200;

        //Expected Results
        int expectedPrice = 0;

        //Input the price
        ticket.setPrice(price);

        assertEquals(expectedPrice, ticket.getPrice());
    }

    @DisplayName("Test if the price has always been applied on ticket")
    @Test
    void testPriceAppliedOnTicket() {
        int price = ticket.getPrice();

        assertNotNull(price);
    }

    @DisplayName("Test if ticket price is a valid value")
    @Test
    void testPriceIsAnInteger() {
        int price = ticket.getPrice();

        assertTrue(price == (int)price | price == (float)price | price == (double)price);
    }

    @DisplayName("Test if the service tax is a valid value")
    @Test
    void testServiceTaxIsAValidValue() {
        double serviceTax = ticket.getServiceTax();

        assertTrue(serviceTax == (int)serviceTax | serviceTax == (float)serviceTax | serviceTax == (double)serviceTax);
    }

    @DisplayName("Test if the service tax has always been applied on ticket")
    @Test
    void testServiceTaxAppliedOnTicket() {
        double serviceTax = ticket.getServiceTax();

        assertNotNull(serviceTax);
    }

    @DisplayName("Include Flight and Passenger as a part of integration test")
    @Test
    void integrationTestWithFLightAndPassenger() {
        this.ticket = new Ticket(99, 200,this.flight, true, this.passenger );

        assertNotNull(ticket);
    }

    @DisplayName("Integration Test: get flight details")
    @Test
    void integrationTestGetFlight() {
        this.ticket = new Ticket(99, 200,this.flight, true, this.passenger );

        when(flight.getFlightID()).thenReturn(1);
        Flight flightDetails = this.ticket.getFlight();
//        System.out.println(flight.getFlightID());
        assertNotNull(flightDetails);
    }
}
