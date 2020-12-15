package pract15;

public final class Customer {

    private final String firstName;
    private final String secondName;
    private final int age;
    private final Address address;
    private final Customer MATURE_UNKNOWN_CUSTOMER = new Customer(null, null, 18, Address.EMPTY_ADDRESS);
    private final Customer NOT_MATURE_UNKNOWN_CUSTOMER = new Customer( null, null, 0, Address.EMPTY_ADDRESS);

    public Customer(String firstName, String secondName, int age, Address address) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.address = address;
    }

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
}