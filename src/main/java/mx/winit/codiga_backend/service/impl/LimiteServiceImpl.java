/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.winit.codiga_backend.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mx.winit.codiga_backend.exception.InternalServerException;
import mx.winit.codiga_backend.exception.NoContentException;
import mx.winit.codiga_backend.mapper.LimiteMapper;
import mx.winit.codiga_backend.model.LimiteDTO;
import mx.winit.codiga_backend.service.LimiteService;
import mx.winit.codiga_backend.util.GenericService;
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
public class LimiteServiceImpl extends GenericService implements LimiteService{
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private LimiteMapper limiteMapper;

    @Override
    public List<LimiteDTO> getLimiteByIdUsuario(Integer idUsuario) {
        List<LimiteDTO> list = this.limiteMapper.getLimiteByIdUsuario(idUsuario);
        if(listaValida(list)){return list;}
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteLimite(Integer idUsuario) {
        try {
            return this.limiteMapper.deleteLimite(idUsuario);
        } catch (Exception e) {
            this.log.error("Error al eliminar limite");
            throw new InternalServerException("Error al eliminar limite");
        }
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean insertLimite(List<LimiteDTO> limites) {
        try {
            this.limiteMapper.deleteLimite(limites.get(0).getIdUsuario());
            return this.limiteMapper.insertLimite(limites);
        } catch (Exception e) {
            this.log.error("Error al insertar limite"+e.getMessage());
            throw new InternalServerException("Error al insertar limite");
        }
        
    }
}