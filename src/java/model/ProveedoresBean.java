package model;

public class ProveedoresBean {

    private int idProveedor;
    private String proveedor;
    private String telefono;
    private String email;
    private String direccion;
    private String personaContacto;
    private int estadoProveedor;

    public ProveedoresBean(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public String getProveedor() {
        return proveedor;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getPersonaContacto() {
        return personaContacto;
    }

    public int getEstadoProveedor() {
        return estadoProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setPersonaContacto(String personaContacto) {
        this.personaContacto = personaContacto;
    }

    public void setEstadoProveedor(int estadoProveedor) {
        this.estadoProveedor = estadoProveedor;
    }
}
