package factory;

import personagens.Bruxa;
import personagens.Personagem;
import personagens.Slayer;
import personagens.Vampiro;

public class PersonagemFactory {
    public static Personagem criarPersonagem(int escolha, String nome) {
        switch (escolha) {
            case 1:
                return new Bruxa(nome);
            case 2:
                return new Slayer(nome);
            case 3:
                return new Vampiro(nome);
            default:
                throw new IllegalArgumentException("Escolha inválida para personagem.");
        }
    }
}
