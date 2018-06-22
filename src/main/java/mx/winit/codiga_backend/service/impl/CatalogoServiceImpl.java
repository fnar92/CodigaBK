/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.winit.codiga_backend.service.impl;

import java.util.List;
import mx.winit.codiga_backend.exception.NoContentException;
import mx.winit.codiga_backend.mapper.CatalogoMapper;
import mx.winit.codiga_backend.model.CatEstatusGanadoDTO;
import mx.winit.codiga_backend.model.CatRazaDTO;
import mx.winit.codiga_backend.model.CatTipoGanadoDTO;
import mx.winit.codiga_backend.service.CatalogoService;
import mx.winit.codiga_backend.util.GenericService;
import mx.winit.codiga_backend.util.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cliente
 */
@Service
public class CatalogoServiceImpl extends GenericService implements CatalogoService{
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private CatalogoMapper catalogoMapper;
   
    @Override
    public List<CatRazaDTO> getCatalogoRazas() {
        List<CatRazaDTO> list = this.catalogoMapper.getCatalogoRazas();
        if(listaValida(list)){return list;}
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }
    
    @Override
    public List<CatEstatusGanadoDTO> getCatalogoEstatusGanado() {
        List<CatEstatusGanadoDTO> list = this.catalogoMapper.getCatalogoEstatusGanado();
        if(listaValida(list)){return list;}
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }
    
    @Override
    public List<CatTipoGanadoDTO> getCatalogoTipoGanado() {
        List<CatTipoGanadoDTO> list = this.catalogoMapper.getCatalogoTipoGanado();
        if(listaValida(list)){return list;}
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }

}