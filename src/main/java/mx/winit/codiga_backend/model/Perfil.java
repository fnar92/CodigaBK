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

public class Perfil implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idPerfil;
    private String descripcion;
    private String tarjet;
    private boolean activo;
    private Date fechaRegistro;

    public Perfil() {
    }

    public Perfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Perfil(Integer idPerfil, String descripcion, String tarjet, boolean activo, Date fechaRegistro) {
        this.idPerfil = idPerfil;
        this.descripcion = descripcion;
        this.tarjet = tarjet;
        this.activo = activo;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTarjet() {
        return tarjet;
    }

    public void setTarjet(String tarjet) {
        this.tarjet = tarjet;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
