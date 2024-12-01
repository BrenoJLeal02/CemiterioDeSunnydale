package atos;

import inimigos.Feiticeiro;
import personagens.Personagem;
import game.Combate;
import state.GameState;

public class AtoDois implements Ato {
    private GameState gameState;
    private Personagem jogador;

    public AtoDois(GameState gameState, Personagem jogador) {
        this.gameState = gameState;
        this.jogador = jogador;
    }

    @Override
    public void iniciar(Personagem jogador) {
        System.out.println("Iniciando Ato 2: Ato Dois");

        // Introdução do cenário
        System.out.println("Após derrotar o inimigo na vila, você segue para a floresta...");
        System.out.println("Você se depara com um feiticeiro misterioso.");

        // Criar inimigo para o combate
        Feiticeiro feiticeiro = new Feiticeiro("Feiticeiro", 40, 14, 8);

        // Iniciar combate
        Combate combate = new Combate(jogador, feiticeiro);
        combate.iniciarCombate();  // Lógica de combate

        if (feiticeiro.getHp() <= 0) {
            System.out.println("Você derrotou o " + feiticeiro.getNome() + "!");
        } else {
            System.out.println("O " + feiticeiro.getNome() + " ainda está de pé, mas você conseguiu um bom golpe.");
        }
    }

    @Override
    public void avancar() {
        // Finaliza o jogo após o Ato 2
        System.out.println("é nois");
    }
}
