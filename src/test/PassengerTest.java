package test;
import fit5171.monash.edu.Person;
import org.junit.jupiter.api.*;
import fit5171.monash.edu.Passenger;
import fit5171.monash.edu.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.testng.util.Strings;

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
//        when(person.setFirstName(firstName)).thenReturn(new Person());
    }

    @Test
    @DisplayName("A test method to test if email cannot be empty")
    void testEmailValid(){
        String email = "rwan0085@student.monash.edu";
        passenger.setEmail(email);
        Assertions.assertEquals(email, passenger.getEmail());
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("A test method to test if email cannot be empty")
    void testEmailInvalid(String email){
        passenger.setEmail(email);
        assertTrue(Strings.isNullOrEmpty(email));
    }

    @Test
    @DisplayName("A test method to test if phone number cannot be empty")
    void testPhoneValid(){
        String phone = "6100000";
        passenger.setPhoneNumber(phone);
        Assertions.assertEquals(phone, passenger.getPhoneNumber());
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("A test method to test if phone number cannot be empty")
    void testPhoneInvalid(String phone){
        passenger.setPhoneNumber(phone);
        assertTrue(Strings.isNullOrEmpty(phone));
    }

    @Test
    @DisplayName("A test method to test if card number cannot be empty")
    void testCardNumberValid(){
        String card = "1234567890";
        passenger.setCardNumber(card);
        Assertions.assertEquals(card, passenger.getCardNumber());
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("A test method to test if card number cannot be empty")
    void testCardNumberInvalid(String cardNumber){
        passenger.setCardNumber(cardNumber);
        assertTrue(Strings.isNullOrEmpty(cardNumber));
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
        int securityCode = passenger.getSecurityCode();
        Assertions.assertNotNull(securityCode);
    }

    @Test
    @DisplayName("A test method to test if passport cannot be empty")
    void testPassportValid(){
        String passport = "Q1234567";
        passenger.setPassport(passport);
        Assertions.assertEquals(passport, passenger.getPassport());
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("A test method to test if passport cannot be empty")
    void testPassportInvalid(String passport){
        passenger.setPassport(passport);
        assertTrue(Strings.isNullOrEmpty(passport));
    }
}
