package model;

import java.util.List;
import java.util.ArrayList;

class Author {
    private Int id;
    private String name;
    private List<Book> bookList;

    public Author(Int id, String name) {

        this.id = id;
        this.name = name;
        this.bookList = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public Int getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setId(Int id) {
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
        String str = "Author:{" + "id=" + id + ", name=" + name + ", book=";

        for(Book book : bookList) str += book + ";";

        str += "}";
        return str;
    }
}