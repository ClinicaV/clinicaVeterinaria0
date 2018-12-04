package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.CatProductosBean;

public class CatProductosDao {

    Conexion conn;

    public CatProductosDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insertar(CatProductosBean cbean) {
        String sql = "insert into categoriasProductos values (?,?,?,?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, cbean.getIdCatProducto());
            ps.setString(2, cbean.getCategoriaProducto());
            ps.setString(3, cbean.getDescripcion());
            ps.setInt(4, cbean.getEstadoCatProducto());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<CatProductosBean> mostrar(String estado) {
        String sql;
        if (estado.equals("habilitado")) {
            sql = "select * from categoriasProductos where estadoCatProducto=1";
            try {
                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                List<CatProductosBean> registros = new ArrayList<>();
                CatProductosBean cbean;
                while (rs.next()) {
                    cbean = new CatProductosBean(rs.getInt("idCatProducto"));
                    cbean.setCategoriaProducto(rs.getString("categoriaProducto"));
                    cbean.setDescripcion(rs.getString("descripcion"));
                    registros.add(cbean);
                }
                return registros;
            } catch (Exception e) {
                return null;
            }
        } else {
            sql = "select * from categoriasProductos where estadoCatProducto=0";
            try {
                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                List<CatProductosBean> registros = new ArrayList<>();
                CatProductosBean cbean;
                while (rs.next()) {
                    cbean = new CatProductosBean(rs.getInt("idCatProducto"));
                    cbean.setCategoriaProducto(rs.getString("categoriaProducto"));
                    cbean.setDescripcion(rs.getString("descripcion"));
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
            sql = "update categoriasProductos set estadoCatProducto=1 where idCatProducto=?";
            try {
                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            sql = "update categoriasProductos set estadoCatProducto=0 where idCatProducto=?";
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

    public List<CatProductosBean> buscarId(int id) {
        String sql = "select * from categoriasProductos where idCatProducto=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<CatProductosBean> registros = new ArrayList<>();
            CatProductosBean cbean;
            while (rs.next()) {
                cbean = new CatProductosBean(rs.getInt("idCatProducto"));
                cbean.setCategoriaProducto(rs.getString("categoriaProducto"));
                cbean.setDescripcion(rs.getString("descripcion"));
                cbean.setEstadoCatProducto(rs.getInt("estadoCatProducto"));
                registros.add(cbean);
            }
            return registros;
        } catch (Exception e) {
            return null;
        }

    }

    public boolean actualizar(CatProductosBean cbean) {
        String sql = "update categoriasProductos set categoriaProducto=?, descripcion=? where idCatProducto=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, cbean.getCategoriaProducto());
            ps.setString(2, cbean.getDescripcion());
            ps.setInt(3, cbean.getIdCatProducto());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
