package Main;

import java.io.IOException;
import java.util.Calendar;

public class Testador {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Mercado mercado = new Mercado("Rua Tal");
        
        mercado.addFuncionario("Matheus", 24, 1234, "Coordenador");
        mercado.addFuncionario("Folly", 24, 4321, "Gerente");
        
        mercado.getFuncionarios();
        
//        testando como ta funcionamento de ordenamento de prateleira

        Prateleira teste =new  Prateleira();
        Calendar c = Calendar.getInstance();
        c.getTime();
        teste.organizaPrateleira();
        teste.addProdPrateleira("feijao", 8, c, 1);
        teste.addProdPrateleira("arroz", 10, c, 2);
        teste.addProdPrateleira("lasanha", 30, c, 3);
        teste.organizaPrateleira();
        System.out.println(teste.getProdutos().get(0).getNome());
        System.out.println(teste.getProdutos().get(1).getNome());
        System.out.println(teste.getProdutos().get(2).getNome());
        teste.retiraDaPrateleira("lasanh");
        //
        System.out.println(teste.getProdutos().get(0).getNome());
        System.out.println(teste.getProdutos().get(1).getNome());
        //System.out.println(teste.getProdutos().get(2).getNome());


    }
}
