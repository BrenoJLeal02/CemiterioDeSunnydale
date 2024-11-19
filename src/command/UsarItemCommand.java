package command;

import personagens.Personagem;
import factory.ItemFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsarItemCommand implements Command {
    private Personagem jogador;
    private List<String> itens;  // Lista de itens na mochila do jogador

    public UsarItemCommand(Personagem jogador) {
        this.jogador = jogador;
        this.itens = new ArrayList<>();  // Inicializa a mochila como uma lista vazia
    }

    public void adicionarItem(String nomeItem) {
        String itemCriado = ItemFactory.criarItem(nomeItem);
        if (itemCriado != null) {
            itens.add(itemCriado);  // Adiciona o item à mochila
        } else {
            System.out.println("Item não reconhecido!");
        }
    }

    public void visualizarItens() {
        if (itens.isEmpty()) {
            System.out.println("Sua mochila está vazia.");
        } else {
            System.out.println("Itens na sua mochila:");
            for (int i = 0; i < itens.size(); i++) {
                System.out.println((i + 1) + ". " + itens.get(i));
            }
        }
    }

    @Override
    public void execute() {
        visualizarItens();  // Exibe os itens disponíveis no inventário

        if (itens.isEmpty()) {
            System.out.println("Você não tem itens para usar!");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Escolha um item para usar (digite o número correspondente): ");
        int escolha = scanner.nextInt();

        if (escolha < 1 || escolha > itens.size()) {
            System.out.println("Opção inválida!");
            return;
        }

        String itemEscolhido = itens.get(escolha - 1);  // Seleciona o item

        // Aplica os efeitos do item
        if (itemEscolhido.contains("Poção de Cura")) {
            System.out.println("Você usou uma Poção de Cura! Recuperando 10 HP.");
            jogador.setHp(jogador.getHp() + 10);
        } else if (itemEscolhido.contains("Poção de Mana")) {
            System.out.println("Você usou uma Poção de Mana! Recuperando 10 MP.");
            // jogador.setMp(jogador.getMp() + 10); // Supondo que o jogador tenha MP
        } else if (itemEscolhido.contains("Elixir de Força")) {
            System.out.println("Você usou um Elixir de Força! Aumentando o dano em 5 por 3 turnos.");
            // jogador.setDano(jogador.getDano() + 5); // Supondo que o jogador tenha uma propriedade de dano
        } else {
            System.out.println("Este item não tem efeito implementado.");
        }

        // Remove o item após o uso (exemplo)
        itens.remove(itemEscolhido);
    }
}
