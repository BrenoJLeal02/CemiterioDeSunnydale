package game;

import command.FugirCommand;
import inimigos.Inimigo;
import itens.Item;
import personagens.Personagem;

import java.util.Random;
import java.util.Scanner;

public class Combate {
    private Personagem jogador;
    private Inimigo inimigo;
    private final AtaqueHandler ataqueHandler;
    private final ItemHandler itemHandler;
    private boolean combateAtivo;

    public Combate(Personagem jogador, Inimigo inimigo) {
        this.jogador = jogador;
        this.inimigo = inimigo;
        this.ataqueHandler = new AtaqueHandler();
        this.itemHandler = new ItemHandler(jogador);
        this.combateAtivo = true;
    }

    public void iniciarCombate() {
        Scanner scanner = new Scanner(System.in);
        while (combateAtivo && jogador.getHp() > 0 && inimigo.getHp() > 0) {
            System.out.println("\nSua vez de agir!");
            System.out.println("1. Atacar");
            System.out.println("2. Mochila");
            System.out.println("3. Fugir");
            System.out.print("Escolha uma ação: ");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    ataqueHandler.atacar(jogador, inimigo);
                    break;
                case 2:
                    itemHandler.interagirComItens();
                    break;
                case 3:
                    FugirCommand fugirCommand = new FugirCommand(jogador, inimigo, this);
                    fugirCommand.execute();
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
            dropItem();
        }
    }

    private void dropItem() {
        Random random = new Random();
        int quantidadeItens = random.nextInt(3) + 1;

        System.out.println("\nO inimigo deixou os seguintes itens:");
        for (int i = 0; i < quantidadeItens; i++) {
            Item itemAleatorio = itemHandler.itemFactory.criarItemAleatorio();
            System.out.println("- " + itemAleatorio.getNome());
            itemHandler.adicionarItem(itemAleatorio.getNome());
        }
    }

    public void encerrarCombate() {
        this.combateAtivo = false;
    }
}
