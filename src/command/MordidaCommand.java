package command;

import inimigos.Inimigo;
import inimigos.VampiroBasico;
import inimigos.Zumbi;
import personagens.Vampiro;

public class MordidaCommand implements Command {
    private Vampiro vampiro;
    private Inimigo inimigo;
    private int chance;

    public MordidaCommand(Vampiro vampiro, Inimigo inimigo, int chance) {
        this.vampiro = vampiro;
        this.inimigo = inimigo;
        this.chance = chance;
    }

    @Override
    public void execute() {
        if (inimigo instanceof VampiroBasico || inimigo instanceof Zumbi) {
            System.out.println("\nVocê tentou morder um " + inimigo.getNome() + " e ele conseguiu te atacar com mais velocidade.");
            if (chance < 7) {
                vampiro.setHp(vampiro.getHp() - 2);
                System.out.println("Você perdeu 2 de HP.");
            }
        } else if (chance > 17) {
            int dano = chance + 3;
            System.out.println("\nVocê morde o seu inimigo, causando " + dano + " de dano e recuperando 10 HP!");
            inimigo.setHp(inimigo.getHp() - dano);
            vampiro.setHp(vampiro.getHp() + 10);
        } else {
            int dano = chance + 2;
            System.out.println("\nVocê morde o seu inimigo, causando " + dano + " de dano e recuperando 5 HP!");
            inimigo.setHp(inimigo.getHp() - dano);
            vampiro.setHp(vampiro.getHp() + 5);
        }
    }
}
