package Main;

import java.util.Scanner;

public class Caixa {
    private Cliente cliente;
    private Carrinho carrinho;
    private String tipoPagamento;
    private double valorTotalCompra;
    Scanner input = new Scanner(System.in);

    public Caixa(Cliente cliente, String tipoPagamento) { //construtor da Classe caixa
        this.cliente = cliente;
        this.tipoPagamento = tipoPagamento;
    }
    
    public double totalCompra(Cliente cli, Carrinho car){
        valorTotalCompra = 0;
        for(Produto prod : car.getItens()){ //para cada produto no carrinho
            valorTotalCompra += prod.getPreco(); //valor total = soma de cada produto
        }
        cli.setValorCompra(valorTotalCompra); //seta valor total da compra do cliente (metodo em Cliente)
        return valorTotalCompra; //retorna o valor
    }
    
    public void fazPagamento(Cliente cli, String tipoPagamento){
        if(tipoPagamento.toLowerCase().equals("cartao")){ //se o tipo de pagamento for cartao
            int senha;
            System.out.println("Digite a senha do cartao:");
            senha = input.nextInt(); //pega senha do usuario
            if(cli.getSenhaCartao() != senha){ //se a senha que o usuario digitou for diferente da salva no cartao
                System.out.println("Senha errada!");
            }
            System.out.println("Pagamento realizado com sucesso");
            cli.setValorCompra(0.0); //reseta o valor de compra do cliente pra 0 (metodo em Cliente)
        }
        if(tipoPagamento.toLowerCase().equals("dinheiro")){ //se o tipo de pagamento for dinheiro
            double quantia;
            System.out.println("Digite quanto dinheiro foi entregue");
            quantia = input.nextDouble(); //pega a quantia em dinheiro do usuario
            if(quantia < cli.getValorCompra()){ //se a quantia for insuficiente
                System.out.println("Quantia insuficiente");
            }
            System.out.println("Pagamento realizado com sucesso");
            System.out.println("Troco = R$" + (quantia - cli.getValorCompra()));
            cli.setValorCompra(0);
        }
    }
    
    //gets e sets dos atributos da classe
    
    public boolean checaFidelidade(Cliente cli){
        return cli.getFidelidade();
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }
    
}