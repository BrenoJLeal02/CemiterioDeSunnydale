package personagens;

public class Vampiro extends Personagem {
    public Vampiro(String nome) {
        super(nome, "Vampiro", "Vampiro", 50, 14, new String[]{"Mordida Vampírica", "Golpes com Supervelocidade", "Hipnose"}, "Neutro Maligno");
    }

    @Override
    public void iniciarNarrativa() {
        System.out.println("Você sente a sede de sangue em suas veias, e sua alma marcada pela maldição da imortalidade.");
        System.out.println("A noite é sua aliada, e você é um predador implacável no escuro.");
    }
}