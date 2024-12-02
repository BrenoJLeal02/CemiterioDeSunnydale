package factory;

import itens.*;

import java.util.*;
import java.util.function.Supplier;

public class ItemFactory implements Factory<Item> {
    private static final Map<String, Supplier<Item>> registry = new HashMap<>();

    static {
        registry.put("poção de cura", PocaoCura::new);
        registry.put("barreira protetora", BarreiraProtetora::new);
        registry.put("jaqueta armadura", JaquetaArmadura::new);
        // registry.put("poção de força", PocaoForca::new);
    }

    @Override
    public Item criar(String nomeItem) {
        Supplier<Item> constructor = registry.get(nomeItem.toLowerCase());
        if (constructor == null) {
            throw new IllegalArgumentException("Item desconhecido: " + nomeItem);
        }
        return constructor.get();
    }
    // ele é usado quando quiser registrar novos items quando programa começar
    public static void registrarItem(String nomeItem, Supplier<Item> constructor) {
        registry.put(nomeItem.toLowerCase(), constructor);
    }

    public Item criarItemAleatorio() {
        List<String> nomesItens = new ArrayList<>(registry.keySet());
        Random random = new Random();
        String nomeAleatorio = nomesItens.get(random.nextInt(nomesItens.size())); // Escolhe uma chave aleatória
        return criar(nomeAleatorio);
    }
}