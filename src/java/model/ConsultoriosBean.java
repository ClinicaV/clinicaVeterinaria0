package model;

public class ConsultoriosBean {

    private int idConsultorio;
    private String consultorio;
    private int estadoConsultorio;

    public ConsultoriosBean(int idConsultorio) {
        this.idConsultorio = idConsultorio;
    }

    public int getIdConsultorio() {
        return idConsultorio;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public int getEstadoConsultorio() {
        return estadoConsultorio;
    }

    public void setIdConsultorio(int idConsultorio) {
        this.idConsultorio = idConsultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public void setEstadoConsultorio(int estadoConsultorio) {
        this.estadoConsultorio = estadoConsultorio;
    }

}
