package src.main.java.model;

import java.util.List;
import java.util.ArrayList;

/**
 * Representa um autor no sistema da biblioteca.
 * Cada autor possui um nome e uma lista de livros associados a ele.
 */
public class Author {
    private String name;
    private List<Book> bookList;

    public Author(String name) {
        this.name = name;
        this.bookList = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
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
        StringBuilder str = new StringBuilder("Author:{name=" + name + ", books=");

        for (Book book : bookList) {
            str.append(book).append(";");
        }

        str.append("}");
        return str.toString();
    }
}