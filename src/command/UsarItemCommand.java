package command;

import personagens.Personagem;
import itens.Item;

public class UsarItemCommand implements Command {

    private Personagem jogador;
    private Item item;

    public UsarItemCommand(Personagem jogador, Item item) {
        this.jogador = jogador;
        this.item = item;
    }

    @Override
    public void execute() {
        // Usando o item
        System.out.println("\nVocê usou: " + item.getNome());
        item.usar(jogador);
    }
}
