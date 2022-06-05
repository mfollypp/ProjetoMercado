package Main;


import java.util.ArrayList;
import java.util.Calendar;

public class Mercado {
    private String endereco;
    private ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
    private ArrayList<Corredor> corredores = new ArrayList<Corredor>();
    private Calendar data;

    public Mercado(String endereco) {
        this.endereco = endereco;
        this.data = Calendar.getInstance();
    }
    
    public void passarDia(){
        this.data.add(Calendar.DATE, 1); //passa 1 dia / 24 horas
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void setCorredores(ArrayList<Corredor> corredores) {
        this.corredores = corredores;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getEndereco() {
        return endereco;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public ArrayList<Corredor> getCorredores() {
        return corredores;
    }

    public Calendar getData() {
        return data;
    }
    
}