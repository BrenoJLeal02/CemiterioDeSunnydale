package atos;

import inimigos.DemonioBasico;
import inimigos.Inimigo;
import personagens.Personagem;
import command.AtacarCommand;
import command.FugirCommand;
import command.UsarItemCommand;
import main.Combate; // Importar a classe Combate

import static utils.GameUtils.continuarHistoria;

public class AtoUm {

    public static void iniciarAtoUm(Personagem jogador) {
        // Introdução ao cenário
        System.out.println("Você acorda em uma pequena vila, o som de pássaros ecoa ao longe e o cheiro de madeira queimada preenche o ar.");
        System.out.println("À sua frente, a aldeia parece tranquila, mas algo em seus instintos lhe diz que algo não está certo.");
        System.out.println("A vila foi recentemente atacada por uma misteriosa força, e os aldeões estão em busca de heróis para defender seu lar.");

        // Apresentação do primeiro inimigo
        DemonioBasico inimigo = new DemonioBasico("Demonio Básico", 50, 10, 6);
        System.out.println("De repente, você ouve passos pesados atrás de você. Um " + inimigo.getNome() + " emerge da floresta, com olhos brilhando em vermelho.");

        // Criando o combate
        Combate combate = new Combate(jogador, inimigo); // Instancia o combate
        combate.iniciarCombate();  // Inicia o combate

        // Transição para o próximo ato, após o combate
        if (inimigo.getHp() <= 0) {
            System.out.println("Você derrotou o " + inimigo.getNome() +"! A vila está um passo mais segura.");
        } else {
            System.out.println("O inimigo ainda está de pé, mas você conseguiu um golpe decisivo!");
        }

        // Continuar com a narrativa
        System.out.println("Com o " + inimigo.getNome() + " derrotado, você se aproxima do ancião da vila para saber mais sobre os ataques misteriosos...");
        continuarHistoria();
    }
}
