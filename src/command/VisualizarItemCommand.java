package command;

import personagens.Personagem;

public class VisualizarItemCommand implements Command {

    private Personagem jogador;

    public VisualizarItemCommand(Personagem jogador) {
        this.jogador = jogador;
    }

    @Override
    public void execute() {
        if (jogador.getMochila().isEmpty()) {
            System.out.println("Sua mochila está vazia.");
        } else {
            System.out.println("\nItens disponíveis na mochila:");
            for (int i = 0; i < jogador.getMochila().size(); i++) {
                System.out.println((i + 1) + ". " + jogador.getMochila().get(i).getNome() + " - " + jogador.getMochila().get(i).getDescricao());
            }
        }
    }
}
