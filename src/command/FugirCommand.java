package command;

import inimigos.Inimigo;
import personagens.Personagem;

public class FugirCommand implements Command {
    private Personagem jogador;
    private Inimigo inimigo;

    public FugirCommand(Personagem jogador, Inimigo inimigo) {
        this.jogador = jogador;
        this.inimigo = inimigo;
    }

    @Override
    public void execute() {
        if (Math.random() < 0.5) { // ajustar % de fuga de acordo com rolagem randômica
            System.out.println(jogador.getNome() + " conseguiu fugir do combate com " + inimigo.getNome() + "!");
        } else {
            System.out.println(jogador.getNome() + " falhou ao tentar fugir. O inimigo atacou!");
            int dano = 5; // ajustar o valor
            jogador.setHp(jogador.getHp() - dano);
            System.out.println(jogador.getNome() + " levou " + dano + " de dano ao tentar fugir!");
        }
    }

}
