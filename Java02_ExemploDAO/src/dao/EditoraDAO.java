package dao;

import Util.Conection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Editora;

public class EditoraDAO {
    
    Connection conection;
    
    public EditoraDAO() throws Exception{
        conection = Conection.getConnection();
    }
    
    public void insert(Editora edit) throws SQLException{
        String sql = "INSERT INTO EDITORA (NOME, MUNICIPIO) VALUES ('"+edit.getNome()+"', '"+edit.getMunicipio()+"')";
        PreparedStatement ps = conection.prepareStatement(sql);
        ps.execute();
    }
    
    public void update(Editora edit) throws SQLException{
        String sql = "UPDATE EDITORA SET NOME = '"+edit.getNome()+"', MUNICIPIO = '"+edit.getMunicipio()+"' WHERE EDITORA_ID = "+edit.getEditora_id();
        PreparedStatement ps = conection.prepareStatement(sql);
        ps.execute();
    }
    
    public void delete(Editora edit) throws SQLException{
        String sql = "DELETE FROM EDITORA WHERE EDITORA_ID = "+edit.getEditora_id();
        PreparedStatement ps = conection.prepareStatement(sql);
        ps.execute();
    }

    public Editora findById(int id){
        return new Editora();
    }
    
    public List<Editora> findALL() throws SQLException{
        // Lista para manter os valores do resultset
        List<Editora> list = new ArrayList<>();
        Editora objeto;
        String sql = "SELECT * FROM EDITORA";
        PreparedStatement p = conection.prepareStatement(sql);
        ResultSet rs = p.executeQuery();
        
        while (rs.next()) {
            //instancia a classe e informa valores do banco de dados
            objeto = new Editora();
            objeto.setEditora_id(rs.getInt("EDITORA_ID"));
            objeto.setNome(rs.getString("NOME"));
            objeto.setMunicipio(rs.getString("MUNICIPIO"));
            
            list.add(objeto);
        }
        rs.close();
        p.close();
        
        return list;
    }
}
