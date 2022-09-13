package test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;

import fit5171.monash.edu.Person;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.testng.util.Strings;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Person test class")
public class PersonTest {

    private Person person;

    public PersonTest() {}

    @BeforeAll
    static void initAll(){new PersonTest();}

    @BeforeEach
    void init(){this.person = new Person() {};}

    @Test
    @DisplayName("A test method to test firstName attribute cannot be empty")
    void testFirstNameValid(){
        String firstName = "Tim";
        person.setFirstName(firstName);
        Assertions.assertEquals(firstName, person.getFirstName());
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("A test method to test firstName attribute empty")
    void testFirstNameInvalid(String firstName) {
        person.setFirstName(firstName);
        assertTrue(Strings.isNullOrEmpty(firstName));
    }

    @Test
    @DisplayName("A test method to test secondName attribute cannot be empty")
    void testSecondNameValid(){
        String secondName = "Tam";
        person.setSecondName(secondName);
        Assertions.assertEquals(secondName, person.getSecondName());
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("A test method to test secondName attribute empty")
    void testSecondNameInvalid(String secondName){
        person.setSecondName(secondName);
        assertTrue(Strings.isNullOrEmpty(secondName));
    }

    @Test
    @DisplayName("A test method to test age attribute cannot be empty")
    void testAgeValid(){
        int age = 18;
        person.setAge(age);
        Assertions.assertEquals(age, person.getAge());
    }

    @Test
    @DisplayName("A test method to test age attribute empty")
    void testAgeInvalid(){
        int age = person.getAge();
        Assertions.assertNotNull(age);
    }

    @Test
    @DisplayName("A test method to test if gender can be Male")
    void testMaleGender(){
        String gender = "Male";
        person.setGender(gender);
        Assertions.assertEquals(gender, person.getGender());
    }

    @Test
    @DisplayName("A test method to test if gender can be Female")
    void testFemaleGender(){
        String gender = "Female";
        person.setGender(gender);
        Assertions.assertEquals(gender, person.getGender());
    }

    @Test
    @DisplayName("A test method to test if gender can be Other")
    void testOtherGender(){
        String gender = "Other";
        person.setGender(gender);
        Assertions.assertEquals(gender, person.getGender());
    }

    @Test
    @DisplayName("A test method to test if gender field valid")
    void testGenderInputInvalid(){
        String gender = "Prefer not to say";
        boolean successful = person.validGender(gender);
        Assertions.assertFalse(successful, "Invalid input");
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("A test method to test if gender field empty")
    void testGenderNull(String gender){
        person.setGender(gender);
        assertTrue(Strings.isNullOrEmpty(gender));
    }

    @Test
    @DisplayName("A test method to test if firstName not start with numbers or symbols")
    void testFirstNameLettersInvalid(){
        String firstName = "00Tim";
        boolean successful = person.validateName(firstName);
        Assertions.assertFalse(successful, "Invalid input");
    }

    @Test
    @DisplayName("A test method to test if secondName not start with numbers or symbols")
    void testLastNameLettersInvalid(){
        String secondName = "00Tim";
        boolean successful = person.validateName(secondName);
        Assertions.assertFalse(successful, "Invalid input");
    }
}
