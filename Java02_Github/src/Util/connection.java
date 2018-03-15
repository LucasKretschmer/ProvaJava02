package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class connection {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("org.firebirdsql.jdbc.FBDriver");

                String servidor = "localhost";
                // Local da database
                String database = "D:\\Técnico\\BD\\AULA06.FDB";
                // Usuario e senha
                String user = "SYSDBA";
                String password = "masterkey";

                String url = "jdbc:firebirdsql:" + servidor + "/3050:" + database + "?encoding=WIN1252";

                try {
                    connection = DriverManager.getConnection(url, user, password);
                } catch (SQLException ex) {
                    System.out.println("Não foi Possivel Conectar ao Banco de Dados: " + ex.getMessage());
                }
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return connection;
    }
}
