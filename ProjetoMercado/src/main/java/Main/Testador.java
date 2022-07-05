package Main;

import java.io.IOException;
import java.util.Calendar;

public class Testador {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        /*--------------------------------------------------------------------*/
        Mercado mercado = new Mercado("Rua Tal");
        
        mercado.leArqFuncionarios();
        
        mercado.addFuncionario("Matheus", 24, 1111, "Coordenador");
        mercado.addFuncionario("Folly", 23, 2222, "Gerente");
        mercado.addFuncionario("Pilotto", 25, 3333, "CEO");
        
        mercado.escreveArqFuncionarios();
        
        mercado.getFuncionarios();
        /*####################################################################*/
        
        /*--------------------------------------------------------------------*/
        Produto arroz = new Produto("Arroz", 10.9, Calendar.getInstance(), 1);
        Produto feijao = new Produto("Feijao", 8.5, Calendar.getInstance(), 2);
        Produto carne = new Produto("Carne", 42.90, Calendar.getInstance(), 3);
        
        Carrinho carrinho = new Carrinho();
        carrinho.addProduto(arroz);
        carrinho.addProduto(feijao);
        carrinho.addProduto(carne);
        
        for(Produto prod : carrinho.getItens()){
            System.out.println(prod);
        }
        /*####################################################################*/
    }
}