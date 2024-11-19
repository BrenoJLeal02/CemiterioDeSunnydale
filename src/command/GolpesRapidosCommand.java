package command;

import inimigos.Inimigo;
import personagens.Vampiro;

public class GolpesRapidosCommand implements Command {
    private Vampiro vampiro;
    private Inimigo inimigo;
    private int chance;

    public GolpesRapidosCommand(Vampiro vampiro, Inimigo inimigo, int chance) {
        this.vampiro = vampiro;
        this.inimigo = inimigo;
        this.chance = chance;
    }

    @Override
    public void execute() {
        if (chance > 17) {
            int dano = chance + 2;
            System.out.println("\nVocê golpeia o inimigo com sua supervelocidade e o atinge com " + dano + " de dano!");
            inimigo.setHp(inimigo.getHp() - dano);
        } else if (chance < 5) {
            int dano = 7 - chance;
            System.out.println("\nO inimigo consegue bloquear seus golpes e contra ataca, te fazendo perder " + dano + " de vida!");
            vampiro.setHp(vampiro.getHp() - dano);
        } else {
            int dano = chance - 3;
            System.out.println("\nVocê golpeia o inimigo com sua supervelocidade e o atinge com " + dano + " de dano!");
            inimigo.setHp(inimigo.getHp() - dano);
        }
    }
}
