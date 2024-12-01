package atos;

import game.ItemHandler;
import inimigos.DemonioBasico;
import personagens.Personagem;
import game.Combate;
import state.GameState;

public class AtoUm implements Ato {
    private GameState gameState;
    private Personagem jogador;

    public AtoUm(GameState gameState, Personagem jogador) {
        this.gameState = gameState;
        this.jogador = jogador;
    }

    @Override
    public void iniciar(Personagem jogador) {
        ItemHandler itemHandler = new ItemHandler(jogador);

        System.out.println("Iniciando Ato 1: Ato Um");


        // Introdução do cenário
        System.out.println("Você acorda em uma pequena vila, o som de pássaros ecoa ao longe...");
        System.out.println("Você encontra um inimigo à sua frente!");
        itemHandler.adicionarItem("poção de cura");
        // Criar inimigo para o combate
        DemonioBasico inimigo = new DemonioBasico("Demônio Básico", 50, 10, 6);

        // Iniciar combate
        Combate combate = new Combate(jogador, inimigo);
        combate.iniciarCombate();  // Lógica de combate

        if (inimigo.getHp() <= 0) {
            System.out.println("Você derrotou o " + inimigo.getNome() + "!");
            gameState.setEstadoAtual(new AtoDois(gameState, jogador));  // Avançar para o AtoDois
        } else {
            System.out.println("O inimigo ainda está de pé, mas você deu um bom golpe.");
        }
        System.out.println("Você concluiu o Ato 1. Preparando para o próximo ato...");
    }


    @Override
    public void avancar() {
        // O avanço do ato já é tratado em `iniciar()`, então este método pode ser simplificado ou removido.
        System.out.println("Avançando para o próximo ato...");
    }
}
