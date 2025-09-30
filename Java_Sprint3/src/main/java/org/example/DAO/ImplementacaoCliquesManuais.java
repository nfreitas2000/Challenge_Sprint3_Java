package org.example.DAO;

import org.example.Conexao.Conexao;
import org.example.Model.Interacoes.CliquesManuais;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImplementacaoCliquesManuais implements DAO<CliquesManuais>{
    @Override
    public List<CliquesManuais> recuperarDadosTodos() {
        List<CliquesManuais> l = new ArrayList<CliquesManuais>();
        String sql = "select id_interacoes_manuais, cliques_acesso_portal, cliques_acesso_teleconsulta , cliques_politicas_privacidade from T_HCFMUSP_INTERACOES_MANUAIS";
        try (
                Connection con = Conexao.recuperaConexao();
                PreparedStatement st = con.prepareStatement(sql);
                ResultSet rs = st.executeQuery();

        ) {
            while(rs.next()) {
                l.add(new CliquesManuais(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return l;
    }

    @Override
    public void inserirDados(CliquesManuais o) {
        String sql = "insert into T_HCFMUSP_INTERACOES_MANUAIS (cliques_acesso_portal, cliques_acesso_teleconsulta , cliques_politicas_privacidade) values (?,?,?)";
        try (
                Connection con = Conexao.recuperaConexao();
                PreparedStatement st = con.prepareStatement(sql);
        ) {
            st.setInt(1,o.getCliquesPortalPaciente());
            st.setInt(2, o.getCliquesGuiaTeleconsulta());
            st.setInt(3, o.getCliquesPrivacidade());

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
    public int recuperaId(CliquesManuais o) throws SQLException {
        int id = 0;
        String sql = "select id_interacoes_manuais from T_HCFMUSP_INTERACOES_MANUAIS";

        try (
                Connection con = Conexao.recuperaConexao();
                PreparedStatement st = con.prepareStatement(sql);
        ) {

            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    id = rs.getInt("id_interacoes_manuais");
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return id;
    }

    @Override
    public void removerDados(CliquesManuais o) {

    }

    @Override
    public void atualizarDados(CliquesManuais o, String coluna, String dado) {

    }
}
