
public class Book {
    private String author;
    private String title;
    private int year_of_publish;
    private int rating;

    public Book(String author, String title, int year_of_publish, int rating)
    {
        this.author = author;
        this.title = title;
        this.year_of_publish = year_of_publish;
        this.rating = rating;
    }

    public Book(String author, String title, int year_of_publish)
    {
        this.author = author;
        this.title = title;
        this.year_of_publish = year_of_publish;
        rating = 0;
    }

    public Book(String author, String title)
    {
        this.author = author;
        this.title = title;
        year_of_publish = 0;
        rating = 0;
    }

    public Book(String author)
    {
        this.author = author;
        title = "Test title";
        year_of_publish = 0;
        rating = 0;
    }

    public Book()
    {
        author = "Test author";
        title = "Test title";
        year_of_publish = 0;
        rating = 0;
    }

    public void setAuthor(String author) { this.author = author; }
    public void setTitle(String title) { this.title = title; }
    public void setYear_of_publish(int year) { this.year_of_publish = year; }
    public void setRating(int rating) { this.rating = rating; }

    public String getAuthor() { return author; }
    public String getTitle() { return  title; }
    public int getYear_of_publish() { return year_of_publish; }
    public int getRating() { return rating; }

    public String toString() {
        return "\"" + this.title + "\" "
                + this.author
                + " year of publishing: " + this.year_of_publish
                + " rating: " + rating;
    }
}