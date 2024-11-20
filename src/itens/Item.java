package itens;

import personagens.Personagem;

public abstract class Item {
    private String nome;
    private String descricao;

    public Item(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public abstract void usar(Personagem jogador);

    // Indica se o item é consumível (padrão: true)
    public boolean isConsumivel() {
        return true;
    }
}
