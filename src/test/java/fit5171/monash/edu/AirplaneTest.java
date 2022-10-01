package fit5171.monash.edu;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.PatternSyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class AirplaneTest {

    private Airplane airplane;

    public AirplaneTest () {}

    @BeforeAll
    static void initAll() {
        new AirplaneTest();
    }

    @BeforeEach
    void init() {
        this.airplane = new Airplane();
    }

    @Test
    @DisplayName("Test the airplaneID cannot be empty")
    void testSetAirplaneIDValid() {
        int airplaneID = 1234;
        airplane.setAirplaneID(airplaneID);
        assertEquals(airplaneID, airplane.getAirplaneID());
    }

    @DisplayName("Test the airplaneID is empty")
    @Test
    public void testSetAirplaneIDInvalid() {
        int airplaneID = 0;
        airplane.setAirplaneID(airplaneID);
        assertEquals(airplaneID, airplane.getAirplaneID());
    }

    @Test
    @DisplayName("Test the airplaneModel cannot be empty")
    void testSetAirplaneModelValid() {
        String airplaneModel = "A123";
        airplane.setAirplaneModel(airplaneModel);
        assertEquals(airplaneModel, airplane.getAirplaneModel());
    }

    @Test
    @DisplayName("Test the airplaneModel is empty")
    void testSetAirplaneModelInvalid() {
        String airplaneModel = "";
        airplane.setAirplaneModel(airplaneModel);
        assertFalse(airplane.getAirplaneModel().isEmpty());
    }

    @Test
    @DisplayName("Test the businessSitsNumber cannot be empty")
    void testSetBusinessSitsNumberValid() {
        int businessSitsNumber = 12;
        airplane.setBusinessSitsNumber(businessSitsNumber);
        assertEquals(businessSitsNumber, airplane.getBusinessSitsNumber());
    }

    @Test
    @DisplayName("Test the businessSitsNumber is empty")
    void testSetBusinessSitsNumberInvalid() {
        int businessSitsNumber = 0;
        airplane.setBusinessSitsNumber(businessSitsNumber);
        assertEquals(businessSitsNumber, airplane.getBusinessSitsNumber());
    }

    @Test
    @DisplayName("Test the businessSitsNumber is not in range [1, 300]")
    void testSetBusinessSitsNumberOverRange() {
        int businessSitsNumber = 301;
        airplane.setBusinessSitsNumber(businessSitsNumber);
        assertThrows(PatternSyntaxException.class, () -> {
            airplane.setBusinessSitsNumber(businessSitsNumber);
        });
    }

    @Test
    @DisplayName("Test the economySitsNumber cannot be empty")
    void testSetEconomySitsNumberValid() {
        int economySitsNumber = 13;
        airplane.setEconomySitsNumber(economySitsNumber);
        assertEquals(economySitsNumber, airplane.getEconomySitsNumber());
    }

    @Test
    @DisplayName("Test the economySitsNumber is empty")
    void testSetEconomySitsNumberInvalid() {
        int economySitsNumber = 0;
        airplane.setEconomySitsNumber(economySitsNumber);
        assertEquals(economySitsNumber, airplane.getEconomySitsNumber());
    }

    @Test
    @DisplayName("Test the economySitsNumber is not in range [1, 300]")
    void testSetEconomySitsNumberOverRange() {
        int economySitsNumber = 302;
        airplane.setEconomySitsNumber(economySitsNumber);
        assertThrows(PatternSyntaxException.class, () -> {
            airplane.setEconomySitsNumber(economySitsNumber);
        });
    }

    @Test
    @DisplayName("Test the crewSitsNumber cannot be empty")
    void testSetCrewSitsNumberValid() {
        int crewSitsNumber = 14;
        airplane.setCrewSitsNumber(crewSitsNumber);
        assertEquals(crewSitsNumber, airplane.getCrewSitsNumber());
    }

    @Test
    @DisplayName("Test the crewSitsNumber is empty")
    void testSetCrewSitsNumberInvalid() {
        int crewSitsNumber = 0;
        airplane.setCrewSitsNumber(crewSitsNumber);
        assertEquals(crewSitsNumber, airplane.getCrewSitsNumber());
    }

    @Test
    @DisplayName("Test the crewSitsNumber is not in range [1, 300]")
    void testSetCrewSitsNumberOverRange() {
        int crewSitsNumber = 303;
        airplane.setCrewSitsNumber(crewSitsNumber);
        assertThrows(PatternSyntaxException.class, () -> {
            airplane.setCrewSitsNumber(crewSitsNumber);
        });
    }
}