import java.util.Random;

public class BruxaPoderosa extends Personagem {
    public BruxaPoderosa(String name) {
        super(name, "Humano", "Feiticeira", 40, 12, 30,
                new String[]{"Encantamento", "Necromancia", "Ilusão"}, "Caótica Boa");
    }

    @Override
    public void iniciarNarrativa() {
        super.iniciarNarrativa();
        System.out.println("Como uma feiticeira poderosa, você sente uma energia mística pulsando em suas veias.");
        System.out.println("Você ouve murmúrios no ar, como se algo ou alguém estivesse observando você.");
    }
    public void encantamento(Inimigo inimigo) {
        Random rand = new Random();
        int dano = rand.nextInt(8) + 5;
        System.out.println("\nVocê usa seu Encantamento e causa " + dano + " de dano no inimigo!");
        inimigo.hp -= dano;
    }

    public void necromancia(Inimigo inimigo) {
        Random rand = new Random();
        int dano = rand.nextInt(10) + 7;
        System.out.println("\nVocê usa a Necromancia, invocando energia das trevas e causando " + dano + " de dano!");
        inimigo.hp -= dano;
    }

    public void ilusao(Inimigo inimigo) {
        System.out.println("\nVocê cria uma ilusão para confundir o inimigo!");
        Random rand = new Random();
        int chanceErro = rand.nextInt(2);
        if (chanceErro == 0) {
            System.out.println("O inimigo se perde na ilusão e falha no ataque!");
        } else {
            System.out.println("A ilusão não foi suficiente para enganar o inimigo...");
        }
    }
}