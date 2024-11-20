package command;

import personagens.Personagem;
import itens.Item;
import java.util.List;
import java.util.Scanner;

public class UsarItemCompostoCommand implements Command {
    private Personagem jogador;
    private Scanner scanner;

    public UsarItemCompostoCommand(Personagem jogador) {
        this.jogador = jogador;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        // 1. Exibir itens na mochila
        Command visualizarItemCommand = new VisualizarItemCommand(jogador);
        visualizarItemCommand.execute();

        // 2. Solicitar escolha do item
        System.out.print("\nEscolha o número do item para usar ou 0 para voltar: ");
        int escolha = scanner.nextInt();

        if (escolha == 0) {
            System.out.println("Voltando para o combate...");
            return; // Retorna para o combate sem fazer nada
        }

        List<Item> itens = jogador.getMochila();
        if (escolha < 1 || escolha > itens.size()) {
            System.out.println("Opção inválida!");
            return;
        }

        // 3. Pega o item escolhido
        Item itemEscolhido = itens.get(escolha - 1);
        System.out.println("Você escolheu: " + itemEscolhido.getNome());

        // 4. Usar o item
        Command usarItemCommand = new UsarItemCommand(jogador, itemEscolhido);
        usarItemCommand.execute();

        // 5. Remover item da mochila, se consumível
        if (itemEscolhido.isConsumivel()) {
            Command removerItemCommand = new RemoverItemCommand(jogador, itemEscolhido.getNome());
            removerItemCommand.execute();
        }
    }
}
