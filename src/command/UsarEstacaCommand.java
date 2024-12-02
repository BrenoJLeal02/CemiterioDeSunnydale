package command;

import inimigos.Inimigo;
import inimigos.VampiroBasico;
import personagens.Slayer;

public class UsarEstacaCommand implements Command {
    private Slayer slayer;
    private Inimigo inimigo;
    private int chance;

    public UsarEstacaCommand(Slayer slayer, Inimigo inimigo, int chance) {
        this.slayer = slayer;
        this.inimigo = inimigo;
        this.chance = chance;
    }

    @Override
    public void execute() {
        if (inimigo instanceof VampiroBasico && chance > 16) {
            inimigo.setHp(0);
            System.out.println("\nVocê acertou a estaca no coração do vampiro e o derrotou!");
        } else if (chance < 4) {
            System.out.println("\nVocê errou o golpe com a estaca e o inimigo conseguiu te atingir com " + 4 + "de dano!");
            slayer.setHp(slayer.getHp() - 4);
        } else {
            int dano = chance + 5;
            inimigo.setHp(inimigo.getHp() - dano);
            System.out.println("\nVocê atingiu o inimigo e causou " + dano + " de dano!");
        }
    }
}
