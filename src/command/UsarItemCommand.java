package command;

import personagens.Personagem;
import itens.Item;
import factory.ItemFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsarItemCommand implements Command {
    private Personagem jogador;
    private List<Item> itens; // Lista de itens disponíveis na mochila do jogador

    public UsarItemCommand(Personagem jogador) {
        this.jogador = jogador;
        this.itens = jogador.getMochila();
    }

    // adiciona itens diretamente na mochila
    public void adicionarItem(String nomeItem) {
        try {
            Item item = ItemFactory.criarItem(nomeItem);
            jogador.adicionarItemNaMochila(item); // Adiciona à mochila do personagem
            System.out.println("Item adicionado à mochila do personagem: " + item.getNome());
        } catch (IllegalArgumentException e) {
            System.out.println("Item não reconhecido: " + nomeItem);
        }
    }


    // Exibe os itens disponíveis na mochila
    public void visualizarItens() {
        if (itens.isEmpty()) {
            System.out.println("Sua mochila está vazia.");
        } else {
            System.out.println("\nItens na sua mochila:");
            for (int i = 0; i < itens.size(); i++) {
                System.out.println((i + 1) + ". " + itens.get(i).getNome() + " - " + itens.get(i).getDescricao());
            }
        }
    }

    @Override
    public void execute() {
        // Exibe os itens disponíveis para o jogador
        visualizarItens();

        // Verifica se há itens na mochila
        if (itens.isEmpty()) {
            System.out.println("Você não tem itens para usar!");
            return;
        }

        // Solicita a escolha do jogador
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEscolha um item para usar (digite o número correspondente): ");
        int escolha = scanner.nextInt();

        // Valida a escolha
        if (escolha < 1 || escolha > itens.size()) {
            System.out.println("Opção inválida!");
            return;
        }

        // Obtém o item escolhido
        Item itemEscolhido = itens.get(escolha - 1);

        // Usa o item no jogador
        System.out.println("\nVocê usou: " + itemEscolhido.getNome());
        itemEscolhido.usar(jogador);

        // Remove o item consumido da mochila
        itens.remove(itemEscolhido);
        System.out.println("O item foi consumido e removido da sua mochila.");
    }
}
