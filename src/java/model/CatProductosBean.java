package model;

public class CatProductosBean {

    private int idCatProducto;
    private String categoriaProducto;
    private String descripcion;
    private int estadoCatProducto;

    public CatProductosBean(int idCatProducto) {
        this.idCatProducto = idCatProducto;
    }

    public int getIdCatProducto() {
        return idCatProducto;
    }

    public String getCategoriaProducto() {
        return categoriaProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getEstadoCatProducto() {
        return estadoCatProducto;
    }

    public void setIdCatProducto(int idCatProducto) {
        this.idCatProducto = idCatProducto;
    }

    public void setCategoriaProducto(String categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstadoCatProducto(int estadoCatProducto) {
        this.estadoCatProducto = estadoCatProducto;
    }

}
