package Main;

public class Cliente extends Pessoa {
    private boolean fidelidade;
    private Carrinho carrinho = new Carrinho(); //instanciado porque se nao fica null e nao insere
    private double valorCompra;
    private int senhaCartao;

    public Cliente(String nome, int idade, int senhaCartao, boolean fidelidade) { //construtor da classe Cliente
        super(nome, idade);
        this.senhaCartao = senhaCartao;
        this.fidelidade = fidelidade;
    }
    
    public void criaFidelidade(){
        if(this.fidelidade = false){
            this.fidelidade = true; //se a fidelidade do Cliente for false entao cria
        }
    }
    
    public void addProd(Produto prod){
        this.carrinho.addProduto(prod); //para add produto ao carrinho sem precisar dar getCarrinho do cliente
    }
    
    //gets e sets dos atributos da classe
    
    public void setFidelidade(boolean fidelidade) {
        this.fidelidade = fidelidade;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public boolean getFidelidade() {
        return fidelidade;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }   

    public double getValorCompra() {
        return valorCompra;
    }

    public int getSenhaCartao() {
        return senhaCartao;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public void setSenhaCartao(int senhaCartao) {
        this.senhaCartao = senhaCartao;
    }

    @Override
    public String toString() {
        return "Cliente{" + "fidelidade=" + fidelidade + ", carrinho=" + carrinho + ", valorCompra=" + valorCompra + ", senhaCartao=" + senhaCartao + '}';
    }   
}