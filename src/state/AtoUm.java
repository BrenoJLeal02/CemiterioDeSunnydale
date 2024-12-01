package state;

import game.ItemHandler;
import inimigos.DemonioBasico;
import personagens.Bruxa;
import personagens.Personagem;
import game.Combate;
import personagens.Slayer;
import personagens.Vampiro;

public class AtoUm implements Ato {
    private AtoState atoState;
    private Personagem jogador;

    public AtoUm(AtoState atoState, Personagem jogador) {
        this.atoState = atoState;
        this.jogador = jogador;
    }

    @Override
    public void iniciar(Personagem jogador) {
        ItemHandler itemHandler = new ItemHandler(jogador);

        System.out.println("Iniciando Ato 1: O Chamado das Trevas");

        if (jogador instanceof Bruxa) {
            System.out.println("Você acorda com uma sensação estranha. O tipo de sensação que vem antes de um grande desastre.");
            System.out.println("Algo na energia ao seu redor está... instável. Como se o equilíbrio estivesse prestes a ser quebrado.");
            System.out.println("Você mal tem tempo de se ajustar, quando percebe que a floresta, normalmente tranquila, está carregada com uma presença maligna.");
            System.out.println("Você segue até o ponto onde a sensação é mais forte e, bingo, lá está ele: um demônio que parece muito mais interessado em sua magia do que você gostaria.");
            System.out.println("Não que isso seja uma surpresa. Sempre surge alguém que acha que pode brincar com forças que não entende.");
            System.out.println("Bom, você tem magia e não tem medo de usá-la. Hora de dar um recado a esse cara.");
        } else if (jogador instanceof Slayer) {
            System.out.println("Você acorda em Sunnydale, e o ar está mais pesado do que deveria. Não é o tipo de peso que vem de um dia normal.");
            System.out.println("E antes que você pudesse sequer decidir entre café ou mais café, um demônio aparece na sua frente. Claro, não seria uma segunda-feira sem um.");
            System.out.println("Ele parece um típico idiota – grande, feio e provavelmente com um objetivo que não envolve nada bom.");
            System.out.println("Mas, ei, pelo menos você tem uma espada afiada e muita disposição para deixá-lo pedaços. Você tem um trabalho a fazer, e esse demônio não vai ser um problema por muito tempo.");
            System.out.println("Porque, no fim, é assim que funciona. Você mata demônios. Eles tentam te matar. Você continua. Eles não.");
        } else if (jogador instanceof Vampiro) {
            System.out.println("Você está na sua cripta e observa a neblina que se forma na noite. O frio é um velho amigo. O problema é outro.");
            System.out.println("Você sente uma presença. Um demônio. Nada novo, exceto o cheiro de algo... sujo no ar. De alguma forma, ele está procurando por você.");
            System.out.println("A coisa é grande, com olhos brilhando em uma cor que faz você lembrar que há mais a temer na noite do que apenas caçadoras.");
            System.out.println("Você tenta ignorar. Mas o demônio se aproxima, sem medo e com um sorriso no rosto.");
            System.out.println("Mais um saco de carne que acha que pode lidar com um vampiro. Bem, vamos ver até onde ele vai.");
            System.out.println("Não que você precise de uma razão para fazer o que faz, mas, sinceramente, você poderia usar um pouco de diversão agora.");
        }

        itemHandler.adicionarItem("Poção de cura");
        // Criar inimigo para o combate
        DemonioBasico inimigo = new DemonioBasico("Demônio Básico", 50, 10, 6);

        // Iniciar combate
        Combate combate = new Combate(jogador, inimigo);
        combate.iniciarCombate();  // Lógica de combate

        if (inimigo.getHp() <= 0) {
            System.out.println("Você derrotou o " + inimigo.getNome() + "!");
            System.out.println("Mas algo ainda está errado... Este demônio não parece ser o único por aqui.");
        } else {
            System.out.println("O inimigo ainda está de pé, mas você deu um bom golpe.");
        }

        System.out.println("Você concluiu o Ato 1. Preparando para o próximo ato...");
        avancar();
    }

    @Override
    public void avancar() {
        System.out.println("Avançando para o próximo ato...");
        atoState.avancarParaProximoAto();
    }

    @Override
    public boolean ultimoAto() {
        return false;
    }
}
