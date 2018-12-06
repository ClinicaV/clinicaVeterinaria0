package model;

public class PersonasBean {

    private int idPersona;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String genero;
    private int estadoPersona;
    private int tipo;

    public PersonasBean(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getGenero() {
        return genero;
    }

    public int getEstadoPersona() {
        return estadoPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setEstadoPersona(int estadoPersona) {
        this.estadoPersona = estadoPersona;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    
}
