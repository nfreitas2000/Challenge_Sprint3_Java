package org.example.DAO;

import org.example.Conexao.Conexao;
import org.example.Model.Paciente.ContaPaciente;
import org.example.Model.Paciente.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ImplementacaoContaPaciente implements DAO<ContaPaciente>{

    @Override
    public List<ContaPaciente> recuperarDadosTodos() {
        return List.of();
    }

    @Override
    public void inserirDados(ContaPaciente o) {
        String sql = "insert into T_HCFMUSP_LOGIN_PACIENTE (nm_usuario, senha, id_paciente) values (?,?,?)";
        try (
                Connection con = Conexao.recuperaConexao();
                PreparedStatement st = con.prepareStatement(sql);
        ) {
            st.setString(1, o.getNm_paciente());
            st.setString(2, o.getSenha());
            st.setInt(3, o.getPaciente().getId_paciente());
            int linhasAfetadas = st.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Conta criada com sucesso!");
            } else {
                System.out.println("Ocorreu um erro! Tente Novamente!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int recuperaId(ContaPaciente o){
        int id = 0;
        String sql = "select id_login_paciente from T_HCFMUSP_LOGIN_PACIENTE where id_paciente = ?";

        try (
                Connection con = Conexao.recuperaConexao();
                PreparedStatement st = con.prepareStatement(sql);
        ) {
            st.setInt(1, o.getPaciente().getId_paciente());

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

    public ContaPaciente recuperarLogin(String user, String senha){
        List<Paciente> paciente = new ImplementacaoPaciente().recuperarDadosTodos();
        ContaPaciente c = new ContaPaciente();

        String sql = "select * from T_HCFMUSP_LOGIN_PACIENTE where nm_usuario = ? and senha = ?";
        try (
                Connection con = Conexao.recuperaConexao();
                PreparedStatement st = con.prepareStatement(sql);
        ) {
            st.setString(1, user);
            st.setString(2, senha);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    for (Paciente pacientes : paciente){
                        if (pacientes.getId_paciente() == rs.getInt(4)){
                            c.setId_conta(rs.getInt(1));
                            c.setNm_paciente(rs.getString(2));
                            c.setSenha(rs.getString(3));
                            c.setPaciente(pacientes);
                        }
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return c;
    }
}
