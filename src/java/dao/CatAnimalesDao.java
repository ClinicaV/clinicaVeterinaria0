package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.CatAnimalesBean;

public class CatAnimalesDao {

    Conexion conn;

    public CatAnimalesDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insertar(CatAnimalesBean cbean) {
        String sql = "insert into categoriasAnimales values (?,?,?,?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, cbean.getIdCatAnimal());
            ps.setString(2, cbean.getCatAnimal());
            ps.setString(3, cbean.getDescripcion());
            ps.setInt(4, cbean.getEstadoCatAnimal());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<CatAnimalesBean> mostrar(String estado) {
        String sql;
        if (estado.equals("habilitado")) {
            sql = "select * from categoriasAnimales where estadoCatAnimal=1";
            try {
                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                List<CatAnimalesBean> registros = new ArrayList<>();
                CatAnimalesBean cbean;
                while (rs.next()) {
                    cbean = new CatAnimalesBean(rs.getInt("idCatAnimal"));
                    cbean.setCatAnimal(rs.getString("catAnimal"));
                    cbean.setDescripcion(rs.getString("descripcion"));
                    registros.add(cbean);
                }
                return registros;
            } catch (Exception e) {
                return null;
            }
        } else {
            sql = "select * from categoriasAnimales where estadoCatAnimal=0";
            try {
                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                List<CatAnimalesBean> registros = new ArrayList<>();
                CatAnimalesBean cbean;
                while (rs.next()) {
                    cbean = new CatAnimalesBean(rs.getInt("idCatAnimal"));
                    cbean.setCatAnimal(rs.getString("catAnimal"));
                    cbean.setDescripcion(rs.getString("descripcion"));
                    registros.add(cbean);
                }
                return registros;
            } catch (Exception e) {
                return null;
            }
        }
    }
    
    public List<CatAnimalesBean> listar() { 
        String sql = "select * from categoriasAnimales where estadoCatAnimal=1";
            try {
                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                List<CatAnimalesBean> registros = new ArrayList<>();
                CatAnimalesBean cbean;
                while (rs.next()) {
                    cbean = new CatAnimalesBean(rs.getInt("idCatAnimal"));
                    cbean.setCatAnimal(rs.getString("catAnimal"));
                    cbean.setDescripcion(rs.getString("descripcion"));
                    registros.add(cbean);
                }
                return registros;
            } catch (Exception e) {
                return null;
            }
    }

    public boolean deshabilitar(int id, String estado) {
        String sql;
        if (estado.equals("habilitar")) {
            sql = "update categoriasAnimales set estadoCatAnimal=1 where idCatAnimal=?";
            try {
                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            sql = "update categoriasAnimales set estadoCatAnimal=0 where idCatAnimal=?";
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

    public List<CatAnimalesBean> buscarId(int id) {
        String sql = "select * from categoriasAnimales where idCatAnimal=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<CatAnimalesBean> registros = new ArrayList<>();
            CatAnimalesBean cbean;
            while (rs.next()) {
                cbean = new CatAnimalesBean(rs.getInt("idCatAnimal"));
                cbean.setCatAnimal(rs.getString("catAnimal"));
                cbean.setDescripcion(rs.getString("descripcion"));
                cbean.setEstadoCatAnimal(rs.getInt("estadoCatAnimal"));
                registros.add(cbean);
            }
            return registros;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean actualizar(CatAnimalesBean cbean) {
        String sql = "update categoriasAnimales set catAnimal=?, descripcion=? where idCatAnimal=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, cbean.getCatAnimal());
            ps.setString(2, cbean.getDescripcion());
            ps.setInt(3, cbean.getIdCatAnimal());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
