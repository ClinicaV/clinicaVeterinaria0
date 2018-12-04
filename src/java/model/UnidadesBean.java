package model;

public class UnidadesBean {

    private int idUnidadMedicion;
    private String unidadMedicion;
    private int estadoUnidad;

    public UnidadesBean(int idUnidadMedicion) {
        this.idUnidadMedicion = idUnidadMedicion;
    }

    public int getIdUnidadMedicion() {
        return idUnidadMedicion;
    }

    public String getUnidadMedicion() {
        return unidadMedicion;
    }

    public int getEstadoUnidad() {
        return estadoUnidad;
    }

    public void setIdUnidadMedicion(int idUnidadMedicion) {
        this.idUnidadMedicion = idUnidadMedicion;
    }

    public void setUnidadMedicion(String unidadMedicion) {
        this.unidadMedicion = unidadMedicion;
    }

    public void setEstadoUnidad(int estadoUnidad) {
        this.estadoUnidad = estadoUnidad;
    }     
}
