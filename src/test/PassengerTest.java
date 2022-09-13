package test;
import fit5171.monash.edu.Person;
import org.junit.jupiter.api.*;
import fit5171.monash.edu.Passenger;
import fit5171.monash.edu.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Passenger test class")
public class PassengerTest {
    private Passenger passenger;
    private Person person;

    public PassengerTest() {}

    @BeforeAll
    static void initAll(){new PassengerTest();}

    @BeforeEach
    void init(){
        person = mock(Person.class);
        this.passenger = new Passenger() {};
    }

    @Test
    @DisplayName("A test method to test if person class attritube valid")
    void testFirstName(){
        String firstName = "Tim";
//        when(person.setFirstName(firstName)).thenReturn(person);
    }

    @Test
    @DisplayName("A test method to test if email cannot be empty")
    void testEmailValid(){
        String email = "rwan0085@student.monash.edu";
        passenger.setEmail(email);
        Assertions.assertEquals(email, passenger.getEmail());
    }

    @Test
    @DisplayName("A test method to test if email cannot be empty")
    void testEmailInvalid(){
    }

    @Test
    @DisplayName("A test method to test if phone number cannot be empty")
    void testPhoneValid(){
        String phone = "6100000";
        passenger.setPhoneNumber(phone);
        Assertions.assertEquals(phone, passenger.getPhoneNumber());
    }

    @Test
    @DisplayName("A test method to test if phone number cannot be empty")
    void testPhoneInvalid(){
    }

    @Test
    @DisplayName("A test method to test if card number cannot be empty")
    void testCardNumberValid(){
        String card = "1234567890";
        passenger.setCardNumber(card);
        Assertions.assertEquals(card, passenger.getCardNumber());
    }

    @Test
    @DisplayName("A test method to test if card number cannot be empty")
    void testCardNumberInvalid(){
    }

    @Test
    @DisplayName("A test method to test if security code cannot be empty")
    void testSecurityCodeValid(){
        int securityCode = 123;
        passenger.setSecurityCode(securityCode);
        Assertions.assertEquals(securityCode, passenger.getSecurityCode());
    }

    @Test
    @DisplayName("A test method to test if security code cannot be empty")
    void testSecurityCodeInvalid(){
    }

    @Test
    @DisplayName("A test method to test if passport cannot be empty")
    void testPassportValid(){
        String passport = "Q1234567";
        passenger.setPassport(passport);
        Assertions.assertEquals(passport, passenger.getPassport());
    }

    @Test
    @DisplayName("A test method to test if passport cannot be empty")
    void testPassportInvalid(){
    }
}
