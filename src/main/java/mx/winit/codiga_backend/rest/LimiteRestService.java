/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.winit.codiga_backend.rest;

import mx.winit.codiga_backend.util.GenericService;
import java.util.List;
import mx.winit.codiga_backend.model.LimiteDTO;
import mx.winit.codiga_backend.service.GanadoService;
import mx.winit.codiga_backend.service.LimiteService;
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
@RequestMapping("/limite")
public class LimiteRestService extends GenericService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LimiteService limiteService;
    
    @RequestMapping(value = "/{idUsuario}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LimiteDTO> getLimiteByIdUsuario(@PathVariable("idUsuario") Integer idUsuario) {
        return this.limiteService.getLimiteByIdUsuario(idUsuario);
    }
    
//        @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
//    //@ResponseStatus(HttpStatus.OK)
//    public Boolean getGanadoPut(@RequestBody GanadoDTO ganadoDTO) throws Exception {
//        return this.ganadoService.updateGanado(ganadoDTO);
//    }
    
    @RequestMapping(value = "/{idUsuario}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean limiteDelete(@PathVariable("idUsuario") Integer idUsuario) {
        return this.limiteService.deleteLimite(idUsuario);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean saveLimite(@RequestBody List<LimiteDTO> limiteDTO) {
        for (LimiteDTO objeto : limiteDTO) {
            log.debug("--"+objeto.getLatitud()+"--"+objeto.getLongitud()+"--"+objeto.getIdUsuario());
        }
        return this.limiteService.insertLimite(limiteDTO);
    }
    
//    @RequestMapping(value = "/params", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<GanadoDTO> getGanadoByParams(
//            @RequestParam(value = "nombre", required = false) String nombre,
//            @RequestParam(value = "idGanado", required = false) Integer idGanado
//    ) {
//        GanadoDTO ganadoDTO = new GanadoDTO();
//        ganadoDTO.setNombre(nombre);
//        ganadoDTO.setIdGanado(idGanado);
//        return this.ganadoService.getGanadoByParams(ganadoDTO);
//    }
//

//
//    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//    public Boolean postGanado(@RequestBody GanadoDTO ganadoDTO) {
//        return this.ganadoService.insertGanado(ganadoDTO);
//    }
//    
//    @RequestMapping(value = "/{idGanado}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public Boolean ganadoDelete(@PathVariable("idGanado") Integer idGanado) {
//        return this.ganadoService.deleteGanado(idGanado);
//    }

}
