package fit5171.monash.edu;

import java.util.regex.PatternSyntaxException;

public class Passenger extends Person
{
    private String email;
    private String phoneNumber;
    private String cardNumber;
    private int securityCode;
    private String passport;

    public Passenger(){}

    public Passenger(String firstName, String secondName, int age, String gender,String email, String phoneNumber, String passport, String cardNumber,int securityCode)
    {
        super();
        this.securityCode=securityCode;
        this.cardNumber=cardNumber;
        if (validatePassport(passport))
            this.passport=passport;
        if (validateEmail(email))
            this.email=email;
        if (validatePhoneNumber(phoneNumber))
            this.phoneNumber=phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        try{
            if (!validateEmail(email))
                this.email = email;
        }
        catch (Throwable e) {
            System.out.println("Email pattern invalid");
        }
    }

    public String getFirstName() {
        return super.getFirstName();
    }

    public String getSecondName() {
        return super.getSecondName();
    }

    public void setSecondName(String secondName) {
        super.setSecondName(secondName);
    }

    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }

    public String getPassport() {
        return passport;
    }

    public void setGender(String gender) {
        super.setGender(gender);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }

    @Override
    public void setAge(int age) {
        super.setAge(age);
    }

    public void setPassport(String passport) {
        try{
            if (validatePassport(passport))
                this.passport = passport;
        }
        catch (Throwable e) {
            System.out.println("Passport pattern invalid");
        }
    }

    @Override
    public String getGender() {
        return super.getGender();
    }

    public void setPhoneNumber(String phoneNumber) {
        try{
            if (validatePhoneNumber(phoneNumber))
                this.phoneNumber = phoneNumber;
        }
        catch (Throwable e) {
            System.out.println("Phone number pattern invalid");
        }
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public String toString()
    {
        return "Passenger{" + " Fullname= "+ super.getFirstName()+" "+super.getSecondName()+
                " ,email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", passport='" + passport +
                '}';
    }

    public boolean validatePassport(String passport){
        if (passport.length()<10)
            return true;
        else
            return false;
    }

    public boolean validateEmail(String email) {
        if (email.matches("^(.+)@(\\\\S+)$"))
            return true;
        else
            return false;
    }

    public boolean validatePhoneNumber(String phoneNumber){
        if (phoneNumber.length()==10 && phoneNumber.charAt(0) == '0' && phoneNumber.charAt(1) == '4') {
            return true;
        }
        if (phoneNumber.length() == 12 && phoneNumber.charAt(0) == '+' && phoneNumber.charAt(1) == '6' && phoneNumber.charAt(2) == '1' && phoneNumber.charAt(3) == '4')
            return true;
        else
            return false;
    }
}
