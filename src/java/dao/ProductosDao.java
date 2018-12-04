package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.CatProductosBean;
import model.UnidadesBean;
import model.ProductosBean;

/**
 * @author Franklin Alexis
 * @version
 * @param
 * @comentarios
 */
public class ProductosDao {
    Conexion conn;
    public ProductosDao(Conexion con){
        conn = con;
    }
    
    public boolean insertar(ProductosBean pbean) {
        String sql = "insert into productos values (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, pbean.getIdProducto());
            ps.setString(2, pbean.getProducto());
            ps.setInt(3, pbean.getIdCategoria());
            ps.setInt(4, pbean.getIdUnidad());
            ps.setDouble(5, pbean.getStock());
            ps.setInt(6, pbean.getEstadoProducto());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<ProductosBean> mostrar(String estado) {
        String sql;
        if (estado.equals("habilitado")) {
            sql = "select p.idProducto as Id, p.producto as Producto, cp.categoriaProducto as Categoria_Producto, um.unidadMedicion as Unidad_Medicion, p.stock as Stock from unidadesMedicion um  inner join productos p on um.idUnidadMedicion=p.idUnidad inner join categoriasproductos cp on cp.idCatProducto=p.idCategoria where estadoProducto=1;";
            try {
                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                List<ProductosBean> registros = new ArrayList<>();
                ProductosBean pbean;
                while (rs.next()) {
                    pbean = new ProductosBean(rs.getInt("Id"));
                    pbean.setProducto(rs.getString("Producto"));
                    pbean.setCategoriaProducto(rs.getString("Categoria_Producto"));
                    pbean.setUnidadMedicion(rs.getString("Unidad_Medicion"));
                    pbean.setStock(rs.getDouble("Stock"));
                    registros.add(pbean);
                }
                return registros;
            } catch (Exception e) {
                return null;
            }

        } else {
            sql = "select p.idProducto as Id, p.producto as Producto, cp.categoriaProducto as Categoria_Producto, um.unidadMedicion as Unidad_Medicion, p.stock as Stock from unidadesMedicion um  inner join productos p on um.idUnidadMedicion=p.idUnidad inner join categoriasproductos cp on cp.idCatProducto=p.idCategoria where estadoProducto=0;";
            try {
                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                List<ProductosBean> registros = new ArrayList<>();
                ProductosBean pbean;
                while (rs.next()) {
                    pbean = new ProductosBean(rs.getInt("Id"));
                    pbean.setProducto(rs.getString("Producto"));
                    pbean.setCategoriaProducto(rs.getString("Categoria_Producto"));
                    pbean.setUnidadMedicion(rs.getString("Unidad_Medicion"));
                    pbean.setStock(rs.getDouble("Stock"));
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
            sql = "update productos set estadoProducto=1 where idProducto=?";
            try {

                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            sql = "update productos set estadoProducto=0 where idProducto=?";
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

    public List<ProductosBean> buscarId(int id) {
        String sql = "select idProducto,producto, idCategoria, idUnidad, stock from productos where idProducto=?";

        try {

            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<ProductosBean> registros = new ArrayList<>();
            ProductosBean pbean;
            while (rs.next()) {
                pbean = new ProductosBean(rs.getInt("idProducto"));
                pbean.setProducto(rs.getString("producto"));
                pbean.setIdCategoria(rs.getInt("idCategoria"));
                pbean.setIdUnidad(rs.getInt("idUnidad"));
                pbean.setStock(rs.getDouble("stock"));
                registros.add(pbean);
            }
            return registros;
        } catch (Exception e) {
            return null;
        }

    }

    public boolean actualizar(ProductosBean pbean) {

        String sql = "update productos set producto=?, idCategoria=?, idUnidad=?, stock=? where idProducto=?";
        try {

            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, pbean.getProducto());
            ps.setInt(2, pbean.getIdCategoria());
            ps.setInt(3, pbean.getIdUnidad());
            ps.setDouble(4, pbean.getStock());
            ps.setInt(5, pbean.getIdProducto());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    
}
