package Main;

public class Cliente extends Pessoa {
    private boolean fidelidade;
    private Carrinho carrinho;
    private double valorCompra;
    private int senhaCartao;

    public Cliente(String nome, int idade, int senhaCartao, boolean fidelidade) {
        super(nome, idade);
        this.senhaCartao = senhaCartao;
        this.fidelidade = fidelidade;
    }
    
    public void criaFidelidade(){
        if(this.fidelidade = false){
            this.fidelidade = true;
        }
    }
    
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
    
}