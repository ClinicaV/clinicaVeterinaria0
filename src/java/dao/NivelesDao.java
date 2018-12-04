package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.NivelesBean;

public class NivelesDao {

    Conexion conn;

    public NivelesDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insertar(NivelesBean nbean) {

        String sql = "insert into niveles values (?,?,?)";
        try {

            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, nbean.getIdNivel());
            ps.setString(2, nbean.getNivel());
            ps.setInt(3, nbean.getEstadoNivel());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<NivelesBean> mostrar(String estado) {
        String sql;
        if (estado.equals("habilitado")) {
            sql = "select * from niveles where estadoNivel = 1";
            try {
                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                List<NivelesBean> registros = new ArrayList<>();
                NivelesBean nbean;
                while (rs.next()) {
                    nbean = new NivelesBean(rs.getInt("idNivel"));
                    nbean.setNivel(rs.getString("nivel"));
                    registros.add(nbean);
                }
                return registros;
            } catch (Exception e) {
                return null;
            }

        } else {
            sql = "select * from niveles where estadoNivel = 0";
            try {
                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                List<NivelesBean> registros = new ArrayList<>();
                NivelesBean nbean;
                while (rs.next()) {
                    nbean = new NivelesBean(rs.getInt("idNivel"));
                    nbean.setNivel(rs.getString("nivel"));
                    registros.add(nbean);
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
            sql = "update niveles set estadoNivel=1 where idNivel=?";
            try {

                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            sql = "update niveles set estadoNivel=0 where idNivel=?";
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

    public List<NivelesBean> buscarId(int id) {
        String sql = "select * from niveles where idNivel =? ";

        try {

            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<NivelesBean> registros = new ArrayList<>();
            NivelesBean nbean;
            while (rs.next()) {
                nbean = new NivelesBean(rs.getInt("idNivel"));
                nbean.setNivel(rs.getString("nivel"));
                nbean.setEstadoNivel(rs.getInt("estadoNivel"));
                registros.add(nbean);
            }
            return registros;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean actualizar(NivelesBean nbean) {

        String sql = "update niveles set nivel =? where idNivel =?";
        try {

            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, nbean.getNivel());
            ps.setInt(2, nbean.getIdNivel());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
