package org.example.DAO;

import org.example.Conexao.Conexao;
import org.example.Model.Funcionario.ContaFuncionario;
import org.example.Model.Funcionario.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ImplementacaoContaFuncionario implements DAO<ContaFuncionario>{
    @Override
    public List<ContaFuncionario> recuperarDadosTodos() {
        return List.of();
    }

    @Override
    public void inserirDados(ContaFuncionario o) {
        String sql = "insert into T_HCFMUSP_AX_LOGIN_DASHTECH (user_dashtech, password_dashtech, id_funcionario) values (?,?,?)";
        try (
                Connection con = Conexao.recuperaConexao();
                PreparedStatement st = con.prepareStatement(sql);
        ) {
            st.setString(1, o.getUser_funcionario());
            st.setString(2, o.getSenha_funcionario());
            st.setInt(3, o.getFuncionario().getId_funcionario());
            int linhasAfetadas = st.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Conta de funcionário criada com sucesso!");
            } else {
                System.out.println("Ocorreu um erro! Tente Novamente!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int recuperaId(ContaFuncionario o) throws SQLException {
        return 0;
    }
}
