package game;

import personagens.Personagem;
import itens.Item;
import factory.ItemFactory;
import java.util.List;

public class ItemHandler {

    private Personagem jogador;

    public ItemHandler(Personagem jogador) {
        this.jogador = jogador;
    }

    public void adicionarItem(String nomeItem) {
        try {
            Item item = ItemFactory.criarItem(nomeItem);
            jogador.adicionarItemNaMochila(item);
            System.out.println("Item adicionado à mochila: " + item.getNome());
        } catch (IllegalArgumentException e) {
            System.out.println("Item desconhecido: " + nomeItem);
        }
    }

    public void removerItem(Item item) {
        if (jogador.getMochila().contains(item)) {
            jogador.getMochila().remove(item);
            System.out.println("Item " + item.getNome() + " removido da mochila.");
        } else {
            System.out.println("O item não está na mochila.");
        }
    }

    public void visualizarItens() {
        List<Item> itens = jogador.getMochila();
        if (itens.isEmpty()) {
            System.out.println("Sua mochila está vazia.");
        } else {
            System.out.println("\nItens disponíveis na mochila:");
            for (int i = 0; i < itens.size(); i++) {
                System.out.println((i + 1) + ". " + itens.get(i).getNome() + " - " + itens.get(i).getDescricao());
            }
        }
    }

    public void usarItem(int indice) {
        List<Item> itens = jogador.getMochila();
        if (itens.isEmpty()) {
            System.out.println("Você não tem itens para usar!");
            return;
        }

        if (indice < 1 || indice > itens.size()) {
            System.out.println("Opção inválida!");
            return;
        }

        Item itemEscolhido = itens.get(indice - 1);
        System.out.println("\nVocê usou: " + itemEscolhido.getNome());

        itemEscolhido.usar(jogador);

        if (itemEscolhido.isConsumivel()) {
            removerItem(itemEscolhido);
        }
    }
}
