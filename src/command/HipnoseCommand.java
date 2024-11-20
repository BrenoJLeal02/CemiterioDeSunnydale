package command;

import inimigos.Inimigo;
import personagens.Vampiro;

public class HipnoseCommand implements Command {

    private Vampiro vampiro;
    private Inimigo inimigo;
    private int chance;

    public HipnoseCommand(Vampiro vampiro, Inimigo inimigo, int chance) {
        this.vampiro = vampiro;
        this.inimigo = inimigo;
        this.chance = chance;
    }

    @Override
    public void execute() {
        if (chance > 17) {
            int dano = chance - 15;
            System.out.println("A hipnose tem sucesso! O inimigo está paralisado e não pode atacar por um turno. Você o atinge causando " + dano + " de dano!");
            inimigo.setHp(inimigo.getHp() - dano);
            inimigo.setHipnotizado(true);
        } else if (chance < 5) {
            int dano = 6 - chance;
            System.out.println("A hipnose falha e o inimigo te ataca, tirando " + dano + " do seu HP!");
            vampiro.setHp(vampiro.getHp() - dano);
        } else {
            System.out.println("A hipnose falha, e o inimigo continua sua ofensiva.");
        }
    }
}
