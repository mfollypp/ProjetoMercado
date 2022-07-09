package Main;

import Main.comparador.ComparadorNomeCrescente;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class Prateleira {
    private ArrayList<Produto> produtosPrateleira = new ArrayList<Produto>();
    private static final int qtdPrateleiraPadrao = 10;
    
    public void organizaPrateleira(){ //ornaginazacao em ordem alfabetica
        try{
            Collections.sort(produtosPrateleira, new ComparadorNomeCrescente()); //da sort na prateleira pra organizar os produtos
        }
        catch(Exception ex){ //trata as excessoes
            System.out.println(ex.getMessage());
        }
    }
    
    public int pesquisaPosicaoDaPrateleira(String nome){
        for(int i = 0; i < this.produtosPrateleira.size(); i++){ //da posicao 0 ate o tamanho final da prateleira
            if(this.produtosPrateleira.get(i).getNome().toLowerCase().equals(nome)){ //se o produto na posicao i tiver o nome buscado
                return i; //retorna posicao do produto com nome buscado
            }
        }
        return -1;
    }
    
    public void addProdPrateleira(String nome, double preco){
        Produto prod = new Produto(nome, preco); //cria produto pra add na prateleira
        produtosPrateleira.add(prod); //add produto na prateleira
    }
    
    public Produto pegaProduto(String nome, int qtd){ //metodo para pegar o produto da prateleira, retirando a quantidade q foi pego
        int indiceProduto = this.pesquisaPosicaoDaPrateleira(nome); //retorna o indice de onde esta o produto na prateleira pelo nome
        int qtdRestante = this.getProdutos().get(indiceProduto).getQtd() - qtd; //para calcular a qtd restante
        this.getProdutos().get(indiceProduto).setQtd(qtdRestante); //atualiza a qtd do produto para o indice calculado pra qtd restante
        return this.getProdutos().get(indiceProduto); //retorna o produto
    }
    
    public void getProdutosPrateleira(){
        System.out.println("\n---------------------------PRODUTOS PRATELEIRA--------------------------\n");
        for(Produto prod : produtosPrateleira){
            System.out.println("Nome: " + prod.getNome());
            System.out.println("Quantidade: " + prod.getQtd() + "\n");
        }
    }
    
    public void criaProdutos(){
        Produto arroz = new Produto("Arroz", 10.9, qtdPrateleiraPadrao);
        produtosPrateleira.add(arroz);
        Produto feijao = new Produto("Feijao", 8.5, qtdPrateleiraPadrao);
        produtosPrateleira.add(feijao);
        Produto carne = new Produto("Carne", 42.90, qtdPrateleiraPadrao);
        produtosPrateleira.add(carne);
        Produto batata = new Produto("Batata", 15.2, qtdPrateleiraPadrao);
        produtosPrateleira.add(batata);
        Produto suco = new Produto("Suco", 4.9, qtdPrateleiraPadrao);
        produtosPrateleira.add(suco);
        Produto refrigerante = new Produto("Refrigerante", 5.9, qtdPrateleiraPadrao);
        produtosPrateleira.add(refrigerante);
    }
    
    public void restocaPrateleira(){
        for(Produto prod : produtosPrateleira){
            prod.setQtd(qtdPrateleiraPadrao);
        }
    }
    
    public void restocaProduto(Produto prod){
        int ind_prod = produtosPrateleira.indexOf(prod);
        produtosPrateleira.get(ind_prod).setQtd(qtdPrateleiraPadrao);
    }
    
    public void retiraDaPrateleira(String nome){
        try{
            produtosPrateleira.remove(pesquisaPosicaoDaPrateleira(nome)); //remove produto pela posicao na prateleira (encontra posicao pelo nome)
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    //gets e sets dos atributos da classe

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtosPrateleira = produtos;
    }

    public ArrayList<Produto> getProdutos() {
        return produtosPrateleira;
    }
    
}