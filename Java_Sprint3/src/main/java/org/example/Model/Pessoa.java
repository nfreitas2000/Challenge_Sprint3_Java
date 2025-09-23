package org.example.Model;

import org.example.DAO.ImplementacaoPessoa;

import java.util.Scanner;

public class Pessoa {
    private int id_pessoa;
    private String nome;
    private String cpf;
    private String rg;
    private String dt_nascimento;
    private String sx_pessoa;
    private String estado_civil;
    private String escolaridade;

    /*CONSTRUTORES ============================================================*/

    public Pessoa(String nome, String cpf, String rg, String dt_nascimento, String sx_pessoa, String estado_civil, String escolaridade) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dt_nascimento = dt_nascimento;
        this.sx_pessoa = sx_pessoa;
        this.estado_civil = estado_civil;
        this.escolaridade = escolaridade;
    }

    public Pessoa(int id_pessoa, String nome, String cpf, String rg, String dt_nascimento, String sx_pessoa, String estado_civil, String escolaridade) {
        this.id_pessoa = id_pessoa;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dt_nascimento = dt_nascimento;
        this.sx_pessoa = sx_pessoa;
        this.estado_civil = estado_civil;
        this.escolaridade = escolaridade;
    }

    public Pessoa() {
    }

    /*GETTERS AND SETTERS ============================================================*/

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(String dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getSx_pessoa() {
        return sx_pessoa;
    }

    public void setSx_pessoa(String sx_pessoa) {
        this.sx_pessoa = sx_pessoa;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    /*METODOS ============================================================*/

    public void cadastrarPessoa(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        setNome(sc.nextLine());
        System.out.println("Digite seu cpf: ");
        setCpf(sc.nextLine());
        System.out.println("Digite seu rg: ");
        setRg(sc.nextLine());
        System.out.println("Digite sua data de nascimento (DD/MM/YYYY): ");
        setDt_nascimento(sc.nextLine());
        System.out.println("Digite seu sexo ('M','F','I'): ");
        setSx_pessoa(sc.nextLine().toUpperCase());
        System.out.println("Digite seu estado civil ('solteiro','casado','divorciado','viúvo): ");
        setEstado_civil(sc.nextLine().toLowerCase());
        System.out.println("Digite sua escolaridade:");
        setEscolaridade(sc.nextLine());
    }
}
