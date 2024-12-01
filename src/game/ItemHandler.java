package game;

import personagens.Personagem;
import itens.Item;
import factory.ItemFactory;

import java.util.Map;
import java.util.Scanner;

public class ItemHandler {
    ItemFactory itemFactory = new ItemFactory();
    private Personagem jogador;
    private Scanner scanner;

    public ItemHandler(Personagem jogador) {
        this.jogador = jogador;
        this.scanner = new Scanner(System.in);
    }

    public void adicionarItem(String nomeItem) {
        try {
            Item item = itemFactory.criar(nomeItem);
            jogador.adicionarItemNaMochila(item); // Atualiza o mapa com o novo item
            System.out.println("Item \"" + item.getNome() + "\" adicionado à mochila.");
        } catch (IllegalArgumentException e) {
            System.out.println("Item desconhecido: " + nomeItem);
        }
    }

    public void removerItem(String nomeItem) {
        Map<String, Integer> mochila = jogador.getMochila();

        if (mochila.containsKey(nomeItem)) {
            int quantidade = mochila.get(nomeItem);
            if (quantidade > 1) {
                mochila.put(nomeItem, quantidade - 1);
            } else {
                mochila.remove(nomeItem);
            }
            System.out.println("Item \"" + nomeItem + "\" foi removido da sua mochila.");
        } else {
            System.out.println("Item \"" + nomeItem + "\" não encontrado na mochila.");
        }
    }

    public void visualizarItens() {
        Map<String, Integer> mochila = jogador.getMochila();

        if (mochila.isEmpty()) {
            System.out.println("Sua mochila está vazia.");
        } else {
            System.out.println("\nItens disponíveis na mochila:");
            int index = 1;
            for (Map.Entry<String, Integer> entry : mochila.entrySet()) {
                System.out.println(index++ + ". " + entry.getKey() + " (Quantidade: " + entry.getValue() + ")");
            }
        }
    }

    public void usarItem(String nomeItem) {
        Map<String, Integer> mochila = jogador.getMochila();

        if (mochila.containsKey(nomeItem)) {
            Item item = itemFactory.criar(nomeItem); // Cria uma instância do item para usar seus efeitos
            System.out.println("\nVocê usou: " + item.getNome());
            item.usar(jogador);

            if (item.isConsumivel()) {
                removerItem(nomeItem);
            }
        } else {
            System.out.println("Item \"" + nomeItem + "\" não encontrado na mochila.");
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

            Map<String, Integer> mochila = jogador.getMochila();
            if (escolha < 1 || escolha > mochila.size()) {
                System.out.println("Opção inválida! Tente novamente.");
                continue;
            }

            String nomeItemEscolhido = (String) mochila.keySet().toArray()[escolha - 1];
            usarItem(nomeItemEscolhido);
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
