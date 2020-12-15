package pract14.task4;

public class TestNumbers {

    public static void main(String[] args) {
        System.out.println("From international: ");
        System.out.println(Numbers.fromInternational("+420503334455").toUnique());

        System.out.println("From *RUSSIAN*:");
        System.out.println(Numbers.fromRussian("89175655655").toUnique());
    }
}
