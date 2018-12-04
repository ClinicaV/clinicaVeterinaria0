package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ConsultoriosBean;

public class ConsultoriosDao {

    Conexion conn;

    public ConsultoriosDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insertar(ConsultoriosBean cbean) {

        String sql = "insert into consultorios values (?,?,?)";
        try {

            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, cbean.getIdConsultorio());
            ps.setString(2, cbean.getConsultorio());
            ps.setInt(3, cbean.getEstadoConsultorio());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<ConsultoriosBean> mostrar(String estado) {
        String sql;
        if (estado.equals("habilitado")) {
            sql = "select * from consultorios where estadoConsultorio = 1";
            try {
                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                List<ConsultoriosBean> registros = new ArrayList<>();
                ConsultoriosBean cbean;
                while (rs.next()) {
                    cbean = new ConsultoriosBean(rs.getInt("idConsultorio"));
                    cbean.setConsultorio(rs.getString("consultorio"));
                    registros.add(cbean);
                }
                return registros;
            } catch (Exception e) {
                return null;
            }

        } else {
            sql = "select * from consultorios where estadoConsultorio = 0";
            try {
                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                List<ConsultoriosBean> registros = new ArrayList<>();
                ConsultoriosBean cbean;
                while (rs.next()) {
                    cbean = new ConsultoriosBean(rs.getInt("idConsultorio"));
                    cbean.setConsultorio(rs.getString("consultorio"));
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
            sql = "update consultorios set estadoConsultorio=1 where idConsultorio=?";
            try {

                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            sql = "update consultorios set estadoConsultorio=0 where idConsultorio=?";
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

    public List<ConsultoriosBean> buscarId(int id) {
        String sql = "select * from consultorios where idConsultorio =? ";

        try {

            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<ConsultoriosBean> registros = new ArrayList<>();
            ConsultoriosBean cbean;
            while (rs.next()) {
                cbean = new ConsultoriosBean(rs.getInt("idConsultorio"));
                cbean.setConsultorio(rs.getString("consultorio"));
                cbean.setEstadoConsultorio(rs.getInt("estadoConsultorio"));
                registros.add(cbean);
            }
            return registros;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean actualizar(ConsultoriosBean cbean) {

        String sql = "update consultorios set consultorio =? where idConsultorio =?";
        try {

            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, cbean.getConsultorio());
            ps.setInt(2, cbean.getIdConsultorio());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
