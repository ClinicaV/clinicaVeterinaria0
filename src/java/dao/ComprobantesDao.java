package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ComprobantesBean;

public class ComprobantesDao {

    Conexion conn;

    public ComprobantesDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insertar(ComprobantesBean cbean) {

        String sql = "insert into comprobantes values (?,?,?)";
        try {

            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, cbean.getIdComprobante());
            ps.setString(2, cbean.getComprobante());
            ps.setInt(3, cbean.getEstadoComprobante());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<ComprobantesBean> mostrar(String estado) {
        String sql;
        if (estado.equals("habilitado")) {
            sql = "select * from comprobantes where estadoComprobante = 1";
            try {
                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                List<ComprobantesBean> registros = new ArrayList<>();
                ComprobantesBean cbean;
                while (rs.next()) {
                    cbean = new ComprobantesBean(rs.getInt("idComprobante"));
                    cbean.setComprobante(rs.getString("comprobante"));
                    registros.add(cbean);
                }
                return registros;
            } catch (Exception e) {
                return null;
            }

        } else {
            sql = "select * from comprobantes where estadoComprobante = 0";
            try {
                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                List<ComprobantesBean> registros = new ArrayList<>();
                ComprobantesBean cbean;
                while (rs.next()) {
                    cbean = new ComprobantesBean(rs.getInt("idComprobante"));
                    cbean.setComprobante(rs.getString("comprobante"));
                    registros.add(cbean);
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
            sql = "update comprobantes set estadoComprobante=1 where idComprobante=?";
            try {

                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            sql = "update comprobantes set estadoComprobante=0 where idComprobante=?";
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

    public List<ComprobantesBean> buscarId(int id) {
        String sql = "select * from comprobantes where idComprobante =? ";

        try {

            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<ComprobantesBean> registros = new ArrayList<>();
            ComprobantesBean cbean;
            while (rs.next()) {
                cbean = new ComprobantesBean(rs.getInt("idComprobante"));
                cbean.setComprobante(rs.getString("comprobante"));
                cbean.setEstadoComprobante(rs.getInt("estadoComprobante"));
                registros.add(cbean);
            }
            return registros;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean actualizar(ComprobantesBean cbean) {

        String sql = "update comprobantes set comprobante =? where idComprobante =?";
        try {

            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, cbean.getComprobante());
            ps.setInt(2, cbean.getIdComprobante());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
