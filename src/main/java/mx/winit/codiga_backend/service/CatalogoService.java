/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.winit.codiga_backend.service;


import java.util.List;
import mx.winit.codiga_backend.model.CatEstatusGanadoDTO;
import mx.winit.codiga_backend.model.CatRazaDTO;
import mx.winit.codiga_backend.model.CatTipoGanadoDTO;

/**
 *
 * @author francisco.acevedo
 */
public interface CatalogoService {
    public List<CatRazaDTO> getCatalogoRazas();
    public List<CatEstatusGanadoDTO> getCatalogoEstatusGanado();
    public List<CatTipoGanadoDTO> getCatalogoTipoGanado();
} 
