/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.winit.codiga_backend.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Cliente
 */

public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idUsuario;
    private String usuario;
    private String password;
    private String tokenActivate;
    private UsuarioDetalleDTO usuarioDetalle;
    private Boolean activo;
    private Boolean borrado;
    private Date fechaRegistro;
    private Date fechaModificacion;
    private Boolean actualizarDatos;
    

    public UsuarioDTO() {
        usuarioDetalle = new UsuarioDetalleDTO();
    }

    public UsuarioDTO(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public UsuarioDTO(Integer idUsuario, String usuario, String password, boolean activo, Date fechaRegistro) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.password = password;
        this.activo = activo;
        this.fechaRegistro = fechaRegistro;
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
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the tokenActivate
     */
    public String getTokenActivate() {
        return tokenActivate;
    }

    /**
     * @param tokenActivate the tokenActivate to set
     */
    public void setTokenActivate(String tokenActivate) {
        this.tokenActivate = tokenActivate;
    }

    /**
     * @return the usuarioDetalle
     */
    public UsuarioDetalleDTO getUsuarioDetalle() {
        return usuarioDetalle;
    }

    /**
     * @param usuarioDetalle the usuarioDetalle to set
     */
    public void setUsuarioDetalle(UsuarioDetalleDTO usuarioDetalle) {
        this.usuarioDetalle = usuarioDetalle;
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
     * @return the actualizarDatos
     */
    public Boolean getActualizarDatos() {
        return actualizarDatos;
    }

    /**
     * @param actualizarDatos the actualizarDatos to set
     */
    public void setActualizarDatos(Boolean actualizarDatos) {
        this.actualizarDatos = actualizarDatos;
    }
    
    
}
