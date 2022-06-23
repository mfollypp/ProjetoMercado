package Main;

import java.io.Serializable;

public class Funcionario extends Pessoa implements Serializable {
    private int cadastro;
    private String tipoFuncionario;

    public Funcionario(String nome, int idade, int cadastro, String tipoFuncionario) {
        super(nome, idade);
        this.cadastro = cadastro;
        this.tipoFuncionario = tipoFuncionario;
    }

    public void setCadastro(int cadastro) {
        this.cadastro = cadastro;
    }

    public void setTipoFuncionario(String tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }

    public int getCadastro() {
        return cadastro;
    }

    public String getTipoFuncionario() {
        return tipoFuncionario;
    }
    
    @Override
    public String toString() {
	return "Nome:" + this.getNome() + "\nCadastro: " + this.cadastro + "\nTipo Funcionario: " + this.tipoFuncionario;
    }
    
}