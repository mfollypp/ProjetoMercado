package Main;

import java.util.ArrayList; 

public class Estoque implements GerenciaProduto {
    private ArrayList<Produto> produtosEstoque = new ArrayList<Produto>();
//    private static final int qtdEstoquePadrao = 20; //substitui por enum de QTDProd
    
    public void restocaEstoque(){
        for(Produto prod : produtosEstoque){
            prod.setQtd(QTDProd.ESTOQUE.getQtd());
        }
    }
    
    public void restocaProduto(Produto prod){
        int ind_prod = produtosEstoque.indexOf(prod);
        produtosEstoque.get(ind_prod).setQtd(QTDProd.ESTOQUE.getQtd());
    }
    
    public void adicionaNoEstoque(Produto prod){
        prod.setQtd(QTDProd.ESTOQUE.getQtd()); //valor padrao do estoque atualmente
        produtosEstoque.add(prod); 
    }
    
    public boolean checaDisponibilidade(String nomeProd){ 
        for(int i = 0; i < produtosEstoque.size(); i++){ 
            if(produtosEstoque.get(i).getNome().equals(nomeProd)){ 
                return true; 
            } 
        } 
        return false;      
    } 
    
    public int checaQuantidade(String nomeProd){ 
        if (checaDisponibilidade(nomeProd) == true){ 
        for(int i = 0; i < produtosEstoque.size(); i++){ 
            if(produtosEstoque.get(i).getNome().equals(nomeProd)){ 
                return produtosEstoque.get(i).getQtd(); 
                } 
            } 
        } 
        return -1; 
    }
    
    public void retiraEstoque(String nomeProd, int pegaQtd){ 
        int qtd = checaQuantidade(nomeProd); 
        if(qtd < pegaQtd){
            System.out.println("Quantidade acima da disponivel");
        } 
        else{
            for(int i = 0; i < produtosEstoque.size(); i++){ 
                if(produtosEstoque.get(i).getNome().equals(nomeProd)){ 
                    int numero = qtd - pegaQtd; 
                    produtosEstoque.get(i).setQtd(numero);
                } 
            }   
        }
    }
    
    //metodos para propria classe
    
    @Override
    public void criaProdutos(){
        Produto arroz = new Produto("Arroz", 10.9, QTDProd.ESTOQUE.getQtd());
        produtosEstoque.add(arroz);
        Produto feijao = new Produto("Feijao", 8.5, QTDProd.ESTOQUE.getQtd());
        produtosEstoque.add(feijao);
        Produto carne = new Produto("Carne", 42.90, QTDProd.ESTOQUE.getQtd());
        produtosEstoque.add(carne);
        Produto batata = new Produto("Batata", 15.2, QTDProd.ESTOQUE.getQtd());
        produtosEstoque.add(batata);
        Produto suco = new Produto("Suco", 4.9, QTDProd.ESTOQUE.getQtd());
        produtosEstoque.add(suco);
        Produto refrigerante = new Produto("Refrigerante", 5.9, QTDProd.ESTOQUE.getQtd());
        produtosEstoque.add(refrigerante);
    }
    
    @Override
    public void printaProdutos(){
        System.out.println("\n----------------------------PRODUTOS ESTOQUE----------------------------\n");
        for(Produto prod : produtosEstoque){
            System.out.println("Nome: " + prod.getNome());
            System.out.println("Quantidade: " + prod.getQtd() + "\n");
        }
    }

    @Override
    public ArrayList<Produto> getProdutos() {
        return this.produtosEstoque;
    }
    
}