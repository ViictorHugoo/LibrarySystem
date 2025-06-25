package src.main.java;

import src.main.java.service.LibraryService;
import src.main.java.util.DataLoader;

public class Main {
    public static void main(String[] args) {
        LibraryService library = new LibraryService();
        DataLoader.loadData(library);

        System.out.println();
        System.out.println();
        System.out.println();

        library.listAvailableBooks();
        System.out.println();

        library.listBorrowedBooks();
        System.out.println();

        library.listBooks();
        System.out.println();

        library.listAuthors();
        System.out.println();

        library.listUsers();
    }
}