package Main;

public class Cliente {
    private String nome;
    private boolean fidelidade;
    private Carrinho carrinho;
    private double valorCompra;
    private int senhaCartao;

    public Cliente(String nome, int senhaCartao, boolean fidelidade) {
        this.nome = nome;
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

    public String getNome() {
        return nome;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public int getSenhaCartao() {
        return senhaCartao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public void setSenhaCartao(int senhaCartao) {
        this.senhaCartao = senhaCartao;
    }
    
}