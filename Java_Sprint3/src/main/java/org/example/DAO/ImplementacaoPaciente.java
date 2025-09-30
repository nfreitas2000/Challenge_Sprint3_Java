package org.example.DAO;

import org.example.Conexao.Conexao;
import org.example.Model.Paciente.Paciente;
import org.example.Model.Pessoa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImplementacaoPaciente implements DAO<Paciente>{
    @Override
    public List<Paciente> recuperarDadosTodos() {
        List<Paciente> l = new ArrayList<Paciente>();
        String sql = "select * from T_HCFMUSP_PACIENTE";
        try (
                Connection con = Conexao.recuperaConexao();
                PreparedStatement st = con.prepareStatement(sql);
                ResultSet rs = st.executeQuery();

        ) {
            ImplementacaoPessoa p = new ImplementacaoPessoa();

            List<Pessoa> pessoas = p.recuperarDadosTodos();

            while(rs.next()) {
                for (Pessoa pessoa : pessoas){
                    if (pessoa.getId_pessoa() == rs.getInt(6)){
                        l.add(new Paciente(rs.getInt(1), pessoa, rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDouble(5)));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return l;
    }

    @Override
    public void inserirDados(Paciente p) {
        String sql = "insert into T_HCFMUSP_PACIENTE (historico_medico, grupo_sanguineo, altura, peso, id_pessoa) values (?,?,?,?,?)";
        try (
                Connection con = Conexao.recuperaConexao();
                PreparedStatement st = con.prepareStatement(sql);
        ) {
            st.setString(1, p.getHistoricoMedico());
            st.setString(2, p.getGrupoSanguineo());
            st.setDouble(3, p.getAltura());
            st.setDouble(4, p.getPeso());
            st.setInt(5, p.getPessoa().getId_pessoa());
            int linhasAfetadas = st.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Cadastro de paciente realizado com sucesso!");
            } else {
                System.out.println("Ocorreu um erro! Tente Novamente!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int recuperaId(Paciente o){
        int id = 0;
        String sql = "select id_paciente from T_HCFMUSP_PACIENTE where id_pessoa = ?";
        try (
            Connection con = Conexao.recuperaConexao();
            PreparedStatement st = con.prepareStatement(sql);
        ) {
            st.setInt(1, o.getPessoa().getId_pessoa());

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt("id_paciente");
                }
            };
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return id;
    }

    @Override
    public void removerDados(Paciente o) {
        String sql = "Delete from T_HCFMUSP_PACIENTE where id_pessoa = ?";

        try (Connection con = Conexao.recuperaConexao()) {
            con.setAutoCommit(false);

            try (PreparedStatement st = con.prepareStatement(sql)) {
                st.setInt(1, o.getPessoa().getId_pessoa());
                int linhasAfetadas = st.executeUpdate();
                if (linhasAfetadas > 0) {
                    con.commit();
                    System.out.println("Paciente apagado do BD!");
                } else {
                    con.rollback();
                    System.out.println("Não foi apagado");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void atualizarDados(Paciente o, String coluna, String dado) {
        String sql = "Update T_HCFMUSP_PACIENTE set " + coluna + " = ? where id_paciente = ?";

        try (Connection con = Conexao.recuperaConexao()) {
            PreparedStatement st = con.prepareStatement(sql);

            try {
                double dadoDouble = Double.parseDouble(dado);
                st.setDouble(1,dadoDouble);
            } catch (NumberFormatException e) {
                st.setString(1, dado);
            }
            st.setInt(2, o.getId_paciente());

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
