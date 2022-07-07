package Main.comparador;

import Main.Produto;
import java.util.Comparator;

public class ComparadorNomeCrescente implements Comparator<Produto>{
    
     @Override
     public int compare(Produto o1, Produto o2) {
        if(o1.getNome().compareTo(o2.getNome()) > 0){
            return 1;
        }
        return -1;
    }
     
}