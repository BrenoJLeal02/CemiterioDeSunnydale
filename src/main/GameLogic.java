package main;

import atos.AtoUm;
import factory.PersonagemFactory;
import inimigos.Inimigo;
import personagens.Personagem;
import state.GameState;
import utils.GameUtils;

public class GameLogic {
    private static Personagem jogador;
    private static GameState atoAtual;
    private static boolean isRunning = false;

    public static void startGame() {
        GameUtils.limparConsole();
        GameUtils.printSeparador(40);
        System.out.println("ESCOLHA SEU PERSONAGEM:");
        System.out.println("(1) Bruxa");
        System.out.println("(2) Slayer");
        System.out.println("(3) Vampiro");
        int choice = GameUtils.readInt("-> ", 3);

        // Criação do jogador usando a fábrica de personagens
        jogador = PersonagemFactory.criarPersonagem(choice, GameUtils.getPlayerName());
        GameUtils.printSeparador(40);
        System.out.println("Bem-vindo, " + jogador.getNome() + "! Sua jornada começa...");
        GameUtils.continuarHistoria();

//        inicializa o jogo com o estado atual
//        setAtoAtual();
        isRunning = true;
        gameLoop();
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

            if (jogador.getHp() <= 0) {
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
