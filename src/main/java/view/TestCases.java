package src.main.java.view;

import src.main.java.model.*;
import src.main.java.service.LibraryService;

/**
 * Classe responsável por executar uma série de casos de teste para verificar a funcionalidade
 * do sistema da biblioteca (LibraryService).
 * Abrange testes para registro, empréstimo, devolução, listagem e remoção de livros, autores e usuários.
 */
public class TestCases {

    /**
     * Executa todos os casos de teste definidos para o sistema da biblioteca.
     * Inicializa um novo LibraryService para cada execução de teste, garantindo um estado limpo.
     */
    public static void runAllTests() {
        System.out.println("\n========================================");
        System.out.println("INICIANDO EXECUÇÃO DOS CASOS DE TESTE");
        System.out.println("========================================");

        // Cria uma nova instância de LibraryService para cada execução de teste, garantindo isolamento.
        LibraryService library = new LibraryService();

        // 1. Testes de Cadastro de Autor
        System.out.println("\n--- 1. Cadastro de Autor ---");
        testRegisterAuthor(library);

        // 2. Testes de Cadastro de Livro
        System.out.println("\n--- 2. Cadastro de Livro ---");
        testRegisterBook(library);

        // 3. Testes de Cadastro de Usuário
        System.out.println("\n--- 3. Cadastro de Usuário ---");
        testRegisterUser(library);

        // 4. Testes de Empréstimo de Livro
        System.out.println("\n--- 4. Empréstimo de Livro ---");
        testBorrowBook(library);

        // 5. Testes de Devolução de Livro
        System.out.println("\n--- 5. Devolução de Livro ---");
        testReturnBook(library);

        // 6. Testes de Listagens
        System.out.println("\n--- 6. Listagens ---");
        testListings(library);

        // 7. Testes de Cobertura de Fluxos Combinados
        System.out.println("\n--- 7. Cobertura de Fluxos Combinados ---");
        testCombinedFlows(library);

        // 8. Testes de Remoção de livros
        System.out.println("\n--- 8. Remoção de livros ---");
        testRemoveBook(library);

        // 9. Testes de Remoção de autores
        System.out.println("\n--- 9. Remoção de autores ---");
        testRemoveAuthor(library);

        System.out.println("\n========================================");
        System.out.println("EXECUÇÃO DOS CASOS DE TESTE CONCLUÍDA");
        System.out.println("========================================");
    }

    /**
     * Testa o registro de autores, incluindo casos de sucesso e tentativa de duplicidade.
     * @param library A instância de LibraryService para realizar as operações.
     */
    private static void testRegisterAuthor(LibraryService library) {
        System.out.println("A1: Cadastrar autor novo com nome único");
        library.registerAuthor(new Author("Autor Teste 1"));

        System.out.println("A2: Tentar cadastrar autor com nome já existente");
        library.registerAuthor(new Author("Autor Teste 1"));
    }

    /**
     * Testa o registro de livros, incluindo casos de sucesso, título repetido e autor inexistente.
     * @param library A instância de LibraryService para realizar as operações.
     */
    private static void testRegisterBook(LibraryService library) {
        System.out.println("--------------- logs de preparação de testes ---------------");
        library.registerAuthor(new Author("Autor Existente"));
        library.registerAuthor(new Author("Autor Diferente 1"));
        library.registerAuthor(new Author("Autor Diferente 2"));
        System.out.println("------------------------------------------------------------");
        System.out.println();

        System.out.println("L1: Cadastrar livro com título único e autor existente");
        library.registerBook(new Book("Livro Teste 1", "Ficção", "Autor Existente"));

        System.out.println("L2: Tentar cadastrar livro com título repetido");
        library.registerBook(new Book("Livro Teste 1", "Drama", "Autor Existente"));

        System.out.println("L3: Tentar cadastrar livro com autor não cadastrado");
        library.registerBook(new Book("Livro Teste 2", "Aventura", "Autor Inexistente"));

        System.out.println("L4: Cadastrar vários livros válidos com autores diferentes");
        library.registerBook(new Book("Livro Teste 3", "Fantasia", "Autor Diferente 1"));
        library.registerBook(new Book("Livro Teste 4", "Mistério", "Autor Diferente 2"));
    }

