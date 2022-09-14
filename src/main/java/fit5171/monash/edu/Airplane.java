package fit5171.monash.edu;

import java.util.regex.PatternSyntaxException;

public class Airplane
{
    private int airplaneID;
    private String airplaneModel;
    private int businessSitsNumber;
    private int economySitsNumber;
    private int crewSitsNumber;

    public Airplane() {}

    public Airplane(int airplaneID, String airplaneModel, int businessSitsNumber, int economySitsNumber, int crewSitsNumber)
    {
        this.airplaneID = airplaneID;
        this.airplaneModel = airplaneModel;
        if (validateSitsNumber(businessSitsNumber))
            this.businessSitsNumber = businessSitsNumber;
        else
            throw new PatternSyntaxException("Seats number is over range!", "", -1);

        if(validateSitsNumber(economySitsNumber))
            this.economySitsNumber = economySitsNumber;
        else
            throw new PatternSyntaxException("Seats number is over range!", "", -1);

        if(validateSitsNumber(crewSitsNumber))
            this.crewSitsNumber = crewSitsNumber;
        else
            throw new PatternSyntaxException("Seats number is over range!", "", -1);
    }

    public int getAirplaneID() {
        return airplaneID;
    }

    public void setAirplaneID(int airplaneID) {
        this.airplaneID = airplaneID;
    }

    public String getAirplaneModel() {
        return airplaneModel;
    }

    public void setAirplaneModel(String airplaneModel) {
        this.airplaneModel = airplaneModel;
    }

    public int getBusinessSitsNumber() {
        return businessSitsNumber;
    }

    public void setBusinessSitsNumber(int businessSitsNumber) {
        if (validateSitsNumber(businessSitsNumber))
            this.businessSitsNumber = businessSitsNumber;
        else if (businessSitsNumber == 0)
            throw new PatternSyntaxException("Seats number cannot be empty!", "", -1);
        else
            throw new PatternSyntaxException("Seats number is over range!", "", -1);
    }

    public int getEconomySitsNumber() {
        return economySitsNumber;
    }

    public void setEconomySitsNumber(int economSitsNumber) {
        if (validateSitsNumber(economSitsNumber))
            this.economySitsNumber = economSitsNumber;
        else if (economSitsNumber == 0)
            throw new PatternSyntaxException("Seats number cannot be empty!", "", -1);
        else
            throw new PatternSyntaxException("Seats number is over range!", "", -1);
    }

    public int getCrewSitsNumber() {
        return crewSitsNumber;
    }

    public void setCrewSitsNumber(int crewSitsNumber) {
        if (validateSitsNumber(crewSitsNumber))
            this.crewSitsNumber = crewSitsNumber;
        else if (crewSitsNumber == 0)
            throw new PatternSyntaxException("Seats number cannot be empty!", "", -1);
        else
            throw new PatternSyntaxException("Seats number is over range!", "", -1);
    }

    public String toString()
    {
        return "Airplane{" +
                "model=" + getAirplaneModel() + '\'' +
                ", business sits=" + getBusinessSitsNumber() + '\'' +
                ", economy sits=" + getEconomySitsNumber() + '\'' +
                ", crew sits=" + getCrewSitsNumber() + '\'' +
                '}';
    }

    public static Airplane getAirPlaneInfo(int airplane_id) {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean validateSitsNumber(int sitsNumber) {
        int bot = 0;
        int top = 301;
        return sitsNumber > bot && sitsNumber < top;
    }
}