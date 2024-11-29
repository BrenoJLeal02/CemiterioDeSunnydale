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

    // Método para adicionar um item à mochila
    public void adicionarItem(String nomeItem) {
        try {
            Item item = ItemFactory.criarItem(nomeItem); // Cria o item com a fábrica
            jogador.adicionarItemNaMochila(item); // Adiciona o item na mochila do jogador
            System.out.println("Item " + item.getNome() + " adicionado à mochila.");
        } catch (IllegalArgumentException e) {
            System.out.println("Item desconhecido: " + nomeItem);
        }
    }

    // Método para remover um item da mochila
    public void removerItem(String nomeItem) {
        boolean removido = jogador.getMochila().removeIf(item -> item.getNome().equals(nomeItem));
        if (removido) {
            System.out.println(nomeItem + " foi removido da sua mochila.");
        } else {
            System.out.println("Item " + nomeItem + " não encontrado na mochila.");
        }
    }

    // Método para visualizar os itens na mochila
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

    // Método para usar um item
    public void usarItem(String nomeItem) {
        // Busca o item pelo nome
        Item item = jogador.getMochila().stream()
                .filter(it -> it.getNome().equals(nomeItem))
                .findFirst()
                .orElse(null);

        if (item != null) {
            System.out.println("\nVocê usou: " + item.getNome());
            item.usar(jogador); // Aplica o efeito do item

            // Remove o item da mochila se ele for consumível
            if (item.isConsumivel()) {
                removerItem(nomeItem);
            }
        } else {
            System.out.println("Item " + nomeItem + " não encontrado na mochila.");
        }
    }

    // Método para interagir com os itens do jogador
    public void interagirComItens() {
        while (true) {
            // Exibe os itens na mochila
            visualizarItens();

            // Solicita ao jogador escolher um item ou sair
            System.out.print("\nEscolha o número do item para usar ou 0 para voltar: ");
            int escolha = lerEntrada();

            if (escolha == 0) {
                System.out.println("Voltando para o combate...");
                break; // Sai do menu de interação
            }

            // Obtém a lista de itens do jogador
            List<Item> itens = jogador.getMochila();
            if (escolha < 1 || escolha > itens.size()) {
                System.out.println("Opção inválida! Tente novamente.");
                continue;
            }

            // Usa o item escolhido
            Item itemEscolhido = itens.get(escolha - 1);
            usarItem(itemEscolhido.getNome());
        }
    }

    // Método para ler a entrada do usuário e tratar exceções
    private int lerEntrada() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine(); // Limpa a entrada inválida
            System.out.println("Entrada inválida! Por favor, insira um número.");
            return -1;
        }
    }
}
