package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.PersonasBean;

public class PersonasDao {

    Conexion conn;

    public PersonasDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insertar(PersonasBean pbean) {

        String sql = "insert into personas values (?,?,?,?,?,?,?)";
        try {

            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, pbean.getIdPersona());
            ps.setString(2, pbean.getNombres());
            ps.setString(3, pbean.getApellidos());
            ps.setString(4, pbean.getTelefono());
            ps.setString(5, pbean.getGenero());
            ps.setInt(6, pbean.getEstadoPersona());
            ps.setInt(7, pbean.getTipo());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {

            return false;
        }

    }

    public List<PersonasBean> mostrar(String estado) {
        String sql;
        if (estado.equals("habilitado")) {
            sql = "select * from personas where estadoPersona = 1 and tipo = 0";
            try {
                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                List<PersonasBean> registros = new ArrayList<>();
                PersonasBean pbean;
                while (rs.next()) {
                    pbean = new PersonasBean(rs.getInt("idPersona"));
                    pbean.setNombres(rs.getString("nombres"));
                    pbean.setApellidos(rs.getString("apellidos"));
                    pbean.setTelefono(rs.getString("telefono"));
                    pbean.setGenero(rs.getString("genero"));
                    registros.add(pbean);

                }
                return registros;
            } catch (Exception e) {
                return null;
            }

        } else {
            sql = "select * from personas where estadoPersona = 0 and tipo = 0";
            try {
                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                List<PersonasBean> registros = new ArrayList<>();
                PersonasBean pbean;
                while (rs.next()) {
                    pbean = new PersonasBean(rs.getInt("idPersona"));
                    pbean.setNombres(rs.getString("nombres"));
                    pbean.setApellidos(rs.getString("apellidos"));
                    pbean.setTelefono(rs.getString("telefono"));
                    pbean.setGenero(rs.getString("genero"));
                    registros.add(pbean);
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
            sql = "update personas set estadoPersona=1 where idPersona=?";
            try {

                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            sql = "update personas set estadoPersona=0 where idPersona=?";
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

    public List<PersonasBean> buscarId(int id) {
        String sql = "select * from personas where idPersona =? ";

        try {

            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<PersonasBean> registros = new ArrayList<>();
            PersonasBean pbean;
            while (rs.next()) {
                pbean = new PersonasBean(rs.getInt("idPersona"));
                pbean.setNombres(rs.getString("nombres"));
                pbean.setApellidos(rs.getString("apellidos"));
                pbean.setTelefono(rs.getString("telefono"));
                pbean.setGenero(rs.getString("genero"));
                pbean.setEstadoPersona(rs.getInt("estadoPersona"));
                registros.add(pbean);
            }
            return registros;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean actualizar(PersonasBean pbean) {

        String sql = "update personas set nombres =?, apellidos=?, telefono=?, genero=? where idPersona =?";
        try {

            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, pbean.getNombres());
            ps.setString(2, pbean.getApellidos());
            ps.setString(3, pbean.getTelefono());
            ps.setString(4, pbean.getGenero());
            ps.setInt(5, pbean.getIdPersona());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
