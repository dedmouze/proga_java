package pract1;

public class BookPr1 {
    private String author;
    private String title;
    private int year_of_publish;

    public BookPr1(String a, String t, int year)
    {
        author = a;
        title = t;
        year_of_publish = year;
    }

    public BookPr1(String a, String t)
    {
        author = a;
        title = t;
        year_of_publish = 0;
    }

    public BookPr1(String a)
    {
        author = a;
        title = "Test title";
        year_of_publish = 0;
    }

    public BookPr1()
    {
        author = "Test author";
        title = "Test title";
        year_of_publish = 0;
    }

    public void setAuthor(String author) { this.author = author; }
    public void setTitle(String title) { this.title = title; }
    public void setYear_of_publish(int year) { this.year_of_publish = year; }

    public String getAuthor() { return author; }
    public String getTitle() { return  title; }
    public int getYear_of_publish() { return year_of_publish; }

    public String toString() {
        return "\"" + this.title + "\" " + this.author + " year of publishing: " + this.year_of_publish;
    }
}
