package dao;

import Util.Conection;
import forms.AutorForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.ParseConversionEvent;
import model.Autor;

public class AutorDAO {
    
    Connection connection;
    
    public AutorDAO() throws Exception{
        connection = Conection.getConnection();
    }
    
    public void insert(Autor autor) throws SQLException{
        String sql = "INSERT INTO AUTOR (NOME) VALUES ('"+autor.getNome()+"';)";
        PreparedStatement p = connection.prepareStatement(sql);
        p.execute();
    }
    
    public void update(Autor autor) throws SQLException{
        AutorForm a = new AutorForm();
        String sql = "UPDATE AUTOR (NOME) SET '"+a.getTxtAutor()+"' WHERE AUTOR_ID IS '"+autor.getAutor_id()+"';";
        PreparedStatement p = connection.prepareStatement(sql);
        p.execute();
    }
    
    public void delete(Autor autor){
        
    }

    public Autor findById(int id){
        return new Autor();
    }
    
    public List<Autor> findALL() throws SQLException{
        // Lista para manter os valores do resultset
        List<Autor> list = new ArrayList<>();
        Autor objeto;
        String sql = "SELECT * FROM AUTOR";
        PreparedStatement p = connection.prepareStatement(sql);
        ResultSet rs = p.executeQuery();
        
        while (rs.next()) {
            objeto = new Autor();
            objeto.setAutor_id(rs.getInt("AUTOR_ID"));
            objeto.setNome(rs.getString("NOME"));            
        }
        rs.close();
        p.close();
        
        return list;
    }
}
