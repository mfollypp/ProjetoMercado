package Main;

public class Pessoa {
    private String nome;
    private int idade;
    
    public Pessoa(String nome, int idade) { //construtor da classe Pessoa
        this.nome = nome;
        this.idade = idade;
    }
    
    //gets e sets dos atributos da classe

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
}