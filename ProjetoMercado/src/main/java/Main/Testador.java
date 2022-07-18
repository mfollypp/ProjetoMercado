package Main;

import java.io.Console;
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
//        Cliente matheus = new Cliente("Matheus", 24, 1324, false);
//        
//        mercado.getPrateleira().printaProdutos();
//        
//        matheus.addProd("arroz", 2, mercado);
//        matheus.addProd("feijao", 3, mercado);
//        matheus.addProd("carne", 11, mercado);
//        
//        matheus.getCarrinho().printaProdutos();
//        mercado.getPrateleira().printaProdutos();
//        mercado.getEstoque().printaProdutos();
//        
//        Caixa.fazPagamento(matheus, "cartao");
        /*####################################################################*/
        
        /*--------------------------------------------------------------------*/
        //Simulacao de checagem para restoque de produtos que acabaram na prateleira
//        mercado.restocaProdutos();
//        
//        matheus.getCarrinho().printaProdutos();
//        mercado.getPrateleira().printaProdutos();
//        mercado.getEstoque().printaProdutos();
        /*####################################################################*/
        
        /*--------------------------------------------------------------------*/
        //Testando o toString
//        System.out.println("\n\n\n");
//        System.out.println(matheus);
//        Funcionario func = new Funcionario("Funcionario Teste", 32, 9999, "Caixa");
//        Caixa.setFuncionario(func);
//        System.out.println(Caixa.getFuncionario());
        /*####################################################################*/
        
        /*--------------------------------------------------------------------*/
        //Simulacao cliente vai fazer compras no mercado:
            
//        mercado.getPrateleira().printaProdutos();
        Scanner input = new Scanner(System.in);
            
        //input do cliente
        System.out.println("\n\nBem vindo ao " + mercado.getNomeMercado() + "!\n");

        System.out.println("Qual seu nome?");
        String nome = input.nextLine();
        System.out.println("Qual a sua idade?");
        int idade = input.nextInt();        
        System.out.println("Qual a senha do seu cartao?");
        int senha = input.nextInt();
        
        System.out.println("\n\n\n\n");

        Cliente matheusin = new Cliente(nome, idade, senha, false);
        
        mercado.getPrateleira().printaProdutos();
        
        System.out.println("\n\nQuantos sacos de arroz voce deseja colocar no carrinho?");
        int qtdArroz = input.nextInt();
        matheusin.addProd("arroz", qtdArroz, mercado);
        System.out.println("Quantos sacos de feijao voce deseja colocar no carrinho?");
        int qtdFeijao = input.nextInt();
        matheusin.addProd("feijao",qtdFeijao, mercado);
        System.out.println("Quantas carnes voce deseja colocar no carrinho?");
        int qtdCarne = input.nextInt();
        matheusin.addProd("carne", qtdCarne, mercado);
        System.out.println("Quantos sacos de batata voce deseja colocar no carrinho?");
        int qtdBatata = input.nextInt();
        matheusin.addProd("batata", qtdBatata, mercado);
        System.out.println("Quantos sucos voce deseja colocar no carrinho?");
        int qtdSuco = input.nextInt();
        matheusin.addProd("suco", qtdSuco, mercado);
        System.out.println("Quantos refrigerantes voce deseja colocar no carrinho?");
        int qtdRefri = input.nextInt();
        matheusin.addProd("refrigerante", qtdRefri, mercado);

        matheusin.getCarrinho().printaProdutos();
        mercado.getPrateleira().printaProdutos();
        mercado.getEstoque().printaProdutos();
        
        System.out.println("\n\nVoce deseja pagar com cartao(1) ou dinheiro(2)?");
        int controle = input.nextInt();
        if(controle == 1){
            Caixa.fazPagamento(matheusin, "cartao");
        }
        if(controle == 2){
            Caixa.fazPagamento(matheusin, "dinheiro");
        }
        
        mercado.restocaProdutos();      
        matheusin.getCarrinho().printaProdutos();
        mercado.getPrateleira().printaProdutos();
        mercado.getEstoque().printaProdutos();
    }
}