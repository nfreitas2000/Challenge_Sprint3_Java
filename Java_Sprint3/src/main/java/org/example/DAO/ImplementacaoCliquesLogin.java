package org.example.DAO;

import org.example.Conexao.Conexao;
import org.example.Model.Interacoes.CliquesLogin;
import org.example.Model.Interacoes.CliquesManuais;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImplementacaoCliquesLogin implements DAO<CliquesLogin>{
    @Override
    public List<CliquesLogin> recuperarDadosTodos() {
        List<CliquesLogin> l = new ArrayList<CliquesLogin>();
        String sql = "select id_manuais_ajuda, cliques_atualizar_cadastro, cliques_senha, id_interacoes_manuais from T_HCFMUSP_INTERACAO_AJUDA";
        try (
                Connection con = Conexao.recuperaConexao();
                PreparedStatement st = con.prepareStatement(sql);
                ResultSet rs = st.executeQuery();

        ) {
            List<CliquesManuais> manuais = new ImplementacaoCliquesManuais().recuperarDadosTodos();

            while(rs.next()) {
                for (CliquesManuais m : manuais){
                    if (m.getIdCliquesManuais() == rs.getInt(4)){
                        l.add(new CliquesLogin(rs.getInt(1), rs.getInt(2), rs.getInt(3), m));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return l;
    }

    @Override
    public void inserirDados(CliquesLogin o) {
        String sql = "insert into T_HCFMUSP_INTERACAO_AJUDA (cliques_atualizar_cadastro, cliques_senha, id_interacoes_manuais) values (?,?,?)";
        try (
                Connection con = Conexao.recuperaConexao();
                PreparedStatement st = con.prepareStatement(sql);
        ) {


            st.setInt(1,o.getCliquesAtualizarDados());
            st.setInt(2, o.getCliquesCadastro());
            st.setInt(3, o.getManuais().getIdCliquesManuais());

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
    public int recuperaId(CliquesLogin o) throws SQLException {
        int id = 0;
        String sql = "select id_manuais_ajuda from T_HCFMUSP_INTERACAO_AJUDA";

        try (
                Connection con = Conexao.recuperaConexao();
                PreparedStatement st = con.prepareStatement(sql);
        ) {

            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    id = rs.getInt("id_manuais_ajuda");
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return id;
    }

    @Override
    public void removerDados(CliquesLogin o) {

    }

    @Override
    public void atualizarDados(CliquesLogin o, String coluna, String dado) {

    }
}
