public class BookTest {
    public static void main(String[] args) {
        Book b0 = new Book("J. London", "Martin Iden", 1909, 1);
        Book b1 = new Book("Alan Alexander Milne", "Winnie-the-Pooh", 1926);
        Book b2 = new Book("HJ.K. Rowling", "Harry Potter and the Philosopher's Stone");
        Book b3 = new Book("Arthur Conan Doyle");        System.out.println(b1);

        Book b4 = new Book();

        System.out.println(b0 + "\n");

        System.out.println(b1);
        b1.setRating(5);
        System.out.println(b1 + "\n");

        System.out.println(b2);
        b2.setYear_of_publish(1992);
        System.out.println(b2 + "\n");

        b3.setTitle("The Adventures of Sherlock Holmes");
        System.out.println(b3);
    }
}
