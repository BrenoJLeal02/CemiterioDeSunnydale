package state;

import personagens.Personagem;

import java.util.ArrayList;
import java.util.List;

public class AtoState {
    private List<Ato> atos; // Lista de atos, permitindo flexibilidade para adicionar mais
    private int indiceAtual; // Indica o ato atual na lista
    private Personagem jogador;

    public AtoState(Personagem jogador) {
        this.jogador = jogador;
        this.atos = new ArrayList<>();
        configurarAtoInicial();
    }

    private void configurarAtoInicial() {
        atos.add(new AtoUm(this, jogador)); // Adiciona o primeiro ato
        atos.add(new AtoDois(this, jogador)); // Adiciona o segundo ato
        this.indiceAtual = 0; // Começa no primeiro ato
    }

    public void iniciarAto() {
        if (indiceAtual < atos.size()) {
            atos.get(indiceAtual).iniciar(jogador); // Inicia o ato atual
        } else {
            finalizarJogo(); // Se não houver mais atos, finaliza o jogo
        }
    }

    public void avancarParaProximoAto() {
        if (!jogoCompleto()) {
            indiceAtual++; // Avança para o próximo ato
        } else {
            finalizarJogo(); // Se o jogo estiver completo, finaliza
        }
    }

    public boolean jogoCompleto() {
        // Verifica se o índice atual é o último na lista de atos
        return getEstadoAtual().ultimoAto();
    }

    public void finalizarJogo() {
        System.out.println("TO BE CONTINUED...");
    }

    // Getter para o estado atual
    public Ato getEstadoAtual() {
        return atos.get(indiceAtual);
    }
}
