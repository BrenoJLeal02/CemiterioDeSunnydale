package factory;

import java.util.HashMap;
import java.util.Map;

public class ItemFactory {
    private static Map<String, String> itens = new HashMap<>();


    static {
        itens.put("Poção de Cura", "Recupera 10 HP");
        itens.put("Poção de Mana", "Recupera 10 MP");
        itens.put("Elixir de Força", "Aumenta o dano em 5 por 3 turnos");
    }

    // Método para criar um item específico
    public static String criarItem(String nomeItem) {
        if (itens.containsKey(nomeItem)) {
            return nomeItem + " - " + itens.get(nomeItem);
        }
        return null;
    }
}