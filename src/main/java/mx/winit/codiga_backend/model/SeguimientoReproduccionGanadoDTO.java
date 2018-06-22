package mx.winit.codiga_backend.model;

import java.util.Date;

/**
 *
 * @author WinIT
 */
public class SeguimientoReproduccionGanadoDTO {
    
    private Integer idSeguimientoReproduccionGanado;
    private  Integer idReproduccionGanado;
    private Integer idGanado;
    private String observaciones;
    private Boolean activo;
    private Boolean borrado;
    private Date fechaRegistro;
    private Date fechaModificacion;

    /**
     * @return the idSeguimientoReproduccionGanado
     */
    public Integer getIdSeguimientoReproduccionGanado() {
        return idSeguimientoReproduccionGanado;
    }

    /**
     * @param idSeguimientoReproduccionGanado the idSeguimientoReproduccionGanado to set
     */
    public void setIdSeguimientoReproduccionGanado(Integer idSeguimientoReproduccionGanado) {
        this.idSeguimientoReproduccionGanado = idSeguimientoReproduccionGanado;
    }

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
     * @return the observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * @param observaciones the observaciones to set
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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
    
    
}
