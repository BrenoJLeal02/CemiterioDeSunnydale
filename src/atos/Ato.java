package atos;

import inimigos.Inimigo;
import personagens.Personagem;

import java.util.List;

public abstract class Ato {
    protected String descricao;
    protected List<Inimigo> inimigos;
    protected Inimigo chefe;

    public Ato(String descricao) {
        this.descricao = descricao;
    }

    public abstract void iniciar(Personagem jogador);


}
