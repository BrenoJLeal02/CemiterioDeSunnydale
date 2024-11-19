package personagens;

public class Vampiro extends Personagem {
    public Vampiro(String nome) {
        super(nome, "FactoryPersonagem.Vampiro", "Vampiro", 50, 14, new String[]{"Golpe Vampírico", "Regeneração", "Hipnose"}, "Neutro Maligno");
    }

    @Override
    public void iniciarNarrativa() {
        super.iniciarNarrativa();
        System.out.println("Você sente a sede de sangue em suas veias, e sua alma marcada pela maldição da imortalidade.");
        System.out.println("A noite é sua aliada, e você é um predador implacável no escuro.");
    }
}