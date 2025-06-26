package src.main.java;

import src.main.java.service.*;
import src.main.java.util.*;
import src.main.java.view.*;

/**
 * Classe principal que inicia a aplicação do sistema de biblioteca.
 * Responsável por carregar os dados iniciais, exibir o menu e gerenciar o fluxo principal do programa.
 */
public class Main {
    /**
     * Método principal que é o ponto de entrada da aplicação.
     * Inicializa o serviço da biblioteca, carrega dados de exemplo e exibe o menu interativo.
     * @param args Argumentos de linha de comando (não utilizados nesta aplicação).
     */
    public static void main(String[] args) {
        LibraryService libraryService = new LibraryService();
        DataLoader.loadData(libraryService);
        Menu menu = new Menu(libraryService);

        // Loop principal da aplicação que mantém o menu ativo até que o usuário decida sair.
        while (true) {
            menu.clearTerminal();
            menu.displayInitialMenu();
            menu.handleInitialMenuInput();
        }
    }
}
