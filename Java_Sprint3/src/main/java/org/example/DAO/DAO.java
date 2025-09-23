package org.example.DAO;

import java.sql.SQLException;
import java.util.List;

public interface DAO<O>{
    List<O> recuperarDadosTodos();
    void inserirDados(O o);
    int recuperaId(O o) throws SQLException;

}
