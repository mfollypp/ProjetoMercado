package Main;

import java.io.Serializable;

public class Funcionario implements Serializable {
    private String nome;
    private int cadastro;
    private String tipoFuncionario;

    public Funcionario(String nome, int cadastro, String tipoFuncionario) {
        this.nome = nome;
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
	return "Nome:" + this.nome + "\nCadastro: " + this.cadastro + "\nTipo Funcionario: " + this.tipoFuncionario;
    }
    
}