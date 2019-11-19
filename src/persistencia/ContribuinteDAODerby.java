package persistencia;

import negocio.Contribuinte;
import negocio.ContribuinteDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContribuinteDAODerby implements ContribuinteDAO {

    private static ContribuinteDAODerby  ref;

    public static ContribuinteDAODerby  getInstance() throws Exception {
        if (ref == null)
            ref = new ContribuinteDAODerby ();
        return ref;
    }

    private ContribuinteDAODerby () throws Exception {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException ex) {
            throw new Exception (ex);//"JdbcOdbDriver not found!!");

        }

        // Cria o banco de dados vazio
        // Retirar do comentário se necessário
/*
        try {
            createDB();
        } catch (Exception ex) {
            System.out.println("Problemas para criar o banco: "+ex.getMessage());
            System.exit(0);
        }
*/
    }

    public static void createDB() throws Exception {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby:derbyDB;create=true");
            Statement sta = con.createStatement();
            String sql = "CREATE TABLE Contribuinte ("
                    + "ID INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                    + "NOME VARCHAR(100) NOT NULL,"
                    + "CPF VARCHAR(15) NOT NULL,"
                    + "IDADE INTEGER,"
                    + "DEPENDENTES INTEGER,"
                    + "CONTRIBPREVIDENCIARIA NUMERIC(6) NOT NULL,"
                    + "RENDIMENTOS NUMERIC(6) NOT NULL,"
                    + "VALOR NUMERIC(6)"
                    + ")";


            sta.executeUpdate(sql);
            sta.close();
            con.close();
        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        }
    }

    private static Connection getConnection() throws SQLException {
        //derbyDB sera o nome do diretorio criado localmente
        return DriverManager.getConnection("jdbc:derby:derbyDB");
    }




    @Override
    public Contribuinte buscarNome(String nome) throws Exception{
        String sql = "select * from Contribuinte where nome = ?";
        Contribuinte c = null;
        try (Connection conexao = ContribuinteDAODerby.getConnection()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setString(1, nome);
                try (ResultSet resultado = comando.executeQuery()) {
                    if (resultado.next()) {
                        c = new Contribuinte(
                                resultado.getString("NOME"),
                                resultado.getString("CPF"),
                                resultado.getInt("IDADE"),
                                resultado.getInt("DEPENDENTES"),
                                resultado.getBigDecimal("CONTRIBPREVIDENCIARIAa"),
                                resultado.getBigDecimal("RENDIMENTOS"),
                                resultado.getBigDecimal("VALOR")
                        );
                    }
                    return c;
                }
            }
        } catch (Exception e) {
            throw new Exception("Falha na busca", e);
        }
        return null;
    }

    @Override
    public boolean adicionar(Contribuinte c) {
        String sql = "insert into Contribuinte(nome,cpf,idade,dependentes,contribprevidenciaria,rendimentos,valor) values(?,?,?,?,?,?,?)";
        int resultado =0;
        try (Connection conexao = ContribuinteDAODerby.getConnection()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setString(1, c.getNome());
                comando.setString(2, c.getCPF());
                comando.setInt(3, c.getIdade());
                comando.setInt(4, c.getNumeroDependentes());
                comando.setBigDecimal(5, c.getContribuicaoPrevidenciariaOficial());
                comando.setBigDecimal(6, c.getTotalRendimentos());
                comando.setBigDecimal(7, c.getValorAPagar());
                resultado = comando.executeUpdate();
            }
        } catch (Exception e) {
            //throw new DAOEditoraException("Falha na inserção", e);
            return false;
        }
        if (resultado == 0) {
           // throw new DAOEditoraException("Falha na inserção");
            return false;
        }
        return true;
    }


    @Override
    public List<Contribuinte> listarTodos(){
        List<Contribuinte> contribuintes = new ArrayList<>();
        String sql = "select * from Contribuinte";
        try (Connection conexao = ContribuinteDAODerby.getConnection()) {
            try (Statement comando = conexao.createStatement()) {
                try (ResultSet resultado = comando.executeQuery(sql)) {
                    while (resultado.next()) {
                        Contribuinte c = new Contribuinte(
                                resultado.getString("NOME"),
                                resultado.getString("CPF"),
                                resultado.getInt("IDADE"),
                                resultado.getInt("DEPENDENTES"),
                                resultado.getBigDecimal("CONTRIBPREVIDENCIARIAa"),
                                resultado.getBigDecimal("RENDIMENTOS"),
                                resultado.getBigDecimal("VALOR")
                        );
                        contribuintes.add(c);
                    }
                    return contribuintes;
                }
            }
        } catch (Exception e) {
            //throw new DAOEditoraException("Falha na busca", e);
        }
        return null;
    }
}
