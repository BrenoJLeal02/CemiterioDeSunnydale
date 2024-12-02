package itens;

import personagens.Personagem;

public class JaquetaArmadura extends Item {

    public JaquetaArmadura() {
        super("Jaqueta de Armadura", "Aumenta permanentemente o AC do personagem em +2.");
    }

    @Override
    public void usar(Personagem jogador) {
        int acAntes = jogador.getAc();
        jogador.setAc(acAntes + 2); // Incrementa permanentemente o AC em +2
        int acDepois = jogador.getAc();

        System.out.println("Você equipou a Jaqueta de Armadura!");
        System.out.println("AC antes: " + acAntes + ", AC depois: " + acDepois + " (+" + (acDepois - acAntes) + " AC)");
    }
}