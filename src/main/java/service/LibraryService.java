package src.main.java.service;

import src.main.java.model.Author;
import src.main.java.model.Book;
import src.main.java.model.User;

import java.util.HashMap;
import java.util.Map;

public class LibraryService {
    private Map<String, Book> books;
    private Map<String, Author> authors;
    private Map<String, User> users;

    public LibraryService() {
        this.books = new HashMap<>();
        this.authors = new HashMap<>();
        this.users = new HashMap<>();
    }

    public void registerUser(User user){}
    public void registerAuthor(Author author){};
    public void registerBook(Book book){};
    public void borrowBook(String userName, String bookTitle){}
    public void returnBook(String userName, String bookTitle){}

}