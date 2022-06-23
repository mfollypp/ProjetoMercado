package Main;

import java.util.Calendar;

public class Produto {
    private String nome;
    private double preco;
    private Calendar validade;
    private int idProduto;

    public Produto(String nome, double preco, Calendar validade, int idProduto) {
        this.nome = nome;
        this.preco = preco;
        this.validade = validade;
        this.idProduto = idProduto;
    }
      
    public boolean checaValidade(){
        Calendar dataDaVerificacao = Calendar.getInstance();
        //retorna false se nao entrou no  logo ta fora da validade
        //retorna true pois validade e menor que a data entao e dentro da validade
        return this.validade.before(dataDaVerificacao.getTime()); //isso aqui foi genial 
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setValidade(Calendar validade) {
        this.validade = validade;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
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

    public int getIdProduto() {
        return idProduto;
    }
    
}