    /**
     * Testa o registro de usuários, incluindo casos de sucesso e tentativa de duplicidade.
     * @param library A instância de LibraryService para realizar as operações.
     */
    private static void testRegisterUser(LibraryService library) {
        System.out.println("U1: Cadastrar usuário novo com nome único");
        library.registerUser(new User("Usuario Teste 1"));

        System.out.println("U2: Tentar cadastrar usuário com nome já existente");
        library.registerUser(new User("Usuario Teste 1"));
    }

    /**
     * Testa o empréstimo de livros, cobrindo cenários de sucesso, livro indisponível, usuário com livro,
     * livro inexistente e usuário inexistente.
     * @param library A instância de LibraryService para realizar as operações.
     */
    private static void testBorrowBook(LibraryService library) {
        System.out.println("--------------- logs de preparação de testes ---------------");
        library.registerUser(new User("Usuario Emprestimo"));
        library.registerUser(new User("Usuario Emprestimo 2"));
        library.registerAuthor(new Author("Autor Emprestimo"));
        library.registerBook(new Book("Livro Disponivel", "Ação", "Autor Emprestimo"));
        library.registerBook(new Book("Livro Ja Emprestado", "Terror", "Autor Emprestimo"));
        library.registerBook(new Book("Livro Para Segundo Emprestimo", "Comédia", "Autor Emprestimo"));
        System.out.println("------------------------------------------------------------");
        System.out.println();

        System.out.println("E1: Usuário pega livro disponível");
        library.borrowBook("Usuario Emprestimo", "Livro Disponivel");

        System.out.println("E2: Usuário tenta pegar livro que já está emprestado");
        library.borrowBook("Usuario Emprestimo 2", "Livro Disponivel");

        System.out.println("E3: Usuário tenta pegar um segundo livro sem devolver o anterior");
        library.borrowBook("Usuario Emprestimo", "Livro Para Segundo Emprestimo");

        System.out.println("E4: Tentar emprestar livro inexistente");
        library.borrowBook("Usuario Emprestimo", "Livro Inexistente");

        System.out.println("E5: Tentar emprestar com usuário inexistente");
        library.borrowBook("Usuario Inexistente", "Livro Disponivel");

        System.out.println("E6: Usuário pega e devolve corretamente, depois pega outro");
        library.returnBook("Usuario Emprestimo", "Livro Disponivel"); // Devolve o primeiro
        library.borrowBook("Usuario Emprestimo", "Livro Para Segundo Emprestimo"); // Pega o segundo
    }

    /**
     * Testa a devolução de livros, cobrindo cenários de sucesso, livro já disponível,
     * livro não pertencente ao usuário, livro inexistente e usuário inexistente.
     * @param library A instância de LibraryService para realizar as operações.
     */
    private static void testReturnBook(LibraryService library) {
        System.out.println("--------------- logs de preparação de testes ---------------");
        library.registerUser(new User("Usuario Devolucao"));
        library.registerAuthor(new Author("Autor Devolucao"));
        library.registerBook(new Book("Livro Emprestado", "Romance", "Autor Devolucao"));
        library.registerBook(new Book("Livro Nao Emprestado", "Biografia", "Autor Devolucao"));
        library.registerBook(new Book("Livro De Outro Usuario", "Suspense", "Autor Devolucao"));
        library.borrowBook("Usuario Devolucao", "Livro Emprestado");
        library.borrowBook(new User("Outro Usuario").getName(), "Livro De Outro Usuario");
        System.out.println("------------------------------------------------------------");
        System.out.println();

        System.out.println("D1: Usuário devolve livro emprestado corretamente");
        library.returnBook("Usuario Devolucao", "Livro Emprestado");

        System.out.println("D2: Tentar devolver livro que já está disponível");
        library.returnBook("Usuario Devolucao", "Livro Nao Emprestado");

        System.out.println("D3: Tentar devolver livro que não pertence ao usuário");
        library.returnBook("Usuario Devolucao", "Livro De Outro Usuario");

        System.out.println("D4: Tentar devolver livro inexistente");
        library.returnBook("Usuario Devolucao", "Livro Inexistente");

        System.out.println("D5: Tentar devolver com usuário inexistente");
        library.returnBook("Usuario Inexistente", "Livro Emprestado");
    }

