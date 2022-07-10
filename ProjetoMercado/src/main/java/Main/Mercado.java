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
    private String nomeMercado;
    private ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
    private Prateleira prateleira = new Prateleira();
    private Estoque estoque = new Estoque();
    private Calendar data;
    private FileOutputStream fos = null;
    private ObjectOutputStream oos = null;
    private FileInputStream fis = null;
    private ObjectInputStream ois = null;
    private int indiceProduto;

    public Mercado(String nomeMercado) { //construtor da classe Mercado
        this.nomeMercado = nomeMercado;
        this.data = Calendar.getInstance();
        this.prateleira.criaProdutos();
        this.estoque.criaProdutos();
    }
    
    //Folly
    public void leArqFuncionarios() throws FileNotFoundException, IOException, ClassNotFoundException, InvalidClassException{
        try{
            fis = new FileInputStream("funcionarios.dat");
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
    
    //Folly
    public void escreveArqFuncionarios() throws FileNotFoundException, IOException{
        try{
            fos = new FileOutputStream("funcionarios.dat", false);
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
    
    //Folly
    public void addFuncionario(String nome, int idade, int cadastro, String tipoFuncionario) {
        Funcionario func = new Funcionario(nome, idade, cadastro, tipoFuncionario); //cria funcionario pra add
        if(!this.funcionarios.contains(func)){ //se funcionario nao ta no arraylist funcionarioS
            this.funcionarios.add(func); //add funcionario no array funcionarioS
        }
    }
    
    //Folly
    public void getFuncionarios() {
        System.out.println("\n---------------------------LISTA FUNCIONARIOS---------------------------\n");
        for(Funcionario func : this.funcionarios){ //para cada funcionario no array funcionarioS
            System.out.println(func); //printa cada funcionario (nao precisa formatar por causa do override em Funcionario)
        }
        System.out.println("---------------------------LISTA FUNCIONARIOS---------------------------\n");
    }
    
    //Folly
    public void restocaProdutos(){
        System.out.println("\n--------------------------------RESTOCA---------------------------------\n");
        for(Produto prod : this.prateleira.getProdutos()){
            if(prod.getQtd() == 0){ //se qtd de produto na prateleira for 0
                if(this.estoque.checaQuantidade(prod.getNome()) > 0){ //se tem produto no estoque para passar pra prateleira
                    System.out.println("Produto " + prod.getNome() + " esta sem estoque, iremos repor!");
                    this.prateleira.restocaProduto(prod); //restoca prateleira
                    this.estoque.retiraEstoque(prod.getNome(), QTDProd.PRATELEIRA.getQtd()); //retira do estoque a qtd da prateleira
                    System.out.println("Produto reposto!");
                }
                else{
                    System.out.println("Produto " + prod.getNome() + " esta sem estoque geral!");
                }
            }
        }
        System.out.println("\n--------------------------------RESTOCA---------------------------------\n");
    }
    
    //Folly
    public void passarDia(){
        this.data.add(Calendar.DATE, 1); //passa 1 dia / 24 horas
    }
    
    //gets e sets dos atributos da classe

    public void setNomeMercado(String nomeMercado) {
        this.nomeMercado = nomeMercado;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getNomeMercado() {
        return nomeMercado;
    }

    public Calendar getData() {
        return data;
    }
    
    public Prateleira getPrateleira(){
        return this.prateleira;
    }
    
    public Estoque getEstoque(){
        return this.estoque;
    }
    
}