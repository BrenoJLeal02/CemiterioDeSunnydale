package state;

import personagens.Personagem;

public interface Ato {
    void iniciar(Personagem jogador);
    void avancar();
    boolean ultimoAto();
}
