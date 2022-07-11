package Main;

import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

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
        /*Cliente matheus = new Cliente("Matheus", 24, 1324, false);
        
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
        /*mercado.restocaProdutos();
        
        matheus.getCarrinho().printaProdutos();
        mercado.getPrateleira().printaProdutos();
        mercado.getEstoque().printaProdutos();*/
        /*####################################################################*/
        
        /*--------------------------------------------------------------------*/
        //Testando o toString
        /*System.out.println("\n\n\n");
        System.out.println(matheus);
        Funcionario func = new Funcionario("Funcionario Teste", 32, 9999, "Caixa");
        Caixa.setFuncionario(func);
        System.out.println(Caixa.getFuncionario());*/
        /*####################################################################*/
        //Simulacao cliente vai fazer compras no mercado:
        /*####################################################################*/
            /*####################################################################*/
            
            mercado.getPrateleira().printaProdutos();
            
            Scanner input = new Scanner(System.in);
                              
            
                //pegando o cliente
                System.out.println("Bem vindo ao Mercado Me de suas informacoes");
                System.out.println("/*--------------------------------------------------------------------*/");
                

                System.out.println("Qual a idade do cliente?");
                int idade=input.nextInt();
                System.out.println("qual a senha do cartao?");
                int senha=input.nextInt();
                System.out.println("/*--------------------------------------------------------------------*/");
                System.out.println("/*--------------------------------------------------------------------*/");
                System.out.println("/*--------------------------------------------------------------------*/");
                System.out.println("/*--------------------------------------------------------------------*/");
                System.out.println("/*--------------------------------------------------------------------*/");
                
                
                Cliente matheusin = new Cliente("aleatorio", idade, senha, false);                
                mercado.getPrateleira().printaProdutos();
            System.out.println("Quantos sacos de arroz voce deseja colocar no carrinho?");
            int sacoArroz=input.nextInt();
            matheusin.addProd("arroz", sacoArroz, mercado);
            System.out.println("Quantos sacos de feijao voce deseja colocar no carrinho?");
            int sacoFeijao=input.nextInt();
            matheusin.addProd("feijao",sacoFeijao, mercado);
            System.out.println("Quantas carnes voce deseja colocar no carrinho?");
            int carne=input.nextInt();
            matheusin.addProd("carne", carne, mercado);
             System.out.println("Quantos sacos de batata voce deseja colocar no carrinho?");
            int SacoBatata=input.nextInt();
            matheusin.addProd("batata", SacoBatata, mercado);
            System.out.println("Quantos refrigerantes voce deseja colocar no carrinho?");
            int refrigerantes=input.nextInt();
            matheusin.addProd("refrigerantes", refrigerantes, mercado);
        
            matheusin.getCarrinho().printaProdutos();
            mercado.getPrateleira().printaProdutos();
            mercado.getEstoque().printaProdutos();
            System.out.println("Voce deseja pagar com cartao(1) ou dinheiro(2)?");
            int controle = input.nextInt();
            if(controle==1){
            Caixa.fazPagamento(matheusin, "cartao");
            }
            if(controle==2){
             Caixa.fazPagamento(matheusin, "dinheiro");
            }
            
            
        
        
        
    }
}