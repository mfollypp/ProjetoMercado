
package Main;

import java.util.ArrayList;
import java.util.Calendar;

public class Estoque extends Localização {
    private Calendar validade;
    
    public Estoque(Calendar validade) { //construtor da classe Estoque
    this.validade = validade;    
    }
    
    private ArrayList<Produto> produtos = new ArrayList<>();
   
    public boolean checaDisponibilidade(){ //método incompleto
        return true;
    }
    
    public boolean checaValidade(){
        Calendar dataDaVerificacao = Calendar.getInstance();
        //retorna false se nao entrou no logo ta fora da validade
        //retorna true pois validade e menor que a data entao e dentro da validade
        return this.validade.before(dataDaVerificacao.getTime());
    }
    
    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
    
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    //gets e sets dos atributos da classe
    
    public void setValidade(Calendar validade) {
        this.validade = validade;
    }
    
    public Calendar getValidade() {
        return validade;
    }
    
}
