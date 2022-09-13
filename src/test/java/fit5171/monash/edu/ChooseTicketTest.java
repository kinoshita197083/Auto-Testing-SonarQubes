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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

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

    @DisplayName("Input cities are valid value")
    @Test
    void testCityWithValidValue() {

        Throwable exception = assertThrows(Exception.class, () -> {
            chooseTicket.chooseTicket("Tokyo", "Sydney");
        });
        assertEquals(Exception.class, exception.getMessage());
    }

    @DisplayName("Input city are invalid value")
    @ParameterizedTest
    @NullSource
    @Test
    void testCityWithInValidValue(String city1, String city2) {

        Throwable exception = assertThrows(Exception.class, () -> {
            chooseTicket.chooseTicket(city1, city2);
        });

        assertEquals(exception.getMessage(), exception.getMessage());
    }
}
