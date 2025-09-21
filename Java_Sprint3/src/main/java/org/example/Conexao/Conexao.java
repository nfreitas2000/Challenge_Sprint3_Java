package org.example.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static Connection conexao = null;
    private static final String server = "oracle.fiap.com.br";
    private static final String port = "1521";
    private static final String sid = "ORCL";
    private static final String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private static final String user = "rm564992";
    private static final String password = "150207";

    public Conexao() {}

    public static Connection recuperaConexao() throws SQLException {
        if (conexao == null) {
            conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", user, password);
        }
        return conexao;
    }
}
