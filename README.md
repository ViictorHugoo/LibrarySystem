# Sistema de Gerenciamento de Biblioteca

Este é um sistema simples de gerenciamento de biblioteca desenvolvido em Java. Ele permite o registro de usuários, autores e livros, além de funcionalidades de empréstimo, devolução e remoção de livros e autores.

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

```
LibrarySystem/
├── src/
│   └── main/
│       └── java/
│           ├── Main.java
│           ├── model/
│           │   ├── Author.java
│           │   ├── Book.java
│           │   └── User.java
│           ├── service/
│           │   └── LibraryService.java
│           ├── util/
│           │   ├── DataLoader.java
│           │   └── InputHandler.java
│           └── view/
│               ├── Menu.java
│               └── TestCases.java
└── README.md
```

- `src/main/java/`: Contém todo o código-fonte Java da aplicação.
  - `Main.java`: Ponto de entrada da aplicação. Inicializa o serviço da biblioteca e o menu.
  - `model/`: Contém as classes que representam as entidades do sistema (Autor, Livro, Usuário).
    - `Author.java`: Define a estrutura de um autor, incluindo seu nome e a lista de livros que ele escreveu.
    - `Book.java`: Define a estrutura de um livro, incluindo título, gênero, autor e status de disponibilidade.
    - `User.java`: Define a estrutura de um usuário, incluindo seu nome e o livro que ele possui emprestado (se houver).
  - `service/`: Contém a lógica de negócios da aplicação.
    - `LibraryService.java`: Gerencia as operações da biblioteca, como registro, empréstimo, devolução e remoção de livros, autores e usuários.
  - `util/`: Contém classes utilitárias.
    - `DataLoader.java`: Responsável por carregar dados de exemplo no sistema para testes e demonstração.
    - `InputHandler.java`: Facilita a leitura de entrada do usuário via console.
  - `view/`: Contém classes relacionadas à interface do usuário (console).
    - `Menu.java`: Exibe os menus da aplicação e lida com a interação do usuário.
    - `TestCases.java`: Contém uma série de testes automatizados para verificar a funcionalidade do sistema.

## Como Rodar o Projeto

Para compilar e executar este projeto, você precisará ter o Java Development Kit (JDK) instalado (versão 17 ou superior é recomendada).

1.  **Navegue até o diretório raiz do projeto:**

2.  **Compile os arquivos Java:**

    ```bash
    mvn clean compile
    ```

3.  **Execute a aplicação:**

    ```bash
    mvn exec:java  -Dexec.mainClass="src.main.java.Main"
    ```

    Ao executar, você será apresentado a um menu inicial. Você pode digitar `ciente` para interagir com o sistema ou `teste` para rodar os casos de teste automatizados.

## Informações Úteis

-   **Dados Iniciais:** O projeto carrega dados de exemplo (autores, livros e usuários) automaticamente ao iniciar, através da classe `DataLoader`.
-   **Tratamento de Erros:** O sistema inclui tratamento básico de erros para entradas inválidas do usuário e para operações que não podem ser realizadas (ex: emprestar livro indisponível, remover autor com livros emprestados).
-   **Remoção de Autor:** A remoção de um autor resultará na remoção de todos os livros associados a ele, desde que esses livros não estejam emprestados. Se um livro estiver emprestado, ele não será removido e uma mensagem de erro será exibida.
-   **Limpeza de Terminal:** A classe `Menu` possui um método `clearTerminal()` que tenta "limpar" o console para uma melhor experiência de usuário, embora isso seja uma simulação (imprime várias linhas em branco).


