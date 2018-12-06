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
 * @comentarios
 */
public class EmpleadosDao {
    Conexion conn = new Conexion();
    public EmpleadosDao(Conexion conn){
        this.conn = conn;
    }
    
    public List<EmpleadosBean> mostrar(){
        String sql = "select e.codEmpleado as Id, e.nombres as Nombres, e.apellidos as Apellidos, e.genero as Genero, e.telefono as Telefono, e.nit as NIT, e.dui as DUI, r.rol as Rol from empleados e inner join roles r on e.idRol = r.idRol where e.estadoEmpleado = 1";
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
        String sql = "insert into empleados values(?,?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, empb.getCodEmpleado());
            ps.setString(2, empb.getNombres());
            ps.setString(3, empb.getApellidos());
            ps.setString(4, empb.getDui());
            ps.setString(5, empb.getNit());
            ps.setString(6, empb.getGenero());
            ps.setString(7, empb.getTelefono());
            ps.setInt(8, empb.getIdRol());
            ps.setInt(9, empb.getEstadoEmpleado());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public List<EmpleadosBean> buscarId(int id){
        String sql = "select * from empleados where codEmpleado=?;";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            EmpleadosBean empb;
            List<EmpleadosBean> listar = new ArrayList<>();
            while (rs.next()) {                
                empb = new EmpleadosBean(rs.getInt("codEmpleado"));
                empb.setNombres(rs.getString("nombres"));
                empb.setApellidos(rs.getString("apellidos"));
                empb.setDui(rs.getString("dui"));
                empb.setNit(rs.getString("nit"));
                empb.setGenero(rs.getString("genero"));
                empb.setTelefono(rs.getString("telefono"));
                empb.setIdRol(rs.getInt("idRol"));
                listar.add(empb);
            }
            return listar;
        } catch (Exception e) {
            return null;
        }
        
    }
    
     public boolean actualizar(EmpleadosBean empb){
        String sql = "update empleados set nombres=?, apellidos=?, dui=?, nit=?, genero=?, telefono=?, idRol=? where codEmpleado=?;";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, empb.getNombres());
            ps.setString(2, empb.getApellidos());
            ps.setString(3, empb.getDui());
            ps.setString(4, empb.getNit());
            ps.setString(5, empb.getGenero());
            ps.setString(6, empb.getTelefono());
            ps.setInt(7, empb.getIdRol());
            ps.setInt(8, empb.getCodEmpleado());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
