package command;

import personagens.Personagem;
import factory.ItemFactory;

public class AdicionarItemCommand implements Command {
    private Personagem jogador;
    private String nomeItem;

    public AdicionarItemCommand(Personagem jogador, String nomeItem) {
        this.jogador = jogador;
        this.nomeItem = nomeItem;
    }

    @Override
    public void execute() {
        try {
            itens.Item item = ItemFactory.criarItem(nomeItem); // Cria o item com a fábrica
            jogador.adicionarItemNaMochila(item); // Adiciona o item na mochila do jogador
            System.out.println("Item " + item.getNome() + " adicionado à mochila.");
        } catch (IllegalArgumentException e) {
            System.out.println("Item desconhecido: " + nomeItem);
        }
    }
}
