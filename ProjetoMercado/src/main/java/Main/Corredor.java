package Main;


import java.util.ArrayList;

public class Corredor {
    private String tipoCorredor;
    private ArrayList<Prateleira> prateleiras = new ArrayList<>();

    public Corredor(String tipoCorredor) {
        this.tipoCorredor = tipoCorredor;
    }

    
    
    public void organizaPrateleiras(){
        
    }

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