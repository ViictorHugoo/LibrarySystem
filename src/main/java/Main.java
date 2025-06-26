package src.main.java;

import src.main.java.service.*;
import src.main.java.util.*;
import src.main.java.view.*;

public class Main {
    public static void main(String[] args) {
        LibraryService libraryService = new LibraryService();
        DataLoader.loadData(libraryService);
        Menu menu = new Menu(libraryService);

        while (true) {
            menu.clearTerminal();
            menu.displayInitialMenu();
            menu.handleInitialMenuInput();
        }
    }
}
