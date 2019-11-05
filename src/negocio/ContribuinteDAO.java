package negocio;

import java.util.List;

public interface ContribuinteDAO {
    Contribuinte buscarNome(String nome);
    boolean adicionar(Contribuinte c);
    List<Contribuinte> listarTodos();
}
