package Main;

import java.util.Calendar;

public class Produto {
    private String nome;
    private double preco;
    private Calendar validade = Calendar.getInstance();
    private int qtd;

    public Produto(String nome, double preco) { //construtor da classe Produto
        validade.add(Calendar.DATE, 3);
        this.nome = nome;
        this.preco = preco;
    }
    
    public Produto(String nome, double preco, int qtd) { //construtor da classe Produto para o Estoque (sobrecarga)
        this.nome = nome;
        this.preco = preco;
        this.qtd = qtd;
    }
      
    public boolean checaValidade(){
        Calendar dataDaVerificacao = Calendar.getInstance(); //retorna false se nao entrou no logo ta fora da validade
        return this.validade.before(dataDaVerificacao.getTime()); //retorna true pois validade e menor que a data entao e dentro da validade
    }
    
    //gets e sets dos atributos da classe

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setValidade(Calendar validade) {
        this.validade = validade;
    }
    
    public void setQtd(int qtd){
        this.qtd = qtd;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public Calendar getValidade() {
        return validade;
    }
    
    public int getQtd(){
        return this.qtd;
    }
    
    @Override
    public String toString() { //para printar os produtos sem precisar formatar na hora
	return "Nome: " + this.getNome() + "\nPreco: " + this.preco + "\nValidade: " + this.validade.getTime() + "\n";
    }
    
}