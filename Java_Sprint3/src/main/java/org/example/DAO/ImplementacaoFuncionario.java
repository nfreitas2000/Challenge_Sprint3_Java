package org.example.DAO;

import org.example.Conexao.Conexao;
import org.example.Model.Funcionario.Funcionario;
import org.example.Model.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImplementacaoFuncionario implements DAO<Funcionario>{
    @Override
    public List<Funcionario> recuperarDadosTodos() {
        List<Funcionario> l = new ArrayList<Funcionario>();
        String sql = "select * from T_HCFMUSP_FUNCIONARIO";
        try (
                Connection con = Conexao.recuperaConexao();
                PreparedStatement st = con.prepareStatement(sql);
                ResultSet rs = st.executeQuery();

        ) {
            ImplementacaoPessoa p = new ImplementacaoPessoa();
            List<Pessoa> pessoas = p.recuperarDadosTodos();

            while(rs.next()) {
                for (Pessoa pessoa : pessoas){
                    if (pessoa.getId_pessoa() == rs.getInt(5)){
                        l.add(new Funcionario(rs.getInt(1), pessoa, rs.getString(2), rs.getString(3), rs.getString(4)));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return l;
    }

    @Override
    public void inserirDados(Funcionario o) {
        String sql = "insert into T_HCFMUSP_FUNCIONARIO (setor, cargo, st_credencial, id_pessoa) values (?,?,?,?)";
        try (
                Connection con = Conexao.recuperaConexao();
                PreparedStatement st = con.prepareStatement(sql);
        ) {
            st.setString(1, o.getSetor());
            st.setString(2, o.getCargo());
            st.setString(3, o.getSt_credencial());
            st.setInt(4, o.getPessoa().getId_pessoa());
            int linhasAfetadas = st.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Cadastro de funcionário realizado com sucesso!");
            } else {
                System.out.println("Ocorreu um erro! Tente Novamente!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int recuperaId(Funcionario o){
        int id = 0;
        String sql = "select id_funcionario from T_HCFMUSP_FUNCIONARIO where id_pessoa = ?";
        try (
                Connection con = Conexao.recuperaConexao();
                PreparedStatement st = con.prepareStatement(sql);
        ) {
            st.setInt(1, o.getPessoa().getId_pessoa());

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt("id_funcionario");
                }
            };
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return id;
    }

    @Override
    public void removerDados(Funcionario o) {

    }

    @Override
    public void atualizarDados(Funcionario o, String coluna, String dado) {

    }
}
