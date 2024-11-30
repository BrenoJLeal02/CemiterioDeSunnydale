package personagens;

public class Slayer extends Personagem {
    public Slayer(String name) {
        super(name, "Humano", "Slayer", 45, 16, new String[]{"Soco da Caçadora", "Estaca", "Intimidação"}, "Leal Neutro");
    }

    @Override
    public void iniciarNarrativa() {
        System.out.println("A Caçadora é uma guerreira escolhida pelo destino para combater vampiros, demônios e criaturas sobrenaturais.");
        System.out.println("Com força sobre-humana, habilidades de combate excepcionais e coragem inabalável, ela luta sozinha contra as trevas, sempre disposta a proteger o mundo a qualquer custo.");
    }
}

