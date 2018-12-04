package model;

public class CatAnimalesBean {

    private int idCatAnimal;
    private String catAnimal;
    private String descripcion;
    private int estadoCatAnimal;

    public CatAnimalesBean(int idCatAnimal) {
        this.idCatAnimal = idCatAnimal;
    }

    public int getIdCatAnimal() {
        return idCatAnimal;
    }

    public String getCatAnimal() {
        return catAnimal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getEstadoCatAnimal() {
        return estadoCatAnimal;
    }

    public void setIdCatAnimal(int idCatAnimal) {
        this.idCatAnimal = idCatAnimal;
    }

    public void setCatAnimal(String catAnimal) {
        this.catAnimal = catAnimal;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstadoCatAnimal(int estadoCatAnimal) {
        this.estadoCatAnimal = estadoCatAnimal;
    }

}
