package command;

import personagens.Personagem;
import itens.Item;

public class RemoverItemCommand implements Command {

    private Personagem jogador;
    private String nomeItem;

    public RemoverItemCommand(Personagem jogador, String nomeItem) {
        this.jogador = jogador;
        this.nomeItem = nomeItem;
    }

    @Override
    public void execute() {
        // Remove o item da mochila
        jogador.getMochila().removeIf(item -> item.getNome().equals(nomeItem));
        System.out.println(nomeItem + " foi removido da sua mochila.");
    }
}
