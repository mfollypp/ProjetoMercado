package Main;

import java.util.ArrayList;

public class Carrinho {
    private ArrayList<Produto> itens = new ArrayList<>(); //array de produtos (carrinho)
    
    public void addProduto(Produto prod){ //insere produto prod no carrinho
        this.itens.add(prod);
    }
    
    public void removeProduto(Produto prod){ //remove produto prod do carrinho
        this.itens.remove(prod);
    }
    
    //gets e sets dos atributos da classe

    public void setItens(ArrayList<Produto> itens) { //pode usar pra clonar um carrinho
        this.itens = itens;
    }

    public ArrayList<Produto> getItens() { //retorna os itens do carrinho
        return itens;
    }

    @Override
    public String toString() {
        return "Carrinho{" + "itens=" + itens + '}';
    }   
}