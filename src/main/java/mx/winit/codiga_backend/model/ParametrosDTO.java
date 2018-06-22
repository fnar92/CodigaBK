/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.winit.codiga_backend.model;

/**
 *
 * @author WinIT
 */
public class ParametrosDTO {
    
    private Integer idUsuario;
    private Integer idGanado;
    private Integer idReproduccionGanado;
    private Integer comienzoPaginacion;
    private Integer numRegistros;
    

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
     * @return the comienzoPaginacion
     */
    public Integer getComienzoPaginacion() {
        return comienzoPaginacion;
    }

    /**
     * @param comienzoPaginacion the comienzoPaginacion to set
     */
    public void setComienzoPaginacion(Integer comienzoPaginacion) {
        this.comienzoPaginacion = comienzoPaginacion;
    }

    /**
     * @return the numRegistros
     */
    public Integer getNumRegistros() {
        return numRegistros;
    }

    /**
     * @param numRegistros the numRegistros to set
     */
    public void setNumRegistros(Integer numRegistros) {
        this.numRegistros = numRegistros;
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
    
    
    @Override
    public String toString() {
        return "ParametrosDTO{" + "idUsuario=" + getIdUsuario() + ", comienzoPaginacion=" + getComienzoPaginacion() + ", numRegistros=" + getNumRegistros() + '}';
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

}
