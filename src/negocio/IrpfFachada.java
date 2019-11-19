package negocio;

import persistencia.ContribuinteDAODerby;

import java.math.BigDecimal;
import java.util.List;


public class IrpfFachada {
    private ContribuinteDAO dao;

    public IrpfFachada() throws Exception{
        try{
            dao = ContribuinteDAODerby.getInstance();
        } catch (Exception e) {
            throw new Exception("Falha de criação da fachada!", e);
        }

    }
public Contribuinte adicionarContribuinteCompleto(String nome, String cpf, int idade, int dependentes, BigDecimal contribuicao, BigDecimal rendimentos) throws Exception{
    Contribuinte c = new Contribuinte(nome, cpf, idade, dependentes, contribuicao, rendimentos);
    c.setValorAPagar(CalculaIrpfFactory.getTipo(c).valorAPagar());
    try {
        boolean ok = dao.adicionar(c);
        if(ok) {
            return c;
        }
        return null;
    } catch (Exception e) {
        throw new Exception("Falha ao adicionar pessoa!", e);
    }
}

    public List<Contribuinte> buscarTodos() throws Exception{
        try {
            return dao.listarTodos();
        } catch (Exception e) {
            throw new Exception("Falha ao buscar pessoas!", e);
        }
    }

    public Contribuinte buscarPorNome(String nome) throws Exception{
        try{
            return dao.buscarNome(nome);
        } catch(Exception e) {
            throw new Exception("Falha ao buscar pessoa", e);
        }
    }
}
