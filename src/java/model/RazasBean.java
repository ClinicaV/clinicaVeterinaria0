package model;

/**
 * @author Carlos Solis
 * @version 
 * @param 
 * @comentarios
 */
public class RazasBean {
    private int idRaza;
    private String raza;
    private String descripcion;
    private String categoria;
    private int idCatAnimal;

    public RazasBean(int idRaza) {
        this.idRaza = idRaza;
    }

    public RazasBean() {
    }

    public int getIdRaza() {
        return idRaza;
    }

    public void setIdRaza(int idRaza) {
        this.idRaza = idRaza;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdCatAnimal() {
        return idCatAnimal;
    }

    public void setIdCatAnimal(int idCatAnimal) {
        this.idCatAnimal = idCatAnimal;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
    
}
