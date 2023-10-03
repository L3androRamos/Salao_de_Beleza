package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBancodeDados {
    static String host = "localhost";
    static String database = "salao";
    static String user = "root";
    static String password = "Umdoistres4!BL";

    static int port = 3306;
    private static ConexaoBancodeDados instance;
    private static Connection connection;
    // Conecta ao banco de dados MySQL

    public Connection getConnection() {
        return connection;
    }
    public static ConexaoBancodeDados getInstance() throws SQLException {
        if (instance == null) {
            instance = new ConexaoBancodeDados();
            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?useTimezone=true&serverTimezone=UTC", user, password);

        }
        return instance;
    }

    public void closeConnection() throws SQLException {
        this.connection.close();
    }

}

