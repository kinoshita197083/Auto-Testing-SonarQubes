package fit5171.monash.edu;

import java.util.regex.PatternSyntaxException;

public abstract class Person //abstract class Person
{
    private String firstName;
    private String secondName;
    private int age;
    private String gender;

    public Person(){}

    public Person(String firstName, String secondName, int age, String gender){
//        try {
            this.age=age;
            if (validateName(firstName))
                this.firstName=firstName;
            else
                throw new PatternSyntaxException("Name cannot start with numbers or symbols", "", -1);
            if (validateName(secondName))
                this.secondName=secondName;
            else
                throw new PatternSyntaxException("Name cannot start with numbers or symbols", "", -1);
            if (validGender(gender))
                this.gender=gender;
//        } catch (NullPointerException e) {
//            System.out.println("Field cannot be empty");
//        }
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age)  {
        try {
            this.age = age;
        }
        catch (Throwable e) {
            System.out.println("Field cannot be empty");
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        try {
            this.gender = gender;
        }
        catch (Throwable e) {
            System.out.println("Field cannot be empty");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setFirstName(String firstName){
//        try {
            if (validateName(firstName))
                this.firstName = firstName;
            else
                throw new PatternSyntaxException("Name cannot start with numbers or symbols", "", -1);
//        }
//        catch (Throwable e) {
//            System.out.println("Field cannot be empty");
//        }
    }

    public void setSecondName(String secondName) {
        try {
            if (validateName(secondName))
                this.secondName = secondName;
            else
                throw new PatternSyntaxException("Name cannot start with numbers or symbols", "", -1);
        }
        catch (Throwable e) {
            System.out.println("Field cannot be empty");
        }
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public boolean validateName (String name) throws NullPointerException {
        return name.matches("^(?!.*[-_]{2})(?=.*[a-z0-9]$)[a-z0-9][a-z0-9_-]*$");
    }

    public boolean validGender (String gender) throws NullPointerException {
        if (gender.equals("Female") || gender.equals("Male") || gender.equals("Other"))
            return true;
        else
            return false;
    }
}