    /**
     * Testa as funcionalidades de listagem de livros (disponíveis, emprestados, todos) e de autores e usuários.
     * @param library A instância de LibraryService para realizar as operações.
     */
    private static void testListings(LibraryService library) {
        System.out.println("--------------- logs de preparação de testes ---------------");
        library.registerAuthor(new Author("Autor Listagem"));
        library.registerBook(new Book("Livro A", "G1", "Autor Listagem"));
        library.registerBook(new Book("Livro B", "G2", "Autor Listagem"));
        library.registerUser(new User("Usuario Listagem"));
        library.borrowBook("Usuario Listagem", "Livro A");
        System.out.println("------------------------------------------------------------");
        System.out.println();

        System.out.println("LS1: Listar livros disponíveis");
        library.listAvailableBooks();

        System.out.println("LS2: Listar livros emprestados");
        library.listBorrowedBooks();

        System.out.println("LS3: Listar todos os livros");
        library.listBooks();

        System.out.println("LS4: Listar autores");
        library.listAuthors();

        System.out.println("LS5: Listar usuários");
        library.listUsers();

        // Testa listagens com uma biblioteca vazia.
        LibraryService emptyLibrary = new LibraryService();
        System.out.println("LS6: Listar livros com nenhum cadastrado ainda");
        emptyLibrary.listBooks();

        System.out.println("LS7: Listar autores com nenhum cadastrado ainda");
        emptyLibrary.listAuthors();
    }

    /**
     * Testa fluxos combinados de operações, incluindo um cenário completo de empréstimo/devolução
     * e tentativas de operações inválidas.
     * @param library A instância de LibraryService para realizar as operações.
     */
    private static void testCombinedFlows(LibraryService library) {
        System.out.println("FX1: Cadastrar autor + livro + usuário + emprestar + devolver");
        library.registerAuthor(new Author("Autor FX1"));
        library.registerBook(new Book("Livro FX1", "Genero FX1", "Autor FX1"));
        library.registerUser(new User("Usuario FX1"));
        library.borrowBook("Usuario FX1", "Livro FX1");
        library.returnBook("Usuario FX1", "Livro FX1");

        System.out.println("FX2: Tentar cadastrar tudo errado (autor duplicado, livro com autor inexistente, etc.)");
        library.registerAuthor(new Author("Autor FX1")); // Tenta cadastrar autor duplicado.
        library.registerBook(new Book("Livro Inexistente Autor", "G", "Autor Nao Existe")); // Tenta cadastrar livro com autor inexistente.
        library.registerUser(new User("Usuario FX1")); // Tenta cadastrar usuário duplicado.
    }

    /**
     * Testa a remoção de livros, incluindo cenários de sucesso, livro inexistente e livro emprestado.
     * @param library A instância de LibraryService para realizar as operações.
     */
    private static void testRemoveBook(LibraryService library) {
        System.out.println("--------------- logs de preparação de testes ---------------");
        library.registerAuthor(new Author("Autor RL1"));
        library.registerBook(new Book("Livro RL1", "Genero RL1", "Autor RL1"));
        library.registerBook(new Book("Livro RL3", "Genero RL3", "Autor RL1"));
        library.registerUser(new User("Usuario RL3"));
        library.borrowBook("Usuario RL3", "Livro RL3");
        System.out.println("------------------------------------------------------------");
        System.out.println();

        System.out.println("RL1: Remover livro existente e disponivel");
        library.removeBook("Livro RL1");

        System.out.println("RL2: Remover livro inexistente");
        library.removeBook("Livro RL1");

        System.out.println("RL3: Remover livro disponivel e emprestado");
        library.removeBook("Livro RL3");
    }

    /**
     * Testa a remoção de autores, incluindo cenários de sucesso, autor inexistente e autor com livros emprestados.
     * @param library A instância de LibraryService para realizar as operações.
     */
    private static void testRemoveAuthor(LibraryService library) {
        System.out.println("--------------- logs de preparação de testes ---------------");
        library.registerAuthor(new Author("Autor RA1"));
        library.registerAuthor(new Author("Autor RA3"));
        library.registerBook(new Book("Livro RA3", "Genero RA3", "Autor RA3"));
        library.registerUser(new User("Usuario RA3"));
        library.borrowBook("Usuario RA3", "Livro RA3");
        System.out.println("------------------------------------------------------------");
        System.out.println();

        System.out.println("RA1: Remover autor existente");
        library.removeAuthor("Autor RA1");

        System.out.println("RA2: Remover autor inexistente");
        library.removeAuthor("Autor RA1");

        System.out.println("RA3: Remover autor com livros emprestados");
        library.removeAuthor("Autor RA3");
    }
}


