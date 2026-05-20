package entities;

import java.util.ArrayList;
import java.util.List;
import services.Status;

public class Pedido {

    private List<Cliente> listaClientes = new ArrayList<>();
    private List<ItemPedido> listaItens =  new ArrayList<>();

    public String clienteNome;
    public double total;
    public double frete;
    public Status status;

    public void adicionarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public void adicionarProduto(ItemPedido item) {
        listaItens.add(item);
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public List<ItemPedido> getListaItens() {
        return listaItens;
    }

}