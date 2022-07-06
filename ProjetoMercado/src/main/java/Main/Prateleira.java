package Main;

import Main.comparador.ComparadorNomeCrescente;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class Prateleira {
    private ArrayList<Produto> produtos = new ArrayList<>();
      
    public void organizaPrateleira(){//ornaginazacao em ordem alfabetica
        try{
            Collections.sort(produtos,new ComparadorNomeCrescente()); //da sort na prateleira pra organizar os produtos
        }
        catch(Exception ex){ //trata as excessoes
            System.out.println(ex.getMessage());
        }
    }
    
    public void retiraDaPrateleira(String nome){
        try{
            produtos.remove(pesquisaPosicaoDaPrateleira(nome)); //remove produto pela posicao na prateleira (encontra posicao pelo nome)
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public int pesquisaPosicaoDaPrateleira(String nome){
        for(int i=0;i<this.produtos.size();i++){ //da posicao 0 ate o tamanho final da prateleira
            if(this.produtos.get(i).getNome().equals(nome)){ //se o produto na posicao i tiver o nome buscado
                return i; //retorna posicao do produto com nome buscado
           }
        }
        return -1;
    }
    
    public void addProdPrateleira(String nome, double preco, Calendar validade, int idProduto){
        Produto x = new Produto(nome,preco,validade,idProduto); //cria produto pra add na prateleira
        produtos.add(x); //add produto na prateleira
    }
    
    //gets e sets dos atributos da classe

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
    
}