package src.main.java.service;

import src.main.java.model.*;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

/**
 * Serviço principal da biblioteca, responsável por gerenciar livros, autores e usuários.
 * Contém a lógica de negócio para registro, empréstimo, devolução e remoção de itens.
 */
public class LibraryService {
    // Mapas para armazenar livros, autores e usuários, usando seus nomes/títulos como chaves para acesso rápido.
    private Map<String, Book> books;
    private Map<String, Author> authors;
    private Map<String, User> users;

    /**
     * Construtor para inicializar o LibraryService.
     * Cria instâncias vazias dos mapas para livros, autores e usuários.
     */
    public LibraryService() {
        this.books = new HashMap<>();
        this.authors = new HashMap<>();
        this.users = new HashMap<>();
    }

    /**
     * Registra um novo usuário no sistema da biblioteca.
     * Verifica se já existe um usuário com o mesmo nome antes de registrar.
     * @param user O objeto User a ser registrado.
     */
    public void registerUser(User user){
        // Verifica se o nome de usuário já existe para evitar duplicatas.
        if(users.containsKey(user.getName())){
            System.out.println("Chegou tarde, já temos um usuário com esse nome");
            return;
        }
        // Adiciona o usuário ao mapa de usuários.
        users.put(user.getName(), user);
        System.out.println("Obrigado por se cadastrar, aproveite nossa extensa colecao de livros");
    }

    /**
     * Registra um novo autor no sistema da biblioteca.
     * Verifica se já existe um autor com o mesmo nome antes de registrar.
     * @param author O objeto Author a ser registrado.
     */
    public void registerAuthor(Author author){
        // Verifica se o nome do autor já existe para evitar duplicatas.
        if(authors.containsKey(author.getName())){
            System.out.println("Autor já cadastrado, favor nao tentar novamente");
            return;
        }
        // Adiciona o autor ao mapa de autores.
        authors.put(author.getName(), author);
        System.out.println("Autor cadastrado com sucesso");
    }

    /**
     * Registra um novo livro no sistema da biblioteca.
     * Verifica se o livro já existe e se o autor está cadastrado antes de registrar.
     * @param book O objeto Book a ser registrado.
     */
    public void registerBook(Book book){
        // Verifica se o título do livro já existe para evitar duplicatas.
        if(books.containsKey(book.getTitle())){
            System.out.println("Nosso sistema de exclusividade nao aceita livros repetidos");
            return;
        }

        // Verifica se o autor do livro está cadastrado no sistema.
        if(!authors.containsKey(book.getAuthor())){
            System.out.println("Verifique o nome do autor, nao ha registros para \'" + book.getAuthor() + "\'");
            return;
        }

        // Adiciona o livro ao mapa de livros.
        books.put(book.getTitle(), book);
        // Associa o livro ao seu autor.
        linkBookToAuthor(book.getTitle(), book.getAuthor());
        System.out.println("Livro cadastrado com sucesso");
    }

    /**
     * Associa um livro a um autor existente.
     * Este método é chamado internamente após o registro de um livro para manter a consistência dos dados.
     * @param bookTitle O título do livro a ser associado.
     * @param authorName O nome do autor ao qual o livro será associado.
     */
    public void linkBookToAuthor(String bookTitle, String authorName){
        Book book = books.get(bookTitle);
        Author author = authors.get(authorName);

        // Adiciona o livro à lista de livros do autor.
        if (author != null && book != null) {
            author.addBook(book);
        }
    }

    /**
     * Permite que um usuário pegue um livro emprestado.
     * Verifica a existência do usuário e do livro, e a disponibilidade do livro e do usuário.
     * @param userName O nome do usuário que deseja emprestar o livro.
     * @param bookTitle O título do livro a ser emprestado.
     */
    public void borrowBook(String userName, String bookTitle){
        User user = users.get(userName);
        Book book = books.get(bookTitle);

        // Verifica se o livro existe.
        if (book == null) {
            System.out.println("Erro: Livro com Titulo \'" + bookTitle + "\' não encontrado.");
            return;
        }
        // Verifica se o usuário existe.
        if (user == null) {
            System.out.println("Erro: Usuário com Nome \'" + userName + "\' não encontrado.");
            return;
        }

        // Verifica se o usuário já possui um livro emprestado.
        if(user.getHasBook()){
            System.out.println("Por favor, retorne o livro emprestado antes de escolher outro");
            return;
        }

        // Verifica se o livro está disponível.
        if(!book.isAvailable()){
            System.out.println("Alguem chegou primeiro e ja pegou esse livro, tente outro");
            return;
        }

        // Se o livro estiver disponível e o usuário não tiver outro livro, realiza o empréstimo.
        if(book.isAvailable() && !user.getHasBook()){
            book.setAvailable(false); // Marca o livro como indisponível.
            user.setHasBook(true); // Marca que o usuário possui um livro.
            user.setBook(book); // Associa o livro ao usuário.
            System.out.println("Obrigado por escolher nosso livro, cuide como se fosse seu filho para nao pagar multa");
            return;
        }

        System.err.println("Erro: Nao foi possivel emprestar o livro");
    }

