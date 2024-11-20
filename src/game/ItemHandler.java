package game;

import personagens.Personagem;
import command.*;
import itens.Item;

import java.util.List;
import java.util.Scanner;

public class ItemHandler {

    private Personagem jogador;
    private Scanner scanner;

    public ItemHandler(Personagem jogador) {
        this.jogador = jogador;
        this.scanner = new Scanner(System.in);
    }

    // Método para interagir com os itens do jogador
    public void interagirComItens() {
        // Exibe os itens na mochila
        Command visualizarItemCommand = new VisualizarItemCommand(jogador); // Executa visualizar itens
        visualizarItemCommand.execute();

        // Solicita ao jogador escolher o item para usar
        System.out.print("\nEscolha o número do item para usar ou 0 para voltar: ");
        int escolha = scanner.nextInt();

        if (escolha == 0) {
            System.out.println("Voltando para o combate...");
            return; // Volta para o combate sem fazer nada
        }

        // Verifica se a escolha está dentro dos limites dos itens
        List<Item> itens = jogador.getMochila();
        if (escolha < 1 || escolha > itens.size()) {
            System.out.println("Opção inválida!");
            return;
        }

        // Pega o item escolhido
        Item itemEscolhido = itens.get(escolha - 1);

        // Executa o comando de usar o item
        Command usarItemCommand = new UsarItemCommand(jogador, itemEscolhido); // Passa o item escolhido
        usarItemCommand.execute();

        // Se o item for consumível, executa o comando para remover o item
        if (itemEscolhido.isConsumivel()) {
            Command removerItemCommand = new RemoverItemCommand(jogador, itemEscolhido.getNome()); // Remove o item
            removerItemCommand.execute();
        }
    }
}
