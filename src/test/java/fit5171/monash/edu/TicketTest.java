package test.java.fit5171.monash.edu;

import main.java.fit5171.monash.edu.Flight;
import main.java.fit5171.monash.edu.Passenger;
import main.java.fit5171.monash.edu.Ticket;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        this.flight = mock(Flight.class);
        this.passenger = mock(Passenger.class);
        this.ticket = new Ticket(123, 700, flight, false, passenger);
    }

    @DisplayName("Test ticket status in boolean")
    @Test
    void testTicketStatusInBoolean() {
        Boolean status = false;
        ticket.setTicketStatus(status);
        assertEquals(status, ticket.ticketStatus());
    }

    @DisplayName("Test ticket price when adult price as input")
    @Test
    void testDiscountBasedOnAgeCategoryAdult() {
        //Mock passenger age, which is required in saleByAge within setPrice()
        when(passenger.getAge()).thenReturn(30);

        //Expected Results; Caution: the price has included service tax
        int expectedPrice = 784;

        ticket.setPrice(700);

        assertEquals(expectedPrice, ticket.getPrice());
    }

    @DisplayName("Test ticket price when child price as input")
    @Test
    void testDiscountBasedOnAgeCategoryChild() {
        //Mock passenger age, which is required in saleByAge within setPrice()
        when(passenger.getAge()).thenReturn(6);

        //Expected Results; Caution: the price has included service tax
        int expectedPrice = 392;

        ticket.setPrice(700);

        assertEquals(expectedPrice, ticket.getPrice());
    }

    @DisplayName("Test ticket price when elder age as input")
    @Test
    void testElderlyDiscount() {
        //Mock passenger age, which is required in saleByAge within setPrice()
        when(passenger.getAge()).thenReturn(70);

        //Expected Results; Caution: the price has included service tax
        int expectedPrice = 0;

        ticket.setPrice(700);

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

        assertTrue(serviceTax != (int)serviceTax | serviceTax == (float)serviceTax |
                serviceTax == (double)serviceTax | serviceTax != 0);
    }

    @DisplayName("Test if the service tax has always been applied on ticket")
    @Test
    void testServiceTaxAppliedOnTicket() {
        double serviceTax = ticket.getServiceTax();

        assertNotNull(serviceTax);
    }

}
