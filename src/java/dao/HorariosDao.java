package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.HorariosBean;

/**
 * @author Franklin Alexis
 * @version
 * @param
 * @comentarios
 */
public class HorariosDao {
    Conexion conn;
    
    public HorariosDao(Conexion con){
        this.conn = con;
    }
    
    public List<HorariosBean> mostrar(){
        String sql = "select h.idHorario as Id, h.horaInicio as Hora_Inicio, h.horaFin as Hora_Fin, s.catTratamiento as Tratamiento from servicios s inner join horarios h on s.idCatTratamiento=h.idCatTratamiento;";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            HorariosBean hbean;
            List<HorariosBean> listar = new ArrayList<>();
            while (rs.next()) {                
                hbean = new HorariosBean(rs.getInt("Id"));
                hbean.setHoraInicio(rs.getString("Hora_Inicio"));
                hbean.setHoraFin(rs.getString("Hora_Fin"));
                hbean.setCatTratamiento(rs.getString("Tratamiento"));
                listar.add(hbean);
            }
            return listar;
        } catch (SQLException e) {
            return null;
        }
        
    }
    
    public boolean insertar(HorariosBean hbean){
        String sql = " INSERT INTO horarios VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, hbean.getIdHorario());
            ps.setString(2, hbean.getHoraInicio());
            ps.setString(3, hbean.getHoraFin());
            ps.setInt(4, hbean.getIdCatTratamiento());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public List<HorariosBean> buscarId(int id){
        String sql = "SELECT idHorario, horaInicio, horaFin, idCatTratamiento FROM horarios WHERE idHorario=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            HorariosBean hbean;
            List<HorariosBean> listar = new ArrayList<>();
            while (rs.next()) {                
                hbean = new HorariosBean(rs.getInt("idHorario"));
                hbean.setHoraInicio(rs.getString("horaInicio"));
                hbean.setHoraFin(rs.getString("horaFin"));
                hbean.setIdCatTratamiento(rs.getInt("idCatTratamiento"));
                listar.add(hbean);
            }
            return listar;
        } catch (SQLException e) {
            return null;
        }
        
    }
    
     public boolean actualizar(HorariosBean hbean){
        String sql = "UPDATE horarios SET horaInicio=?, horaFin=?, idCatTratamiento=? where idHorario=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);            
            ps.setString(1, hbean.getHoraInicio());
            ps.setString(2, hbean.getHoraFin());
            ps.setInt(3, hbean.getIdCatTratamiento());
            ps.setInt(4, hbean.getIdHorario());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    
}
