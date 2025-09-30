package org.example.DAO;

import org.example.Conexao.Conexao;
import org.example.Model.Funcionario.ContaFuncionario;
import org.example.Model.Funcionario.Funcionario;
import org.example.Model.Paciente.ContaPaciente;
import org.example.Model.Paciente.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImplementacaoContaFuncionario implements DAO<ContaFuncionario>{
    @Override
    public List<ContaFuncionario> recuperarDadosTodos() {
        List<ContaFuncionario> l = new ArrayList<ContaFuncionario>();
        String sql = "select * from T_AX_LOGIN_DASHTECH";
        try (
                Connection con = Conexao.recuperaConexao();
                PreparedStatement st = con.prepareStatement(sql);
                ResultSet rs = st.executeQuery();

        ) {
            ImplementacaoFuncionario f = new ImplementacaoFuncionario();

            List<Funcionario> funcionarios = f.recuperarDadosTodos();

            while(rs.next()) {
                for (Funcionario funcionario : funcionarios){
                    if (funcionario.getId_funcionario() == rs.getInt(4)){
                        l.add(new ContaFuncionario(rs.getInt(1), funcionario, rs.getString(2), rs.getString(3)));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return l;
    }

    @Override
    public void inserirDados(ContaFuncionario o) {
        String sql = "insert into T_AX_LOGIN_DASHTECH (user_dashboard, password_dashtech, id_funcionario) values (?,?,?)";
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
        int id = 0;
        String sql = "select id_funcionario from T_AX_LOGIN_DASHTECH where id_funcionario = ?";

        try (
                Connection con = Conexao.recuperaConexao();
                PreparedStatement st = con.prepareStatement(sql);
        ) {
            st.setInt(1, o.getFuncionario().getId_funcionario());

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt("id_funcionario");
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return id;
    }

    @Override
    public void removerDados(ContaFuncionario o) {

    }

    @Override
    public void atualizarDados(ContaFuncionario o, String coluna, String dado) {

    }

    public ContaFuncionario recuperarLogin(String user, String senha){
        List<Funcionario> f = new ImplementacaoFuncionario().recuperarDadosTodos();
        ContaFuncionario c = new ContaFuncionario();

        String sql = "select * from T_AX_LOGIN_DASHTECH where user_dashboard = ? and password_dashtech = ?";
        try (
                Connection con = Conexao.recuperaConexao();
                PreparedStatement st = con.prepareStatement(sql);
        ) {
            st.setString(1, user);
            st.setString(2, senha);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    for (Funcionario funcionario : f){
                        if (funcionario.getId_funcionario() == rs.getInt(4)){
                            c.setId_conta_funcionario(rs.getInt(1));
                            c.setUser_funcionario(rs.getString(2));
                            c.setSenha_funcionario(rs.getString(3));
                            c.setFuncionario(funcionario);
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
