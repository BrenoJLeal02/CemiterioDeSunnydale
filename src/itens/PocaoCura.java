package itens;

import personagens.Personagem;

public class PocaoCura extends Item {
    public PocaoCura() {
        super("Poção de Cura", "Recupera 10 HP");
    }

    @Override
    public void usar(Personagem jogador) {
        int hpAntes = jogador.getHp();
        jogador.setHp(jogador.getHp() + 10);
        int hpDepois = jogador.getHp();

        System.out.println("Você usou uma Poção de Cura!");
        System.out.println("HP antes: " + hpAntes + ", HP depois: " + hpDepois + " (+" + (hpDepois - hpAntes) + " HP)");
    }
}
