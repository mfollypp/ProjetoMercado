package Main;

import java.util.Scanner;

public class Caixa {
    private Cliente cliente;
    private Carrinho carrinho;
    private String tipoPagamento;
    private double valorTotalCompra;
    Scanner input = new Scanner(System.in);

    public Caixa(Cliente cliente, String tipoPagamento) {
        this.cliente = cliente;
        this.tipoPagamento = tipoPagamento;
    }
    
    public double totalCompra(Cliente cli, Carrinho car){
        valorTotalCompra = 0;
        for(Produto prod : car.getItens()){
            valorTotalCompra += prod.getPreco();
        }
        cli.setValorCompra(valorTotalCompra);
        return valorTotalCompra;
    }
    
    public void fazPagamento(Cliente cli, String tipoPagamento){
        if(tipoPagamento.toLowerCase().equals("cartao")){
            int senha;
            System.out.println("Digite a senha do cartao:");
            senha = input.nextInt();
            if(cli.getSenhaCartao() != senha){
                System.out.println("Senha errada!");
            }
            System.out.println("Pagamento realizado com sucesso");
            cli.setValorCompra(0.0);
        }
        if(tipoPagamento.toLowerCase().equals("dinheiro")){
            double quantia;
            System.out.println("Digite quanto dinheiro foi entregue");
            quantia = input.nextDouble();
            if(quantia < cli.getValorCompra()){
                System.out.println("Quantia insuficiente");
            }
            System.out.println("Pagamento realizado com sucesso");
            System.out.println("Troco = R$" + (quantia - cli.getValorCompra()));
            cli.setValorCompra(0);
        }
    }
    
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