package command;

import inimigos.Inimigo;
import personagens.*;

import java.util.Random;
import java.util.Scanner;

public class AtacarCommand {

    public void executarAtaque(Personagem jogador, Inimigo inimigo) {
        Scanner scanner = new Scanner(System.in);

        if (jogador instanceof Slayer) {
            Slayer slayer = (Slayer) jogador;
            System.out.println("Escolha um tipo de ataque:");
            System.out.println("1. Ataque Poderoso");
            System.out.println("2. Defesa Sólida");
            System.out.println("3. Intimidação");
            System.out.print("Digite sua escolha: ");
            int escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    slayer.ataquePoderoso(inimigo);
                    break;
                case 2:
                    slayer.defesaSolida();
                    break;
                case 3:
                    slayer.intimidacao(inimigo);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } else if (jogador instanceof Bruxa) {
            Bruxa bruxa = (Bruxa) jogador;
            System.out.println("Escolha um tipo de ataque:");
            System.out.println("1. Encantamento");
            System.out.println("2. Necromancia");
            System.out.println("3. Ilusão");
            System.out.print("Digite sua escolha: ");
            int escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    bruxa.encantamento(inimigo);
                    break;
                case 2:
                    bruxa.necromancia(inimigo);
                    break;
                case 3:
                    bruxa.ilusao(inimigo);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } else if (jogador instanceof Vampiro) {
            Vampiro vampiro = (Vampiro) jogador;
            System.out.println("Escolha um tipo de ataque:");
            System.out.println("1. Golpe Vampírico");
            System.out.println("2. Regeneração");
            System.out.println("3. Hipnose");
            System.out.print("Digite sua escolha: ");
            int escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    vampiro.golpeVampirico(inimigo);
                    break;
                case 2:
                    vampiro.regeneracao();
                    break;
                case 3:
                    vampiro.hipnose(inimigo);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        // Ataque do inimigo após o ataque do jogador
        inimigoAtacar(jogador, inimigo);
    }

    // Método para o inimigo atacar após o ataque do jogador
    public void inimigoAtacar(Personagem jogador, Inimigo inimigo) {
        Random rand = new Random();
        int dano = rand.nextInt(6) + 4;  // O inimigo causa dano entre 4 e 9
        System.out.println("O inimigo ataca e causa " + dano + " de dano!");
        jogador.setHp(jogador.getHp() - dano);
    }
}
