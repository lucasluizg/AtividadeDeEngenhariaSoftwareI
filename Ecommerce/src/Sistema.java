public class Sistema {

    public static void main(String[] args) {

        Pedido p = new Pedido();

        /*
        Aqui está ferindo o processo de ocultamento de informação colocando
        dados diretamente no atributo do objeto.
        */
        p.clienteNome = "Maria";
        p.clienteEmail = "maria@email.com";
        p.clienteEndereco = "SC";


        p.adicionarItem("Notebook", 3000, 1);
        p.adicionarItem("Mouse", 100, 2);

        p.finalizar();

        // Novamente ferindo o processo de ocultamento de informação.
        BancoDeDados.salvarLog("Sistema finalizado");

        RelatorioService r = new RelatorioService();
        r.gerar(p);

        System.out.println("Frete: " + p.frete);
        System.out.println("Status: " + p.status);
    }
}