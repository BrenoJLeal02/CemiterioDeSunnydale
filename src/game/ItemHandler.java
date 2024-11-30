package game;

import personagens.Personagem;
import itens.Item;
import factory.ItemFactory;

import java.util.List;
import java.util.Scanner;

public class ItemHandler {

    private Personagem jogador;
    private Scanner scanner;

    public ItemHandler(Personagem jogador) {
        this.jogador = jogador;
        this.scanner = new Scanner(System.in);
    }

    public void adicionarItem(String nomeItem) {
        try {
            Item item = ItemFactory.criarItem(nomeItem);
            jogador.adicionarItemNaMochila(item);
            System.out.println("Item " + item.getNome() + " adicionado à mochila.");
        } catch (IllegalArgumentException e) {
            System.out.println("Item desconhecido: " + nomeItem);
        }
    }

    public void removerItem(String nomeItem) {
        boolean removido = jogador.getMochila().removeIf(item -> item.getNome().equals(nomeItem));
        if (removido) {
            System.out.println(nomeItem + " foi removido da sua mochila.");
        } else {
            System.out.println("Item " + nomeItem + " não encontrado na mochila.");
        }
    }

    public void visualizarItens() {
        List<Item> mochila = jogador.getMochila();

        if (mochila.isEmpty()) {
            System.out.println("Sua mochila está vazia.");
        } else {
            System.out.println("\nItens disponíveis na mochila:");
            for (int i = 0; i < mochila.size(); i++) {
                Item item = mochila.get(i);
                System.out.println((i + 1) + ". " + item.getNome() + " - " + item.getDescricao());
            }
        }
    }

    public void usarItem(String nomeItem) {
        // Busca o item pelo nome
        Item item = jogador.getMochila().stream()
                .filter(it -> it.getNome().equals(nomeItem))
                .findFirst()
                .orElse(null);

        if (item != null) {
            System.out.println("\nVocê usou: " + item.getNome());
            item.usar(jogador);

            if (item.isConsumivel()) {
                removerItem(nomeItem);
            }
        } else {
            System.out.println("Item " + nomeItem + " não encontrado na mochila.");
        }
    }

    public void interagirComItens() {
        while (true) {
            visualizarItens();

            System.out.print("\nEscolha o número do item para usar ou 0 para voltar: ");
            int escolha = lerEntrada();

            if (escolha == 0) {
                System.out.println("Voltando para o combate...");
                break;
            }

            List<Item> itens = jogador.getMochila();
            if (escolha < 1 || escolha > itens.size()) {
                System.out.println("Opção inválida! Tente novamente.");
                continue;
            }

            Item itemEscolhido = itens.get(escolha - 1);
            usarItem(itemEscolhido.getNome());
        }
    }

    private int lerEntrada() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("Entrada inválida! Por favor, insira um número.");
            return -1;
        }
    }
}
