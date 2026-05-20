package entities;

import repositories.BancoDeDados;
import services.Boleto;
import services.Cartao;
import services.Pagamento;
import services.Pix;
import services.Status;

import java.util.List;

public class FinalizarPedido {

    private double total;
    private double frete;
    private String status;

    public void executar(Pedido pedido, Cliente cliente, String tipoPagamento, Estoque estoque) {
        List<ItemPedido> listaItens = pedido.getListaItens();

        total = 0;
        for (int i = 0; i < listaItens.size(); i++) {
            total += listaItens.get(i).precoProduto() * listaItens.get(i).getQuantidade();
        }

        if (total > 500) {
            total *= 0.85;
        } else if (total > 200) {
            total *= 0.9;
        }

        if (cliente.getEnderecoCliente().equalsIgnoreCase("sc")) {
            frete = total * 0.05;
        } else {
            frete = total * 0.15;
        }

        // Retira os produtos do estoque
        for (ItemPedido item : listaItens) {
            Produto prod = estoque.buscarProdutoPorNome(item.nomeProduto());
            if (prod != null) {
                estoque.retirarProdutoDoEstoque(prod);
            }
        }

        Pagamento pagamento;

        if (tipoPagamento.equalsIgnoreCase("pix")) {
            pagamento = new Pix();
            pagamento.pagar(total + frete);
        } else if (tipoPagamento.equalsIgnoreCase("cartao")) {
            pagamento = new Cartao();
            pagamento.pagar(total + frete);
        } else if (tipoPagamento.equalsIgnoreCase("boleto")) {
            pagamento = new Boleto();
            pagamento.pagar(total + frete);
        }

        System.out.println("E-mail enviado para " + cliente.getEmailCliente());

        // Salva os dados no pedido para o relatório
        pedido.clienteNome = cliente.getNomeCliente();
        pedido.total = total;
        pedido.frete = frete;
        pedido.status = Status.CONFIRMADO;

        BancoDeDados.salvarPedido(pedido);
        BancoDeDados.salvarLog("Pedido salvo: " + cliente.getNomeCliente());
    }

    /*
    obter subtotal do pedido
    aplicar desconto
    calcular frete a partir do endereço do cliente
    calcular total final (subtotal com desconto + frete)
    processar pagamento (conforme tipo)
    atualizar estoque (para cada item)
    notificar cliente
    salvar pedido + salvar log
    atualizar status para FINALIZADO
    gerar relatório (se fizer parte do caso de uso)
    * */

}
