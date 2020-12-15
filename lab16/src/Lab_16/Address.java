package Lab_16;

public final class Address {
    public String getCityName() {
        return cityName;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public char getBuildingLetter() {
        return buildingLetter;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    private String cityName;
    private String streetName;
    private int zipCode;
    private  int buildingNumber;
    private char buildingLetter;
    private int apartmentNumber;

    Address(String cityName, String streetName, int zipCode, int buildingNumber, char buildingLetter, int apartmentNumber){
        this.cityName=cityName;
        this.streetName=streetName;
        this.zipCode=zipCode;
        this.buildingNumber=buildingNumber;
        this.buildingLetter=buildingLetter;
        this.apartmentNumber=apartmentNumber;
    }
    public static Address EMPTY_ADDRESS = new Address(null, null, 0, 0, (char) 0,
            0);

}
