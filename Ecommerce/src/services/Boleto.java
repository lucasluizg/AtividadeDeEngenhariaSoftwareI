package services;

public class Boleto implements Pagamento {
    public void pagar(double valor) {
        System.out.println("services.Pagamento com services.Boleto: R$ " + valor);
    }
}
