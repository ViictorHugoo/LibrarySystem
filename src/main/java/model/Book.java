package src.main.java.model;

/**
 * Representa um livro no sistema da biblioteca.
 * Cada livro possui um título, gênero, autor e um status de disponibilidade.
 */
public class Book {
    private String title;
    private String genre;
    private String author;
    private boolean available;

    /**
     * Construtor para criar uma nova instância de Book.
     * Inicializa o livro com título, gênero e autor, e define sua disponibilidade como verdadeira.
     * @param title O título do livro.
     * @param genre O gênero do livro.
     * @param author O nome do autor do livro.
     */
    public Book(String title, String genre, String author) {
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.available = true;
    }

    /**
     * Retorna o título do livro.
     * @return O título do livro.
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * Retorna o gênero do livro.
     * @return O gênero do livro.
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Retorna o nome do autor do livro.
     * @return O nome do autor do livro.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Verifica se o livro está disponível para empréstimo.
     * @return true se o livro estiver disponível, false caso contrário.
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Define o título do livro.
     * @param title O novo título do livro.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Define o gênero do livro.
     * @param genre O novo gênero do livro.
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Define o autor do livro.
     * @param author O novo autor do livro.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Define a disponibilidade do livro.
     * @param available true para disponível, false para indisponível.
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * Retorna uma representação em string do objeto Book.
     * @return Uma string formatada com os detalhes do livro.
     */
    @Override
    public String toString(){
        return "Book:{" + "title=" + title
                + ", genre=" + genre
                + ", author=" + author
                + ", available=" + available
                + "}";
    }
}