package model;

public class RolesBean {

    private int idRol;
    private String rol;
    private int estadoRol;

    public RolesBean(int idRol) {
        this.idRol = idRol;
    }

    public int getIdRol() {
        return idRol;
    }

    public String getRol() {
        return rol;
    }

    public int getEstadoRol() {
        return estadoRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setEstadoRol(int estadoRol) {
        this.estadoRol = estadoRol;
    }
    
}
