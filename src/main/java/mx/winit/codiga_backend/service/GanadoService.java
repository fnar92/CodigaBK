/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.winit.codiga_backend.service;


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

/**
 *
 * @author francisco.acevedo
 */
public interface GanadoService {
    public List<GanadoDTO> getGanado();
    public GanadoDTO getGanadoById(Integer idGanado);
    public List<GanadoDTO> getGanadoByParams(GanadoDTO ganadoDTO);
    public Boolean updateGanado(GanadoDTO ganadoDTO);
    public Boolean updateGanadoDetalle(GanadoDetalleDTO ganadoDetalleDTO);
    public Boolean updateGanadoCompra(ComprasGanadoDTO comprasGanadoDTO);
    public GanadoDTO insertGanado(GanadoDTO ganadoDTO);
    public Boolean insertGanadoCompras(ComprasGanadoDTO comprasGanadoDTO);
    public Boolean deleteGanado(Integer idGanado);
    public Boolean deleteGanadoCompra(Integer idCompraGanado);
    public Boolean deleteGanadoDetalle(Integer idGanado);
    public List<GanadoDTO> obtenerInfoMadre(Integer idUsuario);
    public List<GanadoDTO> obtenerInfoPadre(Integer idUsuario);
    public List<GanadoDetalleDTO> obtenerGanadoDetalle(Integer idUsuario);
    public List<GanadoDetalleDTO> paginadorGanadoDetalle(ParametrosDTO parametrosDTO);
    public List<VacunaDTO> obtenerVacuna(Integer idGanado);
    public List<VacunaDTO> paginadorVacuna(ParametrosDTO parametrosDTO);
    public Boolean insertVacuna(VacunaDTO vacunaDTO);
    public Boolean deleteVacunaGanado(Integer idVacuna);
    public List<VacunaDTO> obtenerCatalogoVacuna(Integer idGanado);
    public List<ProduccionGanadoDTO> obtenerProduccionGanado(Integer idGanado);
    public List<ProduccionGanadoDTO> paginadorProduccionGanado(ParametrosDTO parametrosDTO);
    public Boolean insertProduccionGanado(ProduccionGanadoDTO produccionGanadoDTO);
    public Boolean deleteProduccionGanado(Integer idProduccionGanado);
    public List<ReproduccionGanadoDTO> obtenerReproduccionGanado(Integer idGanado);
    public List<ReproduccionGanadoDTO> paginadorReproduccionGanado(ParametrosDTO parametrosDTO);
    public Boolean insertReproduccionGanado(ReproduccionGanadoDTO reproduccionGanadoDTO);
    public Boolean deleteReproduccionGanado(Integer idReproduccionGanado);
    public Boolean updateFecundacionReproduccionGanado(ReproduccionGanadoDTO reproduccionGanadoDTO);
    public List<SeguimientoReproduccionGanadoDTO> obtenerSeguimientoReproduccionGanado(Integer idReproduccionGanado);
    public List<SeguimientoReproduccionGanadoDTO> paginadorSeguimientoReproduccionGanado(ParametrosDTO parametrosDTO);
    public Boolean insertSeguimientoReproduccionGanado(SeguimientoReproduccionGanadoDTO seguimientoReproduccionGanadoDTO);
    public Boolean deleteSeguimientoReproduccionGanado(Integer idSeguimientoReproduccionGanado);
    public List<ReproduccionGanadoDTO> getReproduccionGanadoByParams(ReproduccionGanadoDTO reproduccionGanadoDTO);
    public List<PartoGanadoDTO> obtenerPartoGanado(Integer idGanado);
    public Boolean insertPartoGanado(PartoGanadoDTO partoGanadoDTO);
    public List<PartoGanadoDTO> paginadorPartoGanado(ParametrosDTO parametrosDTO);
}
