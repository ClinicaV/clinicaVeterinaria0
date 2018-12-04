package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.InventarioBean;

/**
 * @author Franklin Alexis
 * @version
 * @param
 * @comentarios
 */
public class InventarioDao {

    Conexion conn;
    public InventarioDao(Conexion con){
        conn = con;
    }
    
    public List<InventarioBean> mostrar(){
        String sql = "select i.idProducto as Id, p.producto as Producto, i.cantidad as Cantidad, i.costoUnitario as Costo_Unitario, i.costoTotal as Costo_Total from productos p inner join inventario i on p.idProducto=i.idProducto";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            InventarioBean ibean;
            List<InventarioBean> listar = new ArrayList<>();
            while (rs.next()) {                
                ibean = new InventarioBean(rs.getInt("Id"));
                ibean.setProducto(rs.getString("Producto"));
                ibean.setCantidad(rs.getDouble("Cantidad"));
                ibean.setCostoUnitario(rs.getDouble("Costo_Unitario"));
                ibean.setCostoTotal(rs.getDouble("Costo_Total"));
                listar.add(ibean);
            }
            return listar;
        } catch (SQLException e) {
            return null;
        }
        
    }
    
    public boolean insertar(InventarioBean ibean){
        String sql = " INSERT INTO inventario VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, ibean.getIdProducto());
            ps.setDouble(2, ibean.getCantidad());
            ps.setDouble(3, ibean.getCostoUnitario());
            ps.setDouble(4, ibean.getCostoTotal());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public List<InventarioBean> buscarId(int id){
        String sql = "SELECT i.idProducto, p.producto, i.cantidad, i.costoUnitario, i.costoTotal FROM inventario i inner join productos p on i.idProducto=p.idProducto WHERE i.idProducto=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            InventarioBean ibean;
            List<InventarioBean> listar = new ArrayList<>();
            while (rs.next()) {                
                ibean = new InventarioBean(rs.getInt("idProducto"));
                ibean.setProducto(rs.getString("producto"));
                ibean.setCantidad(rs.getDouble("cantidad"));
                ibean.setCostoUnitario(rs.getDouble("costoUnitario"));
                ibean.setCostoTotal(rs.getDouble("costoTotal"));
                listar.add(ibean);
            }
            return listar;
        } catch (SQLException e) {
            return null;
        }
        
    }
    
     public boolean actualizar(InventarioBean ibean){
        String sql = "UPDATE inventario SET cantidad=?, costoUnitario=?, costoTotal=? where idProducto=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);            
            ps.setDouble(1, ibean.getCantidad());
            ps.setDouble(2, ibean.getCostoUnitario());
            ps.setDouble(3, ibean.getCostoTotal());
            ps.setInt(4, ibean.getIdProducto());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    
}
