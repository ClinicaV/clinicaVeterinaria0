package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.UnidadesBean;

public class UnidadesDao {

    Conexion conn;

    public UnidadesDao(Conexion conn) {

        this.conn = conn;
    }

    public boolean insertar(UnidadesBean ubean) {

        String sql = "insert into unidadesMedicion values (?,?,?)";
        try {

            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, ubean.getIdUnidadMedicion());
            ps.setString(2, ubean.getUnidadMedicion());
            ps.setInt(3, ubean.getEstadoUnidad());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {

            return false;
        }

    }

    public List<UnidadesBean> mostrar(String estado) {
        String sql;
        if (estado.equals("habilitado")) {
            sql = "select idUnidadMedicion, unidadMedicion from unidadesMedicion where estadoUnidad = 1";
            try {
                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                List<UnidadesBean> registros = new ArrayList<>();
                UnidadesBean ubean;
                while (rs.next()) {
                    ubean = new UnidadesBean(rs.getInt("idUnidadMedicion"));
                    ubean.setUnidadMedicion(rs.getString("unidadMedicion"));
                    registros.add(ubean);

                }
                return registros;
            } catch (Exception e) {
                return null;
            }

        } else {
            sql = "select idUnidadMedicion, unidadMedicion from unidadesMedicion where estadoUnidad = 0";
            try {
                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                List<UnidadesBean> registros = new ArrayList<>();
                UnidadesBean ubean;
                while (rs.next()) {
                    ubean = new UnidadesBean(rs.getInt("idUnidadMedicion"));
                    ubean.setUnidadMedicion(rs.getString("unidadMedicion"));
                    registros.add(ubean);

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
            sql = "update unidadesMedicion set estadoUnidad=1 where idUnidadMedicion=?";
            try {

                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            sql = "update unidadesMedicion set estadoUnidad=0 where idUnidadMedicion=?";
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

    public List<UnidadesBean> buscarId(int id) {
        String sql = "select idUnidadMedicion, unidadMedicion, estadoUnidad from unidadesMedicion where idUnidadMedicion =? ";

        try {

            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<UnidadesBean> registros = new ArrayList<>();
            UnidadesBean ubean;
            while (rs.next()) {
                ubean = new UnidadesBean(rs.getInt("idUnidadMedicion"));
                ubean.setUnidadMedicion(rs.getString("unidadMedicion"));
                ubean.setEstadoUnidad(rs.getInt("estadoUnidad"));
                registros.add(ubean);
            }
            return registros;
        } catch (Exception e) {
            return null;
        }

    }

    public boolean actualizar(UnidadesBean ubean) {

        String sql = "update unidadesMedicion set unidadMedicion =? where idUnidadMedicion =?";
        try {

            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, ubean.getUnidadMedicion());
            ps.setInt(2, ubean.getIdUnidadMedicion());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
