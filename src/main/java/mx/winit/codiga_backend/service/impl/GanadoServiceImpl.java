/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.winit.codiga_backend.service.impl;

import java.util.List;
import mx.winit.codiga_backend.exception.ConflictException;
import mx.winit.codiga_backend.exception.InternalServerException;
import mx.winit.codiga_backend.exception.NoContentException;
import mx.winit.codiga_backend.mapper.GanadoMapper;
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
import mx.winit.codiga_backend.util.GenericService;
import mx.winit.codiga_backend.service.GanadoService;
import mx.winit.codiga_backend.util.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Cliente
 */
@Service
public class GanadoServiceImpl extends GenericService implements GanadoService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GanadoMapper ganadoMapper;

    @Override
    public List<GanadoDTO> getGanado() {
        List<GanadoDTO> list = this.ganadoMapper.getGanado();
        if (listaValida(list)) {
            return list;
        }
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }

    @Override
    public GanadoDTO getGanadoById(Integer idGanado) {
        GanadoDTO myObjetGanado = this.ganadoMapper.getGanadoById(idGanado);
        if (objetoValido(myObjetGanado)) {
            return myObjetGanado;
        }
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }

    @Override
    public List<GanadoDTO> getGanadoByParams(GanadoDTO ganadoDTO) {
        List<GanadoDTO> list = this.ganadoMapper.getGanadoByParams(ganadoDTO);
        if (listaValida(list)) {
            return list;
        }
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateGanado(GanadoDTO ganadoDTO) {
        try {
            return this.ganadoMapper.updateGanado(ganadoDTO);
        } catch (Exception e) {
            this.log.error("Error al actualizar ganado con id:" + ganadoDTO.getIdGanado());
            throw new InternalServerException("Error al actualizar ganado con id:" + ganadoDTO.getIdGanado());
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateGanadoDetalle(GanadoDetalleDTO ganadoDetalleDTO) {
        
        if (ganadoDetalleDTO.getNombreDispositivo() != null) {
            CatDispositivoDTO objetoDispositivo = this.ganadoMapper.validarDispositivoActivo(ganadoDetalleDTO.getNombreDispositivo());

            if (objetoValido(objetoDispositivo)) {
                this.log.error("Es dispositivo ya esta e uso");
                throw new ConflictException("1");
            } else {
                CatDispositivoDTO dispositivo = this.ganadoMapper.getDispositivo(ganadoDetalleDTO.getNombreDispositivo());
                if (objetoValido(dispositivo)) {
                    ganadoDetalleDTO.setIdDispositivo(dispositivo.getIdDispositivo());
                    GanadoDetalleDTO objeto = this.ganadoMapper.validarCompra(ganadoDetalleDTO.getIdGanado());
                    if (objetoValido(objeto)) {
                        this.ganadoMapper.updateGanadoDetalle(ganadoDetalleDTO);
                        this.ganadoMapper.deleteGanadoCompra(objeto.getIdCompraGanado());
                        this.ganadoMapper.updateCatDispositivo(dispositivo.getIdDispositivo());
                        return true;
                    } else {
                        this.ganadoMapper.updateGanadoDetalle(ganadoDetalleDTO);
                        this.ganadoMapper.updateCatDispositivo(dispositivo.getIdDispositivo());
                        return true;
                    }

                } else {
                    this.log.error("No hay dispositivo con esa serie");
                    throw new ConflictException("2");
                }
            }
        } else {
            GanadoDetalleDTO objeto = this.ganadoMapper.validarCompra(ganadoDetalleDTO.getIdGanado());
            if (objetoValido(objeto)) {
                this.ganadoMapper.updateGanadoDetalle(ganadoDetalleDTO);
                this.ganadoMapper.deleteGanadoCompra(objeto.getIdCompraGanado());
                return true;
            } else {
                this.ganadoMapper.updateGanadoDetalle(ganadoDetalleDTO);
                return true;
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateGanadoCompra(ComprasGanadoDTO comprasGanadoDTO) {
        try {
            GanadoDetalleDTO objeto = this.ganadoMapper.validarRegistroEnCompra(comprasGanadoDTO.getIdGanado());
            if (objetoValido(objeto)) {
                this.ganadoMapper.updateGanadoCompra(comprasGanadoDTO);
                return true;
            } else {
                this.ganadoMapper.insertGanadoCompras(comprasGanadoDTO);
                return true;
            }
        } catch (Exception e) {
            this.log.error(e.getMessage());
            this.log.error("Error al actualizar ganado_compra con id:" + comprasGanadoDTO.getIdGanado());
            throw new InternalServerException("Error al actualizar ganado_compra con id:" + comprasGanadoDTO.getIdGanado());
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public GanadoDTO insertGanado(GanadoDTO ganadoDTO) {
        
        try {
            if (ganadoDTO.getDispositivo() != null) {
                CatDispositivoDTO objeto = this.ganadoMapper.validarDispositivoActivo(ganadoDTO.getDispositivo());

                if (objetoValido(objeto)) {
                    this.log.error("Es dispositivo ya esta e uso");
                    throw new ConflictException("1");
                } else {
                    CatDispositivoDTO dispositivo = this.ganadoMapper.getDispositivo(ganadoDTO.getDispositivo());
                    if (objetoValido(dispositivo)) {
                        ganadoDTO.setIdDispositivo(dispositivo.getIdDispositivo());
                        this.ganadoMapper.insertGanado(ganadoDTO);
                        this.ganadoMapper.updateCatDispositivo(dispositivo.getIdDispositivo());
                        return this.getGanadoById(ganadoDTO.getIdGanado());
                    } else {
                        this.log.error("No hay dispositivo con esa serie");
                        throw new ConflictException("2");
                    }
                }
            } else {
                this.ganadoMapper.insertGanado(ganadoDTO);
                return this.getGanadoById(ganadoDTO.getIdGanado());
            }

        } catch (ConflictException e) {
            e.getMessage();
            this.log.error("Error al insertar ganado" + e.getMessage());
            throw new ConflictException("Error al insertar ganado " + e.getMessage());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean insertGanadoCompras(ComprasGanadoDTO comprasGanadoDTO) {
        try {
            return this.ganadoMapper.insertGanadoCompras(comprasGanadoDTO);
        } catch (Exception e) {
            this.log.error("Error al insertar  compras ganado" + e.getMessage());
            throw new InternalServerException("Error al insertar compras ganado");
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteGanado(Integer idGanado) {
        try {
            return this.ganadoMapper.deleteGanado(idGanado);
        } catch (Exception e) {
            this.log.error("Error al eliminar ganado");
            throw new InternalServerException("Error al eliminar ganado");
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteGanadoCompra(Integer idCompraGanado) {
        try {
            return this.ganadoMapper.deleteGanadoCompra(idCompraGanado);
        } catch (Exception e) {
            this.log.error("Error al eliminar compra ganado");
            throw new InternalServerException("Error al eliminar compra ganado");
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteGanadoDetalle(Integer idGanado) {
        try {
            return this.ganadoMapper.deleteGanadoDetalle(idGanado);
        } catch (Exception e) {
            this.log.error("Error al eliminar ganado detalle");
            throw new InternalServerException("Error al eliminar ganado detalle");
        }

    }

    @Override
    public List<GanadoDTO> obtenerInfoMadre(Integer idUsuario) {
        List<GanadoDTO> list = this.ganadoMapper.obtenerInfoMadre(idUsuario);
        if (listaValida(list)) {
            return list;
        }
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }

    @Override
    public List<GanadoDTO> obtenerInfoPadre(Integer idUsuario) {
        List<GanadoDTO> list = this.ganadoMapper.obtenerInfoPadre(idUsuario);
        if (listaValida(list)) {
            return list;
        }
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }

    @Override
    public List<GanadoDetalleDTO> obtenerGanadoDetalle(Integer idUsuario) {
        List<GanadoDetalleDTO> list = this.ganadoMapper.obtenerGanadoDetalle(idUsuario);
        if (listaValida(list)) {
            return list;
        }
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }

    @Override
    public List<GanadoDetalleDTO> paginadorGanadoDetalle(ParametrosDTO parametrosDTO) {
        List<GanadoDetalleDTO> list = this.ganadoMapper.paginadorGanadoDetalle(parametrosDTO);
        if (listaValida(list)) {
            return list;
        }
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }
    
    @Override
    public List<VacunaDTO> obtenerVacuna(Integer idGanado) {
        List<VacunaDTO> list = this.ganadoMapper.obtenerVacuna(idGanado);
        if (listaValida(list)) {
            return list;
        }
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }
    
    @Override
    public List<VacunaDTO> paginadorVacuna(ParametrosDTO parametrosDTO) {
        List<VacunaDTO> list = this.ganadoMapper.paginadorVacuna(parametrosDTO);
        if (listaValida(list)) {
            return list;
        }
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean insertVacuna(VacunaDTO vacunaDTO) {
        try {
            return this.ganadoMapper.insertVacuna(vacunaDTO);
        } catch (Exception e) {
            this.log.error("Error al insertar  vacunas ganado" + e.getMessage());
            throw new InternalServerException("Error al insertar vacunas ganado");
        }
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteVacunaGanado(Integer idVacuna) {
        try {
            return this.ganadoMapper.deleteVacunaGanado(idVacuna);
        } catch (Exception e) {
            this.log.error("Error al eliminar vacuna del ganado");
            throw new InternalServerException("Error al eliminar vacuna del ganado");
        }

    }
    
    @Override
    public List<VacunaDTO> obtenerCatalogoVacuna(Integer idGanado) {
        List<VacunaDTO> list = this.ganadoMapper.obtenerCatalogoVacuna(idGanado);
        if (listaValida(list)) {
            return list;
        }
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }
    
    @Override
    public List<ProduccionGanadoDTO> obtenerProduccionGanado(Integer idGanado) {
        List<ProduccionGanadoDTO> list = this.ganadoMapper.obtenerProduccionGanado(idGanado);
        if (listaValida(list)) {
            return list;
        }
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }
    
    @Override
    public List<ProduccionGanadoDTO> paginadorProduccionGanado(ParametrosDTO parametrosDTO) {
        List<ProduccionGanadoDTO> list = this.ganadoMapper.paginadorProduccionGanado(parametrosDTO);
        if (listaValida(list)) {
            return list;
        }
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean insertProduccionGanado(ProduccionGanadoDTO produccionGanadoDTO) {
        try {
            return this.ganadoMapper.insertProduccionGanado(produccionGanadoDTO);
        } catch (Exception e) {
            this.log.error("Error al insertar  produccion ganado" + e.getMessage());
            throw new InternalServerException("Error al insertar produccion ganado");
        }
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteProduccionGanado(Integer idProduccionGanado) {
        try {
            return this.ganadoMapper.deleteProduccionGanado(idProduccionGanado);
        } catch (Exception e) {
            this.log.error("Error al eliminar produccion del ganado");
            throw new InternalServerException("Error al eliminar produccion del ganado");
        }

    }
    
    @Override
    public List<ReproduccionGanadoDTO> obtenerReproduccionGanado(Integer idGanado) {
        List<ReproduccionGanadoDTO> list = this.ganadoMapper.obtenerReproduccionGanado(idGanado);
        if (listaValida(list)) {
            return list;
        }
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }
    
    @Override
    public List<ReproduccionGanadoDTO> paginadorReproduccionGanado(ParametrosDTO parametrosDTO) {
        List<ReproduccionGanadoDTO> list = this.ganadoMapper.paginadorReproduccionGanado(parametrosDTO);
        if (listaValida(list)) {
            return list;
        }
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean insertReproduccionGanado(ReproduccionGanadoDTO reproduccionGanadoDTO) {
        try {
            return this.ganadoMapper.insertReproduccionGanado(reproduccionGanadoDTO);
        } catch (Exception e) {
            this.log.error("Error al insertar  produccion ganado" + e.getMessage());
            throw new InternalServerException("Error al insertar produccion ganado");
        }
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteReproduccionGanado(Integer idReproduccionGanado) {
        try {
            return this.ganadoMapper.deleteReproduccionGanado(idReproduccionGanado);
        } catch (Exception e) {
            this.log.error("Error al eliminar produccion del ganado");
            throw new InternalServerException("Error al eliminar produccion del ganado");
        }

    }
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateFecundacionReproduccionGanado(ReproduccionGanadoDTO reproduccionGanadoDTO) {
        try {
            return this.ganadoMapper.updateFecundacionReproduccionGanado(reproduccionGanadoDTO);
        } catch (Exception e) {
            this.log.error("Error al actualizar reproducción ganado id:" + reproduccionGanadoDTO.getIdReproduccionGanado());
            throw new InternalServerException("Error al actualizar reproducción ganado id:" + reproduccionGanadoDTO.getIdReproduccionGanado());
        }

    }
    
    @Override
    public List<SeguimientoReproduccionGanadoDTO> obtenerSeguimientoReproduccionGanado(Integer idReproduccionGanado) {
        List<SeguimientoReproduccionGanadoDTO> list = this.ganadoMapper.obtenerSeguimientoReproduccionGanado(idReproduccionGanado);
        if (listaValida(list)) {
            return list;
        }
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }
    
    @Override
    public List<SeguimientoReproduccionGanadoDTO> paginadorSeguimientoReproduccionGanado(ParametrosDTO parametrosDTO) {
        List<SeguimientoReproduccionGanadoDTO> list = this.ganadoMapper.paginadorSeguimientoReproduccionGanado(parametrosDTO);
        if (listaValida(list)) {
            return list;
        }
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean insertSeguimientoReproduccionGanado(SeguimientoReproduccionGanadoDTO seguimientoReproduccionGanadoDTO) {
        try {
            return this.ganadoMapper.insertSeguimientoReproduccionGanado(seguimientoReproduccionGanadoDTO);
        } catch (Exception e) {
            this.log.error("Error al insertar seguimiento reproduccion ganado" + e.getMessage());
            throw new InternalServerException("Error al insertar seguimiento reproduccion ganado");
        }
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteSeguimientoReproduccionGanado(Integer idSeguimientoReproduccionGanado) {
        try {
            return this.ganadoMapper.deleteSeguimientoReproduccionGanado(idSeguimientoReproduccionGanado);
        } catch (Exception e) {
            this.log.error("Error al eliminar seguimiento reproduccion del ganado");
            throw new InternalServerException("Error al eliminar seguimiento reproduccion del ganado");
        }

    }
    
    @Override
    public List<ReproduccionGanadoDTO> getReproduccionGanadoByParams(ReproduccionGanadoDTO reproduccionGanadoDTO) {
        List<ReproduccionGanadoDTO> list = this.ganadoMapper.getReproduccionGanadoByParams(reproduccionGanadoDTO);
        if (listaValida(list)) {
            return list;
        }
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }
    
    @Override
    public List<PartoGanadoDTO> obtenerPartoGanado(Integer idGanado) {
        List<PartoGanadoDTO> list = this.ganadoMapper.obtenerPartoGanado(idGanado);
        if (listaValida(list)) {
            return list;
        }
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean insertPartoGanado(PartoGanadoDTO partoGanadoDTO) {
        try {
            return this.ganadoMapper.insertPartoGanado(partoGanadoDTO);
        } catch (Exception e) {
            this.log.error("Error al insertar parto ganado" + e.getMessage());
            throw new InternalServerException("Error al insertar parto ganado");
        }

    }
    
    @Override
    public List<PartoGanadoDTO> paginadorPartoGanado(ParametrosDTO parametrosDTO) {
        List<PartoGanadoDTO> list = this.ganadoMapper.paginadorPartoGanado(parametrosDTO);
        if (listaValida(list)) {
            return list;
        }
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }
    
}
