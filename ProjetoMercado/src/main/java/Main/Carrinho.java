package Main;

import java.util.ArrayList;

public class Carrinho implements GerenciaProduto {
    private ArrayList<Produto> itens = new ArrayList<>(); //array de produtos (carrinho)
    
    //Folly
    public void addProduto(Produto prod){ //insere produto prod no carrinho
        this.itens.add(prod);
    }
    
    //Folly
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
    
//    //Folly
//    @Override
//    public void printaProdutos(){
//        System.out.println("\n--------------------------------CARRINHO--------------------------------\n");
//        for(Produto prod : itens){
//            System.out.println("Nome: " + prod.getNome());
//            System.out.println("Quantidade: " + prod.getQtd() + "\n");
//        }
//        System.out.println("--------------------------------CARRINHO--------------------------------\n");
//    }
    
    //Folly
    @Override
    public void printaProdutos(){
        System.out.println("\n\n------------------------------------------------------------------");
        System.out.println("                             CARRINHO                             ");
        System.out.println("------------------------------------------------------------------");
        System.out.printf("%-20s | %-20s | %-20s\n", "Nome", "Preco", "Quantidade");
        System.out.println("------------------------------------------------------------------");
        for(Produto prod : itens){
            System.out.printf("%-20s | %-20s | %-20s\n", prod.getNome(), prod.getPreco(), prod.getQtd());
        }
    }

    //Arthur & Folly
    @Override
    public String toString() { //para printar os produtos do carrinho sem precisar formatar na hora
        return this.itens + "";
    }

    //Folly
    @Override
    public void criaProdutos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}