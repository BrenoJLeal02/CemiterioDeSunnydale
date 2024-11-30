package game;

import atos.Ato;

import factory.PersonagemFactory;

import personagens.Personagem;
import state.GameState;
import utils.GameUtils;

import java.util.Scanner;

import static utils.GameUtils.*;

public class GameLogic {
    private static Personagem jogador;
    private static boolean isRunning = false;
    private static GameState gameState;

    static Scanner scanner = new Scanner(System.in);

    public static void gameLoop() {
        while (isRunning) {
            // Exibir o menu
            printMenu();
            int input = readInt("-> ", 3);

            switch (input) {
                case 1:

                    if (gameState.jogoCompleto()) {
                        System.out.println("Você completou todos os atos! Parabéns!");
                        isRunning = false;
                        break;
                    } else {
                        Ato atoAtual = gameState.getAtoAtual();
                        atoAtual.iniciar(jogador);

                        gameState.avancarParaProximoAto();
                    }
                    break;

                case 2:
                    limparConsole();
                    jogador.displayStats(jogador);
                    break;

                case 3:
                    System.out.println("Obrigado por jogar! Até a próxima.");
                    isRunning = false;
                    break;
            }
        }
    }

    public static void startGame() {
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

        jogador = PersonagemFactory.escolherEInstanciarPersonagem(nome);
        limparConsole();
        printTitulo("Bem-vindo ao jogo, " + jogador.getNome() + "!");

        jogador.iniciarNarrativa();

        continuarHistoria();

        gameState = new GameState(jogador);

        gameState.getAtoAtual().iniciar(jogador);

        isRunning = true;
        gameLoop();
    }
}

