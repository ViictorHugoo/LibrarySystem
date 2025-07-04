package src.main.java.view;

import src.main.java.model.*;
import src.main.java.service.LibraryService;
import src.main.java.util.InputHandler;

/**
 * Classe responsável por exibir os menus da aplicação e interagir com o usuário.
 * Gerencia a entrada do usuário e chama os métodos apropriados do LibraryService.
 */
public class Menu {
    private LibraryService library;

    public Menu(LibraryService library) {
        this.library = library;
    }

    /**
     * Exibe o menu inicial da aplicação, com opções para entrar no sistema, rodar testes ou sair.
     */
    public void displayInitialMenu(){
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Ola, sou a super inteligente biblioteca interativa e exclusiva.");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Regras de uso: ");
        System.out.println("Para usar nosso sistema eh necessario um cadastro com nome e senha, super seguro");
        System.out.println("Para cadastrar um livro eh necessario o nome do autor, o titulo e a genero");
        System.out.println("Caso o autor nao esteja cadastrado, eh necessario cadastrar primeiro o autor");
        System.out.println("Nessa biblioteca super exclusiva, nao eh possivel cadastrar livros repetidos ou usuarios com mesmo nome");
        System.out.println("Entao caso queira um livro, torca que alguem nao o tenha pego primeiro");
        System.out.println();
        System.out.println();
        System.out.println("| Digite 'ciente' para entrar no sistema");
        System.out.println("| Digite 'teste' caso queira apenas os testes exigidos pelo desafio");
        System.out.println("| Digite 'sair' para sair do sistema");
        System.out.println();
    }

    /**
     * Exibe o menu principal do sistema, com todas as opções de gerenciamento da biblioteca.
     */
    public void displayInsideSystemMenu(){
        System.out.println("Bem vindo ao sistema da biblioteca");
        System.out.println();
        System.out.println("Digite '0' para sair do sistema");
        System.out.println("Digite '1' para voltar ao menu inicial");
        System.out.println();
        System.out.println("Digite '10' para se cadastrar no sistema");
        System.out.println();
        System.out.println("Digite '20' para ver os livros disponiveis");
        System.out.println("Digite '21' para ver os livros emprestados");
        System.out.println("Digite '22' para ver a colecao de livros");
        System.out.println("Digite '23' para cadastrar um livro");
        System.out.println("Digite '24' para pegar um livro emprestado");
        System.out.println("Digite '25' para devolver um livro emprestado");
        System.out.println();
        System.out.println("Digite '30' para cadastrar um autor");
        System.out.println("Digite '31' para ver os autores cadastrados");
        System.out.println();
        System.out.println("Digite '40' para remover um livro");
        System.out.println("Digite '41' para remover um autor");
        System.out.println();
    }

    /**
     * Lida com a entrada do usuário no menu inicial, direcionando para o sistema interno, testes ou saída.
     */
    public void handleInitialMenuInput() {
        String mode = InputHandler.getStringInput("Sua resposta: ").toLowerCase();
        switch (mode) {
            case "ciente":
                handleInsideSystemMenu();
                break;
            case "teste":
                TestCases.runAllTests();
                System.exit(0);
                break;
            case "sair":
                System.exit(0);
                break;
            default:
                System.err.println("Opção inválida, digite novamente: ");
                handleInitialMenuInput();
        }
    }

    /**
     * Lida com a entrada do usuário no menu interno do sistema, executando as operações da biblioteca.
     */
    public void handleInsideSystemMenu() {
        while (true) {
            clearTerminal();
            displayInsideSystemMenu();
            int option = InputHandler.getIntInput("Sua resposta: ");

            switch (option) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    clearTerminal();
                    return;
                case 10:
                    registerUser();
                    break;
                case 20:
                    library.listAvailableBooks();
                    break;
                case 21:
                    library.listBorrowedBooks();
                    break;
                case 22:
                    library.listBooks();
                    break;
                case 23:
                    registerBook();
                    break;
                case 24:
                    borrowBook();
                    break;
                case 25:
                    returnBook();
                    break;
                case 30:
                    registerAuthor();
                    break;
                case 31:
                    library.listAuthors();
                    break;
                case 40:
                    removeBook();
                    break;
                case 41:
                    removeAuthor();
                    break;
                default:
                    System.err.println("Opção inválida, digite novamente: ");
            }
        InputHandler.getStringInput("Pressione Enter para continuar...");
        }
    }

    /**
     * Solicita ao usuário os dados para registrar um novo usuário e chama o serviço da biblioteca.
     */
    private void registerUser() {
        String name = InputHandler.getStringInput("Digite o nome do usuário: ");
        library.registerUser(new User(name));
    }

    /**
     * Solicita ao usuário os dados para registrar um novo livro e chama o serviço da biblioteca.
     */
    private void registerBook() {
        String title = InputHandler.getStringInput("Digite o título do livro: ");
        String genre = InputHandler.getStringInput("Digite o gênero do livro: ");
        String authorName = InputHandler.getStringInput("Digite o nome do autor: ");
        library.registerBook(new Book(title, genre, authorName));
    }

    /**
     * Solicita ao usuário o nome para registrar um novo autor e chama o serviço da biblioteca.
     */
    private void registerAuthor() {
        String authorName = InputHandler.getStringInput("Digite o nome do autor: ");
        library.registerAuthor(new Author(authorName));
    }

    /**
     * Solicita ao usuário os dados para emprestar um livro e chama o serviço da biblioteca.
     */
    private void borrowBook() {
        String userName = InputHandler.getStringInput("Digite o seu nome de usuário: ");
        String bookTitle = InputHandler.getStringInput("Digite o título do livro a ser emprestado: ");
        library.borrowBook(userName, bookTitle);
    }

    /**
     * Solicita ao usuário os dados para devolver um livro e chama o serviço da biblioteca.
     */
    private void returnBook() {
        String userName = InputHandler.getStringInput("Digite o nome do usuário: ");
        String bookTitle = InputHandler.getStringInput("Digite o título do livro a ser devolvido: ");
        library.returnBook(userName, bookTitle);
    }

    /**
     * Solicita ao usuário o título do livro a ser removido e chama o serviço da biblioteca.
     */
    private void removeBook() {
        String bookTitle = InputHandler.getStringInput("Digite o titulo do livro a ser removido: ");
        library.removeBook(bookTitle);
    }

    /**
     * Solicita ao usuário o nome do autor a ser removido e chama o serviço da biblioteca.
     * Alerta o usuário sobre a remoção de todos os livros associados ao autor.
     */
    private void removeAuthor() {
        System.out.println("A remocao de um autor acarreta na remocao de todos os livros dele na nossa colecao.");
        System.out.println();
        String authorName = InputHandler.getStringInput("Digite o nome do autor a ser removido: ");
        library.removeAuthor(authorName);
    }

    /**
     * Limpa o terminal exibindo várias linhas em branco.
     */
    public static void clearTerminal() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}