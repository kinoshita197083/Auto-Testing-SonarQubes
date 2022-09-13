package test;


import fit5171.monash.edu.TicketCollection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class TicketCollectionTest {

    TicketCollection ticketCollection;

    public TicketCollectionTest() {}

    @BeforeAll
    static void initAll() {
        TicketCollectionTest tester = new TicketCollectionTest();
    }

    @BeforeEach
    void init(){
        this.ticketCollection = new TicketCollection(){};
    }

    @DisplayName("Test ticket status in boolean")
    @Test
    void testPassengerInformation() {

    }
}
