package Main;


import java.util.ArrayList;

public class Carrinho {
    private ArrayList<Produto> itens = new ArrayList<>();
    
    public void addProduto(Produto prod){
        this.itens.add(prod);
    }
    
    public void removeProduto(Produto prod){
        this.itens.remove(prod);
    }

    public void setItens(ArrayList<Produto> itens) {
        this.itens = itens;
    }

    public ArrayList<Produto> getItens() {
        return itens;
    }
    
}