package services;

public class Cartao implements Pagamento{
    public void pagar(double valor) {
        System.out.println("services.Pagamento com Cartão: R$ " + valor);
    }
}
