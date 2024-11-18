package factory;

import personagens.Bruxa;
import personagens.Personagem;
import personagens.Slayer;
import personagens.Vampiro;

public class PersonagemFactory {
    public static Personagem criarPersonagem(String tipo, String nome) {
        if (tipo.equals("Bruxa Poderosa")) {
            return new Bruxa(nome);
        } else if (tipo.equals("Slayer")) {
            return new Slayer(nome);
        } else if (tipo.equals("Vampiro")) {
            return new Vampiro(nome);
        }
        return null;
    }
}
