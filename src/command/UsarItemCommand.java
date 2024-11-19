package command;

import personagens.Personagem;

public class UsarItemCommand implements Command {
    private Personagem jogador;

    public UsarItemCommand(Personagem jogador) {
        this.jogador = jogador;
    }

    @Override
    public void execute() {
        // adicionar a lógica para visualizar itens na mochila e utilizá-los
    }
}
