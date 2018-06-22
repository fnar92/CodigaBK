/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.winit.codiga_backend.rest;

import mx.winit.codiga_backend.util.GenericService;
import java.util.List;
import mx.winit.codiga_backend.model.CatEstatusGanadoDTO;
import mx.winit.codiga_backend.model.CatRazaDTO;
import mx.winit.codiga_backend.model.CatTipoGanadoDTO;
import mx.winit.codiga_backend.service.CatalogoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author francisco.acevedo
 */
@RestController
@RequestMapping("/catalogo")
public class CatalogoRestService extends GenericService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CatalogoService catalogoService;

    @RequestMapping(value = "/razas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CatRazaDTO> razas() {
        return this.catalogoService.getCatalogoRazas();
    }
    
    @RequestMapping(value = "/estatusGanado", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CatEstatusGanadoDTO> estatusGanado() {
        return this.catalogoService.getCatalogoEstatusGanado();
    }
    
    @RequestMapping(value = "/tipoGanado", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CatTipoGanadoDTO> tipoGanado() {
        return this.catalogoService.getCatalogoTipoGanado();
    }
    

}
