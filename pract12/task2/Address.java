package pract14.task2;

import java.util.StringTokenizer;

public class Address {
    private String country;
    private String reg;
    private String city;
    private String street;
    private String building;
    private String housing;
    private String apartment;

    private static final int countField = 7;


    private Address(String country, String region, String city, String street, String building, String housing, String apartment) {
        this.country = country;
        this.reg = region;
        this.city = city;
        this.street = street;
        this.building = building;
        this.housing = housing;
        this.apartment = apartment;
    }


    public static Address commaSeparator(String src) throws IllegalArgumentException {
        src = src.trim();
        String[] fields = src.split(", ");

        if (fields.length != countField)
            throw new IllegalArgumentException();

        return new Address(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6]);
    }


    public static Address anySeparator(String src) throws IllegalArgumentException {
        src = src.trim();
        StringTokenizer stringTokenizer = new StringTokenizer(src, " ,.;-");
        String[] fields = new String[7];

        if (stringTokenizer.countTokens() < countField)
            throw new IllegalArgumentException();

        for (int i = 0; i < countField; ++i)
            fields[i] = stringTokenizer.nextToken();

        return new Address(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6]);
    }

    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", region='" + reg + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", building='" + building + '\'' +
                ", housing='" + housing + '\'' +
                ", apartment='" + apartment + '\'' +
                '}';
    }
}
