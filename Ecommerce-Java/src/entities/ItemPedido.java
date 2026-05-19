package entities;

import java.util.ArrayList;
import java.util.List;

public class ItemPedido {

    private Produto produto;
    private int quantidade;

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public double precoProduto() {
        return produto.getPreco();
    }

    public String nomeProduto() {
        return produto.getNome();
    }

    public int getQuantidade() {
        return quantidade;
    }
}