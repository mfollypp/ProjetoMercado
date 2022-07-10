package Main;

public class Cliente extends Pessoa {
    private boolean fidelidade;
    private Carrinho carrinho = new Carrinho(); //instanciado porque se nao fica null e nao insere
    private double valorCompra;
    private int senhaCartao;
    private int qtdDisponivel;

    public Cliente(String nome, int idade, int senhaCartao, boolean fidelidade) { //construtor da classe Cliente
        super(nome, idade);
        this.senhaCartao = senhaCartao;
        this.fidelidade = fidelidade;
    }
    
    //Folly
    public void criaFidelidade(){
        if(this.fidelidade = false){
            this.fidelidade = true; //se a fidelidade do Cliente for false entao cria
        }
    }
    
    //Folly
    public void addProd(String nomeProd, int qtd, Mercado mercado){
        qtdDisponivel = mercado.getPrateleira().checaQuantidadeDisponivel(nomeProd, qtd); //pega a qtd disponivel de produto na prateleira
        Produto prod = mercado.getPrateleira().pegaProduto(nomeProd, qtdDisponivel); //metodo que ja atualiza a qtd de produtos da prateleira e retorna o produto 
        Produto produto = new Produto(prod.getNome(), prod.getPreco()); // tem que criar um novo produto se nao carrinho e prateleira vao apontar para o mesmo
        produto.setQtd(qtdDisponivel); //atualiza quantidade do produto que vai ser inserido no carrinho
        this.carrinho.addProduto(produto); //para add produto ao carrinho sem precisar dar getCarrinho do cliente
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

    //Arthur & Folly
    @Override
    public String toString() { //para printar os clientes sem precisar formatar na hora
        return "Nome: " + this.getNome() + "\nFidelidade: " + this.fidelidade + "\nCarrinho: " + this.carrinho + "\n";
    }   
}