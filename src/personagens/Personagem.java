package personagens;

import itens.Item;

import java.util.HashMap;
import java.util.Map;

import static utils.GameUtils.*;

public abstract class Personagem {
    String nome;
    String race;
    String classType;
    int hp;
    int maxHp;
    int ac;
    String[] skills;
    private int barreiraAtiva = 0;
    String alignment;
    Map<String, Integer> mochila;

    public int getBarreiraAtiva() {
        return barreiraAtiva;
    }

    public void setBarreiraAtiva(int barreiraAtiva) {
        this.barreiraAtiva = barreiraAtiva;
    }

    public String getNome() {
        return nome;
    }

    public int getHp() {
        return hp;
    }

    public int getAc() {
        return ac;
    }

    public void setAc(int ac) {
        this.ac = ac;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setHp(int hp) {
        this.hp = Math.min(hp, maxHp);
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public Map<String, Integer> getMochila() {
        return mochila;
    }

    public Personagem(String nome, String race, String classType, int hp, int ac, String[] skills, String alignment) {
        this.nome = nome;
        this.race = race;
        this.classType = classType;
        this.hp = hp;
        this.maxHp = hp;
        this.ac = ac;
        this.skills = skills;
        this.alignment = alignment;
        this.mochila = new HashMap<>();
    }

    public void adicionarItemNaMochila(Item item) {
        mochila.put(item.getNome(), mochila.getOrDefault(item.getNome(), 0) + 1);

    }

    public void displayStats(Personagem personagem) {
        limparConsole();
        printTitulo("STATUS DO PERSONAGEM");
        System.out.println("HP: " + personagem.hp + "\nNome: " + personagem.nome );
        printSeparador(20);
        System.out.println("Raça: " + personagem.race + "\nClasse: " + personagem.classType);
        printSeparador(20);
        System.out.println("Classe de Armadura (CA): " + personagem.ac);
        System.out.print("Habilidades: ");
        for (String skill : personagem.skills) {
            System.out.print(skill + ", ");
        }
        System.out.println();
        System.out.println("Tendência: " + personagem.alignment);
        printSeparador(20);
        continuarHistoria();
        limparConsole();
    }

    public abstract void iniciarNarrativa();
}
