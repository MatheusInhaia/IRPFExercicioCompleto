package persistencia;

public class ContribuinteDAOException extends Exception {
    /**
     * Creates a new instance of
     * <code>CadastroDAOException</code> without detail message.
     */
    public ContribuinteDAOException() {
    }

    /**
     * Constructs an instance of
     * <code>ContribuinteDAOException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ContribuinteDAOException(String msg) {
        super(msg);
    }

    public ContribuinteDAOException(String message, Throwable cause) {
        super(message, cause);
    }
}
