package Main;

import java.util.Scanner;

public class Caixa {
    private Cliente cliente;
    private Carrinho carrinho;
    private String tipoPagamento;
    private double valorTotalCompra;
    Scanner input = new Scanner(System.in);
    private String in;

//    public Caixa(Cliente cliente, String tipoPagamento) { //construtor da Classe caixa
//        this.cliente = cliente;
//        this.tipoPagamento = tipoPagamento;
//    }
    
    public double totalCompra(Cliente cli, Carrinho car){
        valorTotalCompra = 0;
        for(Produto prod : car.getItens()){ //para cada produto no carrinho
            valorTotalCompra += prod.getPreco(); //valor total = soma de cada produto
        }
        if(this.checaFidelidade(cli)){ //se cliente tem fidelidade, ganha 50% de desconto
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
    
    public void fazPagamento(Cliente cli, String tipoPagamento){
        if(tipoPagamento.toLowerCase().equals("cartao")){ //se o tipo de pagamento for cartao
            int senha;
            System.out.println("Digite a senha do cartao:");
            senha = input.nextInt(); //pega senha do usuario
            while(senha != cli.getSenhaCartao()){ //enquanto a senha do cartao estiver errada (so entra se tiver errada)
                System.out.println("Senha errada! Digite a senha novamente:");
                senha = input.nextInt(); //pega nova senha e repete o loop
            }
            System.out.println("Pagamento realizado com sucesso!");
            cli.setValorCompra(0.0); //reseta o valor de compra do cliente pra 0 (metodo em Cliente)
        }
        if(tipoPagamento.toLowerCase().equals("dinheiro")){ //se o tipo de pagamento for dinheiro
            double quantia;
            System.out.println("Digite quanto dinheiro foi entregue:");
            quantia = input.nextDouble(); //pega a quantia em dinheiro do usuario
            while(quantia < cli.getValorCompra()){ //enquanto a quantia for insuficiente (so entrar se for insuficiente)
                System.out.println("Quantia insuficiente! Entregue a quantia novamente:");
                quantia = input.nextDouble(); //pega nova quantia
            }
            System.out.println("Pagamento realizado com sucesso!");
            System.out.println("Troco = R$" + (quantia - cli.getValorCompra())); //calcula troco da compra do cliente
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
    
    @Override
    public String toString() {
        return "Caixa{" + "cliente=" + cliente + ", carrinho=" + carrinho + ", tipoPagamento=" + tipoPagamento + ", valorTotalCompra=" + valorTotalCompra + ", input=" + input + '}';
    }  
}