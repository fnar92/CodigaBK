/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.winit.codiga_backend.model;

/**
 *
 * @author francisco.acevedo
 */
public class UsuarioPerfilDTO {
    private Integer idUsuarioPerfil;
    private Integer idUsuario;
    private Integer idPerfil;

    /**
     * @return the idUsuarioPerfil
     */
    public Integer getIdUsuarioPerfil() {
        return idUsuarioPerfil;
    }

    /**
     * @param idUsuarioPerfil the idUsuarioPerfil to set
     */
    public void setIdUsuarioPerfil(Integer idUsuarioPerfil) {
        this.idUsuarioPerfil = idUsuarioPerfil;
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
     * @return the idPerfil
     */
    public Integer getIdPerfil() {
        return idPerfil;
    }

    /**
     * @param idPerfil the idPerfil to set
     */
    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }
    
    
}
