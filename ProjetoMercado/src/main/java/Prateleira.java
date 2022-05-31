
import java.util.ArrayList;
import java.util.Calendar;

public class Prateleira {
    private ArrayList<Produto> produtos = new ArrayList<>();

    public Prateleira() {
    }
    
    public void organizaPrateleira(){//ornaginazacao em ordem alfabetica
        
    }
    
    public void retiraDaPrateleira(){
        
    }
    
    public void addProdPrateleira(String nome, double preco, Calendar validade, int idProduto){
        Produto x = new Produto(nome,preco,validade,idProduto);
        produtos.add(x);
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
    
}