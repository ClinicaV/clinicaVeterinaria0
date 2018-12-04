package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ProveedoresBean;

public class ProveedoresDao {

    Conexion conn;

    public ProveedoresDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insetar(ProveedoresBean pbean) {
        String sql = "insert into proveedores values(?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, pbean.getIdProveedor());
            ps.setString(2, pbean.getProveedor());
            ps.setString(3, pbean.getTelefono());
            ps.setString(4, pbean.getEmail());
            ps.setString(5, pbean.getDireccion());
            ps.setString(6, pbean.getPersonaContacto());
            ps.setInt(7, pbean.getEstadoProveedor());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public List<ProveedoresBean> mostrar(String estado) {
        String sql;
        if (estado.equals("habilitado")) {
            sql = "select * from proveedores where estadoProveedor=1 ";
            try {
                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                List<ProveedoresBean> registros = new ArrayList<>();
                ProveedoresBean pbean;
                while (rs.next()) {
                    pbean = new ProveedoresBean(rs.getInt("idProveedor"));
                    pbean.setProveedor(rs.getString("proveedor"));
                    pbean.setTelefono(rs.getString("telefono"));
                    pbean.setEmail(rs.getString("email"));
                    pbean.setDireccion(rs.getString("direccion"));
                    pbean.setPersonaContacto(rs.getString("personaContacto"));

                    registros.add(pbean);
                }
                return registros;
            } catch (Exception e) {
                return null;
            }
        } else {
            sql = "select * from proveedores where estadoProveedor=0 ";
            try {
                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                List<ProveedoresBean> registros = new ArrayList<>();
                ProveedoresBean pbean;
                while (rs.next()) {
                    pbean = new ProveedoresBean(rs.getInt("idProveedor"));
                    pbean.setProveedor(rs.getString("proveedor"));
                    pbean.setTelefono(rs.getString("telefono"));
                    pbean.setEmail(rs.getString("email"));
                    pbean.setDireccion(rs.getString("direccion"));
                    pbean.setPersonaContacto(rs.getString("personaContacto"));

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
            sql = "update proveedores set estadoProveedor=1 where idProveedor=?";
            try {
                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            sql = "update proveedores set estadoProveedor=0 where idProveedor=?";
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

    public List<ProveedoresBean> buscarId(int id) {
        String sql = "select idProveedor, proveedor, telefono, email, direccion, personaContacto, estadoProveedor from proveedores where idProveedor = ?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<ProveedoresBean> registros = new ArrayList<>();
            ProveedoresBean pbean;
            while (rs.next()) {

                pbean = new ProveedoresBean(rs.getInt("idProveedor"));
                pbean.setProveedor(rs.getString("proveedor"));
                pbean.setTelefono(rs.getString("telefono"));
                pbean.setEmail(rs.getString("email"));
                pbean.setDireccion(rs.getString("direccion"));
                pbean.setPersonaContacto(rs.getString("personaContacto"));
                pbean.setEstadoProveedor(rs.getInt("estadoProveedor"));
                registros.add(pbean);

            }
            return registros;

        } catch (Exception e) {
            return null;
        }
    }

    public boolean actualizar(ProveedoresBean pbean) {
        String sql = "update proveedores set proveedor=?, telefono=?, email=?, direccion=?, personaContacto=? where idProveedor=?";
        try {

            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, pbean.getProveedor());
            ps.setString(2, pbean.getTelefono());
            ps.setString(3, pbean.getEmail());
            ps.setString(4, pbean.getDireccion());
            ps.setString(5, pbean.getPersonaContacto());
            ps.setInt(6, pbean.getIdProveedor());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
