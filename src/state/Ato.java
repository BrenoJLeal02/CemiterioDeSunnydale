package state;

import personagens.Personagem;

public interface Ato {
    void iniciar(Personagem jogador);
    boolean ultimoAto();
    int escolhaDeCaminho();
}
