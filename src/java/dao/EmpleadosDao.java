package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.EmpleadosBean;

/**
 * @author Franklin Alexis
 * @version
 * @param
 * @comentarios<
 * 1. el sp 'sp_actualizarEmpleado' por el hecho de implicar mas de 1 tabla, requiere modificar
 *  configuracion de seguridad de mysql(Edit - preferences - SQL_Editor - safe updates)
 * >
 */
public class EmpleadosDao {
    Conexion conn = new Conexion();
    public EmpleadosDao(Conexion conn){
        this.conn = conn;
    }
    
    public List<EmpleadosBean> mostrar(){
        String sql = "select e.codEmpleado as Id, p.nombres as Nombres, p.apellidos as Apellidos, p.genero as Genero, p.telefono as Telefono, e.nit as NIT, e.dui as DUI, r.rol as Rol from personas p inner join empleados e on p.idPersona = e.idPersona inner join roles r on e.idRol = r.idRol where e.estadoEmpleado = 1 and p.tipo=1";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            EmpleadosBean empb;
            List<EmpleadosBean> listar = new ArrayList<>();
            while (rs.next()) {                
                empb = new EmpleadosBean(rs.getInt("Id"));
                empb.setNombres(rs.getString("Nombres"));
                empb.setApellidos(rs.getString("Apellidos"));
                empb.setGenero(rs.getString("Genero"));
                empb.setTelefono(rs.getString("Telefono"));
                empb.setNit(rs.getString("NIT"));
                empb.setDui(rs.getString("DUI"));
                empb.setRol(rs.getString("Rol"));
                listar.add(empb);
            }
            return listar;
        } catch (SQLException e) {
            return null;
        }
        
    }
    
    public boolean insertar(EmpleadosBean empb){
        String sql = "CALL sp_agregarEmpleado(?,?,?,?,?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, empb.getIdPersona());
            ps.setString(2, empb.getNombres());
            ps.setString(3, empb.getApellidos());
            ps.setString(4, empb.getTelefono());
            ps.setString(5, empb.getGenero());
            ps.setInt(6, empb.getEstadoPersona());
            ps.setInt(7, empb.getCodEmpleado());
            ps.setInt(8, empb.getIdRol());
            ps.setString(9, empb.getNit());
            ps.setString(10, empb.getDui());
            ps.setInt(11, empb.getEstadoEmpleado());
            ps.setInt(12, empb.getTipo());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public List<EmpleadosBean> buscarId(int id){
        String sql = "select e.codEmpleado as Id, p.nombres as Nombres, p.apellidos as Apellidos, p.genero as Genero, "
                + "p.telefono as Telefono, e.nit as NIT, e.dui as DUI, e.idRol as Rol from personas p inner join empleados e\n" 
                + " on p.idPersona = e.idPersona inner join roles r on e.idRol = r.idRol\n" 
                + " where e.codEmpleado = ?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            EmpleadosBean empb;
            List<EmpleadosBean> listar = new ArrayList<>();
            while (rs.next()) {                
                empb = new EmpleadosBean(rs.getInt("Id"));
                empb.setNombres(rs.getString("Nombres"));
                empb.setApellidos(rs.getString("Apellidos"));
                empb.setGenero(rs.getString("Genero"));
                empb.setTelefono(rs.getString("Telefono"));
                empb.setNit(rs.getString("NIT"));
                empb.setDui(rs.getString("DUI"));
                empb.setIdRol(rs.getInt("Rol"));
                listar.add(empb);
            }
            return listar;
        } catch (Exception e) {
            return null;
        }
        
    }
    
     public boolean actualizar(EmpleadosBean empb){
        String sql = "CALL sp_actualizarEmpleado(?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, empb.getNombres());
            ps.setString(2, empb.getApellidos());
            ps.setString(3, empb.getTelefono());
            ps.setString(4, empb.getGenero());
            ps.setInt(5, empb.getCodEmpleado());
            ps.setInt(6, empb.getIdRol());
            ps.setString(7, empb.getNit());
            ps.setString(8, empb.getDui());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
