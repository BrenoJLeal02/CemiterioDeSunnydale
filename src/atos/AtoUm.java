package atos;

import personagens.Personagem;
import inimigos.Inimigo;

public class AtoUm {

    public static void iniciarAtoUm(Personagem jogador) {
        // Introdução ao cenário
        System.out.println("Você acorda em uma pequena vila, o som de pássaros ecoa ao longe e o cheiro de madeira queimada preenche o ar.");
        System.out.println("À sua frente, a aldeia parece tranquila, mas algo em seus instintos lhe diz que algo não está certo.");
        System.out.println("A vila foi recentemente atacada por uma misteriosa força, e os aldeões estão em busca de heróis para defender seu lar.");

        // Apresentação do primeiro inimigo
        Inimigo inimigo = new Inimigo("Ladino Sombrio", 30, 8, 4); // Exemplo de inimigo, você pode personalizar
        System.out.println("De repente, você ouve passos pesados atrás de você. Um Ladino Sombrio emerge da floresta, com olhos brilhando em vermelho.");

        // Opções de ação para o jogador
        System.out.println("O inimigo está se aproximando! O que você faz?");
        System.out.println("1. Atacar o inimigo!");
        System.out.println("2. Tentar fugir!");
        System.out.println("3. Usar um item!");

        // Entrada do jogador (simulando uma escolha)
        int escolha = 1; // Aqui você pode capturar a escolha do jogador. Apenas um exemplo de ataque automático.

        switch (escolha) {
            case 1:
                System.out.println("Você decide enfrentar o Ladino Sombrio com toda sua força!");
                  // Exemplo de ataque, dependendo de como você estruturou seu código
                break;
            case 2:
                System.out.println("Você tenta fugir, mas o Ladino Sombrio é rápido demais!");
                // Implemente a fuga aqui, com chance de sucesso ou falha
                break;
            case 3:
                System.out.println("Você decide usar um item (Poção de Cura)!");
                // Aqui você pode adicionar a lógica de uso de itens
                break;
            default:
                System.out.println("Escolha inválida! O inimigo ataca!");
                break;
        }

        // Resultado do confronto
        if (inimigo.getHp() <= 0) {
            System.out.println("Você derrotou o Ladino Sombrio! A vila está um passo mais segura.");
        } else {
            System.out.println("O inimigo ainda está de pé, mas você conseguiu um golpe decisivo!");
        }

        // Transição para o próximo ato
        System.out.println("Com o Ladino Sombrio derrotado, você se aproxima do ancião da vila para saber mais sobre os ataques misteriosos...");
        // Prossiga com a narrativa ou missão para o próximo ato.
    }
}
