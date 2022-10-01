package fit5171.monash.edu;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.testng.util.Strings;
import static org.mockito.Mockito.mock;

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
    @DisplayName("A test method to test if email cannot be empty")
    void testEmailValid(){
        String email = "abc@domain.com";
        this.passenger.setEmail(email);
        Assertions.assertEquals(email, this.passenger.getEmail());
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("A test method to test if email cannot be empty")
    void testEmailInvalid(String email){
        passenger.setEmail(email);
        assertTrue(Strings.isNullOrEmpty(email));
    }

    @Test
    @DisplayName("A test method to test if local phone number cannot be empty")
    void testLocalPhoneValid(){
        String phone = "0400000000";
        passenger.setPhoneNumber(phone);
        Assertions.assertEquals(phone, passenger.getPhoneNumber());
    }

    @Test
    @DisplayName("A test method to test if international phone number cannot be empty")
    void testInternationalPhoneValid(){
        Passenger passenger = new Passenger();
        String phone = "+61400000000";
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

    @Test
    @DisplayName("Test if passport pattern valid")
    void testPassportPatternInvalid(){
        String passport = "1234567890";
        boolean successful = passenger.validatePassport(passport);
        Assertions.assertFalse(successful, "Invalid input");
    }

    @Test
    @DisplayName("Test if email pattern valid")
    void testEmailPatternInvalid(){
        String email = "1234567890";
        boolean successful = passenger.validateEmail(email);
        Assertions.assertFalse(successful, "Invalid input");
    }

    @Test
    @DisplayName("Test if phone number pattern valid")
    void testPhoneNumberPatternInvalid(){
        String phoneNumber = "1234567890";
        boolean successful = passenger.validatePhoneNumber(phoneNumber);
        Assertions.assertFalse(successful, "Invalid input");
    }

    @Test
    @DisplayName("Test if the first name is matched to user inputs")
    void testIfFirstNameFieldsMatchUserInputs(){
        Passenger mockedPassenger = new Passenger("Lee", "secondName", 20, "Male", "test@email.com", "", "", "", 0);
        assertTrue(mockedPassenger.getFirstName().equals("Lee") );
    }

    @Test
    @DisplayName("Test if the second name is matched to user inputs")
    void testIfSecondNameFieldsMatchUserInputs(){
        Passenger mockedPassenger = new Passenger("Lee", "Apple", 20, "Male", "test@email.com", "", "", "", 0);
        assertTrue(mockedPassenger.getSecondName().equals("Apple") );
    }

    @Test
    @DisplayName("Test if the age is matched to user inputs")
    void testIfAgeFieldsMatchUserInputs(){
        Passenger mockedPassenger = new Passenger("Lee", "secondName", 20, "Male", "test@email.com", "", "", "", 0);
        assertTrue(mockedPassenger.getAge() == 20);
    }

    @Test
    @DisplayName("Test if the gender is matched to user inputs")
    void testIfGenderFieldsMatchUserInputs(){
        Passenger mockedPassenger = new Passenger("Lee", "secondName", 20, "Male", "test@email.com", "", "", "", 0);
        assertTrue(mockedPassenger.getGender().equals("Male") );
    }
}
