/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.winit.codiga_backend.mapper;

import java.util.List;
import mx.winit.codiga_backend.model.CatDispositivoDTO;
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
 * @author Cliente
 */
public interface GanadoMapper {
    List<GanadoDTO> getGanado();
    GanadoDTO getGanadoById(Integer idGanado);
    List<GanadoDTO> getGanadoByParams(GanadoDTO ganadoDTO);
    Boolean updateGanado(GanadoDTO ganadoDTO);
    Boolean updateGanadoDetalle(GanadoDetalleDTO ganadoDetalleDTO);
    Boolean updateGanadoCompra(ComprasGanadoDTO comprasGanadoDTO);
    Boolean updateCatDispositivo(Integer idCatDisositivo);
    Boolean insertGanado(GanadoDTO ganadoDTO);
    Boolean insertGanadoCompras(ComprasGanadoDTO comprasGanadoDTO);
    CatDispositivoDTO validarDispositivoActivo(String dispositivo);
    GanadoDetalleDTO validarCompra(Integer idGanado);
    GanadoDetalleDTO validarRegistroEnCompra(Integer idGanado);
    CatDispositivoDTO getDispositivo(String dispositivo);
    Boolean deleteGanado(Integer idGanado);
    Boolean deleteGanadoCompra(Integer idCompraGanado);
    Boolean deleteGanadoDetalle(Integer idGanado);
    List<GanadoDTO> obtenerInfoMadre(Integer idUsuario);
    List<GanadoDTO> obtenerInfoPadre(Integer idUsuario);
    List<GanadoDetalleDTO> obtenerGanadoDetalle(Integer idUsuario);
    List<GanadoDetalleDTO> paginadorGanadoDetalle(ParametrosDTO parametrosDTO);
    List<VacunaDTO> obtenerVacuna(Integer idGanado);
    List<VacunaDTO> paginadorVacuna(ParametrosDTO parametrosDTO);
    Boolean insertVacuna(VacunaDTO vacunaDTO);
    Boolean deleteVacunaGanado(Integer idVacuna);
    List<VacunaDTO> obtenerCatalogoVacuna(Integer idGanado);
    List<ProduccionGanadoDTO> obtenerProduccionGanado(Integer idGanado);
    List<ProduccionGanadoDTO> paginadorProduccionGanado(ParametrosDTO parametrosDTO);
    Boolean insertProduccionGanado(ProduccionGanadoDTO produccionGanadoDTO);
    Boolean deleteProduccionGanado(Integer idProduccionGanado);
    List<ReproduccionGanadoDTO> obtenerReproduccionGanado(Integer idGanado);
    List<ReproduccionGanadoDTO> paginadorReproduccionGanado(ParametrosDTO parametrosDTO);
    Boolean insertReproduccionGanado(ReproduccionGanadoDTO reproduccionGanadoDTO);
    Boolean deleteReproduccionGanado(Integer idReproduccionGanado);
    Boolean updateFecundacionReproduccionGanado(ReproduccionGanadoDTO reproduccionGanadoDTO);
    List<SeguimientoReproduccionGanadoDTO> obtenerSeguimientoReproduccionGanado(Integer idReproduccionGanado);
    List<SeguimientoReproduccionGanadoDTO> paginadorSeguimientoReproduccionGanado(ParametrosDTO parametrosDTO);
    Boolean insertSeguimientoReproduccionGanado(SeguimientoReproduccionGanadoDTO seguimientoReproduccionGanadoDTO);
    Boolean deleteSeguimientoReproduccionGanado(Integer idSeguimientoReproduccionGanado);
    List<ReproduccionGanadoDTO> getReproduccionGanadoByParams(ReproduccionGanadoDTO reproduccionGanadoDTO);
    List<PartoGanadoDTO> obtenerPartoGanado(Integer idGanado);
    Boolean insertPartoGanado(PartoGanadoDTO partoGanadoDTO);
    List<PartoGanadoDTO> paginadorPartoGanado(ParametrosDTO parametrosDTO);
}
