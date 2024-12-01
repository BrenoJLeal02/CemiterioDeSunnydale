package state;

import atos.Ato;
import atos.AtoDois;
import atos.AtoUm;
import personagens.Personagem;

public class GameState {
    private Ato estadoAtual;
    private Personagem jogador;

    public GameState(Personagem jogador) {
        this.jogador = jogador;
        this.estadoAtual = new AtoUm(this, jogador); // Inicializa com o Ato 1
    }

    public void iniciarAto() {
        estadoAtual.iniciar(jogador); // Inicia o ato atual
    }

    public void avancarParaProximoAto() {
        if (!jogoCompleto()) {
            estadoAtual.avancar();  // Chama o avançar do ato atual

            // Garantir que a transição para o AtoDois aconteça de forma controlada
            if (estadoAtual instanceof AtoDois) {
                System.out.println("Você avançou para o Ato 2!");
            }
        } else {
            finalizarJogo();  // Se o jogo estiver completo, finaliza
        }
    }


    public void setEstadoAtual(Ato novoEstado) {
        this.estadoAtual = novoEstado; // Define o próximo ato/estado
    }

    public Ato getEstadoAtual() {
        return estadoAtual; // Retorna o estado atual
    }

    public boolean jogoCompleto() {
        return estadoAtual instanceof AtoDois; // O jogo é completado após o Ato 2
    }

    public void finalizarJogo() {
        System.out.println("O jogo foi finalizado.");
        // Lógica de finalização, como salvar progresso, etc.
    }
}
