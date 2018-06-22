/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.winit.codiga_backend.rest;

import mx.winit.codiga_backend.util.GenericService;
import java.util.List;
import mx.winit.codiga_backend.model.ComprasGanadoDTO;
import mx.winit.codiga_backend.model.GanadoDTO;
import mx.winit.codiga_backend.model.GanadoDetalleDTO;
import mx.winit.codiga_backend.model.ParametrosDTO;
import mx.winit.codiga_backend.model.PartoGanadoDTO;
import mx.winit.codiga_backend.model.ProduccionGanadoDTO;
import mx.winit.codiga_backend.model.ReproduccionGanadoDTO;
import mx.winit.codiga_backend.model.SeguimientoReproduccionGanadoDTO;
import mx.winit.codiga_backend.model.VacunaDTO;
import mx.winit.codiga_backend.service.GanadoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author francisco.acevedo
 */
@RestController
@RequestMapping("/ganado")
public class GanadoRestService extends GenericService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GanadoService ganadoService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GanadoDTO> getGanado() {
        return this.ganadoService.getGanado();
    }
    
    @RequestMapping(value = "/{idGanado}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public GanadoDTO getGanadoById(@PathVariable("idGanado") Integer idGanado) {
        return this.ganadoService.getGanadoById(idGanado);
    }
    
    @RequestMapping(value = "/params", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GanadoDTO> getGanadoByParams(
            @RequestParam(value = "nombre", required = false) String nombre,
            @RequestParam(value = "idGanado", required = false) Integer idGanado
    ) {
        GanadoDTO ganadoDTO = new GanadoDTO();
        ganadoDTO.setNombre(nombre);
        ganadoDTO.setIdGanado(idGanado);
        return this.ganadoService.getGanadoByParams(ganadoDTO);
    }
    
    @RequestMapping(value = "/obtenerInfoMadre/{idUsuario}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GanadoDTO> getInfoMadre(@PathVariable("idUsuario") Integer idUsuario){
        return this.ganadoService.obtenerInfoMadre(idUsuario);
    }
    @RequestMapping(value = "/obtenerInfoPadre/{idUsuario}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GanadoDTO> getInfoPadre(@PathVariable("idUsuario") Integer idUsuario){
        return this.ganadoService.obtenerInfoPadre(idUsuario);
    }
    
    @RequestMapping(value = "/detalle/{idUsuario}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GanadoDetalleDTO> getGanadoDetalle(@PathVariable("idUsuario") Integer idUsuario){
        return this.ganadoService.obtenerGanadoDetalle(idUsuario);
    }
    
    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    //@ResponseStatus(HttpStatus.OK)
    public Boolean getGanadoPut(@RequestBody GanadoDTO ganadoDTO) throws Exception {
        return this.ganadoService.updateGanado(ganadoDTO);
    }
    
    @RequestMapping(value = "/actualizar", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    //@ResponseStatus(HttpStatus.OK)
    public Boolean updateGanadoDetalle(@RequestBody GanadoDetalleDTO ganadoDetalleDTO) throws Exception {
        return this.ganadoService.updateGanadoDetalle(ganadoDetalleDTO);
    }
    
    @RequestMapping(value = "/actualizar/compra", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    //@ResponseStatus(HttpStatus.OK)
    public Boolean updateGanadoCompra(@RequestBody ComprasGanadoDTO comprasGanadoDTO) throws Exception {
        return this.ganadoService.updateGanadoCompra(comprasGanadoDTO);
    }

    @RequestMapping(value = "/alta", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public GanadoDTO postGanado(@RequestBody GanadoDTO ganadoDTO) {
        return this.ganadoService.insertGanado(ganadoDTO);
    }
    
    @RequestMapping(value = "/alta/compra", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean postGanadoCompras(@RequestBody ComprasGanadoDTO comprasGanadoDTO) {
        return this.ganadoService.insertGanadoCompras(comprasGanadoDTO);
    }
    
    @RequestMapping(value = "/{idGanado}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean ganadoDelete(@PathVariable("idGanado") Integer idGanado) {
        return this.ganadoService.deleteGanado(idGanado);
    }
    
    @RequestMapping(value = "/eliminar/compra/{idCompraGanado}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean deleteGanadoCompra(@PathVariable("idCompraGanado") Integer idCompraGanado) {
        return this.ganadoService.deleteGanadoCompra(idCompraGanado);
    }
    
    @RequestMapping(value = "/eliminar/{idGanado}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean deleteGanadoDetalle(@PathVariable("idGanado") Integer idGanado) {
        return this.ganadoService.deleteGanadoDetalle(idGanado);
    }
    
    @RequestMapping(value = "/paginador", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GanadoDetalleDTO> paginadorGanadoDetalle(
            @RequestParam(value = "idUsuario", required = false) Integer idUsuario,
            @RequestParam(value = "comienzoPaginacion", required = false) Integer comienzoPaginacion,
            @RequestParam(value = "numRegistros", required = false) Integer numRegistros
    ) {
        ParametrosDTO parametrosDTO = new ParametrosDTO();
        parametrosDTO.setIdUsuario(idUsuario);
        parametrosDTO.setComienzoPaginacion(comienzoPaginacion);
        parametrosDTO.setNumRegistros(numRegistros);
        System.out.println(parametrosDTO.toString());
        return this.ganadoService.paginadorGanadoDetalle(parametrosDTO);
    }
    
    @RequestMapping(value = "/vacunas/ver/{idGanado}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VacunaDTO> getVerVacuna(@PathVariable("idGanado") Integer idGanado){
        return this.ganadoService.obtenerVacuna(idGanado);
    }
    
    @RequestMapping(value = "/vacunas/ver/paginador", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VacunaDTO> paginadorVacuna(
            @RequestParam(value = "idGanado", required = false) Integer idGanado,
            @RequestParam(value = "comienzoPaginacion", required = false) Integer comienzoPaginacion,
            @RequestParam(value = "numRegistros", required = false) Integer numRegistros
    ) {
        ParametrosDTO parametrosDTO = new ParametrosDTO();
        parametrosDTO.setIdGanado(idGanado);
        parametrosDTO.setComienzoPaginacion(comienzoPaginacion);
        parametrosDTO.setNumRegistros(numRegistros);
        System.out.println(parametrosDTO.toString());
        return this.ganadoService.paginadorVacuna(parametrosDTO);
    }
    
    @RequestMapping(value = "/vacunas/ver/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean postVacuna(@RequestBody VacunaDTO vacunaDTO) {
        return this.ganadoService.insertVacuna(vacunaDTO);
    }
    
    @RequestMapping(value = "/vacunas/ver/eliminar/{idVacuna}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean deleteVacunaGanado(@PathVariable("idVacuna") Integer idVacuna) {
        return this.ganadoService.deleteVacunaGanado(idVacuna);
    }
    
    @RequestMapping(value = "/vacunas/ver/catalogo/{idGanado}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VacunaDTO> getCatalogoVacuna(@PathVariable("idGanado") Integer idGanado){
        return this.ganadoService.obtenerCatalogoVacuna(idGanado);
    }
    
    @RequestMapping(value = "/produccion/ver/{idGanado}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProduccionGanadoDTO> getVerProduccionGanado(@PathVariable("idGanado") Integer idGanado){
        return this.ganadoService.obtenerProduccionGanado(idGanado);
    }

    @RequestMapping(value = "/produccion/ver/paginador", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProduccionGanadoDTO> paginadorProduccionGanado(
            @RequestParam(value = "idGanado", required = false) Integer idGanado,
            @RequestParam(value = "comienzoPaginacion", required = false) Integer comienzoPaginacion,
            @RequestParam(value = "numRegistros", required = false) Integer numRegistros
    ) {
        ParametrosDTO parametrosDTO = new ParametrosDTO();
        parametrosDTO.setIdGanado(idGanado);
        parametrosDTO.setComienzoPaginacion(comienzoPaginacion);
        parametrosDTO.setNumRegistros(numRegistros);
        System.out.println(parametrosDTO.toString());
        return this.ganadoService.paginadorProduccionGanado(parametrosDTO);
    }
    
    @RequestMapping(value = "/produccion/ver/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean postProduccionGanado(@RequestBody ProduccionGanadoDTO produccionGanadoDTO) {
        return this.ganadoService.insertProduccionGanado(produccionGanadoDTO);
    }
    
    @RequestMapping(value = "/produccion/ver/eliminar/{idProduccionGanado}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean deleteProduccionGanado(@PathVariable("idProduccionGanado") Integer idProduccionGanado) {
        return this.ganadoService.deleteProduccionGanado(idProduccionGanado);
    }
    
    @RequestMapping(value = "/reproduccion/ver/{idGanado}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReproduccionGanadoDTO> getVerReproduccionGanado(@PathVariable("idGanado") Integer idGanado){
        return this.ganadoService.obtenerReproduccionGanado(idGanado);
    }
    
    @RequestMapping(value = "/reproduccion/ver/paginador", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReproduccionGanadoDTO> paginadorReproduccionGanado(
            @RequestParam(value = "idGanado", required = false) Integer idGanado,
            @RequestParam(value = "comienzoPaginacion", required = false) Integer comienzoPaginacion,
            @RequestParam(value = "numRegistros", required = false) Integer numRegistros
    ) {
        ParametrosDTO parametrosDTO = new ParametrosDTO();
        parametrosDTO.setIdGanado(idGanado);
        parametrosDTO.setComienzoPaginacion(comienzoPaginacion);
        parametrosDTO.setNumRegistros(numRegistros);
        System.out.println(parametrosDTO.toString());
        return this.ganadoService.paginadorReproduccionGanado(parametrosDTO);
    }
    
   @RequestMapping(value = "/reproduccion/ver/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean postReproduccionGanado(@RequestBody ReproduccionGanadoDTO reproduccionGanadoDTO) {
        return this.ganadoService.insertReproduccionGanado(reproduccionGanadoDTO);
    }
    
    
    
    @RequestMapping(value = "/reproduccion/ver/actualizar", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean updateFecundacionReproduccionGanado(@RequestBody ReproduccionGanadoDTO reproduccionGanadoDTO) throws Exception {
        return this.ganadoService.updateFecundacionReproduccionGanado(reproduccionGanadoDTO);
    }

    @RequestMapping(value = "/reproduccion/ver/eliminar/{idReproduccionGanado}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean deleteReproduccionGanado(@PathVariable("idReproduccionGanado") Integer idReproduccionGanado) {
        return this.ganadoService.deleteReproduccionGanado(idReproduccionGanado);
    }
    
    @RequestMapping(value = "/reproduccion/ver/seguimiento/{idReproduccionGanado}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SeguimientoReproduccionGanadoDTO> getVerSeguimientoReproduccionGanado(@PathVariable("idReproduccionGanado") Integer idReproduccionGanado){
        return this.ganadoService.obtenerSeguimientoReproduccionGanado(idReproduccionGanado);
    }
    
    @RequestMapping(value = "/reproduccion/ver/seguimiento/paginador", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SeguimientoReproduccionGanadoDTO> paginadorSeguimientoReproduccionGanado(
            @RequestParam(value = "idReproduccionGanado", required = false) Integer idReproduccionGanado,
            @RequestParam(value = "comienzoPaginacion", required = false) Integer comienzoPaginacion,
            @RequestParam(value = "numRegistros", required = false) Integer numRegistros
    ) {
        ParametrosDTO parametrosDTO = new ParametrosDTO();
        parametrosDTO.setIdReproduccionGanado(idReproduccionGanado);
        parametrosDTO.setComienzoPaginacion(comienzoPaginacion);
        parametrosDTO.setNumRegistros(numRegistros);
        System.out.println(parametrosDTO.toString());
        return this.ganadoService.paginadorSeguimientoReproduccionGanado(parametrosDTO);
    }
    
    @RequestMapping(value = "/reproduccion/ver/seguimiento", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean postSeguimientoReproduccionGanado(@RequestBody SeguimientoReproduccionGanadoDTO seguimientoReproduccionGanadoDTO) {
        return this.ganadoService.insertSeguimientoReproduccionGanado(seguimientoReproduccionGanadoDTO);
    }
    
    @RequestMapping(value = "/reproduccion/ver/eliminar/seguimiento/{idSeguimientoReproduccionGanado}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean deleteSeguimientoReproduccionGanado(@PathVariable("idSeguimientoReproduccionGanado") Integer idSeguimientoReproduccionGanado) {
        return this.ganadoService.deleteSeguimientoReproduccionGanado(idSeguimientoReproduccionGanado);
    }
    
    @RequestMapping(value = "/reproduccion/ver/seguimiento/params", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReproduccionGanadoDTO> getReproduccionGanadoByParams(
            @RequestParam(value = "idReproduccionGanado", required = false) Integer idReproduccionGanado
    ) {
        ReproduccionGanadoDTO reproduccionGanadoDTO = new ReproduccionGanadoDTO();
        reproduccionGanadoDTO.setIdReproduccionGanado(idReproduccionGanado);
        return this.ganadoService.getReproduccionGanadoByParams(reproduccionGanadoDTO);
    }
    
    @RequestMapping(value = "/reproduccion/ver/parto/{idGanado}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PartoGanadoDTO> getPartoGanado(@PathVariable("idGanado") Integer idGanado){
        return this.ganadoService.obtenerPartoGanado(idGanado);
    }
    
    @RequestMapping(value = "/reproduccion/ver/parto", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean postPartoGanado(@RequestBody PartoGanadoDTO partoGanadoDTO) {
        return this.ganadoService.insertPartoGanado(partoGanadoDTO);
    }
    
    @RequestMapping(value = "/reproduccion/ver/parto/paginador", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PartoGanadoDTO> paginadorPartoGanado(
            @RequestParam(value = "idGanado", required = false) Integer idGanado,
            @RequestParam(value = "comienzoPaginacion", required = false) Integer comienzoPaginacion,
            @RequestParam(value = "numRegistros", required = false) Integer numRegistros
    ) {
        ParametrosDTO parametrosDTO = new ParametrosDTO();
        parametrosDTO.setIdGanado(idGanado);
        parametrosDTO.setComienzoPaginacion(comienzoPaginacion);
        parametrosDTO.setNumRegistros(numRegistros);
        return this.ganadoService.paginadorPartoGanado(parametrosDTO);
    }
}
