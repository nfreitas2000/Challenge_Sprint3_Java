package org.example.DAO;

import java.util.List;

public interface DAO<O>{
    List<O> recuperarDados();
    void inserirDados(O o);

}
