package org.example.Model.Funcionario;

import org.example.Model.Pessoa;

public class Funcionario {
    int id_funcionario;
    Pessoa pessoa;
    String setor;
    String cargo;
    String st_credencial;

    public Funcionario(int id_funcionario, Pessoa pessoa,String setor, String cargo, String st_credencial) {
        this.id_funcionario = id_funcionario;
        this.setor = setor;
        this.cargo = cargo;
        this.st_credencial = st_credencial;
    }

    public Funcionario(String setor, String cargo, String st_credencial) {
        this.setor = setor;
        this.cargo = cargo;
        this.st_credencial = st_credencial;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSt_credencial() {
        return st_credencial;
    }

    public void setSt_credencial(String st_credencial) {
        this.st_credencial = st_credencial;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
