package ex1;

import java.util.HashMap;
import java.util.Stack;

public class GerenciadorEstoque {

    private static HashMap<String, Item> itensDoEstoque = new HashMap<>();

    private static Stack<Item> itensRemovidosAdicionados = new Stack<>();

    public static void inserirItemNoHashMap(HashMap<String, Item> itensDoEstoque, Stack<Item> itensRemovidosAdicionados, Item item, String codigoBarras) {
        if (itensDoEstoque.containsKey(codigoBarras)) {
            System.out.println("Item já registrado no estoque");
        } else {
            itensDoEstoque.put(codigoBarras, item);
            Item itemMock = new Item(item.getNome(), item.getPreco(), item.getQtdeEstoque());
            itensRemovidosAdicionados.push(itemMock);
            System.out.println("Item inserido com sucesso!");
        }
    }

    public static void removerItemDoHashMap(HashMap<String, Item> itensDoEstoque, Stack<Item> itensRemovidosAdicionados, String codigoBarras) {
        if (!itensDoEstoque.containsKey(codigoBarras)) {
            System.out.println("Item não encontrado no registro do estoque");
        } else {
            Item item = itensDoEstoque.get(codigoBarras);
            itensDoEstoque.remove(codigoBarras);
            Item itemMock = new Item(item.getNome(), item.getPreco(), item.getQtdeEstoque());
            itemMock.setAdicionado(false);
            itensRemovidosAdicionados.push(itemMock);
            System.out.println("Item removido com sucesso!");
        }
    }

    public static void buscarItemNoEstoque(HashMap<String, Item> itensDoEstoque, String codigoBarras) {
        if (!itensDoEstoque.containsKey(codigoBarras)) {
            System.out.println("Item não encontrado no registro do estoque!");
        } else {
            Item item = itensDoEstoque.get(codigoBarras);
            System.out.println(item);
        }
    }

    public static void imprimirItensDoEstoque(HashMap<String, Item> itensDoEstoque) {
        for (String key : itensDoEstoque.keySet()) {
            Item item = itensDoEstoque.get(key);
            System.out.println(item);
        }
    }

    public static void imprimirItensRemovidosAdicionados(Stack<Item> itensRemovidosAdicionados) {
        itensRemovidosAdicionados.forEach(System.out::println);
    }

    public static HashMap<String, Item> getItensDoEstoque() {
        return itensDoEstoque;
    }

    public static Stack<Item> getItensRemovidosAdicionados() {
        return itensRemovidosAdicionados;
    }
}
