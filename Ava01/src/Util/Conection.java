package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection {

    private static Connection connection = null;

    public static Connection getConnection() throws Exception{
        if (connection == null) {
            try {
                Class.forName("org.firebirdsql.jdbc.FBDriver");

                String servidor = "localhost";
                // Local da database
                String database = "D:\\Técnico\\BD\\java02_ava01.fdb";
                // Usuario e senha
                String user = "SYSDBA";
                String password = "masterkey";

                String url = "jdbc:firebirdsql:" + servidor + "/3050:" + database + "?encoding=WIN1252";

                try {
                    connection = DriverManager.getConnection(url, user, password);
                } catch (SQLException ex) {
                    throw new Exception(ex);
                }
            } catch (ClassNotFoundException ex) {
                throw new Exception(ex);
            }
        }
        return connection;
    }
}
