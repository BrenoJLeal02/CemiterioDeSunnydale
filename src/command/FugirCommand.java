package command;

import inimigos.Inimigo;
import personagens.Personagem;
import game.Combate;

public class FugirCommand implements Command {
    private Personagem jogador;
    private Inimigo inimigo;
    private Combate combate;

    public FugirCommand(Personagem jogador, Inimigo inimigo, Combate combate) {
        this.jogador = jogador;
        this.inimigo = inimigo;
        this.combate = combate;
    }

    @Override
    public void execute() {
        if (Math.random() < 0.5) {
            System.out.println(jogador.getNome() + " conseguiu fugir do combate com " + inimigo.getNome() + "!");
            combate.encerrarCombate();
        } else {
            System.out.println(jogador.getNome() + " falhou ao tentar fugir. O inimigo atacou!");
            int dano = 5;
            jogador.setHp(jogador.getHp() - dano);
            System.out.println(jogador.getNome() + " levou " + dano + " de dano ao tentar fugir!");
        }
    }
}
