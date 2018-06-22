/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.winit.codiga_backend.model;

import java.util.Date;

/**
 *
 * @author WinIT
 */
public class VacunaDTO {
    
    private Integer idVacunaGanado;
    private Integer idGanado;
    private String nombreVacuna;
    private Float cantidadSubministrada;
    private Date fechaVacuna;
    private Date fechaProximaVacuna;
    private String observaciones;
    private Boolean activo;
    private Boolean borrado;
    private Date fechaRegistro;
    private Date fechaModificacion;

    /**
     * @return the idVacunaGanado
     */
    public Integer getIdVacunaGanado() {
        return idVacunaGanado;
    }

    /**
     * @param idVacunaGanado the idVacunaGanado to set
     */
    public void setIdVacunaGanado(Integer idVacunaGanado) {
        this.idVacunaGanado = idVacunaGanado;
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
     * @return the nombreVacuna
     */
    public String getNombreVacuna() {
        return nombreVacuna;
    }

    /**
     * @param nombreVacuna the nombreVacuna to set
     */
    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }

    /**
     * @return the cantidadSubministrada
     */
    public Float getCantidadSubministrada() {
        return cantidadSubministrada;
    }

    /**
     * @param cantidadSubministrada the cantidadSubministrada to set
     */
    public void setCantidadSubministrada(Float cantidadSubministrada) {
        this.cantidadSubministrada = cantidadSubministrada;
    }

    /**
     * @return the fechaVacuna
     */
    public Date getFechaVacuna() {
        return fechaVacuna;
    }

    /**
     * @param fechaVacuna the fechaVacuna to set
     */
    public void setFechaVacuna(Date fechaVacuna) {
        this.fechaVacuna = fechaVacuna;
    }

    /**
     * @return the fechaProximaVacuna
     */
    public Date getFechaProximaVacuna() {
        return fechaProximaVacuna;
    }

    /**
     * @param fechaProximaVacuna the fechaProximaVacuna to set
     */
    public void setFechaProximaVacuna(Date fechaProximaVacuna) {
        this.fechaProximaVacuna = fechaProximaVacuna;
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
