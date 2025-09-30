package org.example.DAO;

import org.example.Conexao.Conexao;
import org.example.Model.Paciente.ContaPaciente;
import org.example.Model.Paciente.Paciente;
import org.example.Model.Paciente.Sessao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImplementacaoSessao implements DAO<Sessao>{
    @Override
    public List<Sessao> recuperarDadosTodos() {
        List<Sessao> l = new ArrayList<Sessao>();
        String sql = "select * from T_HCFMUSP_SESSAO";
        try (
                Connection con = Conexao.recuperaConexao();
                PreparedStatement st = con.prepareStatement(sql);
                ResultSet rs = st.executeQuery();

        ) {
            ImplementacaoContaPaciente p = new ImplementacaoContaPaciente();

            List<ContaPaciente> contasP = p.recuperarDadosTodos();

            while(rs.next()) {
                for (ContaPaciente contaPaciente : contasP){
                    if (contaPaciente.getId_conta() == rs.getInt(5)){
                        l.add(new Sessao(rs.getInt(1), rs.getString(2), rs.getString(3), contaPaciente));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return l;
    }

    @Override
    public void inserirDados(Sessao o) {
        String sql = "insert into T_HCFMUSP_SESSAO (st_sessao, dt_inicio_sessao, tempo_sessao, id_login_paciente) values (?,TO_DATE(?, 'DD/MM/YYYY HH24:MI:SS'), ?, ?)";
        try (
                Connection con = Conexao.recuperaConexao();
                PreparedStatement st = con.prepareStatement(sql);
        ) {
            st.setString(1, o.getStatus());
            st.setString(2, o.getDt_inicio());
            st.setString(3, o.getTempo());
            st.setInt(4, o.getContaPaciente().getId_conta());

            int linhasAfetadas = st.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Sessão salva com sucesso!");
            } else {
                System.out.println("Ocorreu um erro! Tente Novamente!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int recuperaId(Sessao o) throws SQLException {
        return 0;
    }

    @Override
    public void removerDados(Sessao o) {

    }

    @Override
    public void atualizarDados(Sessao o, String coluna, String dado) {

    }
}
