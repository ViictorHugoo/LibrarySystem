package src.main.java.model;

import java.util.List;
import java.util.ArrayList;

public class User {
    private String name;
    private String password;
    private Book book;
    private boolean hasBook;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.book = null;
        this.hasBook = false;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setHasBook(boolean hasBook) {
        this.hasBook = User.this.hasBook;
    }


    @Override
    public String toString(){
        return"User:{"
                + "name=" + name
                + ", password=" + password
                + ", book=" + book
                + ", hasBook=" + hasBook
                + "}";
    }
}
