package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ServiciosBean;

public class ServiciosDao {

    Conexion conn;

    public ServiciosDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insertar(ServiciosBean sbean) {
        String sql = "insert into servicios values (?,?,?,?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, sbean.getIdCatTratamiento());
            ps.setString(2, sbean.getCatTratamiento());
            ps.setString(3, sbean.getDescripcion());
            ps.setInt(4, sbean.getEstadoServicios());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<ServiciosBean> mostrar(String estado) {
        String sql;
        if (estado.equals("habilitado")) {
            sql = "select * from servicios where estadoServicios=1";
            try {
                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                List<ServiciosBean> registros = new ArrayList<>();
                ServiciosBean sbean;
                while (rs.next()) {
                    sbean = new ServiciosBean(rs.getInt("idCatTratamiento"));
                    sbean.setCatTratamiento(rs.getString("catTratamiento"));
                    sbean.setDescripcion(rs.getString("descripcion"));
                    registros.add(sbean);
                }
                return registros;
            } catch (Exception e) {
                return null;
            }
        } else {
            sql = "select * from servicios where estadoServicios=0";
            try {
                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                List<ServiciosBean> registros = new ArrayList<>();
                ServiciosBean sbean;
                while (rs.next()) {
                    sbean = new ServiciosBean(rs.getInt("idCatTratamiento"));
                    sbean.setCatTratamiento(rs.getString("catTratamiento"));
                    sbean.setDescripcion(rs.getString("descripcion"));
                    registros.add(sbean);
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
            sql = "update servicios set estadoServicios=1 where idCatTratamiento=?";
            try {
                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            sql = "update servicios set estadoServicios=0 where idCatTratamiento=?";
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

    public List<ServiciosBean> buscarId(int id) {
        String sql = "select * from servicios where idCatTratamiento=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<ServiciosBean> registros = new ArrayList<>();
            ServiciosBean sbean;
            while (rs.next()) {
                sbean = new ServiciosBean(rs.getInt("idCatTratamiento"));
                sbean.setCatTratamiento(rs.getString("catTratamiento"));
                sbean.setDescripcion(rs.getString("descripcion"));
                sbean.setEstadoServicios(rs.getInt("estadoServicios"));
                registros.add(sbean);
            }
            return registros;
        } catch (Exception e) {
            return null;
        }

    }

    public boolean actualizar(ServiciosBean sbean) {
        String sql = "update servicios set catTratamiento=?, descripcion=? where idCatTratamiento=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, sbean.getCatTratamiento());
            ps.setString(2, sbean.getDescripcion());
            ps.setInt(3, sbean.getIdCatTratamiento());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
