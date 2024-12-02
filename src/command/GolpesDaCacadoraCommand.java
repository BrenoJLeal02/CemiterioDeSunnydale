package command;

import inimigos.Inimigo;
import personagens.Slayer;

public class GolpesDaCacadoraCommand implements Command {
    private Slayer slayer;
    private Inimigo inimigo;
    private int chance;

    public GolpesDaCacadoraCommand(Slayer slayer, Inimigo inimigo, int chance) {
        this.slayer = slayer;
        this.inimigo = inimigo;
        this.chance = chance;
    }

    @Override
    public void execute() {
        if (chance > 17) {
            int dano = chance * 2 - 5;
            System.out.println("\nVocê ataca o inimigo com um chute aéreo e causa " + dano + " de dano ao inimigo!");
            inimigo.setHp(inimigo.getHp() - dano);
        } else if (chance < 5) {
            int dano = 5 - chance;
            System.out.println("\nVocê erra o golpe e perde o equilíbrio, recebendo " + dano + " de dano!");
            slayer.setHp(slayer.getHp() - dano);
        } else {
            int dano = chance - 3;
            System.out.println("\nVocê ataca o inimigo com um soco e causa " + dano + " de dano ao inimigo!");
            inimigo.setHp(inimigo.getHp() - dano);
        }
    }
}