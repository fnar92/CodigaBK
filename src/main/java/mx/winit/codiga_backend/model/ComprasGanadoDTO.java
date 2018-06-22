package mx.winit.codiga_backend.model;

import java.util.Date;

/**
 *
 * @author WinIT
 */
public class ComprasGanadoDTO {
    
    private Integer idCompraGanado;
    private Integer idGanado;
    private String vendedor;
    private Float costo;
    private Integer factura;
    private  Boolean activo;
    private  Boolean borrado;
    private  Date fechaRegistro;
    private  Date fechaModificacion;

    /**
     * @return the idCompraGanado
     */
    public Integer getIdCompraGanado() {
        return idCompraGanado;
    }

    /**
     * @param idCompraGanado the idCompraGanado to set
     */
    public void setIdCompraGanado(Integer idCompraGanado) {
        this.idCompraGanado = idCompraGanado;
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
     * @return the vendedor
     */
    public String getVendedor() {
        return vendedor;
    }

    /**
     * @param vendedor the vendedor to set
     */
    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    /**
     * @return the costo
     */
    public Float getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(Float costo) {
        this.costo = costo;
    }

    /**
     * @return the factura
     */
    public Integer getFactura() {
        return factura;
    }

    /**
     * @param factura the factura to set
     */
    public void setFactura(Integer factura) {
        this.factura = factura;
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
