package command;

import inimigos.Inimigo;
import personagens.Personagem;

public class AtacarCommand implements Command {
    private Personagem jogador;
    private Inimigo inimigo;

    public AtacarCommand(Personagem jogador, Inimigo inimigo) {
        this.jogador = jogador;
        this.inimigo = inimigo;
    }

    @Override
    public void execute() {
        int dano = 5; // ajustar com base na rolagem randômica
        if (dano < 0) dano = 0;
        inimigo.setHp(inimigo.getHp() - dano);

        if (inimigo.getHp() <= 0) {
            System.out.println(inimigo.getNome() + " foi derrotado!");
            // inserir alguma recompensa
        }
    }
}
