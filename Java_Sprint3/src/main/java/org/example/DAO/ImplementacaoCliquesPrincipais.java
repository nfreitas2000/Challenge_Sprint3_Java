package org.example.DAO;

import org.example.Conexao.Conexao;
import org.example.Model.Interacoes.CliquesLogin;
import org.example.Model.Interacoes.CliquesPrincipais;
import org.example.Model.Paciente.ContaPaciente;
import org.example.Model.Paciente.Sessao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImplementacaoCliquesPrincipais implements DAO<CliquesPrincipais> {
    @Override
    public List<CliquesPrincipais> recuperarDadosTodos() {
        List<CliquesPrincipais> l = new ArrayList<CliquesPrincipais>();
        String sql = "select id_interacao,cliques_agendas, cliques_teleconsulta, cliques_termos, cliques_dados, cliques_resultados, id_sessao, id_manuais_ajuda from T_AX_REGISTRO_INTERACAO";
        try (
                Connection con = Conexao.recuperaConexao();
                PreparedStatement st = con.prepareStatement(sql);
                ResultSet rs = st.executeQuery();

        ) {
            List<CliquesLogin> logins = new ImplementacaoCliquesLogin().recuperarDadosTodos();
            List<Sessao> sessao = new ImplementacaoSessao().recuperarDadosTodos();

            while(rs.next()) {
                for (CliquesLogin login : logins){
                    for (Sessao s : sessao){
                        if (login.getIdCliquesLogin() == rs.getInt(8) && s.getId_sessao() == rs.getInt(7)){
                            l.add(new CliquesPrincipais(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), login, s));
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return l;
    }

    @Override
    public void inserirDados(CliquesPrincipais o) {

        String sql = "insert into T_AX_REGISTRO_INTERACAO (cliques_agendas, cliques_teleconsulta, cliques_termos, cliques_dados, cliques_resultados, id_sessao, id_manuais_ajuda) values (?,?,?,?,?,?,?)";
        try (
                Connection con = Conexao.recuperaConexao();
                PreparedStatement st = con.prepareStatement(sql);
        ) {
            st.setInt(1,o.getCliquesAgendamentos());
            st.setInt(2, o.getCliquesConsultas());
            st.setInt(3, o.getCliquesManuais());
            st.setInt(4, o.getCliquesLogin());
            st.setInt(5, o.getCliquesOutros());
            st.setInt(6, o.getSessao().getId_sessao());
            st.setInt(7, o.getLogin().getIdCliquesLogin());
            int linhasAfetadas = st.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Dados de interação salvos com sucesso!");
            } else {
                System.out.println("Ocorreu um erro! Tente Novamente!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int recuperaId(CliquesPrincipais o) throws SQLException {
        return 0;
    }

    @Override
    public void removerDados(CliquesPrincipais o) {

    }

    @Override
    public void atualizarDados(CliquesPrincipais o, String coluna, String dado) {

    }
}
