package game;

import atos.Ato;
import atos.AtoUm;
import factory.PersonagemFactory;
import inimigos.Inimigo;
import personagens.Personagem;
import state.GameState;
import utils.GameUtils;

import java.util.Scanner;

import static utils.GameUtils.*;

public class GameLogic {
    private static Personagem personagem;
    private static GameState atoAtual;
    private static boolean isRunning = false;
    static Scanner scanner = new Scanner(System.in);

    public static void gameLoop() {
        while (isRunning) {
            printMenu();
            int input = readInt("-> ", 3);

            switch (input) {
                case 1:
                    continueJourney();
                    break;
                case 2:
                    limparConsole();
                    personagem.displayStats(personagem);
                    break;
                case 3:
                    System.out.println("Obrigado por jogar! Até a próxima.");
                    isRunning = false;
                    break;
            }
        }
    }

    private static void continueJourney() {
        System.out.println("A aventura ainda está em desenvolvimento...");
        isRunning = false;
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


        personagem = PersonagemFactory.escolherEInstanciarPersonagem(nome);
        limparConsole();
        printTitulo("Bem-vindo ao jogo, " + personagem.getNome() + "!");
        personagem.iniciarNarrativa();

        continuarHistoria();
        Ato atoUm = new AtoUm(personagem);
        atoUm.iniciar(personagem);

        isRunning = true;

        gameLoop();
    }


}
