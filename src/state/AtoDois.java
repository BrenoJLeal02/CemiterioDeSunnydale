package state;

import factory.InimigoFactory;
import inimigos.Inimigo;
import personagens.Bruxa;
import personagens.Personagem;
import game.Combate;
import personagens.Slayer;
import personagens.Vampiro;

public class AtoDois implements Ato {
    InimigoFactory inimigoFactory = new InimigoFactory();

    public AtoDois(AtoState atoState, Personagem jogador) {
    }

    @Override
    public void iniciar(Personagem jogador) {
        System.out.println("Iniciando Ato 2: O Demônio na Floresta");

        if (jogador instanceof Bruxa) {
            System.out.println("Você sente uma perturbação na energia mágica ao seu redor enquanto caminha pela floresta.");
            System.out.println("As árvores altas projetam sombras inquietantes, e a névoa densa parece esconder algo sinistro.");
            System.out.println("Seu coração acelera quando a presença maligna que você sentiu desde o início se materializa.");
            System.out.println("Um demônio emerge das sombras. Seus olhos brilham com uma fome insaciável.");
            System.out.println("Ele ruge, mas você mantém a calma. Este é o tipo de situação para a qual suas magias foram feitas.");
        } else if (jogador instanceof Slayer) {
            System.out.println("Você avança para a floresta com passos firmes. O som de folhas secas esmagadas sob suas botas ecoa na quietude.");
            System.out.println("De repente, um cheiro de enxofre invade o ar. Seus instintos entram em alerta, e você puxa sua arma, pronta para o que vier.");
            System.out.println("Um demônio com chifres retorcidos e garras afiadas surge de trás de uma árvore caída.");
        } else if (jogador instanceof Vampiro) {
            System.out.println("A floresta à noite é atrativa e confortável para você e você resolve adentrá-la.");
            System.out.println("Mas há algo... diferente no ar. Não é apenas o cheiro de terra úmida e folhas mortas.");
            System.out.println("Você para de andar quando uma figura monstruosa aparece.");
            System.out.println("Um demônio com chifres retorcidos se aproxima.");
            System.out.println("Ele não fala, mas não precisa. Ele quer brigar, e você está mais do que disposto a retribuir o favor.");
        }

        // Criar inimigo para o combate
        Inimigo inimigo = inimigoFactory.criar("Demônio");

        // Iniciar combate
        Combate combate = new Combate(jogador, inimigo);
        combate.iniciarCombate();  // Lógica de combate

        if (inimigo.getHp() <= 0) {
            System.out.println("Você derrotou o " + inimigo.getNome() + "!");
        } else {
            System.out.println("O " + inimigo.getNome() + " ainda está de pé, mas você conseguiu um bom golpe.");
        }

        System.out.println("Você concluiu o Ato 2.");
    }

    @Override
    public int escolhaDeCaminho() {
        return 0;
    }

    @Override
    public boolean ultimoAto() {
        return true;
    }
}
