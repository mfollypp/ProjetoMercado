package Main;

import java.text.NumberFormat;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Caixa {
    private static Funcionario funcionario;
    private static String tipoPagamento;
    private static double valorTotalCompra;
 private static Scanner input = new Scanner(System.in);
    private static String in;
    private static NumberFormat nf = NumberFormat.getCurrencyInstance();
    private static double valor = 0;
    private static String valorTotal = "";
    
    //Folly
    public static double totalCompra(Cliente cli){
        valorTotalCompra = 0;
        for(Produto prod : cli.getCarrinho().getProdutos()){ //para cada produto no carrinho
            if(prod.getQtd() > 0){
                valorTotalCompra += (prod.getPreco() * prod.getQtd()); //valor total = soma de cada produto
            }
        }
        if(checaFidelidade(cli)){ //se cliente tem fidelidade, ganha 50% de desconto
            cli.setValorCompra(valorTotalCompra*0.5);
            return valorTotalCompra*0.5;
        }
        System.out.println("Cliente nao possui fidelidade, deseja criar? s/n"); //cai aqui se nao tiver fidelidade e pergunta se deseja criar
        in = input.nextLine();
        if(in.toLowerCase().equals("s")){ //se deseja criar fidelidade
            cli.criaFidelidade();
            cli.setValorCompra(valorTotalCompra*0.5); //criou fidelidade e ganhou desconto
            return valorTotalCompra*0.5;
        }
        cli.setValorCompra(valorTotalCompra); //seta valor total da compra (sem fidelidade) do cliente (metodo em Cliente)
        return valorTotalCompra; //retorna o valor (sem desconto de fidelidade)
    }
    
    //Folly
    public static void printaTotalCompra(Cliente cli){
        valor = totalCompra(cli);
        valorTotal = nf.format(valor);
        System.out.println("Valor total da compra: " + valorTotal);
    }
    
    //Folly
    public static void fazPagamento(Cliente cli, String tipoPagamento) {
        System.out.println("\n----------------------------PAGAMENTO-----------------------------\n");
        printaTotalCompra(cli);
       try{
        if(tipoPagamento.toLowerCase().equals("cartao")){ //se o tipo de pagamento for cartao
            System.out.println("Digite a senha do cartao:");
            int senha = input.nextInt(); //recebe a senha do cliente
            while(senha != cli.getSenhaCartao()){ //enquanto a senha do cartao estiver errada (so entra se tiver errada)
                System.out.println("Senha errada! Digite a senha novamente:");
                senha = input.nextInt(); //pega nova senha e repete o loop
            }
            System.out.println("Pagamento realizado com sucesso!");
            cli.setValorCompra(0.0); //reseta o valor de compra do cliente pra 0 (metodo em Cliente)
        }
        if(tipoPagamento.toLowerCase().equals("dinheiro")){ //se o tipo de pagamento for dinheiro
            System.out.println("Digite quanto dinheiro foi entregue:");
            double quantia = input.nextDouble(); //recebe a quantia em dinheiro do cliente
            while(quantia < cli.getValorCompra()){ //enquanto a quantia for insuficiente (so entrar se for insuficiente)
                System.out.println("Quantia insuficiente! Entregue a quantia novamente:");
                quantia = input.nextDouble(); //pega nova quantia
            }
            System.out.println("Pagamento realizado com sucesso!");
            String troco = nf.format((quantia - cli.getValorCompra()));
            System.out.println("Troco = " + troco); //calcula troco da compra do cliente
            cli.setValorCompra(0.0);
        }}
       catch(Exception ex){
           System.out.println("Digite numeros validos");
           System.out.println("Digite NOvamentes numeros validos");
           fazPagamento(cli, tipoPagamento);
       }
       
    }
    
    //gets e sets dos atributos da classe
    
    public static boolean checaFidelidade(Cliente cli){
        return cli.getFidelidade();
    }

    public static void setFuncionario(Funcionario func) {
        funcionario = func;
    }

    public void setTipoPagamento(String tipoPag) {
        tipoPagamento = tipoPag;
    }

    public static Funcionario getFuncionario() {
        return funcionario;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }
    
}