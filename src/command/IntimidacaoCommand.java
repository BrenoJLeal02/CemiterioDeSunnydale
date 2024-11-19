package command;

import inimigos.Inimigo;
import personagens.Slayer;

public class IntimidacaoCommand implements Command {
    private Slayer slayer;
    private Inimigo inimigo;
    private int chance;

    public IntimidacaoCommand(Slayer slayer, Inimigo inimigo, int chance) {
        this.slayer = slayer;
        this.inimigo = inimigo;
        this.chance = chance;
    }

    @Override
    public void execute() {
        if (chance > 7) {
            System.out.println("O inimigo fica intimidado e seus ataques causam menos dano nos próximos turnos.");
            inimigo.setDano(Math.max(0, inimigo.getDano() - 2));
        } else {
            System.out.println("O inimigo não se intimida e continua com sua força total!");
        }
    }
}
