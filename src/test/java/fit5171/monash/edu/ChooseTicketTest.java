package test.java.fit5171.monash.edu;



import main.java.fit5171.monash.edu.ChooseTicket;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ChooseTicketTest {

    ChooseTicket chooseTicket;

    public ChooseTicketTest() {}

    @BeforeAll
    static void initAll() {
        ChooseTicketTest tester = new ChooseTicketTest();
    }

    @BeforeEach
    void init(){
        this.chooseTicket = new ChooseTicket(){};
    }

    @DisplayName("Input city are nulls")
    @Test
    void testChooseTicketWithNullInputAsCityName() {

        Throwable exception = assertThrows(Exception.class, () -> {
            chooseTicket.chooseTicket(null, null);
        });

        assertTrue(exception.getMessage().contains("Invalid city"));
    }

    @DisplayName("Input city are valid values")
    @Test
    void testChooseTicketWithValidValues() {
        String city1 = "Tokyo";
        String city2 = "Taipei";

        Throwable exception = assertThrows(Exception.class, () -> {
            chooseTicket.chooseTicket(city1, city2);
        });

        assertFalse(exception.getMessage().contains("Invalid city"));
    }

    @DisplayName("Input city are invalid values")
    @Test
    void testChooseTicketWithInValidValues() {
        String city1 = "123";
        String city2 = "Taipei";

        Throwable exception = assertThrows(Exception.class, () -> {
            chooseTicket.chooseTicket(city1, city2);
        });

        assertTrue(exception.getMessage().contains("Invalid city"));
    }

    @DisplayName("Choose an already booked ticket")
    @Test
    void testChoosingAnAlreadyBookedTicket() {
        String city1 = "Tokyo";
        String city2 = "Taipei";
        int input = 1;

        try {
            Throwable exception = assertThrows(Exception.class, () -> {
                chooseTicket.chooseTicket(city1, city2);
                IntegerAsker asker = mock(IntegerAsker.class);
                when(asker.ask(anyString())).thenReturn(input);
            });

            assertFalse(exception.getMessage().contains("Enter a valid"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @DisplayName("Choose a not booked ticket")
    @Test
    void testChoosingAnNotBookedTicket() {
        String city1 = "Tokyo";
        String city2 = "Taipei";
        String userInput = "99";

        try {
            Throwable exception = assertThrows(Exception.class, () -> {
                InputStream input = new ByteArrayInputStream(userInput.getBytes());
                System.setIn(input);
                chooseTicket.chooseTicket(city1, city2);
            });
            assertTrue(exception.getMessage().contains("Enter"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
