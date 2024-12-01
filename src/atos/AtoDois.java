package atos;

import inimigos.DemonioBasico;
import inimigos.Feiticeiro;
import personagens.Personagem;
import game.Combate;
import game.ItemHandler;
import state.GameState;

import static utils.GameUtils.continuarHistoria;
import static utils.GameUtils.limparConsole;

public class AtoDois extends Ato {

    public AtoDois(Personagem jogador, GameState gameState) {
        super("Ato Dois", gameState);
    }

    @Override
    public void iniciar(Personagem jogador) {

        limparConsole();
        System.out.println("Após o combate, você segue em direção à floresta para encontrar respostas.");
        System.out.println("A vila parece mais calma agora, mas a sensação de algo sombrio ainda paira no ar.");
        System.out.println("O ancião lhe contou sobre uma força maligna que se aproxima, e você deve impedi-la antes que seja tarde demais.");


        Feiticeiro inimigo = new Feiticeiro("Feiticeiro", 40, 14, 8);
        System.out.println("De repente, a terra treme sob seus pés, e um " + inimigo.getNome() + " surge das sombras, com uma aura ameaçadora.");


        Combate combate = new Combate(jogador, inimigo, getGameState());
        combate.iniciarCombate();


        if (inimigo.getHp() <= 0) {
            System.out.println("Você derrotou o " + inimigo.getNome() + "! A ameaça foi afastada, mas você sabe que ainda há mais perigos à frente.");
        } else {
            System.out.println("O " + inimigo.getNome() + " ainda está de pé, mas você conseguiu um golpe crucial.");
        }


        System.out.println("Com o " + inimigo.getNome() + " derrotado, você descobre um mapa antigo nas suas posses, indicando a localização de um novo desafio...");
        continuarHistoria();



    }
}
