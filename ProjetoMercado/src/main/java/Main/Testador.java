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
        Calendar data = Calendar.getInstance();
        data.set(2022, 7, 11);
        Produto arroz = new Produto("Arroz", 10.9, data, 1);
        Produto feijao = new Produto("Feijao", 8.5, data, 2);
        Produto carne = new Produto("Carne", 42.90, data, 3);
        
        Carrinho carrinho = new Carrinho();
        carrinho.addProduto(arroz);
        carrinho.addProduto(feijao);
        carrinho.addProduto(carne);
        
        for(Produto prod : carrinho.getItens()){
            System.out.println(prod);
        }
        /*####################################################################*/
        
        /*--------------------------------------------------------------------*/
        //Simulacao cliente vai fazer compras no mercado:
        Cliente matheus = new Cliente("Matheus", 24, 1324, false);
        matheus.addProd(arroz);
        matheus.addProd(feijao);
        
        Caixa caixa = new Caixa();
        System.out.println("Valor total da compra: R$" + caixa.totalCompra(matheus, matheus.getCarrinho()));
        caixa.fazPagamento(matheus, "dinheiro");
        System.out.println("Valor da 'conta' da compra apos pagamento = R$" + matheus.getValorCompra());
        /*####################################################################*/
    }
}