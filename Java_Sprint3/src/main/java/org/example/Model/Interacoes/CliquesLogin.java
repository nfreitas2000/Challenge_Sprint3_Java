package org.example.Model.Interacoes;

import org.example.DAO.ImplementacaoCliquesLogin;
import org.example.DAO.ImplementacaoCliquesManuais;
import org.example.DAO.ImplementacaoCliquesPrincipais;

public class CliquesLogin {
    private int idCliquesLogin;
    private int cliquesCadastro;
    private int cliquesAtualizarDados;
    private CliquesManuais Manuais;

    public CliquesLogin(CliquesManuais manuais) {
        Manuais = manuais;
    }

    public CliquesLogin(int idCliquesLogin, int cliquesCadastro, int cliquesAtualizarDados, CliquesManuais manuais) {
        this.idCliquesLogin = idCliquesLogin;
        this.cliquesCadastro = cliquesCadastro;
        this.cliquesAtualizarDados = cliquesAtualizarDados;
        Manuais = manuais;
    }

    public CliquesLogin() {
    }

    public int getIdCliquesLogin() {
        return idCliquesLogin;
    }

    public void setIdCliquesLogin(int idCliquesLogin) {
        this.idCliquesLogin = idCliquesLogin;
    }

    public int getCliquesCadastro() {
        return cliquesCadastro;
    }

    public void setCliquesCadastro(int cliquesCadastro) {
        this.cliquesCadastro = cliquesCadastro;
    }

    public int getCliquesAtualizarDados() {
        return cliquesAtualizarDados;
    }

    public void setCliquesAtualizarDados(int cliquesAtualizarDados) {
        this.cliquesAtualizarDados = cliquesAtualizarDados;
    }

    public CliquesManuais getManuais() {
        return Manuais;
    }

    public void setManuais(CliquesManuais manuais) {
        Manuais = manuais;
    }

}
