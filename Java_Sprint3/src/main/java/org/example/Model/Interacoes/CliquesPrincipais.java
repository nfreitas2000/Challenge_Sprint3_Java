package org.example.Model.Interacoes;

import org.example.DAO.ImplementacaoCliquesLogin;
import org.example.DAO.ImplementacaoCliquesManuais;
import org.example.DAO.ImplementacaoCliquesPrincipais;
import org.example.DAO.ImplementacaoSessao;
import org.example.Model.Paciente.Sessao;

import java.sql.SQLException;

public class CliquesPrincipais {
    private int idCliquesPrincipais;
    private int cliquesLogin = 0;
    private int cliquesConsultas = 0;
    private int cliquesAgendamentos = 0;
    private int cliquesManuais = 0;
    private int cliquesOutros = 0;
    private CliquesLogin login;
    private Sessao sessao;

    public CliquesPrincipais() {
    }

    public CliquesPrincipais(Sessao sessao, CliquesLogin login) {
        this.sessao = sessao;
        this.login = login;
    }

    public CliquesPrincipais(int idCliquesPrincipais, int cliquesLogin, int cliquesConsultas, int cliquesAgendamentos, int cliquesManuais, int cliquesOutros, CliquesLogin login, Sessao sessao) {
        this.idCliquesPrincipais = idCliquesPrincipais;
        this.cliquesLogin = cliquesLogin;
        this.cliquesConsultas = cliquesConsultas;
        this.cliquesAgendamentos = cliquesAgendamentos;
        this.cliquesManuais = cliquesManuais;
        this.cliquesOutros = cliquesOutros;
        this.login = login;
        this.sessao = sessao;
    }

    public int getIdCliquesPrincipais() {
        return idCliquesPrincipais;
    }

    public void setIdCliquesPrincipais(int idCliquesPrincipais) {
        this.idCliquesPrincipais = idCliquesPrincipais;
    }

    public int getCliquesLogin() {
        return cliquesLogin;
    }

    public void setCliquesLogin(int cliquesLogin) {
        this.cliquesLogin = cliquesLogin;
    }

    public int getCliquesConsultas() {
        return cliquesConsultas;
    }

    public void setCliquesConsultas(int cliquesConsultas) {
        this.cliquesConsultas = cliquesConsultas;
    }

    public int getCliquesAgendamentos() {
        return cliquesAgendamentos;
    }

    public void setCliquesAgendamentos(int cliquesAgendamentos) {
        this.cliquesAgendamentos = cliquesAgendamentos;
    }

    public int getCliquesManuais() {
        return cliquesManuais;
    }

    public void setCliquesManuais(int cliquesManuais) {
        this.cliquesManuais = cliquesManuais;
    }

    public int getCliquesOutros() {
        return cliquesOutros;
    }

    public void setCliquesOutros(int cliquesOutros) {
        this.cliquesOutros = cliquesOutros;
    }

    public CliquesLogin getLogin() {
        return login;
    }

    public void setLogin(CliquesLogin login) {
        this.login = login;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public void salvarInteracoes(CliquesManuais manuais, CliquesLogin login, CliquesPrincipais principais, Sessao sessao) throws SQLException {
        ImplementacaoCliquesLogin cliquesLoginCRUD = new ImplementacaoCliquesLogin();
        ImplementacaoCliquesManuais cliquesManuaisCRUD = new ImplementacaoCliquesManuais();
        ImplementacaoCliquesPrincipais cliquesPrincipaisCRUD = new ImplementacaoCliquesPrincipais();

        ImplementacaoSessao sessaoCRUD = new ImplementacaoSessao();
        sessaoCRUD.inserirDados(sessao);

        cliquesManuaisCRUD.inserirDados(manuais);
        manuais.setIdCliquesManuais(cliquesManuaisCRUD.recuperaId(manuais));
        login.setManuais(manuais);
        cliquesLoginCRUD.inserirDados(login);
        login.setIdCliquesLogin(cliquesLoginCRUD.recuperaId(login));
        principais.setLogin(login);
        sessao.setId_sessao(sessaoCRUD.recuperaId(sessao));
        principais.setSessao(sessao);
        cliquesPrincipaisCRUD.inserirDados(principais);
    }
}
