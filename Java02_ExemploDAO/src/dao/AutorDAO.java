package dao;

import Util.Conection;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    
    public void update(Autor autor){
        
    }
    
    public void delete(Autor autor){
        
    }

    public Autor findById(int id){
        return new Autor();
    }
    
    public List<Autor> findALL(){
        return new ArrayList<>();
    }
}
