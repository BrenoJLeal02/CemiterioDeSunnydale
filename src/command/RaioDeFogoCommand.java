package command;

import inimigos.Inimigo;
import personagens.Bruxa;

public class RaioDeFogoCommand implements Command {
    private Bruxa bruxa;
    private Inimigo inimigo;
    private int chance;

    public RaioDeFogoCommand(Bruxa bruxa, Inimigo inimigo, int chance) {
        this.bruxa = bruxa;
        this.inimigo = inimigo;
        this.chance = chance;
    }

    @Override
    public void execute() {
        if (chance > 17) {
            int dano = chance * 2 - 12;
            System.out.println("\nVocê usa o Raio de Fogo e causa " + dano + " de dano no inimigo!");
            inimigo.setHp(inimigo.getHp() - dano);
        } else if (chance < 6) {
            int dano = 7 - chance;
            System.out.println("\nVocê falha ao tentar invocar o Raio de Fogo e perde " + dano + " de HP!");
            bruxa.setHp(bruxa.getHp() - dano);
        } else {
            int dano = chance + 3;
            System.out.println("\nVocê usa o Raio de Fogo e causa " + dano + " de dano no inimigo!");
            inimigo.setHp(inimigo.getHp() - dano);
        }
    }
}
