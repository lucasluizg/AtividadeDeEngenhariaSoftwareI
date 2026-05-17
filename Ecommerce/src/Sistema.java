import entities.Carrinho;
import entities.Cliente;
import entities.Estoque;
import entities.Produto;

import java.util.Scanner;

public class Sistema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cliente cliente = new Cliente();
        Carrinho carrinho = new Carrinho();
        Produto MouseGamer = new Produto(1,"Mouse Gamer", 80.00);
        Produto Notebook = new Produto(2,"Notebook Gamer", 3000.00);
        Produto CadeiraGamer = new Produto(3,"Cadeira Gamer Mancer", 850.00);
        Estoque estoque = new Estoque<>();

        //Entrando no sistema
        System.out.println("Bem vindo a Fast-By");
        System.out.println("Faça o seu cadastro !");
        System.out.println("Digite o seu nome: ");
        String respostaNome = scanner.nextLine();
        cliente.setNomeCliente(respostaNome);

        System.out.println("Agora digite o seu email:  (Sem o @gmail.com)"  );
        String respostaEmail = scanner.nextLine();
        String emailFormatado = String.format(respostaEmail + "@gmail.com");
        System.out.println("O email digitado é: " + emailFormatado);
        System.out.println("Deseja confirmar ? (sim/nao) ");
        String respostaEmail2 = scanner.nextLine().toLowerCase();
        if (respostaEmail2.equalsIgnoreCase("sim")) {
            //Utiliza o método para determinar o email do cliente
            cliente.setEmailCliente(emailFormatado);

            //Interface do Sistema, com Switch Case
            boolean sistemaLogado = true;

            //SISTEMA DO ECOMMERCE
            while (sistemaLogado) {
                System.out.println("Digite o número da opção que deseja: ");
                System.out.println("1- Listar produtos disponíveis para compra");
                System.out.println("2- Comprar produto(s)");
                System.out.println("3- Verificar o carrinho ");
                System.out.println("4- Efetuar compra dos itens do carrinho ");
                System.out.println("5- Status do(s) pedido(s) ");
                System.out.println("6 - Sair ");
                int respostaSistema = scanner.nextInt();

                switch (respostaSistema) {
                    case 1:
                    //Lista os produtos disponíveis para a compra
                    System.out.println("Produtos disponíveis: ");
                    estoque.listarEstoque();
                    break;

                    case 2:
                        System.out.println("Digite o produto que deseja comprar: ");
                        String nomeProduto = scanner.nextLine();

                        //Procura o produto no estoque
                        Produto produtoEncontrado = estoque.buscarProdutoPorNome(nomeProduto);

                        //Se o produto foi encontrado, mostra o preço dele, pede para adicionar no carrinho

                        if (produtoEncontrado != null) {
                            System.out.println("Você selecionou: " + produtoEncontrado.getNome());
                            System.out.println("Preço: R$ " + produtoEncontrado.getPreco());
                            System.out.println("Deseja adiciona-lo ao carrinho ? (S/N)");
                            char repostaProduto = scanner.next().charAt(0);
                            if (repostaProduto == 'S') {
                                carrinho.adicionarProdutoCarrinho(produtoEncontrado);
                            }
                        } else {
                            System.out.println("Produto não encontrado.");
                        }
                        break;

                    case 3:
                        carrinho.exibirCarrinho();
                        System.out.println("Deseja retirar algo do carrinho ? (S/N) ");
                        char repostaEscolha = scanner.next().charAt(0);
                        if (repostaEscolha == 'S') {
                            if (!carrinho.estaVazio()) {
                                System.out.println("Deseja limpar o carrinho ? (S/N)");
                                char repostaEscolha2 = scanner.next().charAt(0);
                                if (repostaEscolha2 == 'S') {
                                    carrinho.limparCarrinho();
                                }
                                System.out.println("Digite o produto que deseja retirar do carrinho");

                                //Busca no carrinho se o produto existe, retira ele do carrinho e atualiza o estoque
                                String nomeProduto2 = scanner.nextLine();
                                Produto produtoEncontrado2 = carrinho.buscarProdutoPorNome(nomeProduto2);

                                if (produtoEncontrado2 != null) {
                                    carrinho.removeProdutoCarrinho(produtoEncontrado2);
                                }
                            }
                            System.out.println("O carrinho está vazio !");
                        }
                        break;

                    case 4:
                        //PRECISA SER IMPLEMENTADO
                        break;

                    case 5:
                        //PRECISA SER IMPLEMENTADO
                        break;

                    case 6:
                        System.out.println("Saindo...");
                        sistemaLogado = false;
                        break;
                }
            }
        }
        //Caso não tenha certeza que digitou o email certo
        else if (respostaEmail2.equalsIgnoreCase("nao")) {
            System.out.println("Digite o email novamente:  (Sem o @gmail.com)");
            String respostaEmail3 = scanner.nextLine();
            String emailFormatado2 = String.format(respostaEmail3 + "@gmail.com");
            cliente.setEmailCliente(emailFormatado2);
        }
        else {
            throw new RuntimeException("Digite uma opção válida");
        }








        /*
        Pedido p = new Pedido();

        /*
        Aqui está ferindo o processo de ocultamento de informação colocando
        dados diretamente no atributo do objeto.

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
        System.out.println("services.Status: " + p.status);
        */
    }
}