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

    /**
     * Construtor para criar uma nova instância de Author.
     * Inicializa o nome do autor e uma lista vazia para seus livros.
     * @param name O nome do autor.
     */
    public Author(String name) {
        this.name = name;
        this.bookList = new ArrayList<>();
    }

    /**
     * Retorna o nome do autor.
     * @return O nome do autor.
     */
    public String getName(){
        return this.name;
    }

    /**
     * Define o nome do autor.
     * @param name O novo nome do autor.
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Retorna a lista de livros associados a este autor.
     * @return Uma lista de objetos Book escritos por este autor.
     */
    public List<Book> getBookList() {
        return bookList;
    }

    /**
     * Define a lista de livros para este autor.
     * @param bookList A nova lista de livros para o autor.
     */
    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    /**
     * Adiciona um livro à lista de livros deste autor.
     * @param book O livro a ser adicionado.
     */
    public void addBook(Book book){
        this.bookList.add(book);
    }

    /**
     * Remove um livro da lista de livros deste autor.
     * @param book O livro a ser removido.
     */
    public void removeBook(Book book){
        this.bookList.remove(book);
    }

    /**
     * Retorna uma representação em string do objeto Author.
     * Inclui o nome do autor e os títulos dos livros associados.
     * @return Uma string formatada com os detalhes do autor e seus livros.
     */
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