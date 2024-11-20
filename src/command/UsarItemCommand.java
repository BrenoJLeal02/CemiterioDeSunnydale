package command;

import game.ItemHandler;
import personagens.Personagem;
import java.util.Scanner;

public class UsarItemCommand implements Command {
    private Personagem jogador;
    private ItemHandler itemHandler;

    public UsarItemCommand(Personagem jogador) {
        this.jogador = jogador;
        this.itemHandler = new ItemHandler(jogador);
    }

    @Override
    public void execute() {
        itemHandler.visualizarItens();

        if (jogador.getMochila().isEmpty()) {
            System.out.println("Você não tem itens para usar!");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEscolha um item para usar (digite o número correspondente): ");
        int escolha = scanner.nextInt();

        itemHandler.usarItem(escolha);
    }
}
