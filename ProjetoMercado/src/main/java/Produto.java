
import java.util.Calendar;

public class Produto {
    private String nome;
    private double preco;
    private Calendar validade;
    private String idProduto;

    public Produto() {
    }
    
    public boolean checaValidade(){
        return true;
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

    public void setIdProduto(String idProduto) {
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

    public String getIdProduto() {
        return idProduto;
    }
    
    
}