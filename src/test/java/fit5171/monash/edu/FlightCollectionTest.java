package fit5171.monash.edu;

import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;

import java.sql.Timestamp;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FlightCollectionTest {

    FlightCollection flightCollection;
    private static Airplane airplane = new Airplane(1, "A120", 1, 1, 1);
    private static Flight flight = new Flight(123, "MEL", "SYD", "D", "Jetstar",
            Timestamp.valueOf("2022-09-03 10:10:10.0"), Timestamp.valueOf("2022-09-03 10:10:10.0"), airplane);

    private MockedStatic<FlightCollection> mFlightCollection;

    public FlightCollectionTest() {}

    @BeforeAll
    static void initAll() {
        new FlightCollectionTest();
    }

    @BeforeEach
    void init() {
        Flight mFlight = mock(Flight.class);
        this.mFlightCollection = mockStatic(FlightCollection.class, CALLS_REAL_METHODS);
    }

    @AfterEach
    void after() {
        mFlightCollection.close();
    }

    @DisplayName("Test adding a valid flight into flightCollection")
    @Test
    void testAddingFlight() {
        ArrayList<Flight> flights = new ArrayList<Flight>();
        flights.add(flight);
        FlightCollection.addFlights(flights);
    }

    @DisplayName("Test adding an invalid flight into flightCollection")
    @Test
    void testAddingInvalidFlight() {
        ArrayList<Flight> flights = new ArrayList<Flight>();
        flights.add(null);

        try {
            FlightCollection.addFlights(flights);
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Invalid"));
        }
    }

    @DisplayName("Test getting flights information with two cities")
    @Test
    void testGetFlightInfoByTwoCities() {
        mFlightCollection.when(() -> FlightCollection.getFlightInfo(anyString())).thenReturn(flight);

        try {
            Flight testFlight = FlightCollection.getFlightInfo(flight.getDepartFrom(), flight.getDepartTo());
            assertTrue(testFlight != null);
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    @DisplayName("Test getting flights information with invalid cities")
    @Test
    void testGetFlightInfoByInvalidCities() {
        try {
            Flight testFlight = FlightCollection.getFlightInfo("BNE", "PER");
        } catch(Exception e) {
            assertTrue(e.getMessage().contains("This flight does not exist"));
        }
    }

    @DisplayName("Test getting flights information with departTo")
    @Test
    void testGetFlightInfoByDepartTo() {
        mFlightCollection.when(() -> FlightCollection.getFlightInfo(anyString())).thenReturn(flight);

        try {
            Flight testFlight = FlightCollection.getFlightInfo(flight.getDepartTo());
            assertTrue(testFlight != null);
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    @DisplayName("Test getting flights information with invalid departTo")
    @Test
    void testGetFlightInfoByInvalidDepartTo() {
        try {
            Flight testFlight = FlightCollection.getFlightInfo("BNE");
        } catch(Exception e) {
            assertTrue(e.getMessage().contains("This flight does not exist"));
        }
    }

    @DisplayName("Test getting flights information with flightID")
    @Test
    void testGetFlightInfoFlightID() {
        mFlightCollection.when(() -> FlightCollection.getFlightInfo(anyInt())).thenReturn(flight);

        try {
            Flight testFlight = FlightCollection.getFlightInfo(flight.getFlightID());
            assertTrue(testFlight != null);
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    @DisplayName("Test getting flights information with invalid flightID")
    @Test
    void testGetFlightInfoByInvalidFlightID() {
        try {
            Flight testFlight = FlightCollection.getFlightInfo(0);
        } catch(Exception e) {
            assertTrue(e.getMessage().contains("This flight does not exist"));
        }
    }
}