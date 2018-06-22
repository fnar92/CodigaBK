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
public class PartoGanadoDTO {
    private Integer idPartoGanado; 
    private Integer idGanado;
    private Integer idReproduccionGanado;
    private Integer idGanadoHijo;
    private Date fechaParto;
    private Boolean activo;
    private Boolean borrado;
    private Date fechaRegistro;
    private Date fechaModificacion;
    
    private String nombre;
    private String sexo;

    /**
     * @return the idPartoGanado
     */
    public Integer getIdPartoGanado() {
        return idPartoGanado;
    }

    /**
     * @param idPartoGanado the idPartoGanado to set
     */
    public void setIdPartoGanado(Integer idPartoGanado) {
        this.idPartoGanado = idPartoGanado;
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
     * @return the idGanadoHijo
     */
    public Integer getIdGanadoHijo() {
        return idGanadoHijo;
    }

    /**
     * @param idGanadoHijo the idGanadoHijo to set
     */
    public void setIdGanadoHijo(Integer idGanadoHijo) {
        this.idGanadoHijo = idGanadoHijo;
    }

    /**
     * @return the fechaParto
     */
    public Date getFechaParto() {
        return fechaParto;
    }

    /**
     * @param fechaParto the fechaParto to set
     */
    public void setFechaParto(Date fechaParto) {
        this.fechaParto = fechaParto;
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

   
    
    
}