    /**
     * Permite que um usuário devolva um livro emprestado.
     * Verifica a existência do usuário e do livro, e se o livro realmente pertence ao usuário.
     * @param userName O nome do usuário que deseja devolver o livro.
     * @param bookTitle O título do livro a ser devolvido.
     */
    public void returnBook(String userName, String bookTitle){
        User user = users.get(userName);
        Book book = books.get(bookTitle);

        // Verifica se o livro existe.
        if (book == null) {
            System.out.println("Erro: Livro com Titulo \'" + bookTitle + "\' não encontrado.");
            return;
        }
        // Verifica se o usuário existe.
        if (user == null) {
            System.out.println("Erro: Usuário com Nome \'" + userName + "\' não encontrado.");
            return;
        }

        // Verifica se o livro já está disponível (não emprestado).
        if(book.isAvailable()){
            System.out.println("Livro \'" + book.getTitle() + "\' nao foi emprestado");
            return;
        }

        // Verifica se o livro que está sendo devolvido é o mesmo que o usuário pegou emprestado.
        if(user.getBook() == null || !bookTitle.equals(user.getBook().getTitle())){
            System.out.println("Livro \'" + bookTitle + "\' nao pertence ao usuario \'" + userName + "\'");
            return;
        }
        // Se o livro não estiver disponível e o usuário tiver um livro, realiza a devolução.
        if(!book.isAvailable() && user.getHasBook()){
            book.setAvailable(true); // Marca o livro como disponível.
            user.setHasBook(false); // Marca que o usuário não possui mais um livro.
            user.setBook(null); // Remove a associação do livro com o usuário.
            System.out.println("O Livro \'" + bookTitle + "\' parece estar em bom estado, obrigado por devolve-lo inteiro");
            return;
        }

        System.err.println("Erro: Nao foi possivel devolver o livro");
    }

    /**
     * Remove um livro do sistema da biblioteca.
     * O livro só pode ser removido se estiver disponível (não emprestado).
     * @param bookTitle O título do livro a ser removido.
     */
    public void removeBook(String bookTitle){
        Book book = books.get(bookTitle);
        // Verifica se o livro existe.
        if(book == null){
            System.out.println("Livro com titulo \'" + bookTitle + "\' nao encontrado");
            return;
        }
        // Verifica se o livro está emprestado.
        if(!book.isAvailable()){
            System.out.println("O livro \'" + bookTitle + "\' nao pode ser removido, atualmente em emprestimo");
            return;
        }

        // Remove o livro da lista de livros do autor, se o autor existir.
        Author author = authors.get(book.getAuthor());
        if (author != null) author.removeBook(book);

        // Remove o livro do mapa de livros.
        books.remove(bookTitle);
        System.out.println("Livro \'" + bookTitle + "\' removido com sucesso" );
    }

    /**
     * Remove um autor e todos os seus livros associados do sistema da biblioteca.
     * Livros emprestados associados a este autor não podem ser removidos.
     * @param authorName O nome do autor a ser removido.
     */
    public void removeAuthor(String authorName){
        Author author = authors.get(authorName);
        // Verifica se o autor existe.
        if(author == null){
            System.out.println("Autor com nome \'" + authorName + "\' nao encontrado");
            return;
        }

        // Cria uma cópia da lista de livros do autor para evitar ConcurrentModificationException
        // ao remover livros enquanto itera sobre a lista original.
        for(Book book : new ArrayList<>(author.getBookList())){
            // Tenta remover cada livro associado ao autor. O método removeBook já verifica a disponibilidade.
            if(book != null) removeBook(book.getTitle());
        }

        // Remove o autor do mapa de autores.
        authors.remove(authorName);
        System.out.println("Autor \'" + authorName + "\' removido com sucesso");
    }

    /**
     * Lista todos os livros que estão disponíveis para empréstimo.
     */
    public void listAvailableBooks(){
        System.out.println("Livros disponiveis: ");
        // Itera sobre todos os livros e imprime apenas os que estão disponíveis.
        for(Book book : books.values()){
            if(book.isAvailable()) System.out.println(book.getTitle() + " - " + book.getAuthor());
        }
    }

    /**
     * Lista todos os livros que estão atualmente emprestados.
     */
    public void listBorrowedBooks(){
        System.out.println("Livros emprestados: ");
        // Itera sobre todos os livros e imprime apenas os que não estão disponíveis (emprestados).
        for(Book book : books.values()){
            if(!book.isAvailable()) System.out.println(book.getTitle() + " - " + book.getAuthor());
        }
    }

    /**
     * Lista todos os livros cadastrados no sistema, independentemente de sua disponibilidade.
     */
    public void listBooks(){
        System.out.println("Livros cadastrados: ");
        // Itera sobre todos os livros e imprime seus títulos e autores.
        for(Book book : books.values()) System.out.println(book.getTitle() + " - " + book.getAuthor());
    }

    /**
     * Lista todos os livros escritos por um autor específico.
     * @param authorName O nome do autor cujos livros serão listados.
     */
    public void listBooksByAuthor(String authorName){
        Author author = authors.get(authorName);
        // Verifica se o autor existe antes de tentar listar seus livros.
        if (author == null) {
            System.out.println("Autor \'" + authorName + "\' não encontrado.");
            return;
        }
        System.out.println("Livros de \'" + authorName + "\':");
        // Itera sobre a lista de livros do autor e imprime seus títulos.
        for(Book book : author.getBookList()){
            System.out.println(book.getTitle());
        }
    }

    /**
     * Lista todos os autores cadastrados no sistema.
     */
    public void listAuthors(){
        System.out.println("Autores cadastrados: ");
        // Itera sobre todos os autores e imprime seus nomes.
        for(Author author : authors.values()){
            System.out.println(author.getName());
        }
    }

    /**
     * Lista todos os usuários cadastrados no sistema.
     */
    public void listUsers(){
        System.out.println("Usuarios cadastrados: ");
        // Itera sobre todos os usuários e imprime seus nomes.
        for(User user : users.values()){
            System.out.println(user.getName());
        }
    }
}