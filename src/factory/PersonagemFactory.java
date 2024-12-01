package factory;

import personagens.Bruxa;
import personagens.Personagem;
import personagens.Slayer;
import personagens.Vampiro;

import static utils.GameUtils.readInt;

public class PersonagemFactory implements Factory<Personagem> {
    @Override
    public Personagem criar(String nome) {
        while (true) {
            System.out.println("Escolha um personagem para iniciar o jogo:");
            System.out.println("(1) Bruxa Poderosa");
            System.out.println("(2) Slayer");
            System.out.println("(3) Vampiro");
            System.out.println("(4) Sair");
            int choice = readInt("-> ", 4);

            switch (choice) {
                case 1:
                    return new Bruxa(nome);
                case 2:
                    return new Slayer(nome);
                case 3:
                    return new Vampiro(nome);
                case 4:
                    System.out.println("Saindo do jogo...");
                    return null;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}


