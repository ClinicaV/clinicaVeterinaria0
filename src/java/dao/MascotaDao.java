package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.MascotaBean;
import model.PersonasBean;

/**
 * @author Carlos Solis
 * @version
 * @param
 * @comentarios
 */
public class MascotaDao {

    Conexion conn;
    private String sql;

    public MascotaDao(Conexion conn) {
        this.conn = conn;
    }

    public List<MascotaBean> mostrar(String estado) {
        if (estado.equals("habilitado")) {
            sql = "SELECT m.idMascota as Id, r.raza as Raza, m.nombreMascota as Mascota, m.sexo as sexo, concat(p.nombres, ' ',p.apellidos) as Nombre, m.edad as Edad, m.identificacionTatoo as Tatoo, m.alergias as Alergia FROM mascotas m INNER JOIN razas r ON r.idRaza = m.idRaza INNER JOIN personas p ON p.idPersona = m.idPersona where m.estadoMascota = 1";
            try {
                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                List<MascotaBean> registros = new ArrayList<>();
                MascotaBean mascotab;
                while (rs.next()) {
                    mascotab = new MascotaBean(rs.getInt("Id"));
                    mascotab.setRaza(rs.getString("Raza"));
                    mascotab.setNombreMascota(rs.getString("Mascota"));
                    mascotab.setSexo(rs.getString("sexo"));
                    mascotab.setNombres(rs.getString("Nombre"));
                    mascotab.setEdad(rs.getInt("Edad"));
                    mascotab.setIdentificacionTatoo(rs.getString("Tatoo"));
                    mascotab.setAlergias(rs.getString("Alergia"));
                    registros.add(mascotab);
                }
                return registros;
            } catch (Exception e) {
                return null;
            }

        } else {
            sql = "SELECT m.idMascota as Id, r.raza as Raza, m.nombreMascota as Mascota, m.sexo as sexo, concat(p.nombres, ' ',p.apellidos) as Nombre, m.edad as Edad, m.identificacionTatoo as Tatoo, m.alergias as Alergia FROM mascotas m INNER JOIN razas r ON r.idRaza = m.idRaza INNER JOIN personas p ON p.idPersona = m.idPersona where m.estadoMascota = 1";
            try {
                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                List<MascotaBean> registros = new ArrayList<>();
                MascotaBean mascotab;
                while (rs.next()) {
                    mascotab = new MascotaBean(rs.getInt("Id"));
                    mascotab.setRaza(rs.getString("Raza"));
                    mascotab.setNombreMascota(rs.getString("Mascota"));
                    mascotab.setSexo(rs.getString("sexo"));
                    mascotab.setNombres(rs.getString("Nombre"));
                    mascotab.setEdad(rs.getInt("Edad"));
                    mascotab.setIdentificacionTatoo(rs.getString("Tatoo"));
                    mascotab.setAlergias(rs.getString("Alergia"));
                    registros.add(mascotab);
                }
                return registros;
            } catch (Exception e) {
                return null;
            }
        }
    }

    public boolean insertar(MascotaBean mascotab) {
        sql = "INSERT INTO mascotas VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, mascotab.getIdMascota());
            ps.setInt(2, mascotab.getIdRaza());
            ps.setString(3, mascotab.getNombreMascota());
            ps.setString(4, mascotab.getSexo());
            ps.setInt(5, mascotab.getIdPersona());
            ps.setInt(6, mascotab.getEdad());
            ps.setString(7, mascotab.getIdentificacionTatoo());
            ps.setString(8, mascotab.getAlergias());
            ps.setInt(9, mascotab.getEstadoMascota());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<MascotaBean> buscarId(int id) {

            sql = "SELECT m.idMascota as Id, r.idRaza, m.nombreMascota as Mascota, m.sexo as sexo, p.idPersona, m.edad as Edad, m.identificacionTatoo as Tatoo, m.alergias as Alergia FROM mascotas m INNER JOIN razas r ON r.idRaza = m.idRaza INNER JOIN personas p ON p.idPersona = m.idPersona where m.idMascota = ?";
            try {
                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                List<MascotaBean> registros = new ArrayList<>();
                MascotaBean mascotab;
                while (rs.next()) {
                    mascotab = new MascotaBean(rs.getInt("Id"));
                    mascotab.setIdRaza(rs.getInt("idRaza"));
                    mascotab.setNombreMascota(rs.getString("Mascota"));
                    mascotab.setSexo(rs.getString("sexo"));
                    mascotab.setIdPersona(rs.getInt("idPersona"));
                    mascotab.setEdad(rs.getInt("Edad"));
                    mascotab.setIdentificacionTatoo(rs.getString("Tatoo"));
                    mascotab.setAlergias(rs.getString("Alergia"));
                    registros.add(mascotab);
                }
                return registros;
            } catch (Exception e) {
                return null;
            }
    }

    public boolean actualizar(MascotaBean mascotab) {
        sql = "UPDATE  mascotas SET idRaza=?, nombreMascota=?, sexo=?, idPersona=?, edad=?, identificacionTatoo=?, alergias=? where idMascota=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            
            ps.setInt(1, mascotab.getIdRaza());
            ps.setString(2, mascotab.getNombreMascota());
            ps.setString(3, mascotab.getSexo());
            ps.setInt(4, mascotab.getIdPersona());
            ps.setInt(5, mascotab.getEdad());
            ps.setString(6, mascotab.getIdentificacionTatoo());
            ps.setString(7, mascotab.getAlergias());
            ps.setInt(8, mascotab.getIdMascota());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
