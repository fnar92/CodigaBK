/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.winit.codiga_backend.model;

import java.util.Date;

/**
 *
 * @author francisco.acevedo
 */
public class GanadoDTO {

   private Integer idGanado;
   private Integer idUsuario;
   private String codigoArete;
   private String nombre;
   private String nombreToro;
   private Date fechaNacimiento;
   private String sexo;
   private String color;
   private Float peso;
   private Integer procedencia;
   private  Boolean inseminacion;
   private String observaciones;
   private Integer idTipoGanado;
   private Integer idEstatusGanado;
   private Integer idRaza;
   private Integer idPadre;
   private Integer idMadre;
   private Integer idDispositivo;
   private  Boolean activo;
   private  Boolean borrado;
   private  Date fechaRegistro;
   private  Date fechaModificacion;
   private String dispositivo;

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
     * @return the codigoArete
     */
    public String getCodigoArete() {
        return codigoArete;
    }

    /**
     * @param codigoArete the codigoArete to set
     */
    public void setCodigoArete(String codigoArete) {
        this.codigoArete = codigoArete;
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
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the peso
     */
    public Float getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(Float peso) {
        this.peso = peso;
    }

    /**
     * @return the procedencia
     */
    public Integer getProcedencia() {
        return procedencia;
    }

    /**
     * @param procedencia the procedencia to set
     */
    public void setProcedencia(Integer procedencia) {
        this.procedencia = procedencia;
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
     * @return the idTipoGanado
     */
    public Integer getIdTipoGanado() {
        return idTipoGanado;
    }

    /**
     * @param idTipoGanado the idTipoGanado to set
     */
    public void setIdTipoGanado(Integer idTipoGanado) {
        this.idTipoGanado = idTipoGanado;
    }


    /**
     * @return the idRaza
     */
    public Integer getIdRaza() {
        return idRaza;
    }

    /**
     * @param idRaza the idRaza to set
     */
    public void setIdRaza(Integer idRaza) {
        this.idRaza = idRaza;
    }

    /**
     * @return the idPadre
     */
    public Integer getIdPadre() {
        return idPadre;
    }

    /**
     * @param idPadre the idPadre to set
     */
    public void setIdPadre(Integer idPadre) {
        this.idPadre = idPadre;
    }

    /**
     * @return the idMadre
     */
    public Integer getIdMadre() {
        return idMadre;
    }

    /**
     * @param idMadre the idMadre to set
     */
    public void setIdMadre(Integer idMadre) {
        this.idMadre = idMadre;
    }

    /**
     * @return the idDispositivo
     */
    public Integer getIdDispositivo() {
        return idDispositivo;
    }

    /**
     * @param idDispositivo the idDispositivo to set
     */
    public void setIdDispositivo(Integer idDispositivo) {
        this.idDispositivo = idDispositivo;
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
     * @return the idUsuario
     */
    public Integer getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the idEstatusGanado
     */
    public Integer getIdEstatusGanado() {
        return idEstatusGanado;
    }

    /**
     * @param idEstatusGanado the idEstatusGanado to set
     */
    public void setIdEstatusGanado(Integer idEstatusGanado) {
        this.idEstatusGanado = idEstatusGanado;
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
     * @return the dispositivo
     */
    public String getDispositivo() {
        return dispositivo;
    }

    /**
     * @param dispositivo the dispositivo to set
     */
    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }
   
    
   
}
