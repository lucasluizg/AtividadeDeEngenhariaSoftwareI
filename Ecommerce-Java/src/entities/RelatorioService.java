package entities;

public class RelatorioService {

    public void gerar(Pedido p) {
        System.out.println("Cliente: " + p.clienteNome);
        System.out.println("Total com frete: " + (p.total + p.frete));
        System.out.println("Status: " + p.status);

        if (p.total > 1000) {
            System.out.println("Cliente VIP");
        }
    }
}