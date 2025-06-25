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

    public void registerUser(User user){
        if(users.containsKey(user.getName())){
            System.out.println("Chegou tarde, já temos um usuário com esse nome");
            return;
        }
        users.put(user.getName(), user);
        System.out.println("Obrigado por se cadastrar, aproveite nossa extensa colecao de livros");
    }


    public void registerAuthor(Author author){
        if(authors.containsKey(author.getName())){
            System.out.println("Autor já cadastrado, favor nao tentar novamente");
            return;
        }
        authors.put(author.getName(), author);
        System.out.println("Autor cadastrado com sucesso");
    };


    public void registerBook(Book book){
        if(books.containsKey(book.getTitle())){
            System.out.println("Nosso sistema de exclusividade nao aceita livros repetidos");
            return;
        }

        if(!authors.containsKey(book.getAuthor())){
            System.out.println("Verifique o nome do autor, nao ha registros para '" + book.getAuthor() + "'");
            return;
        }

        linkBookToAuthor(book.getTitle(), book.getAuthor());
        books.put(book.getTitle(), book);
        System.out.println("Livro cadastrado com sucesso");
    };

    public void linkBookToAuthor(String bookTitle, String authorName){
        Book book = books.get(bookTitle);
        Author author = authors.get(authorName);

        author.addBook(book);
    }

    public void borrowBook(String userName, String bookTitle){
        User user = users.get(userName);
        Book book = books.get(bookTitle);

        if (book == null) {
            System.out.println("Erro: Livro com Titulo: '" + bookTitle + "' não encontrado.");
            return;
        }
        if (user == null) {
            System.out.println("Erro: Usuário com Nome: '" + userName + "' não encontrado.");
            return;
        }

        if(user.getHasBook()){
            System.out.println("Por favor, retorne o livro emprestado antes de escolher outro");
            return;
        }

        if(!book.isAvailable()){
            System.out.println("Alguem chegou primeiro e ja pegou esse livro, tente outro");
            return;
        }

        if(book.isAvailable() && !user.getHasBook()){
            book.setAvailable(false);
            user.setHasBook(true);
            user.setBook(book);
            System.out.println("Obrigado por escolher nosso livro, cuide como se fosse seu filho para nao pagar multa");
            return;
        }

        System.err.println("Erro: Nao foi possivel emprestar o livro");
    }

    public void returnBook(String userName, String bookTitle){
        User user = users.get(userName);
        Book book = books.get(bookTitle);

        if (book == null) {
            System.out.println("Erro: Livro com Titulo: '" + bookTitle + "' não encontrado.");
            return;
        }
        if (user == null) {
            System.out.println("Erro: Usuário com Nome: '" + userName + "' não encontrado.");
            return;
        }

        if(book.isAvailable()){
            System.out.println("Livro '" + book.getTitle() + "' nao foi emprestado");
            return;
        }

        if(!bookTitle.equals(user.getBook().getTitle())){
            System.out.println("Livro '" + bookTitle + "' nao pertence ao usuario '" + userName + "'");
            return;
        }
        if(!book.isAvailable() && user.getHasBook()){
            book.setAvailable(true);
            user.setHasBook(false);
            user.setBook(null);
            System.out.println("O Livro '" + bookTitle + "' parece estar em bom estado, obrigado por devolve-lo inteiro");
            return;
        }

        System.err.println("Erro: Nao foi possivel devolver o livro");
    }

    public void listAvailableBooks(){
        System.out.println("Livros disponiveis: ");
        for(Book book : books.values()){
            if(book.isAvailable()) System.out.println(book);
        }
    }

    public void listBorrowedBooks(){
        System.out.println("Livros emprestados: ");
        for(Book book : books.values()){
            if(!book.isAvailable()) System.out.println(book);
        }
    }

    public void listBooks(){
        System.out.println("Livros cadastrados: ");
        for(Book book : books.values()){
            System.out.println(book);
        }
    }

    public void listAuthors(){
        System.out.println("Autores cadastrados: ");
        for(Author author : authors.values()){
            System.out.println(author);
        }
    }

    public void listUsers(){
        System.out.println("Usuarios cadastrados: ");
        for(User user : users.values()){
            System.out.println(user);
        }
    }

}