// Classe Autor
class Author {

    // O nome do autor
    private String name;

    // Construtor da classe
    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Classe que representa um livro
// Incluir atributos e métodos necessários
class Book {
}

// Classe que representa um usuário da biblioteca
class User {

}

// Classe que representa uma biblioteca
// Incluir atributos e métodos necessários
class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }
}
// Exemplo de utilização
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
    }
}