package game;

import command.AdicionarItemCommand;
import command.FugirCommand;
import command.UsarItemCommand;
import inimigos.Inimigo;
import itens.Item;
import personagens.Personagem;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import factory.ItemFactory;

public class Combate {
    private Personagem jogador;
    private Inimigo inimigo;
    private AtaqueHandler ataqueHandler;
    private FugirCommand fugirCommand;
    private ItemHandler itemHandler; // Agora usaremos o ItemHandler diretamente
    private boolean combateAtivo;

    public Combate(Personagem jogador, Inimigo inimigo) {
        this.jogador = jogador;
        this.inimigo = inimigo;
        this.ataqueHandler = new AtaqueHandler();
        this.fugirCommand = new FugirCommand(jogador, inimigo, this);
        this.itemHandler = new ItemHandler(jogador); // Instanciamos ItemHandler
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
                    ataqueHandler.atacar(jogador, inimigo); // Executa o ataque
                    break;
                case 2:
                    itemHandler.interagirComItens();
                    break;
                case 3:
                    fugirCommand.execute();  // Executa a fuga
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

        if (!combateAtivo) {
            System.out.println("\nVocê fugiu do combate.");
        }
    }

    private void dropItem() {
        Random random = new Random();
        int quantidadeItens = random.nextInt(3) + 1; // Gera entre 1 e 3 itens aleatórios

        System.out.println("\nO inimigo deixou os seguintes itens:");
        for (int i = 0; i < quantidadeItens; i++) {
            // Cria um item aleatório
            Item itemAleatorio = ItemFactory.criarItemAleatorio(); // Gera um item aleatório do registro

            // Exibe o nome do item
            System.out.println("- " + itemAleatorio.getNome());

            // Adiciona o item à mochila usando o comando apropriado
            AdicionarItemCommand adicionarItemCommand = new AdicionarItemCommand(jogador, itemAleatorio.getNome());
            adicionarItemCommand.execute(); // Executa o comando para adicionar o item à mochila
        }
    }

    public void encerrarCombate() {
        this.combateAtivo = false;
    }
}

