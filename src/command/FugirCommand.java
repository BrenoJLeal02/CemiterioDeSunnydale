package command;

import inimigos.Inimigo;
import personagens.Personagem;
import main.Combate;  // Importando a classe Combate

public class FugirCommand implements Command {
    private Personagem jogador;
    private Inimigo inimigo;
    private Combate combate;  // Adicionar o combate para encerrar

    public FugirCommand(Personagem jogador, Inimigo inimigo, Combate combate) {
        this.jogador = jogador;
        this.inimigo = inimigo;
        this.combate = combate;  // Inicializar o combate
    }

    @Override
    public void execute() {
        if (Math.random() < 0.5) { // Ajustar a chance de sucesso
            System.out.println(jogador.getNome() + " conseguiu fugir do combate com " + inimigo.getNome() + "!");
            combate.encerrarCombate();  // Encerrar o combate se a fuga for bem-sucedida
        } else {
            System.out.println(jogador.getNome() + " falhou ao tentar fugir. O inimigo atacou!");
            int dano = 5; // Ajuste o valor do dano
            jogador.setHp(jogador.getHp() - dano);
            System.out.println(jogador.getNome() + " levou " + dano + " de dano ao tentar fugir!");
        }
    }
}
