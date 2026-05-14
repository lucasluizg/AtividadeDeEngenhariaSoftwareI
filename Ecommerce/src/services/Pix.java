package services;

public class Pix implements Pagamento {
    public void pagar(double valor) {
        System.out.println("services.Pagamento com services.Pix: R$ " + valor);
    }
}
