package src.main.java.model;

import java.util.List;
import java.util.ArrayList;

public class Author {
    private int id;
    private String name;
    private List<Book> bookList;

    public Author(int id, String name) {
        this.id = id;
        this.name = name;
        this.bookList = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public int getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Book> getBookList() {
        return bookList;
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
        StringBuilder str = new StringBuilder("Author:{id=" + id + ", name=" + name + ", books=");

        for (Book book : bookList) {
            str.append(book).append(";");
        }

        str.append("}");
        return str.toString();
    }
}