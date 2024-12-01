package state;

import atos.Ato;
import atos.AtoDois;
import atos.AtoUm;
import personagens.Personagem;

import java.util.List;

public class GameState {
    private Personagem jogador;
    private List<Ato> atos;
    private int atoAtual;

    public GameState(Personagem jogador) {
        this.jogador = jogador;
        this.atos = List.of(new AtoUm(jogador, this), new AtoDois(jogador, this));  // Passa o GameState para os Atos
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
            System.out.println("Avançando para o Ato " + (atoAtual + 1));
        }else{
            jogoCompleto();
        }
    }

    public boolean jogoCompleto() {
        return atoAtual >= atos.size();

    }

    public int getNumeroAtoAtual() {
        return atoAtual + 1;
    }
}
