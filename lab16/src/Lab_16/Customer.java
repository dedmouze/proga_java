package Lab_16;

public final class Customer {
    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    Customer(String firstName, String secondName, int age, Address address){
        this.firstName=firstName;
        this.secondName=secondName;
        this.age=age;
        this.address=address;
    }

    private String firstName;
    private String secondName;
    private int age;
    private Address address;
    private static Customer MATURE_UNKNOWN_CUSTOMER = new Customer(null, null, 18, null);
    private static Customer NOT_MATURE_UNKNOWN_CUSTOMER = new Customer(null, null, 17, null);
}
