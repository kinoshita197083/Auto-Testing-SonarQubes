package fit5171.monash.edu;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.regex.PatternSyntaxException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FlightTest {

    private Flight flight;
    Airplane airplane;
    Flight mFlight;

    public FlightTest() {
    }

    @BeforeAll
    static void initAll() {
        new FlightTest();
    }

    @BeforeEach
    void init() {
        airplane = mock(Airplane.class);
        mFlight = mock(Flight.class);
        flight = new Flight(123, "MEL", "SYD", "D", "Jetstar",
                Timestamp.valueOf("2022-09-03 10:10:10.0"), Timestamp.valueOf("2022-09-03 10:10:10.0"), airplane);
    }

    @DisplayName("Test the flightID is empty")
    @Test
    void testFlightIDIsEmpty() {
        when(mFlight.getFlightID()).thenReturn(0);
        assertThrows(PatternSyntaxException.class, () -> flight.getFlightID(), "Invalid Flight!");
    }

    @DisplayName("Test the departTo cannot be empty")
    @Test
    void testDepartTo() {
        assertNotNull(flight.getDepartTo());
    }

    @DisplayName("Test the departTo is empty")
    @Test
    void testDepartToIsEmpty() {
        when(mFlight.getDepartTo()).thenReturn(null);
        assertThrows(PatternSyntaxException.class, () -> flight.getDepartTo(), "Invalid Flight!");
    }

    @DisplayName("Test the departFrom cannot be empty")
    @Test
    void testDepartFrom() {
        assertNotNull(flight.getDepartFrom());
    }

    @DisplayName("Test the departFrom is empty")
    @Test
    void testDepartFromIsEmpty() {
        when(mFlight.getDepartFrom()).thenReturn(null);
        assertThrows(PatternSyntaxException.class, () -> flight.getDepartFrom(), "Invalid Flight!");
    }

    @DisplayName("Test the code cannot be empty")
    @Test
    void testCode() {
        assertNotNull(flight.getCode());
    }

    @DisplayName("Test the code is empty")
    @Test
    void testCodeIsEmpty() {
        when(mFlight.getCode()).thenReturn(null);
        assertThrows(PatternSyntaxException.class, () -> flight.getCode(), "Invalid Flight!");
    }

    @DisplayName("Test the company cannot be empty")
    @Test
    void testCompany() {
        assertNotNull(flight.getCompany());
    }

    @DisplayName("Test the company is empty")
    @Test
    void testCompanyIsEmpty() {
        when(mFlight.getCompany()).thenReturn(null);
        assertThrows(PatternSyntaxException.class, () -> flight.getCompany(), "Invalid Flight!");
    }

    @DisplayName("Test the dateFrom cannot be empty")
    @Test
    void testDateFrom() {
        assertNotNull(flight.getDateFrom());
    }

    @DisplayName("Test the dateFrom is empty")
    @Test
    void testDateFromIsEmpty() {
        when(mFlight.getDateFrom()).thenReturn(null);
        assertThrows(PatternSyntaxException.class, () -> flight.getDateFrom(), "Invalid Flight!");
    }

    @DisplayName("Test the dateTo cannot be empty")
    @Test
    void testDateTo() {
        assertNotNull(flight.getDateTo());
    }

    @DisplayName("Test the dateTo is empty")
    @Test
    void testDateToEmpty() {
        when(mFlight.getDateTo()).thenReturn(null);
        assertThrows(PatternSyntaxException.class, () -> flight.getDateTo(), "Invalid Flight!");
    }

    @DisplayName("Test the airplane cannot be empty")
    @Test
    void testAirplane() {
        assertNotNull(flight.getAirplane());
    }

    @DisplayName("Test the airplane is empty")
    @Test
    void testAirplaneIsEmpty() {
        when(mFlight.getAirplane()).thenReturn(null);
        assertThrows(PatternSyntaxException.class, () -> flight.getAirplane(), "Invalid Flight!");
    }

    @DisplayName("Test the application can accept the date in DD/MM/YY format")
    @Test
    void testAcceptDateFormat() {
        Timestamp dateTo = flight.getDateTo();
        assertEquals(String.format("%d/%d/%d", dateTo.getDate(), dateTo.getMonth() + 1, dateTo.getYear() + 1900),
                flight.getDateTo().toString());
    }

    @DisplayName("Test the application can recognize the date in MM/DD/YY format")
    @Test
    void testRecognizeDateFormat() {
        Timestamp dateTo = flight.getDateTo();
        assertEquals(String.format("%d/%d/%d", dateTo.getMonth() + 1, dateTo.getDate(), dateTo.getYear() + 1900),
                flight.getDateTo().toString());
    }

    @DisplayName("Test the airplane is existed already")
    @Test
    void testAirplaneExist() {
        when(mFlight.getAirplane()).thenReturn(airplane);
        assertNotNull(mFlight.getAirplane());
    }
}