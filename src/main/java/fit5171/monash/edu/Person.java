package fit5171.monash.edu;


public class Person //abstract class Person
{
    private String firstName;
    private String secondName;
    private int age;
    private String gender;

    public Person(){}

    public Person(String firstName, String secondName, int age, String gender){
        this.age=age;
        if (validateName(firstName))
            this.firstName=firstName;
        if (validateName(secondName))
            this.secondName=secondName;
        if (validateGender(gender))
            this.gender=gender;
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
        try{
            if (validateGender(gender))
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
        try{
            if (validateName(firstName))
                this.firstName = firstName;
        }
        catch (Throwable e) {
            System.out.println("Field cannot be empty");
        }
    }

    public void setSecondName(String secondName) {
        try{
            if (validateName(secondName))
                this.secondName = secondName;
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

    public boolean validateName (String name) {
        if (Character.isLetter(name.charAt(0)))
            return true;
        else
            return false;
//        return name.matches("^(?!.*[-_]{2})(?=.*[a-z0-9]$)[a-z0-9][a-z0-9_-]*$");
    }

    public boolean validateGender (String gender) throws NullPointerException {
        if (gender.equals("Female") || gender.equals("Male") || gender.equals("Other"))
            return true;
        else
            return false;
    }
}
