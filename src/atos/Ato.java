package atos;

import inimigos.Inimigo;
import personagens.Personagem;
import state.GameState;

import java.util.List;

public abstract class Ato {
    protected String descricao;
    protected List<Inimigo> inimigos;
    protected Personagem jogador;
    protected Inimigo chefe;
    protected GameState gameState;

    // Modifica o construtor para aceitar GameState
    public Ato(String descricao, GameState gameState) {
        this.descricao = descricao;
        this.gameState = gameState;
    }

    public abstract void iniciar(Personagem jogador);

    public GameState getGameState() {
        return gameState;
    }
}
