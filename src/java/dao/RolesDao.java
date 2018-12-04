package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.RolesBean;

public class RolesDao {

    Conexion conn;

    public RolesDao(Conexion conn) {
        this.conn = conn;
    }
    
     public boolean insertar(RolesBean rbean) {

        String sql = "insert into roles values (?,?,?)";
        try {

            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, rbean.getIdRol());
            ps.setString(2, rbean.getRol());
            ps.setInt(3, rbean.getEstadoRol());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {

            return false;
        }

    }

    public List<RolesBean> mostrar(String estado) {
        String sql;
        if (estado.equals("habilitado")) {
            sql = "select * from roles where estadoRol = 1";
            try {
                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                List<RolesBean> registros = new ArrayList<>();
                RolesBean rbean;
                while (rs.next()) {
                    rbean = new RolesBean(rs.getInt("idRol"));
                    rbean.setRol(rs.getString("rol"));
                    registros.add(rbean);

                }
                return registros;
            } catch (Exception e) {
                return null;
            }

        } else {
            sql = "select * from roles where estadoRol = 0";
            try {
                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                List<RolesBean> registros = new ArrayList<>();
                RolesBean rbean;
                while (rs.next()) {
                    rbean = new RolesBean(rs.getInt("idRol"));
                    rbean.setRol(rs.getString("rol"));
                    registros.add(rbean);

                }
                return registros;
            } catch (Exception e) {
                return null;
            }
        }
    }

    public boolean deshabilitar(int id, String estado) {
        String sql;
        if (estado.equals("habilitar")) {
            sql = "update roles set estadoRol=1 where idRol=?";
            try {

                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            sql = "update roles set estadoRol=0 where idRol=?";
            try {

                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }

    public List<RolesBean> buscarId(int id) {
        String sql = "select * from roles where idRol =? ";

        try {

            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<RolesBean> registros = new ArrayList<>();
            RolesBean rbean;
            while (rs.next()) {
                rbean = new RolesBean(rs.getInt("idRol"));
                rbean.setRol(rs.getString("rol"));
                rbean.setEstadoRol(rs.getInt("estadoRol"));
                registros.add(rbean);
            }
            return registros;
        } catch (Exception e) {
            return null;
        }

    }

    public boolean actualizar(RolesBean rbean) {

        String sql = "update roles set rol =? where idRol =?";
        try {

            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, rbean.getRol());
            ps.setInt(2, rbean.getIdRol());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }

    }
    
}
