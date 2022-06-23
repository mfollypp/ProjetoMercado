package Main;


import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Mercado {
    private String endereco;
    private ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
    private ArrayList<Corredor> corredores = new ArrayList<Corredor>();
    private Calendar data;
    private FileOutputStream fos = null;
    private ObjectOutputStream ous = null;
    private FileInputStream fis = null;
    private ObjectInputStream ois = null;

    public Mercado(String endereco) {
        this.endereco = endereco;
        this.data = Calendar.getInstance();
    }
    
    public void addFuncionario(String nome, int idade, int cadastro, String tipoFuncionario) throws IOException{
        try{
            Funcionario func = new Funcionario(nome, idade, cadastro, tipoFuncionario);
            fos = new FileOutputStream("funcionarios.txt", true);
            ous = new ObjectOutputStream(fos);
            ous.writeObject(func);
        }catch (IOException ex){
            System.out.println("Erro ao escrever no arquivo");
        }
        finally{
            if(fos != null){
                fos.close();
            }
            if(ous != null){
                ous.close();
            }
        }
    }
    
    public void getFuncionarios() throws FileNotFoundException, IOException, ClassNotFoundException, EOFException{ // ta perdendo o header do output stream
        try{
            fis = new FileInputStream("funcionarios.txt");
            ois = new ObjectInputStream(fis);
            while(true){
                Funcionario func = (Funcionario) ois.readObject();
                System.out.println(func.toString());
            }
        }catch (EOFException e){
            System.out.println("Fim do arquivo");
        }finally{
            if(fis != null){
                fis.close();
            }
            if(ois != null){
                ois.close();
            }
        }
    }
    
    public void passarDia(){
        this.data.add(Calendar.DATE, 1); //passa 1 dia / 24 horas
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

//    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
//        this.funcionarios = funcionarios;
//    }

    public void setCorredores(ArrayList<Corredor> corredores) {
        this.corredores = corredores;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getEndereco() {
        return endereco;
    }

//    public ArrayList<Funcionario> getFuncionarios() {
//        return funcionarios;
//    }

    public ArrayList<Corredor> getCorredores() {
        return corredores;
    }

    public Calendar getData() {
        return data;
    }
    
}