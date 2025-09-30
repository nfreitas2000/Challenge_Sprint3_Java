package org.example.Model.Funcionario;

import org.example.Model.Pessoa;

import java.util.Scanner;

public class Funcionario {
    private int id_funcionario;
    private Pessoa pessoa;
    private String setor;
    private String cargo;
    private String st_credencial;

    public Funcionario(int id_funcionario, Pessoa pessoa,String setor, String cargo, String st_credencial) {
        this.id_funcionario = id_funcionario;
        this.pessoa = pessoa;
        this.setor = setor;
        this.cargo = cargo;
        this.st_credencial = st_credencial;
    }

    public Funcionario(String setor, String cargo, String st_credencial) {
        this.setor = setor;
        this.cargo = cargo;
        this.st_credencial = st_credencial;
    }

    public Funcionario() {
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

    public void cadastrarFuncionario(Pessoa pessoa) {
        setPessoa(pessoa);
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Qual o seu setor: ");
                setSetor(sc.nextLine());
                System.out.print("Qual o seu cargo: ");
                setCargo(sc.nextLine());
                while (true){
                    System.out.println("Você é um funcionário ativo: ");
                    System.out.println("1) Sim");
                    System.out.println("2) Não");
                    System.out.print("Digite: ");
                    try {
                        switch (Integer.parseInt(sc.nextLine())){
                            case 1:
                                setSt_credencial("A");
                            case 2:
                                setSt_credencial("I");
                        }
                    } catch (NumberFormatException e){
                        System.out.println("Entrada inválida! Tente Novamente digintando 1 ou 2!");
                        continue;
                    }
                    break;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Tente novamente!");
            }
        }
    }
}
