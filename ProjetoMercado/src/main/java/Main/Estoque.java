package Main; 
 
import java.util.ArrayList; 

public class Estoque {
    private ArrayList<Produto> produtos = new ArrayList<>(); 
    private ArrayList<Integer> quantidadesDoProduto=new ArrayList<>();// qtd respectiva  de cada produto no estoque da mesma possição do arrayList de produtos 
    
    public void adicionaNoEstoque(Produto prod, int quantidade){ 
        produtos.add(prod); 
        quantidadesDoProduto.add(quantidade); 
    }
    
    public boolean checaDisponibilidade(String x){ 
        for(int i=0;i<produtos.size();i++){ 
            if(produtos.get(i).getNome().equals(x)){ 
                return true; 
            } 
        } 
        return false;      
    } 
    
    public int checaQuantidade(String nome_prod){ 
        if (checaDisponibilidade(nome_prod)== true){ 
        for(int i=0;i<produtos.size();i++){ 
            if(produtos.get(i).getNome().equals(nome_prod)){ 
                return quantidadesDoProduto.get(i); 
                } 
            } 
        } 
        return -1; 
    }
    
    public void retiraEstoque(int quantidade, String nome_prod){ 
        int qtd = checaQuantidade(nome_prod); 
        if(qtd <= quantidade){
            System.out.println("Quantidade acima da disponivel");
        } 
        else{
            for(int i = 0; i < produtos.size(); i++){ 
                if(produtos.get(i).getNome().equals(nome_prod)){ 
                    int numero = qtd - quantidade; 
                    quantidadesDoProduto.set(i, numero); 
                } 
            }   
        }
    }
    
}