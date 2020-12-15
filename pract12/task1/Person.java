package pract14.task1;

public class Person {
    private String firstName = "";
    private String lastName = "";

    public Person() {}

    public Person(String firstName) {
        this.firstName = firstName;
    }
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        if (firstName.isEmpty() || lastName.isEmpty())
            return "First name or last name is empty";

        return firstName + " " + lastName;
    }
}
