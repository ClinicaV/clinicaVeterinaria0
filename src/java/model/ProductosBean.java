package model;

/**
 * @author Franklin Alexis
 * @version
 * @param
 * @comentarios
 */
public class ProductosBean {

    //atributos tabla productos
    private int idProducto;
    private String producto;
    private int idCategoria;//fk
    private int idUnidad;//fk
    private double stock;
    private int estadoProducto;
    //atributo tabla categoriasProductos
    private String categoriaProducto;
    //atributo tabla unidadesMedicion
    private String unidadMedicion;

    public ProductosBean(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(int idUnidad) {
        this.idUnidad = idUnidad;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public int getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(int estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    public String getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(String categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public String getUnidadMedicion() {
        return unidadMedicion;
    }

    public void setUnidadMedicion(String unidadMedicion) {
        this.unidadMedicion = unidadMedicion;
    }
    
    
    
}
