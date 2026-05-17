import entities.*;
import repositories.BancoDeDados;

public class Sistema {

    public static void main(String[] args) {

        Cliente cliente = new Cliente("Maria", "maria@email.com", "SC");

        Pedido pedido = new Pedido();

        ItemPedido notebook = new ItemPedido("Notebook", 3000, 1);
        pedido.adicionarProduto(notebook);

        ItemPedido mouse = new ItemPedido("Mouse", 100, 2);
        pedido.adicionarProduto(mouse);

        FinalizarPedido finalizar = new FinalizarPedido();
        finalizar.executar(pedido, cliente, "PIX");

        // Novamente ferindo o processo de ocultamento de informação.
        BancoDeDados.salvarLog("Sistema finalizado");

        RelatorioService r = new RelatorioService();
        // r.gerar(p);

        /* System.out.println("Frete: " + p.frete);
        System.out.println("Status: " + p.status); */
    }
}