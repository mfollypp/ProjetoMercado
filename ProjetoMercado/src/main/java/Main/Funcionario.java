package Main;

public class Funcionario {
    private int cadastro;
    private String tipoFuncionario;

    public Funcionario(int cadastro, String tipoFuncionario) {
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
    
}