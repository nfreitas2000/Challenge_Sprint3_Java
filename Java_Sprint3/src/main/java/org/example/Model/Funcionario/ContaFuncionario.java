package org.example.Model.Funcionario;

import org.example.DAO.*;
import org.example.Model.Paciente.ContaPaciente;
import org.example.Model.Paciente.Paciente;
import org.example.Model.Pessoa;

import java.sql.SQLException;
import java.util.Scanner;

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

    public ContaFuncionario() {
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

    public void cadastrarConta(Funcionario funcionario){
        Scanner sc = new Scanner(System.in);
        setFuncionario(funcionario);
        System.out.println("Digite o seu novo usuário: ");
        setUser_funcionario(sc.nextLine());
        System.out.println("Digite a senha para sua conta: ");
        setSenha_funcionario(sc.nextLine());
    }

    public boolean realizarLogin(ContaFuncionario contaFuncionario){
        if (contaFuncionario.getId_conta_funcionario() == 0){
            return false;
        } else {
            return true;
        }
    }

    public void criarContaCompleta() {
        /*INSTÂNCIAÇÃO DE OBJETOS DE CRUD*/
        ImplementacaoPessoa pessoaCRUD = new ImplementacaoPessoa();
        ImplementacaoFuncionario funcionarioCRUD = new ImplementacaoFuncionario();
        ImplementacaoContaFuncionario contaCRUD = new ImplementacaoContaFuncionario();

        /*INSTÂNCIAÇÃO DE OBJETOS DE GENÉRICOS PARA PREENCHIMENTO*/
        Pessoa p = new Pessoa();
        Funcionario f = new Funcionario();


        /*SEQUENCIA DE MÉTODOS PARA PREENCHIMENTO DE TABELAS NO BD (tables de pessoa, funcionario e conta de funcionario)*/
        p.cadastrarPessoa();
        System.out.println("=====================================================");
        pessoaCRUD.inserirDados(p); /*ISSO PODE DAR ERRO -> SE OS DADOS NO ESTIVEREM CORRETOS, O BD VAI NEGAR A CRIAÇÃO, MAS O CÓDIGO CONTINUA DE QUALQUER JEITO*/
        /*PARA CORRIGIR, TRATAR OS DADOS NO CADASTRO DE PESSOA*/
        System.out.println("=====================================================");
        p.setId_pessoa(pessoaCRUD.recuperaId(p));
        f.cadastrarFuncionario(p);
        System.out.println("=====================================================");
        funcionarioCRUD.inserirDados(f);
        f.setId_funcionario(funcionarioCRUD.recuperaId(f));
        System.out.println("=====================================================");
        cadastrarConta(f);
        contaCRUD.inserirDados(this);
    }
}
