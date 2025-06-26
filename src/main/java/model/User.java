package src.main.java.model;

import java.util.List;
import java.util.ArrayList;

public class User {
    private String name;
    private Book book;
    private boolean hasBook;

    public User(String name) {
        this.name = name;
        this.book = null;
        this.hasBook = false;
    }

    public String getName() {
        return name;
    }

    public Book getBook() {
        return book;
    }

    public boolean getHasBook(){
        return this.hasBook;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setHasBook(boolean hasBook) {
        this.hasBook = hasBook;
    }


    @Override
    public String toString(){
        return"User:{"
                + "name=" + name
                + ", book=" + book
                + ", hasBook=" + hasBook
                + "}";
    }
}
