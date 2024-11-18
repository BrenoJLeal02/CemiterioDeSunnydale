package main;

import atos.AtoUm;
import factory.PersonagemFactory;
import inimigos.Inimigo;
import personagens.Personagem;
import state.GameState;
import utils.GameUtils;

import java.util.Scanner;

import static factory.PersonagemFactory.criarPersonagem;
import static utils.GameUtils.*;

public class GameLogic {
    private static Personagem personagem;
    private static GameState atoAtual;
    private static boolean isRunning = false;
    static Scanner scanner = new Scanner(System.in);

    public static void startGame() {
        isRunning = true;

        limparConsole();
        printSeparador(40);
        printSeparador(30);
        System.out.println("CEMITÉRIO DE SUNNYDALE");
        System.out.println("RPG POR ANA CLARA E BRENO LEAL");
        printSeparador(30);
        printSeparador(40);
        continuarHistoria();

        // Definir o nome do jogador
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

        // Escolha do personagem
        while (personagem == null) { // Usando a variável global
            limparConsole();
            printTitulo("Escolha um personagem para iniciar o jogo:");
            System.out.println("(1) Bruxa Poderosa");
            System.out.println("(2) Slayer");
            System.out.println("(3) Vampiro");
            System.out.println("(4) Sair");
            int choice = readInt("-> ", 4);

            switch (choice) {
                case 1:
                    personagem = criarPersonagem("Bruxa Poderosa", nome); // Atribui à variável global
                    break;
                case 2:
                    personagem = criarPersonagem("Slayer", nome);
                    break;
                case 3:
                    personagem = criarPersonagem("Vampiro", nome);
                    break;
                case 4:
                    System.out.println("Saindo do jogo...");
                    isRunning = false;
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }

        // Jogo inicializado com o personagem selecionado
        limparConsole();
        printTitulo("Bem-vindo ao jogo, " + personagem.getNome() + "!");
        personagem.displayStats(personagem);

        // Continuação do loop principal do jogo
        while (isRunning) {

            printTitulo("O que você gostaria de fazer?");
            System.out.println("(1) Ver status do personagem");
            System.out.println("(2) Continuar a aventura");
            System.out.println("(3) Sair do jogo");
            int input = readInt("-> ", 3);

            switch (input) {
                case 1:
                    personagem.displayStats(personagem);
                    break;
                case 2:
                    System.out.println("A aventura ainda está em desenvolvimento...");
                    continuarHistoria();
                    break;
                case 3:
                    System.out.println("Obrigado por jogar! Até a próxima.");
                    isRunning = false;
                    break;
            }
        }
    }


    private static void setAtoAtual(GameState newAct) {
        //definir o ato atual (padrão state)
    }

    private static void gameLoop() {
        //ajustar
    }

    private static void proximoAto() {
        // lógica de mudar ato
    }

    public static void batalha(Inimigo inimigo) {
//        Command attackCommand = new AttackCommand(jogador, inimigo);
//        Command usePotionCommand = new UsePotionCommand(jogador);
//        Command runCommand = new RunCommand(jogador, inimigo);

        while (true) {
            int input = GameUtils.readInt("Escolha sua ação:\n(1) Lutar\n(2) Usar poção\n(3) Fugir -> ", 3);

//            if (input == 1) {
//                attackCommand.execute();
//            } else if (input == 2) {
//                usePotionCommand.execute();
//            } else {
//                runCommand.execute();
//                if (runCommand.isSuccessful()) break;
//            }

            if (personagem.getHp() <= 0) {
                jogadorMorreu();
                break;
            } else if (inimigo.getHp() <= 0) {
                finalDeBatalha(inimigo);
                break;
            }
        }
    }

    private static void finalDeBatalha(Inimigo inimigo) {
        System.out.println("Você derrotou " + inimigo.getNome() + "!");
        // usar a factory de itens pra presentear o jogador
    }

    // Método de utilidade para exibir a mensagem de morte do jogador
    private static void jogadorMorreu() {
        System.out.println("Você foi derrotado. Fim de jogo.");
        isRunning = false;
    }
}
