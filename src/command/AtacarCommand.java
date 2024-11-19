package command;

import personagens.Bruxa;
import personagens.Personagem;
import inimigos.Inimigo;
import personagens.Slayer;
import personagens.Vampiro;
import utils.GameUtils;

import java.util.Random;

public class AtacarCommand {

    public static void executar(Personagem personagem, Inimigo inimigo) {
        // Verificar se o personagem está vivo e se o inimigo está vivo
        if (personagem.getHp() <= 0) {
            System.out.println(personagem.getNome() + " não pode atacar, pois está sem HP!");
            return;
        }
        if (inimigo.getHp() <= 0) {
            System.out.println("O inimigo já foi derrotado!");
            return;
        }

        // Exibir as habilidades do personagem
        System.out.println("Escolha uma habilidade para atacar:");
        String[] habilidades = personagem.getSkills();
        for (int i = 0; i < habilidades.length; i++) {
            System.out.println("(" + (i + 1) + ") " + habilidades[i]);
        }

        // Solicitar a escolha da habilidade
        int escolha = GameUtils.readInt("-> ", habilidades.length);

        // Executar o ataque com base na habilidade escolhida
        switch (escolha) {
            case 1: // Exemplo de ataque: Ataque Poderoso / Golpe Vampírico / Encantamento
                if (personagem instanceof Slayer) {
                    ((Slayer) personagem).ataquePoderoso(inimigo);
                } else if (personagem instanceof Vampiro) {
                    ((Vampiro) personagem).golpeVampirico(inimigo);
                } else if (personagem instanceof Bruxa) {
                    ((Bruxa) personagem).encantamento(inimigo);
                }
                break;

            case 2: // Exemplo de defesa ou habilidade de cura: Defesa Sólida / Regeneração / Necromancia
                if (personagem instanceof Slayer) {
                    ((Slayer) personagem).defesaSolida();
                } else if (personagem instanceof Vampiro) {
                    ((Vampiro) personagem).regeneracao();
                } else if (personagem instanceof Bruxa) {
                    ((Bruxa) personagem).necromancia(inimigo);
                }
                break;

            case 3: // Exemplo de habilidade de controle: Intimidação / Hipnose / Ilusão
                if (personagem instanceof Slayer) {
                    ((Slayer) personagem).intimidacao(inimigo);
                } else if (personagem instanceof Vampiro) {
                    ((Vampiro) personagem).hipnose(inimigo);
                } else if (personagem instanceof Bruxa) {
                    ((Bruxa) personagem).ilusao(inimigo);
                }
                break;

            default:
                System.out.println("Opção inválida! Tente novamente.");
        }
    }
}
