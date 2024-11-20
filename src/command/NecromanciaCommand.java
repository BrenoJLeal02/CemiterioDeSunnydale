package command;

import inimigos.Inimigo;
import personagens.Bruxa;

public class NecromanciaCommand implements Command {
    private Bruxa bruxa;
    private Inimigo inimigo;
    private int chance;

    public NecromanciaCommand(Bruxa bruxa, Inimigo inimigo, int chance) {
        this.bruxa = bruxa;
        this.inimigo = inimigo;
        this.chance = chance;
    }

    @Override
    public void execute() {
        if (chance > 17) {
            int dano = chance * 2 - 5;
            System.out.println("\nVocê usa a Necromancia, invocando energia das trevas e causando " + dano + " de dano ao inimigo!");
            inimigo.setHp(inimigo.getHp() - dano);
        } else if (chance < 10) {
            int dano = 10 - chance;
            System.out.println("\nVocê é tomada pela energia das trevas que tentou invocar e perde " + dano + " de HP!");
            bruxa.setHp(bruxa.getHp() - dano);
        } else {
            int dano = chance + 4;
            System.out.println("\nVocê usa a Necromancia, invocando energia das trevas e causando " + dano + " de dano ao inimigo mas também sofre uma perda no seu HP.");
            inimigo.setHp(inimigo.getHp() - dano);
            bruxa.setHp(bruxa.getHp() - 2);
        }
    }

}
