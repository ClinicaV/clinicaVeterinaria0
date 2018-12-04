package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.UsuariosBean;

/**
 * @author Franklin Alexis
 * @version
 * @param
 * @comentarios
 */
public class UsuariosDao {
    Conexion conn;
    public UsuariosDao(Conexion con){
        conn = con;
    }
    
public boolean insertar(UsuariosBean ubean) {
        String sql = "insert into usuarios values (?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, ubean.getUsuario());
            ps.setString(2, ubean.getPassword());
            ps.setInt(3, ubean.getCodEmpleado());
            ps.setInt(4, ubean.getIdNivel());
            ps.setInt(5, ubean.getEstadoUsuario());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

public List<UsuariosBean> mostrar(String estado) {
    String sql;
    if (estado.equals("habilitado")) {
        sql = "select u.codEmpleado as Id, p.nombres as Nombres, p.apellidos as Apellidos, u.usuario as Usuario, u.password as Clave_Acceso, n.nivel as Nivel from personas p  inner join usuarios u on p.idPersona=u.codEmpleado inner join niveles n on n.idNivel=u.idNivel where estadoUsuario=1;";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<UsuariosBean> registros = new ArrayList<>();
            UsuariosBean ubean;
            while (rs.next()) {
                ubean = new UsuariosBean(rs.getString("Usuario"));
                ubean.setCodEmpleado(rs.getInt("Id"));
                ubean.setNombres(rs.getString("Nombres"));
                ubean.setApellidos(rs.getString("Apellidos"));
                ubean.setPassword(rs.getString("Clave_Acceso"));
                ubean.setNivel(rs.getString("Nivel"));
                registros.add(ubean);
            }
            return registros;
        } catch (SQLException e) {
            return null;
        }

    } else {
        sql = "select u.codEmpleado as Id, p.nombres as Nombres, p.apellidos as Apellidos, u.usuario as Usuario, u.password as Clave_Acceso, n.nivel as Nivel from personas p  inner join usuarios u on p.idPersona=u.codEmpleado inner join niveles n on n.idNivel=u.idNivel where estadoUsuario=0;";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<UsuariosBean> registros = new ArrayList<>();
            UsuariosBean ubean;
            while (rs.next()) {
                ubean = new UsuariosBean(rs.getString("Usuario"));
                ubean.setCodEmpleado(rs.getInt("Id"));
                ubean.setNombres(rs.getString("Nombres"));
                ubean.setApellidos(rs.getString("Apellidos"));
                ubean.setPassword(rs.getString("Clave_Acceso"));
                ubean.setNivel(rs.getString("Nivel"));
                registros.add(ubean);
            }
            return registros;
        } catch (SQLException e) {
            return null;
        }
    }
}

public boolean deshabilitar(String usu, String estado) {
    String sql;
    if (estado.equals("habilitar")) {
        sql = "update usuarios set estadoUsuario=1 where usuario=?";
        try {

            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, usu);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    } else {
        sql = "update usuarios set estadoUsuario=0 where usuario=?";
        try {

            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, usu);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}

public List<UsuariosBean> buscarId(String usu) {
    String sql = "select u.codEmpleado, p.nombres, p.apellidos, u.usuario, u.password, u.idNivel from personas p  inner join usuarios u on p.idPersona=u.codEmpleado inner join niveles n on n.idNivel=u.idNivel where usuario=?;";
    try {
        PreparedStatement ps = conn.conectar().prepareStatement(sql);
        ps.setString(1, usu);
        ResultSet rs = ps.executeQuery();
        List<UsuariosBean> registros = new ArrayList<>();
            UsuariosBean ubean;
            while (rs.next()) {
                ubean = new UsuariosBean(rs.getString("usuario"));
                ubean.setCodEmpleado(rs.getInt("codEmpleado"));
                ubean.setNombres(rs.getString("nombres"));
                ubean.setApellidos(rs.getString("apellidos"));
                ubean.setPassword(rs.getString("password"));
                ubean.setIdNivel(rs.getInt("idNivel"));
                registros.add(ubean);
            }
            return registros;
        }
        catch (SQLException e) {
        return null;
    }
    } 

public boolean actualizar(UsuariosBean ubean){
        String sql = "update usuarios set usuario=?, password=?, idNivel=? where codEmpleado=?";
        try{
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, ubean.getUsuario());
            ps.setString(2, ubean.getPassword());
            ps.setInt(3, ubean.getIdNivel());
            ps.setInt(4, ubean.getCodEmpleado());
            ps.executeUpdate();
            return true;
        }catch(SQLException e){
            return false;
        }
    }
  

}
