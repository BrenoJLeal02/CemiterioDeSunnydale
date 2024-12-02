package itens;

import personagens.Personagem;

public class BarreiraProtetora extends Item {
    public BarreiraProtetora() {
        super("Barreira Protetora", "Bloqueia dano por 2 turnos.");
    }

    @Override
    public void usar(Personagem jogador) {
        jogador.setBarreiraAtiva(2);
        System.out.println("Você ativou uma Barreira Protetora! Não sofrerá dano pelos próximos 2 turnos.");
    }
}
