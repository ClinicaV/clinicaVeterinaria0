package model;

public class ServiciosBean {

    private int idCatTratamiento;
    private String catTratamiento;
    private String descripcion;
    private int estadoServicios;

    public ServiciosBean(int idCatTratamiento) {
        this.idCatTratamiento = idCatTratamiento;
    }

    public int getIdCatTratamiento() {
        return idCatTratamiento;
    }

    public String getCatTratamiento() {
        return catTratamiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getEstadoServicios() {
        return estadoServicios;
    }

    public void setIdCatTratamiento(int idCatTratamiento) {
        this.idCatTratamiento = idCatTratamiento;
    }

    public void setCatTratamiento(String catTratamiento) {
        this.catTratamiento = catTratamiento;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstadoServicios(int estadoServicios) {
        this.estadoServicios = estadoServicios;
    }
    
    
}
