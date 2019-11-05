package persistencia;

import negocio.Contribuinte;
import negocio.ContribuinteDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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

    private static void createDB() throws Exception {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby:derbyDB;create=true");
            Statement sta = con.createStatement();
            String sql = "CREATE TABLE Contribuinte ("
                    + "ID INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                    + "NOME VARCHAR(100) NOT NULL,"
                    + "TELEFONE CHAR(8) NOT NULL,"
                    + "SEXO CHAR(1) NOT NULL"
                    + ")";
            sta.executeUpdate(sql);
            sta.close();
            con.close();
        } catch (SQLException ex) {
            throw new CadastroDAOException(ex.getMessage());
        }
    }

    private static Connection getConnection() throws SQLException {
        //derbyDB sera o nome do diretorio criado localmente
        return DriverManager.getConnection("jdbc:derby:derbyDB");
    }




    @Override
    public Contribuinte buscarNome(String nome) {
        return null;
    }

    @Override
    public boolean adicionar(Contribuinte c) {
        return false;
    }

    @Override
    public List<Contribuinte> listarTodos() {
        return null;
    }
}
