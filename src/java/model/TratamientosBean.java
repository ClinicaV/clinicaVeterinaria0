package model;

/**
 * @author Franklin Alexis
 * @version
 * @param
 * @comentarios
 */
public class TratamientosBean {

    //atributos tabla tratamientos
    private int idTratamiento;
    private String tratamiento;
    private int idCatTratamiento;
    private double precio;
    //atributo tabla servicios
    private String catTratamiento;

    public TratamientosBean(int idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public int getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(int idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public int getIdCatTratamiento() {
        return idCatTratamiento;
    }

    public void setIdCatTratamiento(int idCatTratamiento) {
        this.idCatTratamiento = idCatTratamiento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCatTratamiento() {
        return catTratamiento;
    }

    public void setCatTratamiento(String catTratamiento) {
        this.catTratamiento = catTratamiento;
    }
    
    
}
