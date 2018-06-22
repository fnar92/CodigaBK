/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.winit.codiga_backend.mapper;

import java.util.List;
import mx.winit.codiga_backend.model.CatEstatusGanadoDTO;
import mx.winit.codiga_backend.model.CatRazaDTO;
import mx.winit.codiga_backend.model.CatTipoGanadoDTO;

/**
 *
 * @author Cliente
 */
public interface CatalogoMapper {
    List<CatRazaDTO> getCatalogoRazas();
    List<CatEstatusGanadoDTO> getCatalogoEstatusGanado();
    List<CatTipoGanadoDTO> getCatalogoTipoGanado();
}
