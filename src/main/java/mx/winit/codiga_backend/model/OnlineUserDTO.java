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
public class OnlineUserDTO {
    private Integer idOnlineUser;
    private String idSocket;
    private String username;
    private Boolean activo;
    private Boolean borrado;
    private Date fechaRegistro;
    private Date fechaModificacion;

    /**
     * @return the idOnlineUser
     */
    public Integer getIdOnlineUser() {
        return idOnlineUser;
    }

    /**
     * @param idOnlineUser the idOnlineUser to set
     */
    public void setIdOnlineUser(Integer idOnlineUser) {
        this.idOnlineUser = idOnlineUser;
    }

    /**
     * @return the idSocket
     */
    public String getIdSocket() {
        return idSocket;
    }

    /**
     * @param idSocket the idSocket to set
     */
    public void setIdSocket(String idSocket) {
        this.idSocket = idSocket;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
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
