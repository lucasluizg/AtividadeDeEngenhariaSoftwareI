import java.util.*;

public class Pedido {

    // O código faz muitas coisas, ele deve ser dividido em outras classes.

    // Todas as variáveis públicas ferindo o princípio de ocultamento de informação.
    public List<String> produtos = new ArrayList<>();
    public List<Double> precos = new ArrayList<>();
    public List<Integer> quantidades = new ArrayList<>();

    public String clienteNome;
    public String clienteEmail;
    public String clienteEndereco;

    public double total;
    public double frete;
    public String status;

    private RelatorioService relatorioService = new RelatorioService();

    public void adicionarItem(String nome, double preco, int qtd) {
        produtos.add(nome);
        precos.add(preco);
        quantidades.add(qtd);
    }

    // Três métodos sobre o cálculo do preço quebrando já a Integridade Conceitual
    public void calcularTotal() {
        total = 0;
        for (int i = 0; i < precos.size(); i++) {
            total += precos.get(i) * quantidades.get(i);
        }
    }

    public void calcularFrete() {
        if (clienteEndereco.contains("SC")) {
            frete = total * 0.05;
        } else {
            frete = total * 0.15;
        }
    }

    public void aplicarDesconto() {
        if (total > 500) {
            total *= 0.85;
        } else if (total > 200) {
            total *= 0.9;
        }
    }

    // Classe pedido com método de atualizar estoque? Seria ideal uma nova classe.
    public void atualizarEstoque() {
        for (String p : produtos) {
            System.out.println("Atualizando estoque de: " + p);
        }
    }

    // Mesma coisa do método acima.
    public void processarPagamento(String tipo) {
        if (tipo.equals("cartao")) {
            System.out.println("Pagamento cartão OK");
        } else if (tipo.equals("boleto")) {
            System.out.println("Boleto gerado");
        } else if (tipo.equals("pix")) {
            System.out.println("PIX enviado");
        }
    }

    // Idem aos métodos acima.
    public void enviarNotificacao() {
        System.out.println("Email enviado para " + clienteEmail);
    }

    // Idem aos métodos acima.
    public void gerarRelatorio() {
        System.out.println("Relatorio do pedido:");
        for (String p : produtos) {
            System.out.println(p);
        }
        System.out.println("Total: " + total);
    }

    public void salvarNoBanco() {
        BancoDeDados.salvarPedido(this);
        BancoDeDados.salvarLog("Pedido salvo: " + clienteNome);
    }

    public void finalizar() {
        calcularTotal();
        aplicarDesconto();
        calcularFrete();
        atualizarEstoque();
        processarPagamento("cartao");
        enviarNotificacao();
        gerarRelatorio();
        salvarNoBanco();
        status = "FINALIZADO";
    }
}