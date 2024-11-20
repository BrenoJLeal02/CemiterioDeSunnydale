package state;

import atos.Ato;
import personagens.Personagem;

import java.util.List;

public class GameState {
    private Personagem jogador;
    private List<Ato> atos;
    private int atoAtual;

    public GameState(Personagem jogador, List<Ato> atos) {
        this.jogador = jogador;
        this.atos = atos;
        this.atoAtual = 0;
    }

    public Personagem getJogador() {
        return jogador;
    }

    public void setJogador(Personagem jogador) {
        this.jogador = jogador;
    }

    public Ato getAtoAtual() {
        return atos.get(atoAtual);
    }

    public void avancarParaProximoAto() {
        if (atoAtual < atos.size() - 1) {
            atoAtual++;
        } else {
            System.out.println("Você completou todos os atos! Parabéns!");
        }
    }

    public boolean jogoCompleto() {
        return atoAtual >= atos.size();
    }

    public int getNumeroAtoAtual() {
        return atoAtual + 1; // Retorna um índice mais intuitivo (1, 2, 3...).
    }
}
