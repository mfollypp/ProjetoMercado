package Main;

import java.util.ArrayList; 

public class Estoque2 {
    private ArrayList<Produto> produtosEstoque = new ArrayList<Produto>();
    
    public void restocaEstoque(){
        for(Produto prod : produtosEstoque){
            prod.setQtd(20);
        }
    }
    
    public void restocaProduto(Produto prod){
        int ind_prod = produtosEstoque.indexOf(prod);
        produtosEstoque.get(ind_prod).setQtd(20);
    }
    
    //metodos para propria classe
    
    public void criaProdutos(){
        Produto arroz = new Produto("Arroz", 10.9, 20);
        produtosEstoque.add(arroz);
        Produto feijao = new Produto("Feijao", 8.5, 20);
        produtosEstoque.add(feijao);
        Produto carne = new Produto("Carne", 42.90, 20);
        produtosEstoque.add(carne);
        Produto batata = new Produto("Batata", 15.2, 20);
        produtosEstoque.add(batata);
        Produto suco = new Produto("Suco", 4.9, 20);
        produtosEstoque.add(suco);
        Produto refrigerante = new Produto("Refrigerante", 5.9, 20);
        produtosEstoque.add(refrigerante);
    }
    
    public void getProdutosEstoque(){
        System.out.println("\n----------------------------PRODUTOS ESTOQUE----------------------------\n");
        for(Produto prod : produtosEstoque){
            System.out.println("Nome: " + prod.getNome());
            System.out.println("Quantidade: " + prod.getQtd() + "\n");
        }
    }
    
}