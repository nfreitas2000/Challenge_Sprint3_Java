package org.example.Model.Funcionario;

public class ContaFuncionario {
    int id_conta_funcionario;
    Funcionario funcionario;
    String user_funcionario;
    String senha_funcionario;

    public ContaFuncionario(int id_conta_funcionario, Funcionario funcionario, String user_funcionario, String senha_funcionario) {
        this.id_conta_funcionario = id_conta_funcionario;
        this.funcionario = funcionario;
        this.user_funcionario = user_funcionario;
        this.senha_funcionario = senha_funcionario;
    }

    public ContaFuncionario(Funcionario funcionario, String user_funcionario, String senha_funcionario) {
        this.funcionario = funcionario;
        this.user_funcionario = user_funcionario;
        this.senha_funcionario = senha_funcionario;
    }

    public int getId_conta_funcionario() {
        return id_conta_funcionario;
    }

    public void setId_conta_funcionario(int id_conta_funcionario) {
        this.id_conta_funcionario = id_conta_funcionario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getUser_funcionario() {
        return user_funcionario;
    }

    public void setUser_funcionario(String user_funcionario) {
        this.user_funcionario = user_funcionario;
    }

    public String getSenha_funcionario() {
        return senha_funcionario;
    }

    public void setSenha_funcionario(String senha_funcionario) {
        this.senha_funcionario = senha_funcionario;
    }
}
