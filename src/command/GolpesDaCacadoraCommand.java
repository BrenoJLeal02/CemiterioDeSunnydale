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
        int dano = chance * 2;

        if (chance > 17) {
            System.out.println("\nVocê ataca o inimigo com um chute aéreo e causa " + dano + " de dano ao inimigo!");
            inimigo.setHp(inimigo.getHp() - dano);
        } else if (chance < 5) {
            System.out.println("\nVocê erra o golpe e perde o equilíbrio, recebendo " + dano + " de dano!");
            slayer.setHp(slayer.getHp() - dano);
        } else {
            System.out.println("\nVocê ataca o inimigo com um soco e causa " + (dano - 5) + " de dano ao inimigo!");
            inimigo.setHp(inimigo.getHp() - (dano - 5));
        }
    }
}