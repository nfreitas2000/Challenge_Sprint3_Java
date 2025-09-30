package org.example.DAO;

import org.example.Conexao.Conexao;
import org.example.Model.Pessoa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImplementacaoPessoa implements DAO<Pessoa>{
    @Override
    public List<Pessoa> recuperarDadosTodos() {

        List<Pessoa> l = new ArrayList<Pessoa>();
        String sql = "select * from T_HCFMUSP_PESSOA";
        try (
            Connection con = Conexao.recuperaConexao();
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

        ) {
            while(rs.next()) {
                l.add(new Pessoa(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return l;
    }

    @Override
    public void inserirDados(Pessoa p) {
        String sql = "insert into T_HCFMUSP_PESSOA (nm_pessoa, cpf, rg, dt_nascimento, sx_pessoa, estado_civil, escolaridade) values (?,?,?,?,?,?,?)";
        try (
                Connection con = Conexao.recuperaConexao();
                PreparedStatement st = con.prepareStatement(sql);
        ) {
            st.setString(1, p.getNome());
            st.setString(2, p.getCpf());
            st.setString(3, p.getRg());
            st.setString(4, p.getDt_nascimento());
            st.setString(5, p.getSx_pessoa());
            st.setString(6, p.getEstado_civil());
            st.setString(7, p.getEscolaridade());
            int linhasAfetadas = st.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Cadastro de pessoa realizado com sucesso!");
            } else {
                System.out.println("Ocorreu um erro! Tente Novamente!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int recuperaId(Pessoa o) {
        int id = 0;
        String sql = "select id_pessoa from T_HCFMUSP_PESSOA where cpf = ?";

        try (
                Connection con = Conexao.recuperaConexao();
                PreparedStatement st = con.prepareStatement(sql);
        ) {
            st.setString(1, o.getCpf());

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt("id_pessoa");
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return id;
    }

    @Override
    public void removerDados(Pessoa o) {
        String sql = "Delete from T_HCFMUSP_PESSOA where id_pessoa = ?";

        try (Connection con = Conexao.recuperaConexao()) {
            con.setAutoCommit(false);

            try (PreparedStatement st = con.prepareStatement(sql)) {
                st.setInt(1, o.getId_pessoa());
                int linhasAfetadas = st.executeUpdate();
                if (linhasAfetadas > 0) {
                    con.commit();
                    System.out.println("Pessoa apagada do BD!");
                } else {
                    con.rollback();
                    System.out.println("Não foi apagada");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void atualizarDados(Pessoa o, String coluna, String dado) {
        String sql = "Update T_HCFMUSP_PESSOA set " + coluna + " = ? where id_pessoa = ?";

        try (Connection con = Conexao.recuperaConexao()) {
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, dado);
            st.setInt(2, o.getId_pessoa());

            int linhas = st.executeUpdate();

            if (linhas > 0) {
                System.out.println("Dado atualizado!");
            } else {
                System.out.println("Não atualizou!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
