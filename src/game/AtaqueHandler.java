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
    private final GameUtils gameUtils;

    public AtaqueHandler() {
        this.gameUtils = new GameUtils();
    }

    public void atacar(Personagem jogador, Inimigo inimigo) {
        Scanner scanner = new Scanner(System.in);

        if (jogador instanceof Slayer slayer) {
            System.out.println("Escolha um tipo de ataque:");
            System.out.println("1. Golpe da Caçadora");
            System.out.println("2. Usar Estaca");
            System.out.println("3. Intimidação");
            System.out.print("Digite sua escolha: ");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    GolpesDaCacadoraCommand golpesCommand = new GolpesDaCacadoraCommand(slayer, inimigo, gameUtils.rolarDadosComExibicao());
                    golpesCommand.execute();
                    break;
                case 2:
                    UsarEstacaCommand usarEstacaCommand = new UsarEstacaCommand(slayer, inimigo, gameUtils.rolarDadosComExibicao());
                    usarEstacaCommand.execute();
                    break;
                case 3:
                    IntimidacaoCommand intimidacaoCommand = new IntimidacaoCommand(slayer, inimigo, gameUtils.rolarDadosComExibicao());
                    intimidacaoCommand.execute();
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } else if (jogador instanceof Bruxa bruxa) {
            System.out.println("Escolha um tipo de ataque:");
            System.out.println("1. Raio de Fogo");
            System.out.println("2. Necromancia");
            System.out.println("3. Barreira Mágica");
            System.out.print("Digite sua escolha: ");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    RaioDeFogoCommand raioDeFogoCommand = new RaioDeFogoCommand(bruxa, inimigo, gameUtils.rolarDadosComExibicao());
                    raioDeFogoCommand.execute();
                    break;
                case 2:
                    NecromanciaCommand necromanciaCommand = new NecromanciaCommand(bruxa, inimigo, gameUtils.rolarDadosComExibicao());
                    necromanciaCommand.execute();
                    break;
                case 3:
                    BarreiraMagicaCommand barreiraMagicaCommand = new BarreiraMagicaCommand(bruxa, inimigo, gameUtils.rolarDadosComExibicao());
                    barreiraMagicaCommand.execute();
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } else if (jogador instanceof Vampiro vampiro) {
            System.out.println("Escolha um tipo de ataque:");
            System.out.println("1. Mordida Vampírica");
            System.out.println("2. Golpes com Supervelocidade");
            System.out.println("3. Hipnose");
            System.out.print("Digite sua escolha: ");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    MordidaCommand golpeVampiricoCommand = new MordidaCommand(vampiro, inimigo, gameUtils.rolarDadosComExibicao());
                    golpeVampiricoCommand.execute();
                    break;
                case 2:
                    GolpesRapidosCommand regeneracaoCommand = new GolpesRapidosCommand(vampiro, inimigo, gameUtils.rolarDadosComExibicao());
                    regeneracaoCommand.execute();
                    break;
                case 3:
                    HipnoseCommand hipnoseCommand = new HipnoseCommand(vampiro, inimigo, gameUtils.rolarDadosComExibicao());
                    hipnoseCommand.execute();
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        inimigoAtacar(jogador, inimigo);
    }

    private void inimigoAtacar(Personagem jogador, Inimigo inimigo) {
        if (inimigo.isHipnotizado()) {
            System.out.println("O inimigo está hipnotizado e não pode atacar neste turno!");
            inimigo.setHipnotizado(false);
        } else if (jogador.getBarreiraAtiva() > 0) {
            System.out.println("A Barreira Mágica está ativa! Você não sofre dano neste turno.");
            jogador.setBarreiraAtiva(jogador.getBarreiraAtiva() - 1); // Reduz a duração da barreira
        } else {
            int chance = gameUtils.rolarDados();
            if (chance > jogador.getAc()) {
                int dano = chance - 5;
                System.out.println("O inimigo ataca e causa " + dano + " de dano!");
                jogador.setHp(jogador.getHp() - dano);
            } else {
                System.out.println("O inimigo não consegue te atingir.");
            }
        }
    }
}
