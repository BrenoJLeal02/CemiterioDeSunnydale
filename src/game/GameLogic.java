package game;

import factory.PersonagemFactory;
import personagens.Personagem;
import state.AtoState;

import java.util.Scanner;

import static utils.GameUtils.*;

public class GameLogic {
    private static final PersonagemFactory personagemFactory = new PersonagemFactory();
    private static Personagem jogador;
    private static boolean isRunning = false;
    private static AtoState atoState;

    static Scanner scanner = new Scanner(System.in);

    public static void gameLoop() {
        while (isRunning) {
            printMenu();
            int input = readInt("-> ", 3);
            switch (input) {
                case 1:
                    limparConsole();
                    if (atoState.jogoCompleto()) {
                        isRunning = false;
                    }
                    atoState.iniciarAto(); // Inicia o ato atual
                    continuarHistoria();
                    atoState.avancarParaProximoAto();
                    break;
                case 2:
                    limparConsole();
                    jogador.displayStats(jogador); // Exibe as estatísticas do jogador
                    continuarHistoria();
                    break;
                case 3:
                    System.out.println("Obrigado por jogar! Até a próxima.");
                    isRunning = false; // Finaliza o jogo
                    break;
            }
        }
    }

    public static void iniciarJogo() {
        limparConsole();
        printSeparador(40);
        printSeparador(30);
        System.out.println("CEMITÉRIO DE SUNNYDALE");
        System.out.println("RPG POR ANA CLARA E BRENO LEAL");
        printSeparador(30);
        printSeparador(40);
        continuarHistoria();

        String nome;
        boolean nameSet = false;
        do {
            limparConsole();
            printTitulo("Qual o seu nome?");
            nome = scanner.next();
            limparConsole();
            printTitulo("Seu nome é " + nome + ".\nEstá correto?");
            System.out.println("(1) Sim!");
            System.out.println("(2) Não, eu gostaria de trocar meu nome.");
            int input = readInt("-> ", 2);
            if (input == 1)
                nameSet = true;
        } while (!nameSet);

        limparConsole();

        jogador = personagemFactory.criar(nome); // Criação do personagem
        limparConsole();
        printTitulo("Bem-vindo ao jogo, " + jogador.getNome() + "!");

        jogador.iniciarNarrativa();
        continuarHistoria();

        atoState = new AtoState(jogador); // Inicializa o estado do jogo

        isRunning = true;
        gameLoop(); // Começa o loop do jogo
    }
}
