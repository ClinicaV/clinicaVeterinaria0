package model;

/**
 * @author Carlos Solis
 * @version 
 * @param 
 * @comentarios
 */
public class MascotaBean {
    private int idMascota;
    private int idRaza;
    private String nombreMascota;
    private String sexo;
    private int idPersona;
    private int edad;
    private String identificacionTatoo;
    private String alergias;
    private int estadoMascota;
    private String nombres;
    private String apellidos;
    private String raza;

    public MascotaBean(int idMascota) {
        this.idMascota = idMascota;
    }

    public MascotaBean() {
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public int getIdRaza() {
        return idRaza;
    }

    public void setIdRaza(int idRaza) {
        this.idRaza = idRaza;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getIdentificacionTatoo() {
        return identificacionTatoo;
    }

    public void setIdentificacionTatoo(String identificacionTatoo) {
        this.identificacionTatoo = identificacionTatoo;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public int getEstadoMascota() {
        return estadoMascota;
    }

    public void setEstadoMascota(int estadoMascota) {
        this.estadoMascota = estadoMascota;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
    
    
    
    
    
}
