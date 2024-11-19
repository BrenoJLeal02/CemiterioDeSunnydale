package personagens;

import inimigos.Inimigo;

import java.util.Random;

public class Slayer extends Personagem {
    public Slayer(String name) {
        super(name, "Humano", "Guerreiro", 45, 16, new String[]{"Ataque Poderoso", "Defesa Sólida", "Intimidação"}, "Leal Neutro");
    }
    @Override
    public void iniciarNarrativa() {
        super.iniciarNarrativa();
        System.out.println("Com sua espada afiada em mãos, você sente a determinação em sua alma.");
        System.out.println("Os ventos da batalha estão perto, e você sabe que nada o deterá.");
    }

    public void ataquePoderoso(Inimigo inimigo) {
        Random rand = new Random();
        int dano = rand.nextInt(12) + 8;
        System.out.println("\nVocê usa seu Ataque Poderoso e causa " + dano + " de dano no inimigo!");
        inimigo.setHp(inimigo.getHp() - dano);
    }

    public void defesaSolida() {
        System.out.println("\nVocê aumenta sua defesa com a Defesa Sólida, tornando-se mais difícil de atingir!");
        this.ac += 2;
    }
    public void intimidacao(Inimigo inimigo) {
        System.out.println("\nVocê usa sua Intimidação para diminuir a moral do inimigo.");
        Random rand = new Random();
        int chance = rand.nextInt(2);
        if (chance == 0) {
            System.out.println("O inimigo fica intimidado, e seus ataques causam menos dano nos próximos turnos.");
            inimigo.setDano(Math.max(0, inimigo.getDano() - 2));
        } else {
            System.out.println("O inimigo não se intimida e continua com sua força total!");
        }
    }
}

