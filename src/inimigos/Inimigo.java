package inimigos;

public class Inimigo {
    String nome;
    int hp;
    int ac;
    int dano;

    public Inimigo(String nome, int hp, int ac, int dano) {
        this.nome = nome;
        this.hp = hp;
        this.ac = ac;
        this.dano = dano;
    }

    public String getNome() {
        return nome;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }
}