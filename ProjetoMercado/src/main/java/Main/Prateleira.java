package Main;

import Main.comparador.ComparadorNomeCrescente;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class Prateleira {
    private ArrayList<Produto> produtos = new ArrayList<>();

    public Prateleira() {
    }
      
    public void organizaPrateleira(){//ornaginazacao em ordem alfabetica
        try{
            Collections.sort(produtos,new ComparadorNomeCrescente());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void retiraDaPrateleira(String nome){
        try{
            produtos.remove(pesquisaPosicaoDaPrateleira(nome));
            
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public int pesquisaPosicaoDaPrateleira(String nome){
        for(int i=0;i<this.produtos.size();i++){
            if(this.produtos.get(i).getNome().equals(nome)){
                return i;
           }
        }
        return -1;
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