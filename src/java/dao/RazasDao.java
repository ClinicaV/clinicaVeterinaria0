package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.CatAnimalesBean;
import model.RazasBean;

/**
 * @author Carlos Solis
 * @version 
 * @param 
 * @comentarios
 */
public class RazasDao {
    Conexion conn;

    public RazasDao(Conexion conn) {
        this.conn = conn;
    }
    
    public List<RazasBean> mostrar(){
        String sql = "SELECT r.idRaza as Id, r.raza as Raza, r.descripcion as Descripcion, ca.catAnimal as Categoria FROM razas r INNER JOIN categoriasanimales ca on ca.idCatAnimal = r.idCatAnimal";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            RazasBean razasb;
            List<RazasBean> listar = new ArrayList<>();
            while (rs.next()) {                
                razasb = new RazasBean(rs.getInt("Id"));
                razasb.setRaza(rs.getString("Raza"));
                razasb.setDescripcion(rs.getString("Descripcion"));
                razasb.setCategoria(rs.getString("Categoria"));
                listar.add(razasb);
            }
            return listar;
        } catch (Exception e) {
            return null;
        }
        
    }
    
    public boolean insertar(RazasBean razasb){
        String sql = " INSERT INTO razas VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, razasb.getIdRaza());
            ps.setString(2, razasb.getRaza());
            ps.setString(3, razasb.getDescripcion());
            ps.setInt(4, razasb.getIdCatAnimal());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public List<RazasBean> buscarId(int id){
        String sql = "SELECT idRaza, raza, descripcion, idCatAnimal FROM razas WHERE idRaza=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            RazasBean razasb;
            List<RazasBean> listar = new ArrayList<>();
            while (rs.next()) {                
                razasb = new RazasBean(rs.getInt("idRaza"));
                razasb.setRaza(rs.getString("raza"));
                razasb.setDescripcion(rs.getString("descripcion"));
                razasb.setIdCatAnimal(rs.getInt("idCatAnimal"));
                listar.add(razasb);
            }
            return listar;
        } catch (Exception e) {
            return null;
        }
        
    }
    
     public boolean actualizar(RazasBean razasb){
        String sql = "UPDATE razas SET raza=?, descripcion=?, idCatAnimal=? where idRaza=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);            
            ps.setString(1, razasb.getRaza());
            ps.setString(2, razasb.getDescripcion());
            ps.setInt(3, razasb.getIdCatAnimal());
            ps.setInt(4, razasb.getIdRaza());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
