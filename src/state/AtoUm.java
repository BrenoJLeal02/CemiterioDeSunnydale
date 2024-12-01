package state;

import factory.InimigoFactory;
import game.ItemHandler;
import inimigos.Inimigo;
import inimigos.VampiroBasico;
import personagens.Bruxa;
import personagens.Personagem;
import game.Combate;
import personagens.Slayer;
import personagens.Vampiro;

import java.util.Scanner;

public class AtoUm implements Ato {

    public AtoUm(AtoState atoState, Personagem jogador) {
    }

    @Override
    public void iniciar(Personagem jogador) {
        ItemHandler itemHandler = new ItemHandler(jogador);

        System.out.println("Iniciando Ato 1: Nas trevas");

        if (jogador instanceof Bruxa) {
            System.out.println("Você está no cemitério de Sunnydale, sob a luz pálida da lua. A brisa fria agita as folhas secas ao seu redor.");
            System.out.println("Treinar feitiços exige concentração. Mas algo quebra o silêncio...");
        } else if (jogador instanceof Slayer) {
            System.out.println("Mais uma noite de patrulha no cemitério de Sunnydale. O chão úmido e a névoa que sobe entre as lápides tornam tudo mais sombrio.");
            System.out.println("Uma sensação estranha percorre seu corpo. Está tudo quieto demais...");
        } else if (jogador instanceof Vampiro) {
            System.out.println("Você está na sua cripta e observa a neblina que se forma na noite.");
        }
        System.out.println("De repente, você escuta um barulho. Um grito. Parece uma mulher.");

        int escolha = escolhaDeCaminho();

        if (escolha == 1 || escolha == 2) {
            Inimigo inimigo = InimigoFactory.criarInimigo("Vampiro");
            Combate combate = new Combate(jogador, inimigo);
            combate.iniciarCombate();  // Lógica de combate
            if (inimigo.getHp() <= 0) {
                System.out.println("Você derrotou o " + inimigo.getNome() + "!");
            } else if (jogador.getHp() <= 0) {
                System.out.println("O inimigo ainda está de pé. Mas pra você, é fim de jogo...");
            }
        } else if (escolha == 3) {
            System.out.println("Ao seguir na direção da floresta, você encontra um frasco próximo a uma árvore.");
            System.out.println("Talvez venha a ser útil.");
            itemHandler.adicionarItem("Poção de cura");
        }

        if (escolha == 2 && jogador instanceof Vampiro) {
            System.out.println("Você segue na direção para onde a mulher seguiu e a encontra escondida.");
            System.out.println("É sua vez de encontrar, ou melhor, recuperar o lanche da noite...");
            jogador.setHp(jogador.getHp() + 10);
        }

        System.out.println("Você concluiu o Ato 1. Preparando para o próximo ato...");
    }

    @Override
    public int escolhaDeCaminho() {
        System.out.println("O que você faz?");
        System.out.println("1 - Corre na direção de onde veio grito.");
        System.out.println("2 - Tenta se aproximar cautelosamente.");
        System.out.println("3 - Resolve seguir para a direção oposta.");

        Scanner scanner = new Scanner(System.in);
        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                System.out.println("\nSeu corpo reage impulsivamente e você corre com tudo na direção do som.");
                System.out.println("Ao se aproximar, você se depara um vampiro de pé sobre uma jovem mulher.");
                System.out.println("Com um movimento brusco, ele torce o pescoço dela com facilidade, e o som de ossos quebrando ecoa na noite.");
                break;
            case 2:
                System.out.println("\nVocê decide se aproximar com cautela. Seus passos são leves, quase inaudíveis.");
                System.out.println("A visão se revela à medida que você se aproxima: um vampiro está com os dentes enfiados no pescoço de uma jovem mulher.");
                System.out.println("Com um movimento rápido, você golpeia a cabeça do vampiro, fazendo-o cambalear para trás.");
                System.out.println("A jovem aproveita a chance e corre.");
                System.out.println("Você observa o vampiro se levantar, furioso.");
                break;
            case 3:
                System.out.println("Ao longe, você escuta os gritos cada vez mais distantes, até que cessam completamente.");
                break;
        }

        return escolha;
    }

    @Override
    public boolean ultimoAto() {
        return false;
    }
}
