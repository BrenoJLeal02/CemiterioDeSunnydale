package command;

import inimigos.Inimigo;
import personagens.Bruxa;

public class AtordoamentoCommand implements Command {

    private Bruxa bruxa;
    private Inimigo inimigo;
    private int chance;

    public AtordoamentoCommand(Bruxa bruxa, Inimigo inimigo, int chance) {
        this.bruxa = bruxa;
        this.inimigo = inimigo;
        this.chance = chance;
    }

    @Override
    public void execute() {
        if (chance > 17) {
            int dano = chance * 2 - 10;
            System.out.println("\nVocê usa seu feitiço de Atordoamento e causa " + dano + " de dano no inimigo!");
            inimigo.setHp(inimigo.getHp() - dano);
        } else if (chance < 7) {
            int dano = 10 - chance;
            System.out.println("\nVocê falha ao tentar fazer o feitiço de Atordoamento e perde " + dano + " de HP!");
            bruxa.setHp(bruxa.getHp() - dano);
        } else {
            int dano = chance + 4;
            System.out.println("\nVocê usa seu feitiço de Atordoamento e causa " + dano + " de dano no inimigo!");
            inimigo.setHp(inimigo.getHp() - dano);
        }
    }
}
