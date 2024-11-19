package personagens;

public class Bruxa extends Personagem {
    public Bruxa(String name) {
        super(name, "Humano", "Bruxa", 40, 12, new String[]{"Encantamento", "Necromancia", "Ilusão"}, "Caótica Boa");
    }

    @Override
    public void iniciarNarrativa() {
        super.iniciarNarrativa();
        System.out.println("Como uma feiticeira poderosa, você sente uma energia mística pulsando em suas veias.");
        System.out.println("Você ouve murmúrios no ar, como se algo ou alguém estivesse observando você.");
    }
}