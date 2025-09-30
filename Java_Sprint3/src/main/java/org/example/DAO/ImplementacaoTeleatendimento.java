package org.example.DAO;

import org.example.Conexao.Conexao;
import org.example.Model.Funcionario.ContaFuncionario;
import org.example.Model.Paciente.ContaPaciente;
import org.example.Model.Paciente.Sessao;
import org.example.Model.Paciente.Teleconsulta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImplementacaoTeleatendimento implements DAO<Teleconsulta>{
    @Override
    public List<Teleconsulta> recuperarDadosTodos() {
        List<Teleconsulta> l = new ArrayList<Teleconsulta>();
        String sql = "select * from T_HCFMUSP_TELEATENDIMENTO";
        try (
                Connection con = Conexao.recuperaConexao();
                PreparedStatement st = con.prepareStatement(sql);
                ResultSet rs = st.executeQuery();

        ) {
            ImplementacaoContaPaciente p = new ImplementacaoContaPaciente();
            List<ContaPaciente> contasP = p.recuperarDadosTodos();
            ImplementacaoContaFuncionario f = new ImplementacaoContaFuncionario();
            List<ContaFuncionario> contasF = f.recuperarDadosTodos();


            while(rs.next()) {
                for (ContaPaciente contaPaciente : contasP){
                    for (ContaFuncionario contaFuncionario : contasF){
                        if (contaPaciente.getId_conta() == rs.getInt(6) && (contaFuncionario.getFuncionario().getId_funcionario() == rs.getInt(5))){
                            l.add(new Teleconsulta(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), contaFuncionario.getFuncionario(), contaPaciente));
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return l;
    }

    @Override
    public void inserirDados(Teleconsulta o) {
        String sql = "insert into T_HCFMUSP_TELEATENDIMENTO (dt_teleatendimento, tempo_atendimento, questao_tratada, id_funcionario ,id_login_paciente) values (TO_DATE(?, 'DD/MM/YYYY HH24:MI:SS'),? ,? ,? ,? )";
        try (
                Connection con = Conexao.recuperaConexao();
                PreparedStatement st = con.prepareStatement(sql);
        ) {
            st.setString(1, o.getDt_teleatendimento());
            st.setString(2, o.getTempo_teleatendimento());
            st.setString(3, o.getQuestao_tratada());
            st.setInt(4, o.getFuncionario().getId_funcionario());
            st.setInt(5, o.getPaciente().getId_conta());

            int linhasAfetadas = st.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Teleconsulta agendada com sucesso!");
            } else {
                System.out.println("Ocorreu um erro! Tente Novamente!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int recuperaId(Teleconsulta o) throws SQLException {
        return 0;
    }

    @Override
    public void removerDados(Teleconsulta o) {

    }

    @Override
    public void atualizarDados(Teleconsulta o, String coluna, String dado) {

    }
}
