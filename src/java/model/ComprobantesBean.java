package model;

public class ComprobantesBean {

    private int idComprobante;
    private String comprobante;
    private int estadoComprobante;

    public ComprobantesBean(int idComprobante) {
        this.idComprobante = idComprobante;
    }

    public int getIdComprobante() {
        return idComprobante;
    }

    public String getComprobante() {
        return comprobante;
    }

    public int getEstadoComprobante() {
        return estadoComprobante;
    }

    public void setIdComprobante(int idComprobante) {
        this.idComprobante = idComprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    public void setEstadoComprobante(int estadoComprobante) {
        this.estadoComprobante = estadoComprobante;
    }

}
