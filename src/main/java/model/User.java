package src.main.java.model;

import java.util.List;
import java.util.ArrayList;

public class User {
    private String name;
    private String password;
    private List<Book> bookList;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.bookList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void addBook(Book book){
        this.bookList.add(book);
    }

    public void removeBook(Book book){
        this.bookList.remove(book);
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder("User:{" + "name=" + name + ", password=" + password + ", books=");

        for (Book book : bookList) {
            str.append(book).append(";");
        }

        str.append("}");
        return str.toString();
    }
}
