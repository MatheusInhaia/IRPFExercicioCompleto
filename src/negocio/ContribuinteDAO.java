package negocio;

import java.util.List;

public interface ContribuinteDAO {
    Contribuinte buscarNome(String nome) throws Exception;
    boolean adicionar(Contribuinte c) throws Exception;
    List<Contribuinte> listarTodos() throws Exception;
}
