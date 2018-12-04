package model;

/**
 * @author Franklin Alexis
 * @version
 * @param
 * @comentarios
 */
public class HorariosBean {

    //atributos tabla Horarios
    private int idHorario;
    private String horaInicio;
    private String horaFin;
    private int idCatTratamiento;
    //atributo tabla servicios
    private String catTratamiento;

    public HorariosBean(int idHorario) {
        this.idHorario = idHorario;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public int getIdCatTratamiento() {
        return idCatTratamiento;
    }

    public void setIdCatTratamiento(int idCatTratamiento) {
        this.idCatTratamiento = idCatTratamiento;
    }

    public String getCatTratamiento() {
        return catTratamiento;
    }

    public void setCatTratamiento(String catTratamiento) {
        this.catTratamiento = catTratamiento;
    }
    
    
    
}
