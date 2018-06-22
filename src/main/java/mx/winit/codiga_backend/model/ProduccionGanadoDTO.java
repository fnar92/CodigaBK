package mx.winit.codiga_backend.model;

import java.util.Date;

/**
 *
 * @author WinIT
 */
public class ProduccionGanadoDTO {
    private Integer idProduccionGanado;
    private Integer idGanado;
    private String nombreVenta;
    private Float cantidad;
    private Float precio;
    private String observaciones;
    private Boolean activo;
    private Boolean borrado;
    private Date fechaRegistro;
    private Date fechaModificacion;
    private Float total;
    

    /**
     * @return the idProduccionGanado
     */
    public Integer getIdProduccionGanado() {
        return idProduccionGanado;
    }

    /**
     * @param idProduccionGanado the idProduccionGanado to set
     */
    public void setIdProduccionGanado(Integer idProduccionGanado) {
        this.idProduccionGanado = idProduccionGanado;
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
     * @return the nombreVenta
     */
    public String getNombreVenta() {
        return nombreVenta;
    }

    /**
     * @param nombreVenta the nombreVenta to set
     */
    public void setNombreVenta(String nombreVenta) {
        this.nombreVenta = nombreVenta;
    }

    /**
     * @return the cantidad
     */
    public Float getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the precio
     */
    public Float getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Float precio) {
        this.precio = precio;
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

    /**
     * @return the total
     */
    public Float getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Float total) {
        this.total = total;
    }

}
