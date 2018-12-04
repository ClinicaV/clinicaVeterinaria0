package model;

public class NivelesBean {

    private int idNivel;
    private String nivel;
    private int estadoNivel;

    public NivelesBean(int idNivel) {
        this.idNivel = idNivel;
    }

    public int getIdNivel() {
        return idNivel;
    }

    public String getNivel() {
        return nivel;
    }

    public int getEstadoNivel() {
        return estadoNivel;
    }

    public void setIdNivel(int idNivel) {
        this.idNivel = idNivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public void setEstadoNivel(int estadoNivel) {
        this.estadoNivel = estadoNivel;
    }

}
