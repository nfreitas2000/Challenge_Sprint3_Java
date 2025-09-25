package org.example.Model;

public class ContaPaciente {
    int id_conta;
    Paciente paciente;
    String nm_paciente;
    String senha;

    public ContaPaciente(int id_conta, Paciente paciente, String nm_paciente, String senha) {
        this.id_conta = id_conta;
        this.paciente = paciente;
        this.nm_paciente = nm_paciente;
        this.senha = senha;
    }

    public ContaPaciente(Paciente paciente, String nm_paciente, String senha) {
        this.paciente = paciente;
        this.nm_paciente = nm_paciente;
        this.senha = senha;
    }

    public ContaPaciente() {
    }

    public int getId_conta() {
        return id_conta;
    }

    public void setId_conta(int id_conta) {
        this.id_conta = id_conta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getNm_paciente() {
        return nm_paciente;
    }

    public void setNm_paciente(String nm_paciente) {
        this.nm_paciente = nm_paciente;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}
