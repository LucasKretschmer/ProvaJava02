package dao;

import Util.Conection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.cadastro;

public class cadastroDAO {
    
    Connection conection;
    
    public cadastroDAO() throws Exception{
        conection = Conection.getConnection();
    }
    
    public void insert(cadastro cad) throws SQLException{
        System.out.println("passo");
        String sql = "INSERT INTO CADASTROAGRICULTOR (NOME, DATA_CADASTRO, MUNICIPIO, LOCALIDADE, PRODUTOS, STATUS, TELEFONE) "
                + "VALUES ('"+cad.getNome()+"','"+cad.getData()+"','"+cad.getMunicipio()+"', '"+cad.getLocalidade()+"', "
                + "'"+cad.getProdutos()+"','"+cad.getStatus()+"', '"+cad.getTelefone()+"')";
        PreparedStatement ps = conection.prepareStatement(sql);
        ps.execute();
    }
    
    public void update(cadastro cad) throws SQLException{
        String sql = "UPDATE EDITORA SET NOME = '"+cad.getNome()+"', DATA_CADASTRO = '"+cad.getData()+"', MUNICIPIO = '"+cad.getMunicipio()+"', "
                + "LOCALIDADE = '"+cad.getLocalidade()+"', PRODUTOS = '"+cad.getProdutos()+"', STATUS = '"+cad.getStatus()+"', "
                + "TELEFONE = '"+cad.getTelefone()+"'";
        PreparedStatement ps = conection.prepareStatement(sql);
        ps.execute();
    }
    
    public void delete(cadastro cad) throws SQLException{
        String sql = "DELETE FROM EDITORA WHERE EDITORA_ID = "+cad.getId();
        PreparedStatement ps = conection.prepareStatement(sql);
        ps.execute();
    }

    public cadastro findById(int id){
        return new cadastro();
    }
    
    public List<cadastro> findALL() throws SQLException{
        // Lista para manter os valores do resultset
        List<cadastro> list = new ArrayList<>();
        cadastro objeto;
        String sql = "SELECT * FROM CADASTROAGRICULTOR";
        PreparedStatement p = conection.prepareStatement(sql);
        ResultSet rs = p.executeQuery();
        
        while (rs.next()) {
            //instancia a classe e informa valores do banco de dados
            objeto = new cadastro();
            objeto.setId(rs.getInt("EDITORA_ID"));
            objeto.setNome(rs.getString("NOME"));
            objeto.setData("DATA_CADASTRO");
            objeto.setMunicipio(rs.getString("MUNICIPIO"));
            objeto.setLocalidade(rs.getString("LOCALIDADE"));
            objeto.setProdutos(rs.getString("PRODUTOS"));
            objeto.setStatus(rs.getInt("STATUS"));
            objeto.setTelefone(rs.getString("TELEFONE"));
            
            list.add(objeto);
        }
        rs.close();
        p.close();
        
        return list;
    }

    public void insert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
