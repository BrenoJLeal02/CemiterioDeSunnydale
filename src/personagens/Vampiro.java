package personagens;

import inimigos.Inimigo;

import java.util.Random;

public class Vampiro extends Personagem {
    public Vampiro(String nome) {
        super(nome, "FactoryPersonagem.Vampiro", "Vampiro", 50, 14, new String[]{"Golpe Vampírico", "Regeneração", "Hipnose"}, "Neutro Maligno");
    }

    public void golpeVampirico(Inimigo inimigo) {
        Random rand = new Random();
        int dano = rand.nextInt(10) + 6;
        System.out.println("\nVocê usa seu Golpe Vampírico, causando " + dano + " de dano e recuperando 5 HP!");
        this.hp += 5;
        inimigo.setHp(inimigo.getHp() - dano);
    }

    public void regeneracao() {
        System.out.println("\nSua habilidade de Regeneração ativa, recuperando 10 HP.");
        this.hp += 10;
    }

    public void hipnose(Inimigo inimigo) {
        System.out.println("\nVocê tenta hipnotizar o inimigo, paralisando-o por um turno.");
        Random rand = new Random();
        int chanceSucesso = rand.nextInt(2);
        if (chanceSucesso == 0) {
            System.out.println("A hipnose tem sucesso! O inimigo está paralisado e não pode atacar por um turno.");
        } else {
            System.out.println("A hipnose falha, e o inimigo continua sua ofensiva.");
        }
    }
    @Override
    public void iniciarNarrativa() {
        super.iniciarNarrativa();
        System.out.println("Você sente a sede de sangue em suas veias, e sua alma marcada pela maldição da imortalidade.");
        System.out.println("A noite é sua aliada, e você é um predador implacável no escuro.");
    }
}