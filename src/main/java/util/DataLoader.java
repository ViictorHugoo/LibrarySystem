package src.main.java.util;

import src.main.java.model.*;
import src.main.java.service.*;

public class DataLoader {

    public static void loadData(LibraryService library) {

        // Autores
        Author[] autores = new Author[]{
                new Author( "Machado de Assis"),
                new Author( "Clarice Lispector"),
                new Author( "Jorge Amado"),
                new Author( "Lima Barreto"),
                new Author( "Cecília Meireles"),
                new Author( "Carlos Drummond de Andrade"),
                new Author( "João Cabral de Melo Neto"),
                new Author( "Rubem Fonseca"),
                new Author( "Lygia Fagundes Telles"),
                new Author("Graciliano Ramos")
        };

        for (Author autor : autores) {
            library.registerAuthor(autor);
        }

        // Livros (3 por autor)
        library.registerBook(new Book("Dom Casmurro", "Romance", "Machado de Assis"));
        library.registerBook(new Book("Memórias Póstumas de Brás Cubas", "Romance", "Machado de Assis"));
        library.registerBook(new Book("Quincas Borba", "Romance", "Machado de Assis"));

        library.registerBook(new Book("A Hora da Estrela", "Ficção", "Clarice Lispector"));
        library.registerBook(new Book("Perto do Coração Selvagem", "Romance", "Clarice Lispector"));
        library.registerBook(new Book("A Paixão segundo G.H.", "Filosofia", "Clarice Lispector"));

        library.registerBook(new Book("Gabriela, Cravo e Canela", "Romance", "Jorge Amado"));
        library.registerBook(new Book("Capitães da Areia", "Romance", "Jorge Amado"));
        library.registerBook(new Book("Dona Flor e Seus Dois Maridos", "Comédia", "Jorge Amado"));

        library.registerBook(new Book("Triste Fim de Policarpo Quaresma", "Política", "Lima Barreto"));
        library.registerBook(new Book("Clara dos Anjos", "Ficção", "Lima Barreto"));
        library.registerBook(new Book("Recordações do Escrivão Isaías Caminha", "Autobiografia", "Lima Barreto"));

        library.registerBook(new Book("Romanceiro da Inconfidência", "Poesia", "Cecília Meireles"));
        library.registerBook(new Book("Viagem", "Poesia", "Cecília Meireles"));
        library.registerBook(new Book("Escolha o seu sonho", "Poesia", "Cecília Meireles"));

        library.registerBook(new Book("Alguma Poesia", "Poesia", "Carlos Drummond de Andrade"));
        library.registerBook(new Book("A Rosa do Povo", "Poesia", "Carlos Drummond de Andrade"));
        library.registerBook(new Book("Claro Enigma", "Poesia", "Carlos Drummond de Andrade"));

        library.registerBook(new Book("Morte e Vida Severina", "Poesia", "João Cabral de Melo Neto"));
        library.registerBook(new Book("O Cão sem Plumas", "Poesia", "João Cabral de Melo Neto"));
        library.registerBook(new Book("A Educação pela Pedra", "Poesia", "João Cabral de Melo Neto"));

        library.registerBook(new Book("Agosto", "Policial", "Rubem Fonseca"));
        library.registerBook(new Book("Feliz Ano Novo", "Conto", "Rubem Fonseca"));
        library.registerBook(new Book("O Caso Morel", "Suspense", "Rubem Fonseca"));

        library.registerBook(new Book("Ciranda de Pedra", "Romance", "Lygia Fagundes Telles"));
        library.registerBook(new Book("As Meninas", "Romance", "Lygia Fagundes Telles"));
        library.registerBook(new Book("Verão no Aquário", "Romance", "Lygia Fagundes Telles"));

        library.registerBook(new Book("Vidas Secas", "Romance", "Graciliano Ramos"));
        library.registerBook(new Book("São Bernardo", "Romance", "Graciliano Ramos"));
        library.registerBook(new Book("Angústia", "Romance", "Graciliano Ramos"));

        // Usuários
        library.registerUser(new User("Victor Guimarães", "1234"));
        library.registerUser(new User("João Silva", "abcd"));
        library.registerUser(new User("Maria Oliveira", "pass123"));
        library.registerUser(new User("Ana Santos", "ana456"));
        library.registerUser(new User("Carlos Mendes", "mendes789"));
    }
}
