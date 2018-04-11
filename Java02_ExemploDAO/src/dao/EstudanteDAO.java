package dao;

import Util.Conection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Editora;
import model.Estudante;
import model.Livro;

public class EstudanteDAO {

    Connection connection;

    public EstudanteDAO() throws Exception {
        connection = Conection.getConnection();
    }

    public void insert(Estudante est) throws SQLException {
        String sql = "INSERT INTO ESTUDANTE (NOME, CURSO, DATA_MATRICULA, STATUS) "
                + "VALUES ('" + est.getNome() + "', '" + est.getCurso() + "', '" + est.getData_matricula() + "', '" + est.getStatus() + "')";
        PreparedStatement p = connection.prepareStatement(sql);
        p.execute();
    }
    
    public void update(Estudante est) throws SQLException{
        String sql = "UPDATE ESTUDANTE SET NOME = '" + est.getNome() + "', CURSO = '" + est.getCurso() + "', "
                + "DATA_MATRICULA = '" + est.getData_matricula() + "', STATUS = '" + est.getStatus() + "' "
                + "WHERE ESTUDANTE_ID = '"+est.getEstudante_id()+"'";
        PreparedStatement p = connection.prepareStatement(sql);
        p.execute();
    }
    
    public void delete(Estudante est) throws SQLException{
        String sql = "DELETE FROM ESTUDANTE WHERE ESTUDANTE_ID = '"+est.getEstudante_id();
        PreparedStatement p = connection.prepareStatement(sql);
        p.execute();
    }
    
    public Estudante findById(int id) throws Exception {
        Estudante objeto = new Estudante();
        String SQL = "SELECT STATUS, DATA_MATRICULA FROM ESTUDANTE "
                + "WHERE ESTUDANTE_ID = ?";
        try {
            // Prepara a SQL
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setInt(1, id);
            // Executa a SQL e mantem os valores no ResultSet rs
            ResultSet rs = p.executeQuery();
            // Navega pelos registros no rs
            while (rs.next()) {
                // Instancia a classe e informa os valores do BD
                objeto = new Estudante();
                
                objeto.setEstudante_id(id);
            }
            rs.close();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
        // Retorna a lista
        return objeto;
    }
    
    public List<Estudante> findALL() throws SQLException{
        // Lista para manter os valores do resultset
        List<Estudante> list = new ArrayList<>();
        Estudante objeto;
        String sql = "SELECT * FROM ESTUDANTE";
        PreparedStatement p = connection.prepareStatement(sql);
        ResultSet rs = p.executeQuery();
        
        while (rs.next()) {
            //instancia a classe e informa valores do banco de dados
            objeto = new Estudante();
            objeto.setEstudante_id(rs.getInt("ESTUDANTE_ID"));
            objeto.setNome(rs.getString("NOME"));
            objeto.setCurso(rs.getString("CURSO"));
            objeto.setData_matricula(rs.getDate("DATA_MATRICULA"));
            objeto.setStatus(rs.getString("STATUS").charAt(0));
            list.add(objeto);
        }
        rs.close();
        p.close();
        
        return list;
    }
}
