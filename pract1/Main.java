package pract1;

public class Main {

    public static void main(String[] args) {
        BookPr1 b1 = new BookPr1("Alan Alexander Milne", "Winnie-the-Pooh", 1926);
        BookPr1 b2 = new BookPr1("HJ.K. Rowling", "Harry Potter and the Philosopher's Stone");
        BookPr1 b3 = new BookPr1("Arthur Conan Doyle");
        BookPr1 b4 = new BookPr1();

        b3.setTitle("The Adventures of Sherlock Holmes");
        System.out.println(b1);
    }
}
