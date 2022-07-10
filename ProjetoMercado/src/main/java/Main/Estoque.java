package Main;

import java.util.ArrayList; 

public class Estoque implements GerenciaProduto {
    private ArrayList<Produto> produtosEstoque = new ArrayList<Produto>();
//    private static final int qtdEstoquePadrao = 20; //substitui por enum de QTDProd
    
    //Folly
    public void restocaEstoque(){
        for(Produto prod : produtosEstoque){
            prod.setQtd(QTDProd.ESTOQUE.getQtd()); //para restocar qtd de todos os produtos no estoque
        }
    }
    
    //Folly
    public void restocaProduto(Produto prod){
        int ind_prod = produtosEstoque.indexOf(prod); //pega o indice do produto no estoque
        produtosEstoque.get(ind_prod).setQtd(QTDProd.ESTOQUE.getQtd()); //restoca produto no estoque
    }
    
    //Pilotto & Folly
    public void adicionaNoEstoque(Produto prod){
        prod.setQtd(QTDProd.ESTOQUE.getQtd()); //valor padrao do estoque atualmente
        produtosEstoque.add(prod); 
    }
    
    //Pilotto & Folly
    public boolean checaDisponibilidade(String nomeProd){ 
        for(int i = 0; i < produtosEstoque.size(); i++){ 
            if(produtosEstoque.get(i).getNome().equals(nomeProd)){ //checa se produto existe no estoque
                return true; 
            } 
        } 
        return false;      
    } 
    
    //Pilotto & Folly
    public int checaQuantidade(String nomeProd){ 
        if (checaDisponibilidade(nomeProd) == true){ 
            for(int i = 0; i < produtosEstoque.size(); i++){ 
                if(produtosEstoque.get(i).getNome().equals(nomeProd)){ 
                    return produtosEstoque.get(i).getQtd(); //checa quantidade do produto no estoque
                } 
            } 
        } 
        return -1; 
    }
    
    //Pilotto & Folly
    public void retiraEstoque(String nomeProd, int pegaQtd){ 
        int qtd = checaQuantidade(nomeProd); 
        if(qtd < pegaQtd){ //se tentar pegar mais do que tem disponivel
            System.out.println("Quantidade acima da disponivel");
        } 
        else{
            for(int i = 0; i < produtosEstoque.size(); i++){ 
                if(produtosEstoque.get(i).getNome().equals(nomeProd)){ 
                    int numero = qtd - pegaQtd; //pega a qtd
                    produtosEstoque.get(i).setQtd(numero); //atualiza a qtd para a nova restante
                } 
            }   
        }
    }
    
    //metodos para propria classe
    
    //Folly
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
    
    //gets e sets dos atributos da classe
    
//    //Folly
//    @Override
//    public void printaProdutos(){
//        System.out.println("\n----------------------------PRODUTOS ESTOQUE----------------------------\n");
//        for(Produto prod : produtosEstoque){
//            System.out.println("Nome: " + prod.getNome());
//            System.out.println("Quantidade: " + prod.getQtd() + "\n");
//        }
//        System.out.println("----------------------------PRODUTOS ESTOQUE----------------------------\n");
//    }
    
    //Folly
    @Override
    public void printaProdutos(){
        System.out.println("\n\n------------------------------------------------------------------");
        System.out.println("                             ESTOQUE                              ");
        System.out.println("------------------------------------------------------------------");
        System.out.printf("%-20s | %-20s | %-20s\n", "Nome", "Preco", "Quantidade");
        System.out.println("------------------------------------------------------------------");
        for(Produto prod : produtosEstoque){
            System.out.printf("%-20s | %-20s | %-20s\n", prod.getNome(), prod.getPreco(), prod.getQtd());
        }
    }

    @Override
    public ArrayList<Produto> getProdutos() {
        return this.produtosEstoque;
    }
    
}