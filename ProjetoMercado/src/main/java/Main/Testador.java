package Main;

import java.util.Calendar;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pcezar
 */
public class Testador {
    public static void main(String[] args) {
        /**
         * testando como ta funcionamento de ordenamento de prateleira* */
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
