// Classe Inimigo
package inimigos;

public class Inimigo {
    private String nome;
    private int hp;
    private int ac;
    private int dano;

    public Inimigo(String nome, int hp, int ac, int dano) {
        this.nome = nome;
        this.hp = hp;
        this.ac = ac;
        this.dano = dano;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAc() {
        return ac;
    }

    public void setAc(int ac) {
        this.ac = ac;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    // Método para aplicar dano
    public void receberDano(int dano) {
        this.hp -= dano;
    }
}
