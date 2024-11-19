package game;

import command.*;
import inimigos.Inimigo;
import personagens.Bruxa;
import personagens.Personagem;
import personagens.Slayer;
import personagens.Vampiro;
import utils.GameUtils;

import java.util.Scanner;

public class AtaqueHandler {

    private GameUtils gameUtils;

    public AtaqueHandler() {
        this.gameUtils = new GameUtils();
    }

    public void atacar(Personagem jogador, Inimigo inimigo) {
        Scanner scanner = new Scanner(System.in);

        if (jogador instanceof Slayer) {
            Slayer slayer = (Slayer) jogador;
            System.out.println("Escolha um tipo de ataque:");
            System.out.println("1. Golpe da Caçadora");
            System.out.println("2. Usar Estaca");
            System.out.println("3. Intimidação");
            System.out.print("Digite sua escolha: ");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    GolpesDaCacadoraCommand golpesCommand = new GolpesDaCacadoraCommand(slayer, inimigo, gameUtils.rolarDados());
                    golpesCommand.execute();
                    break;
                case 2:
                    UsarEstacaCommand usarEstacaCommand = new UsarEstacaCommand(slayer, inimigo, gameUtils.rolarDados());
                    usarEstacaCommand.execute();
                    break;
                case 3:
                    IntimidacaoCommand intimidacaoCommand = new IntimidacaoCommand(slayer, inimigo, gameUtils.rolarDados());
                    intimidacaoCommand.execute();
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } else if (jogador instanceof Bruxa) {
            Bruxa bruxa = (Bruxa) jogador;
            System.out.println("Escolha um tipo de ataque:");
            System.out.println("1. Atordoamento");
            System.out.println("2. Necromancia");
            System.out.println("3. Barreira Mágica");
            System.out.print("Digite sua escolha: ");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    AtordoamentoCommand atordoamentoCommand = new AtordoamentoCommand(bruxa, inimigo, gameUtils.rolarDados());
                    atordoamentoCommand.execute();
                    break;
                case 2:
                    NecromanciaCommand necromanciaCommand = new NecromanciaCommand(bruxa, inimigo, gameUtils.rolarDados());
                    necromanciaCommand.execute();
                    break;
                case 3:
                    BarreiraMagicaCommand barreiraMagicaCommand = new BarreiraMagicaCommand(bruxa, inimigo, gameUtils.rolarDados());
                    barreiraMagicaCommand.execute();
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } else if (jogador instanceof Vampiro) {
            Vampiro vampiro = (Vampiro) jogador;
            System.out.println("Escolha um tipo de ataque:");
            System.out.println("1. Mordida Vampírica");
            System.out.println("2. Golpes com Supervelocidade");
            System.out.println("3. Hipnose");
            System.out.print("Digite sua escolha: ");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    MordidaCommand golpeVampiricoCommand = new MordidaCommand(vampiro, inimigo, gameUtils.rolarDados());
                    golpeVampiricoCommand.execute();
                    break;
                case 2:
                    GolpesRapidosCommand regeneracaoCommand = new GolpesRapidosCommand(vampiro, inimigo, gameUtils.rolarDados());
                    regeneracaoCommand.execute();
                    break;
                case 3:
                    HipnoseCommand hipnoseCommand = new HipnoseCommand(vampiro, inimigo, gameUtils.rolarDados());
                    hipnoseCommand.execute();
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        inimigoAtacar(jogador);
    }

    // Método para o inimigo atacar após o turno do jogador
    private void inimigoAtacar(Personagem jogador) {
        int dano = 20 - gameUtils.rolarDados();
        System.out.println("O inimigo ataca e causa " + dano + " de dano!");
        jogador.setHp(jogador.getHp() - dano);
    }
}
