package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.TratamientosBean;

/**
 * @author Franklin Alexis
 * @version
 * @param
 * @comentarios
 */
public class TratamientosDao {
    Conexion conn;
    public TratamientosDao(Conexion con){
        conn = con;
    }
    
    public List<TratamientosBean> mostrar(){
        String sql = "select t.idTratamiento as Id, t.tratamiento as Tratamiento, s.catTratamiento as Servicio, t.precio as Precio from servicios s inner join tratamientos t on s.idCatTratamiento=t.idCatTratamiento";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            TratamientosBean tbean;
            List<TratamientosBean> listar = new ArrayList<>();
            while (rs.next()) {                
                tbean = new TratamientosBean(rs.getInt("Id"));
                tbean.setTratamiento(rs.getString("Tratamiento"));
                tbean.setCatTratamiento(rs.getString("Servicio"));
                tbean.setPrecio(rs.getDouble("Precio"));
                listar.add(tbean);
            }
            return listar;
        } catch (SQLException e) {
            return null;
        }
        
    }
    
    public boolean insertar(TratamientosBean tbean){
        String sql = " INSERT INTO tratamientos VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, tbean.getIdTratamiento());
            ps.setString(2, tbean.getTratamiento());
            ps.setInt(3, tbean.getIdCatTratamiento());
            ps.setDouble(4, tbean.getPrecio());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public List<TratamientosBean> buscarId(int id){
        String sql = "SELECT idTratamiento, tratamiento, idCatTratamiento, precio FROM tratamientos WHERE idTratamiento=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            TratamientosBean tbean;
            List<TratamientosBean> listar = new ArrayList<>();
            while (rs.next()) {                
                tbean = new TratamientosBean(rs.getInt("idTratamiento"));
                tbean.setTratamiento(rs.getString("tratamiento"));
                tbean.setCatTratamiento(rs.getString("idCatTratamiento"));
                tbean.setPrecio(rs.getDouble("precio"));
                listar.add(tbean);
            }
            return listar;
        } catch (SQLException e) {
            return null;
        }
        
    }
    
     public boolean actualizar(TratamientosBean tbean){
        String sql = "UPDATE tratamientos SET tratamiento=?, idCatTratamiento=?, precio=? where idTratamiento=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);            
            ps.setString(1, tbean.getTratamiento());
            ps.setInt(2, tbean.getIdCatTratamiento());
            ps.setDouble(3, tbean.getPrecio());
            ps.setInt(4, tbean.getIdTratamiento());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    
}
