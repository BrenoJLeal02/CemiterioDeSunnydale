package state;

import inimigos.Feiticeiro;
import personagens.Bruxa;
import personagens.Personagem;
import game.Combate;
import personagens.Slayer;
import personagens.Vampiro;

public class AtoDois implements Ato {
    private AtoState atoState;
    private Personagem jogador;

    public AtoDois(AtoState atoState, Personagem jogador) {
        this.atoState = atoState;
        this.jogador = jogador;
    }

    @Override
    public void iniciar(Personagem jogador) {
        System.out.println("Iniciando Ato 2: O Feiticeiro na Floresta");

        System.out.println("Após a batalha com o demônio, você se adentra mais na floresta. O silêncio é quase opressor,");
        System.out.println("mas algo na atmosfera faz o ambiente vibrar, como se a própria terra estivesse inquieta.");
        System.out.println("De repente, à sua frente, surge uma figura sombria. Um feiticeiro, seus olhos emitindo uma luz etérea,");
        System.out.println("seus gestos ágeis e predatórios, como se tudo ao seu redor fosse parte de sua magia.");

        if (jogador instanceof Bruxa) {
            System.out.println("Uma onda de energia corre por você. Ele conhece a magia como você conhece,");
            System.out.println("mas a sua é distorcida. O que é isso, afinal? Um aliado perdido ou um inimigo mais forte?");
        } else if (jogador instanceof Slayer) {
            System.out.println("Você o observa com desconfiança. Uma ameaça para todos que respiram.");
            System.out.println("Não há lugar para compaixão, apenas uma missão: eliminar o mal. Esse feiticeiro é mais um obstáculo.");
        } else if (jogador instanceof Vampiro) {
            System.out.println("O feiticeiro pode ser apenas mais uma peça no jogo de poder, mas... há algo nele.");
            System.out.println("Sua magia parece diferente de tudo que você já enfrentou. Ele é um desafio, mais do que uma simples caça.");
        }

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

        avancar();
    }

    @Override
    public void avancar() {
        // Finaliza o jogo após o Ato 2
        System.out.println("é nois");
        atoState.avancarParaProximoAto();
    }

    @Override
    public boolean ultimoAto() {
        return true;
    }
}
