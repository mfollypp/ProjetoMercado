package Main;

import java.util.ArrayList;

public class Carrinho implements GerenciaProduto {
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

    @Override
    public ArrayList<Produto> getProdutos() { //retorna os itens do carrinho
        return itens;
    }
    
    @Override
    public void printaProdutos(){
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

    @Override
    public void criaProdutos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}