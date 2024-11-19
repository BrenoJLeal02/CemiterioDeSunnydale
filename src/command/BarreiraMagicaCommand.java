package command;

import inimigos.Inimigo;
import personagens.Bruxa;

public class BarreiraMagicaCommand implements Command {
    private Bruxa bruxa;
    private Inimigo inimigo;
    private int chance;

    public BarreiraMagicaCommand(Bruxa bruxa, Inimigo inimigo, int chance) {
        this.bruxa = bruxa;
        this.inimigo = inimigo;
        this.chance = chance;
    }

    @Override
    public void execute() {
        if (chance < 4) {
            int vida = 7 - chance;
            System.out.println("\nVocê erra ao tentar utilizar a Barreira Mágica e aumenta o HP do inimigo em " + vida);
            inimigo.setHp(inimigo.getHp() + vida);
        } else {
            int vida = chance + 2;
            System.out.println("\nVocê cria uma Barreira Mágica e aumenta seu HP em " + vida + "!");
            bruxa.setHp(bruxa.getHp() + vida);
        }
    }
}
