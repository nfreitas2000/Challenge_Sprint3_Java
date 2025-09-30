package org.example.Model.Paciente;

import org.example.DAO.ImplementacaoContaPaciente;
import org.example.DAO.ImplementacaoPaciente;
import org.example.DAO.ImplementacaoPessoa;
import org.example.Model.Pessoa;

import java.util.Scanner;

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

    /*METODOS*/

    public void cadastrarConta(Paciente paciente){
        Scanner sc = new Scanner(System.in);
        setPaciente(paciente);
        System.out.println("Digite o seu novo usuário: ");
        setNm_paciente(sc.nextLine());
        System.out.println("Digite a senha para sua conta: ");
        setSenha(sc.nextLine());
    }

    public boolean realizarLogin(ContaPaciente contaPaciente){
        if (contaPaciente.getId_conta() == 0){
            return false;
        } else {
            return true;
        }
    }

    public void criarContaCompleta(){
        /*INSTÂNCIAÇÃO DE OBJETOS DE CRUD*/
        ImplementacaoPessoa pessoaCRUD = new ImplementacaoPessoa();
        ImplementacaoPaciente pacienteCRUD = new ImplementacaoPaciente();
        ImplementacaoContaPaciente contaCRUD = new ImplementacaoContaPaciente();

        /*INSTÂNCIAÇÃO DE OBJETOS DE GENÉRICOS PARA PREENCHIMENTO*/
        Pessoa p = new Pessoa();
        Paciente paciente = new Paciente();


        /*SEQUENCIA DE MÉTODOS PARA PREENCHIMENTO DE TABELAS NO BD (tables de pessoa, paciente e conta de paciente)*/
        p.cadastrarPessoa();
        System.out.println("=====================================================");
        pessoaCRUD.inserirDados(p);
        System.out.println("=====================================================");
        p.setId_pessoa(pessoaCRUD.recuperaId(p));
        paciente.cadastrarPaciente(p);
        System.out.println("=====================================================");
        pacienteCRUD.inserirDados(paciente);
        paciente.setId_paciente(pacienteCRUD.recuperaId(paciente));
        System.out.println("=====================================================");
        cadastrarConta(paciente);
        contaCRUD.inserirDados(this);

    }
}
