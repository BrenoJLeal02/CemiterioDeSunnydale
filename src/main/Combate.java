package main;

import command.AtacarCommand;
import command.FugirCommand;
import command.UsarItemCommand;
import inimigos.Inimigo;
import personagens.Personagem;

import java.util.Scanner;

public class Combate {
    private Personagem jogador;
    private Inimigo inimigo;
    private AtacarCommand ataqueCommand;
    private FugirCommand fugirCommand;
    private UsarItemCommand usarItemCommand;
    private boolean combateAtivo;  // Variável para controlar se o combate está ativo

    public Combate(Personagem jogador, Inimigo inimigo) {
        this.jogador = jogador;
        this.inimigo = inimigo;
        this.ataqueCommand = new AtacarCommand();
        this.fugirCommand = new FugirCommand(jogador, inimigo, this); // Passando o combate para o FugirCommand
        this.usarItemCommand = new UsarItemCommand(jogador);
        this.combateAtivo = true;  // O combate começa ativo
    }

    public void iniciarCombate() {
        Scanner scanner = new Scanner(System.in);
        while (combateAtivo && jogador.getHp() > 0 && inimigo.getHp() > 0) {
            System.out.println("\nSua vez de agir!");
            System.out.println("1. Atacar");
            System.out.println("2. Defender");
            System.out.println("3. Usar Itens");
            System.out.println("4. Fugir");
            System.out.print("Escolha uma ação: ");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    ataqueCommand.executarAtaque(jogador, inimigo);
                    break;
                case 2:
                    defender();
                    break;
                case 3:
                    usarItemCommand.execute();  // Executa o comando de usar item
                    break;
                case 4:
                    fugirCommand.execute();  // Executa o comando de fuga
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }

            System.out.println("Inimigo: " + inimigo.getHp() + " HP restantes.");
            System.out.println("Você: " + jogador.getHp() + " HP restantes.");
        }

        if (jogador.getHp() <= 0) {
            System.out.println("\nVocê foi derrotado... Tente novamente.");
        } else if (inimigo.getHp() <= 0) {
            System.out.println("\nVocê derrotou o inimigo!");
        }

        // Encerramento do combate
        if (!combateAtivo) {
            System.out.println("\nVocê fugiu do combate.");
        }
    }

    public void defender() {
        System.out.println("\nVocê se prepara para a defesa, aumentando sua chance de evitar o ataque.");
        jogador.setAc(jogador.getAc() + 2);
    }

    // Método para encerrar o combate
    public void encerrarCombate() {
        this.combateAtivo = false;  // Define o combate como não ativo
    }

    //Seria bom criar um metodo de drop de itens no combate para adicionar coisas na mochila
}
