package mx.winit.codiga_backend.model;

import java.util.Date;

/**
 *
 * @author WinIT
 */
public class ReproduccionGanadoDTO {
    private Integer idReproduccionGanado;
    private Integer idGanado;
    private Boolean inseminacion;
    private String nombreToro;
    private Integer idToroMonta;
    private Date fechaSecado;
    private Boolean activo;
    private Boolean borrado;
    private Date fechaRegistro;
    private Date fechaModificacion;
    private String nombreToroMonta;
    
    private Date fechaInseminacion;
    private Boolean pego;
    private Boolean parto;
    private Boolean aborto;
    /**
     * @return the idReproduccionGanado
     */
    public Integer getIdReproduccionGanado() {
        return idReproduccionGanado;
    }

    /**
     * @param idReproduccionGanado the idReproduccionGanado to set
     */
    public void setIdReproduccionGanado(Integer idReproduccionGanado) {
        this.idReproduccionGanado = idReproduccionGanado;
    }

    /**
     * @return the idGanado
     */
    public Integer getIdGanado() {
        return idGanado;
    }

    /**
     * @param idGanado the idGanado to set
     */
    public void setIdGanado(Integer idGanado) {
        this.idGanado = idGanado;
    }

    /**
     * @return the inseminacion
     */
    public Boolean getInseminacion() {
        return inseminacion;
    }

    /**
     * @param inseminacion the inseminacion to set
     */
    public void setInseminacion(Boolean inseminacion) {
        this.inseminacion = inseminacion;
    }

    /**
     * @return the nombreToro
     */
    public String getNombreToro() {
        return nombreToro;
    }

    /**
     * @param nombreToro the nombreToro to set
     */
    public void setNombreToro(String nombreToro) {
        this.nombreToro = nombreToro;
    }

    /**
     * @return the idToroMonta
     */
    public Integer getIdToroMonta() {
        return idToroMonta;
    }

    /**
     * @param idToroMonta the idToroMonta to set
     */
    public void setIdToroMonta(Integer idToroMonta) {
        this.idToroMonta = idToroMonta;
    }

    /**
     * @return the fechaSecado
     */
    public Date getFechaSecado() {
        return fechaSecado;
    }

    /**
     * @param fechaSecado the fechaSecado to set
     */
    public void setFechaSecado(Date fechaSecado) {
        this.fechaSecado = fechaSecado;
    }

    /**
     * @return the activo
     */
    public Boolean getActivo() {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    /**
     * @return the borrado
     */
    public Boolean getBorrado() {
        return borrado;
    }

    /**
     * @param borrado the borrado to set
     */
    public void setBorrado(Boolean borrado) {
        this.borrado = borrado;
    }

    /**
     * @return the fechaRegistro
     */
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * @param fechaRegistro the fechaRegistro to set
     */
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * @return the fechaModificacion
     */
    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    /**
     * @param fechaModificacion the fechaModificacion to set
     */
    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    /**
     * @return the nombreToroMonta
     */
    public String getNombreToroMonta() {
        return nombreToroMonta;
    }

    /**
     * @param nombreToroMonta the nombreToroMonta to set
     */
    public void setNombreToroMonta(String nombreToroMonta) {
        this.nombreToroMonta = nombreToroMonta;
    }

    /**
     * @return the fechaInseminacion
     */
    public Date getFechaInseminacion() {
        return fechaInseminacion;
    }

    /**
     * @param fechaInseminacion the fechaInseminacion to set
     */
    public void setFechaInseminacion(Date fechaInseminacion) {
        this.fechaInseminacion = fechaInseminacion;
    }

    /**
     * @return the pego
     */
    public Boolean getPego() {
        return pego;
    }

    /**
     * @param pego the pego to set
     */
    public void setPego(Boolean pego) {
        this.pego = pego;
    }

    /**
     * @return the parto
     */
    public Boolean getParto() {
        return parto;
    }

    /**
     * @param parto the parto to set
     */
    public void setParto(Boolean parto) {
        this.parto = parto;
    }

    /**
     * @return the aborto
     */
    public Boolean getAborto() {
        return aborto;
    }

    /**
     * @param aborto the aborto to set
     */
    public void setAborto(Boolean aborto) {
        this.aborto = aborto;
    }

    
    
}
