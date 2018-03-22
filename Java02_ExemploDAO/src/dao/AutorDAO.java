package dao;

import Util.Conection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Autor;

public class AutorDAO {
    
    Connection connection;
    
    public AutorDAO() throws Exception{
        connection = Conection.getConnection();
    }
    
    public void insert(Autor autor) throws SQLException{
        String sql = "INSERT INTO AUTOR (NOME) VALUES ('"+autor.getNome()+"')";
        PreparedStatement p = connection.prepareStatement(sql);
        p.execute();
    }
    
    public void update(Autor autor) throws SQLException{
        String sql = "UPDATE AUTOR SET NOME = '"+autor.getNome()+"' WHERE AUTOR_ID = "+autor.getAutor_id();
        PreparedStatement p = connection.prepareStatement(sql);
        p.execute();
    }
    
    public void delete(Autor autor) throws SQLException{
        String sql = "DELETE FROM AUTOR WHERE AUTOR_ID = "+autor.getAutor_id();
        PreparedStatement p = connection.prepareStatement(sql);
        p.execute();
    }

    public Autor findById(int id){
        return new Autor();
    }
    
    public List<Autor> findALL() throws SQLException{
        // Lista para manter os valores do resultset
        List<Autor> list = new ArrayList<>();
        Autor objeto;
        String sql = "SELECT * FROM AUTOR ORDER BY AUTOR_ID ";
        PreparedStatement p = connection.prepareStatement(sql);
        ResultSet rs = p.executeQuery();
        
        while (rs.next()) {
            //instancia a classe e informa valores do banco de dados
            objeto = new Autor();
            objeto.setAutor_id(rs.getInt("AUTOR_ID"));
            objeto.setNome(rs.getString("NOME")); 
            list.add(objeto);
        }
        rs.close();
        p.close();
        
        return list;
    }
}
