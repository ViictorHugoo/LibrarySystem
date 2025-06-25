package src.main.java;

import src.main.java.model.*;
import src.main.java.service.LibraryService;
import src.main.java.util.DataLoader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryService library = new LibraryService();
        DataLoader.loadData(library);
        limparTela();

        start(library);
        limparTela();
    }
    public static void testCase(LibraryService library){}

    public static void direction(String mode, LibraryService library){
        if(mode.equals("ciente")) insideSystem(library);
        else if(mode.equals("teste")) testCase(library);
        else if(mode.equals("sair")) System.exit(0);
        else {
            System.err.println("Opcao invalida, digite novamente: ");
            start(library);
        }
    }

    public static void insideSystem(LibraryService library){
        System.out.println("Bem vindo ao sistema da biblioteca");
        System.out.println();
        System.out.println("Digite '00' para sair do sistema");
        System.out.println("Digite '01' para voltar ao menu inicial");
        System.out.println();
        System.out.println("Digite '10' para se cadastrar no sistema");
        System.out.println();
        System.out.println("Digite '20' para ver os livros disponiveis");
        System.out.println("Digite '21' para ver os livros emprestados");
        System.out.println("Digite '22' para ver a colecao de livros");
        System.out.println("Digite '23' para cadastrar um livro");
        System.out.println();
        System.out.println("Digite '30' para cadastrar um autor");
        System.out.println("Digite '31' para ver os autores cadastrados");
        System.out.println();
        System.out.print("Sua resposta: ");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        switch (option) {
            case 00:
                System.exit(0);
                break;
            case 01:
                limparTela();
                start(library);
                break;
            case 10:
                library.registerUser(new User(scanner.nextLine(), scanner.nextLine()));
                limparTela();
                insideSystem(library);
                break;
            case 20:
                library.listAvailableBooks();
                insideSystem(library);
                break;
            case 21:
                library.listBorrowedBooks();
                insideSystem(library);
                break;
            case 22:
                library.listBooks();
                insideSystem(library);
                break;
            case 23:
                library.registerBook(new Book(scanner.nextLine(), scanner.nextLine(), scanner.nextLine()));
                insideSystem(library);
                break;
            case 30:
                library.registerAuthor(new Author(scanner.nextLine()));
                insideSystem(library);
                break;
            case 31:
                library.listAuthors();
                insideSystem(library);
                break;
            default:
                System.err.println("Opcao invalida, digite novamente: ");
                insideSystem(library);
        }
    }


    public static void start(LibraryService library){
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
        System.out.print("Sua resposta: ");

        Scanner scanner = new Scanner(System.in);
        String mode = scanner.nextLine().toLowerCase();

        direction(mode, library);
    }

    public static void limparTela() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

}