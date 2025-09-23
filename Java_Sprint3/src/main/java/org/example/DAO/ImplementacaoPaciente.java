package org.example.DAO;

import org.example.Conexao.Conexao;
import org.example.Model.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ImplementacaoPaciente implements DAO<Paciente>{
    @Override
    public List<Paciente> recuperarDadosTodos() {
        return List.of();
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
                System.out.println("Cadastro de pessoa realizado com sucesso!");
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
        String sql = "select id_paciente from T_HCFMUSP_PACIENTE";
        try (
            Connection con = Conexao.recuperaConexao();
            PreparedStatement st = con.prepareStatement(sql);
        ) {
            System.out.println("oi");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return id;
    }
}
