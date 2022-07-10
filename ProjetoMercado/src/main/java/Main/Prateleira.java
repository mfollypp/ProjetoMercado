package Main;

import Main.comparador.ComparadorNomeCrescente;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class Prateleira implements GerenciaProduto {
    private ArrayList<Produto> produtosPrateleira = new ArrayList<Produto>();
//    private static final int qtdPrateleiraPadrao = 10; //substitui por enum de QTDProd
    private int indiceProduto;
    private int qtdRestante;
    private int qtdDisponivel;
    
    //Pilotto
    public void organizaPrateleira(){ //ornaginazacao em ordem alfabetica
        try{
            Collections.sort(produtosPrateleira, new ComparadorNomeCrescente()); //da sort na prateleira pra organizar os produtos
        }
        catch(Exception ex){ //trata as excessoes
            System.out.println(ex.getMessage());
        }
    }
    
    //Pilotto
    public int pesquisaPosicaoDaPrateleira(String nome){
        for(int i = 0; i < this.produtosPrateleira.size(); i++){ //da posicao 0 ate o tamanho final da prateleira
            if(this.produtosPrateleira.get(i).getNome().toLowerCase().equals(nome)){ //se o produto na posicao i tiver o nome buscado
                return i; //retorna posicao do produto com nome buscado
            }
        }
        return -1;
    }
    
    //Pilotto
    public void addProdPrateleira(String nomeProd, double preco){
        Produto prod = new Produto(nomeProd, preco); //cria produto pra add na prateleira
        produtosPrateleira.add(prod); //add produto na prateleira
    }
    
    //Folly
    public Produto pegaProduto(String nomeProd, int qtd){ //metodo para pegar o produto da prateleira, retirando a quantidade q foi pego
        qtdDisponivel = this.checaQuantidade(nomeProd);
        indiceProduto = this.pesquisaPosicaoDaPrateleira(nomeProd); //retorna o indice de onde esta o produto na prateleira pelo nome
        if(qtdDisponivel >= qtd){
            qtdRestante = this.getProdutos().get(indiceProduto).getQtd() - qtd; //para calcular a qtd restante
            this.getProdutos().get(indiceProduto).setQtd(qtdRestante); //atualiza a qtd do produto para o indice calculado pra qtd restante
        }
        else{
            this.getProdutos().get(indiceProduto).setQtd(0); //atualiza a qtd do produto para o indice calculado pra 0 (pegou tudo que tinha disponivel)
        }
        return this.getProdutos().get(indiceProduto); //retorna o produto
    }
    
    //Pilotto
    public boolean checaDisponibilidade(String nomeProd){ 
        for(Produto prod : produtosPrateleira){
            if(prod.getNome().toLowerCase().equals(nomeProd)){ //checa se produto existe na prateleira
                return true;
            }
        }
        return false;
    } 
    
    //Pilotto & Folly
    public int checaQuantidade(String nomeProd){ 
        if(checaDisponibilidade(nomeProd)){
            int indice = this.pesquisaPosicaoDaPrateleira(nomeProd);
            return produtosPrateleira.get(indice).getQtd(); //checa quantidade do produto na prateleira
        }
        return -1;
    }
    
    //Folly
    public int checaQuantidadeDisponivel(String nomeProd, int qtd){
        if(this.checaDisponibilidade(nomeProd)){
            qtdDisponivel = this.checaQuantidade(nomeProd);
            if(qtdDisponivel < qtd){ //checa qtd disponivel para pegar
                return qtdDisponivel;
            }
            return qtd;
        }
        return -1;
    }
    
    //Folly
    @Override
    public void criaProdutos(){
        Produto arroz = new Produto("Arroz", 10.9, QTDProd.PRATELEIRA.getQtd());
        produtosPrateleira.add(arroz);
        Produto feijao = new Produto("Feijao", 8.5, QTDProd.PRATELEIRA.getQtd());
        produtosPrateleira.add(feijao);
        Produto carne = new Produto("Carne", 42.90, QTDProd.PRATELEIRA.getQtd());
        produtosPrateleira.add(carne);
        Produto batata = new Produto("Batata", 15.2, QTDProd.PRATELEIRA.getQtd());
        produtosPrateleira.add(batata);
        Produto suco = new Produto("Suco", 4.9, QTDProd.PRATELEIRA.getQtd());
        produtosPrateleira.add(suco);
        Produto refrigerante = new Produto("Refrigerante", 5.9, QTDProd.PRATELEIRA.getQtd());
        produtosPrateleira.add(refrigerante);
    }
    
    //Folly
    public void restocaPrateleira(){
        for(Produto prod : produtosPrateleira){
            prod.setQtd(QTDProd.PRATELEIRA.getQtd()); //restoca produtos da prateleira
        }
    }
    
    //Folly
    public void restocaProduto(Produto prod){
        indiceProduto = produtosPrateleira.indexOf(prod);
        produtosPrateleira.get(indiceProduto).setQtd(QTDProd.PRATELEIRA.getQtd()); //restoca determinado produto da prateleira
    }
    
    //Pilotto
    public void retiraDaPrateleira(String nome){
        try{
            produtosPrateleira.remove(pesquisaPosicaoDaPrateleira(nome)); //remove produto pela posicao na prateleira (encontra posicao pelo nome)
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    //gets e sets dos atributos da classe
    
//    //Folly
//    @Override
//    public void printaProdutos(){
//        System.out.println("\n---------------------------PRODUTOS PRATELEIRA--------------------------\n");
//        for(Produto prod : produtosPrateleira){
//            System.out.println("Nome: " + prod.getNome());
//            System.out.println("Quantidade: " + prod.getQtd() + "\n");
//        }
//        System.out.println("---------------------------PRODUTOS PRATELEIRA--------------------------\n");
//    }
    
    //Folly
    @Override
    public void printaProdutos(){
        System.out.println("\n\n------------------------------------------------------------------");
        System.out.println("                            PRATELEIRA                            ");
        System.out.println("------------------------------------------------------------------");
        System.out.printf("%-20s | %-20s | %-20s\n", "Nome", "Preco", "Quantidade");
        System.out.println("------------------------------------------------------------------");
        for(Produto prod : produtosPrateleira){
            System.out.printf("%-20s | %-20s | %-20s\n", prod.getNome(), prod.getPreco(), prod.getQtd());
        }
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtosPrateleira = produtos;
    }

    @Override
    public ArrayList<Produto> getProdutos() {
        return produtosPrateleira;
    }
    
}