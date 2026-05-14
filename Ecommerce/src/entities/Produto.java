package entities;

import java.util.ArrayList;
import java.util.List;

public class Produto {
    List<String> produtos = new ArrayList<>();

    private String nome;
    private int id;
    private double preco;
    private static int quantidade;

    public Produto() {}

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public double getPreco() {
        return preco;
    }

    public static int getQuantidade() {
        return quantidade;
    }

    //Pega os produtos do estoque atual
    public List<String> produtosNoEstoque() {
        return produtos;
    }
}
