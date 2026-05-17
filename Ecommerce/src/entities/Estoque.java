package entities;

import java.util.ArrayList;
import java.util.List;

abstract class Estoque <T> {

    private List<T> produtos = new ArrayList<>();

    public void atualizarEstoque() {
        for (T p : produtos) {
            System.out.println("Atualizando estoque de: " + p);
        }
    }

    public List<T> getProdutos() {
        return produtos;
    }
}
