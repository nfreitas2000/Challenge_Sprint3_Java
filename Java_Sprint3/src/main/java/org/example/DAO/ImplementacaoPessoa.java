package org.example.DAO;

import org.example.Conexao.Conexao;
import org.example.Model.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ImplementacaoPessoa implements DAO<Pessoa>{
    @Override
    public List<Pessoa> recuperarDados() {
        return List.of();
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
}
