package src.main.java.util;

import java.util.Scanner;

/**
 * Classe utilitária para lidar com a entrada de dados do usuário via console.
 * Fornece métodos para ler strings e inteiros, com tratamento básico de erros para entradas numéricas.
 */
public class InputHandler {
    // Instância única do Scanner para toda a aplicação
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Solicita e lê uma entrada de string do usuário.
     * @param prompt A mensagem a ser exibida ao usuário antes de aguardar a entrada.
     * @return A string lida do console.
     */
    public static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    /**
     * Solicita e lê uma entrada de número inteiro do usuário.
     * Repete a solicitação até que uma entrada numérica válida seja fornecida.
     * @param prompt A mensagem a ser exibida ao usuário antes de aguardar a entrada.
     * @return O número inteiro lido do console.
     */
    public static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                // Tenta converter a entrada do usuário para um inteiro.
                int input = Integer.parseInt(scanner.nextLine());
                return input;
            } catch (NumberFormatException e) {
                // Captura a exceção se a entrada não for um número válido e informa o usuário.
                System.err.println("Entrada inválida. Por favor, digite um número inteiro.");
            }
        }
    }
}


