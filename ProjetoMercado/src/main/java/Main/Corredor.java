package Main;

import Main.comparador.ComparadorNomeCrescente;
import java.util.ArrayList;
import java.util.Collections;

public class Corredor { 
    private String tipoCorredor;
    private ArrayList<Prateleira> prateleiras = new ArrayList<>();

    public Corredor(String tipoCorredor) { //construtor da classe Corredor
        this.tipoCorredor = tipoCorredor;
    }
    
    public void organizaPrateleiras(){
        for(Prateleira prat : prateleiras){ //para cada prateleira em prateleiras
            prat.organizaPrateleira(); //organiza a prateleira (metodo em Prateleira)
        }
    }
    
    //gets e sets dos atributos da classe

    public void setTipoCorredor(String tipoCorredor) {
        this.tipoCorredor = tipoCorredor;
    }

    public void setPrateleiras(ArrayList<Prateleira> prateleiras) {
        this.prateleiras = prateleiras;
    }

    public String getTipoCorredor() {
        return tipoCorredor;
    }

    public ArrayList<Prateleira> getPrateleiras() {
        return prateleiras;
    }
    
}