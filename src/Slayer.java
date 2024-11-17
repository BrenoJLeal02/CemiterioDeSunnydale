import java.util.Random;

public class Slayer extends Personagem {
    public Slayer(String name) {
        super(name, "Humano", "Guerreiro", 45, 16, 30,
                new String[]{"Ataque Poderoso", "Defesa Sólida", "Intimidação"}, "Leal Neutro");
    }

    public void ataquePoderoso(Inimigo inimigo) {
        Random rand = new Random();
        int dano = rand.nextInt(12) + 8;
        System.out.println("\nVocê usa seu Ataque Poderoso e causa " + dano + " de dano no inimigo!");
        inimigo.hp -= dano;
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
            inimigo.dano = Math.max(0, inimigo.dano - 2);
        } else {
            System.out.println("O inimigo não se intimida e continua com sua força total!");
        }
    }
}

