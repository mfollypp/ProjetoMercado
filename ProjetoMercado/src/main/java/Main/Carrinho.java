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
    
    public void getProdutos(){
        System.out.println("\n--------------------------------CARRINHO--------------------------------\n");
        for(Produto prod : itens){
            System.out.println("Nome: " + prod.getNome());
            System.out.println("Quantidade: " + prod.getQtd() + "\n");
        }
    }

    @Override
    public String toString() {
        return "Carrinho{" + "itens=" + itens + '}';
    }   
}