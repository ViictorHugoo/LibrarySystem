package src.main.java.model;

/**
 * Representa um usuário no sistema da biblioteca.
 * Cada usuário possui um nome, pode ter um livro emprestado e um status indicando se possui um livro.
 */
public class User {
    private String name;
    private Book book;
    private boolean hasBook;

    /**
     * Construtor para criar uma nova instância de User.
     * Inicializa o usuário com um nome, sem livro emprestado e com o status `hasBook` como falso.
     * @param name O nome do usuário.
     */
    public User(String name) {
        this.name = name;
        this.book = null;
        this.hasBook = false;
    }

    /**
     * Retorna o nome do usuário.
     * @return O nome do usuário.
     */
    public String getName() {
        return name;
    }

    /**
     * Retorna o livro que o usuário possui emprestado.
     * @return O objeto Book que o usuário tem, ou null se não tiver nenhum.
     */
    public Book getBook() {
        return book;
    }

    /**
     * Verifica se o usuário possui um livro emprestado.
     * @return true se o usuário tiver um livro, false caso contrário.
     */
    public boolean getHasBook(){
        return this.hasBook;
    }

    /**
     * Define o nome do usuário.
     * @param name O novo nome do usuário.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Define o livro que o usuário possui emprestado.
     * @param book O livro a ser associado ao usuário.
     */
    public void setBook(Book book) {
        this.book = book;
    }

    /**
     * Define o status de posse de livro do usuário.
     * @param hasBook true se o usuário agora tem um livro, false caso contrário.
     */
    public void setHasBook(boolean hasBook) {
        this.hasBook = hasBook;
    }

    /**
     * Retorna uma representação em string do objeto User.
     * @return Uma string formatada com os detalhes do usuário, incluindo o livro emprestado (se houver).
     */
    @Override
    public String toString(){
        return"User:{"
                + "name=" + name
                + ", book=" + book
                + ", hasBook=" + hasBook
                + "}";
    }
}