package Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Mercado {
    private String endereco;
    private ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
    private ArrayList<Corredor> corredores = new ArrayList<Corredor>();
    private Calendar data;
    private FileOutputStream fos = null;
    private ObjectOutputStream oos = null;
    private FileInputStream fis = null;
    private ObjectInputStream ois = null;

    public Mercado(String endereco) { //construtor da classe Mercado
        this.endereco = endereco;
        this.data = Calendar.getInstance();
    }
    
    public void leArqFuncionarios() throws FileNotFoundException, IOException, ClassNotFoundException, InvalidClassException{
        try{
            fis = new FileInputStream("funcionarios.txt");
            ois = new ObjectInputStream(fis); //metodos pra abrir arquivo pra ler
            while(fis.available() != 0){ //enquanto nao é o fim do arquivo
                Funcionario func = (Funcionario) ois.readObject(); //le objeto funcionario do arquivo
                 if(!this.funcionarios.contains(func)){ //se nao contem o funcionario no array de funcionarioS
                    this.funcionarios.add(func); //add o funcionario lido do arquivo ao array funcionarioS
                }
            }
        }catch(FileNotFoundException | InvalidClassException fnfex){ //trata as excessoes 
            
        }finally{
            if(fis != null){
                fis.close(); //fecha file input
            }
            if(ois != null){
                ois.close(); //fecha object input
            }
        }
    }
    
    public void escreveArqFuncionarios() throws FileNotFoundException, IOException{
        try{
            fos = new FileOutputStream("funcionarios.txt", false);
            oos = new ObjectOutputStream(fos); //metodos pra abrir o arquivo pra escrever
            for(Funcionario func : this.funcionarios){ //para cada funcionario no array funcionarioS
                oos.writeObject(func); //escreve no arquivo cada funcionario
            }
        }catch(FileNotFoundException fex){ //trata as excessoes
            
        }finally{
            if(fos != null){
                fos.close(); //fecha file output
            }
            if(oos != null){
                oos.close(); //fecha object output
            }
        }
    }
    
    public void addFuncionario(String nome, int idade, int cadastro, String tipoFuncionario) {
        Funcionario func = new Funcionario(nome, idade, cadastro, tipoFuncionario); //cria funcionario pra add
        if(!this.funcionarios.contains(func)){ //se funcionario nao ta no arraylist funcionarioS
            this.funcionarios.add(func); //add funcionario no array funcionarioS
        }
    }
    
    public void getFuncionarios() {
        System.out.println("--- Lista de Funcionarios ---\n");
        for(Funcionario func : this.funcionarios){ //para cada funcionario no array funcionarioS
            System.out.println(func); //printa cada funcionario (nao precisa formatar por causa do override em Funcionario)
        }
    }
    
    public void passarDia(){
        this.data.add(Calendar.DATE, 1); //passa 1 dia / 24 horas
    }
    
    //gets e sets dos atributos da classe

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public ArrayList<Corredor> getCorredores() {
        return corredores;
    }

    public Calendar getData() {
        return data;
    }
    
}