package src.main.java.model;

public class Book {
    private String title;
    private String genre;
    private String author;
    private boolean available;

    public Book(String title, String genre, String author) {
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.available = true;
    }

    public String getTitle(){
        return this.title;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString(){
        return "Book:{" + "title=" + title
                + ", genre=" + genre
                + ", author=" + author
                + ", available=" + available + "}";
    }
}
