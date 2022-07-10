package Main;

import java.io.IOException;
import java.util.Calendar;

public class Testador {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        /*--------------------------------------------------------------------*/
        //Teste da escrita e leitura do arquivo de funcionarios:
        Mercado mercado = new Mercado("OOProducts");
        
        mercado.leArqFuncionarios();
        mercado.addFuncionario("Matheus", 24, 1111, "Coordenador");
        mercado.addFuncionario("Folly", 23, 2222, "Gerente");
        mercado.addFuncionario("Pilotto", 25, 3333, "CEO");
        mercado.escreveArqFuncionarios();
        mercado.getFuncionarios();
        
        mercado.leArqFuncionarios();
        mercado.addFuncionario("Peixoto", 26, 4444, "CTO");
        mercado.escreveArqFuncionarios();
        mercado.getFuncionarios();
        /*####################################################################*/
        
        /*--------------------------------------------------------------------*/
        //Simulacao cliente vai fazer compras no mercado:
        Cliente matheus = new Cliente("Matheus", 24, 1324, false);
        
        mercado.getPrateleira().printaProdutos();
        
        matheus.addProd("arroz", 2, mercado);
        matheus.addProd("feijao", 3, mercado);
        matheus.addProd("carne", 11, mercado);
        
        matheus.getCarrinho().printaProdutos();
        mercado.getPrateleira().printaProdutos();
        mercado.getEstoque().printaProdutos();
        
        Caixa.fazPagamento(matheus, "cartao");
        /*####################################################################*/
        
        /*--------------------------------------------------------------------*/
        //Simulacao de checagem para restoque de produtos que acabaram na prateleira
        mercado.restocaProdutos();
        
        matheus.getCarrinho().printaProdutos();
        mercado.getPrateleira().printaProdutos();
        mercado.getEstoque().printaProdutos();
        /*####################################################################*/
        
        /*--------------------------------------------------------------------*/
        //Testando o toString
        System.out.println(matheus);
        Funcionario func = new Funcionario("Funcionario Teste", 32, 9999, "Caixa");
        Caixa.setFuncionario(func);
        System.out.println(Caixa.getFuncionario());
        /*####################################################################*/
    }
}