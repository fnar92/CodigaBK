/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.winit.codiga_backend.rest;


import java.util.List;
import mx.winit.codiga_backend.model.MensajeDTO;
import mx.winit.codiga_backend.model.OnlineUserDTO;
import mx.winit.codiga_backend.model.UsuarioDTO;
import mx.winit.codiga_backend.service.UsuarioService;
import mx.winit.codiga_backend.util.GenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Cliente
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioRestService extends GenericService{
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private UsuarioService usuarioService;
    
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public UsuarioDTO getUsuarioBy(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "idUsuario", required = false) Integer idUsario
    ){
        UsuarioDTO usuarioDTO=new UsuarioDTO();
        usuarioDTO.setUsuario(username);
        usuarioDTO.setIdUsuario(idUsario);
        return this.usuarioService.getUsuarioBy(usuarioDTO);
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public UsuarioDTO insertUsuario(@RequestBody UsuarioDTO usuarioDTO){
        return this.usuarioService.insertUsuario(usuarioDTO);
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public UsuarioDTO updateUsuarioInfo(@RequestBody UsuarioDTO usuarioDTO){
        return this.usuarioService.updateUsuarioInfo(usuarioDTO);
    }
    
    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean resetPassword(@RequestBody ResetPW resetPW){
        return this.usuarioService.resetPassword(resetPW.getCorreo());
    }
    
    @RequestMapping(value = "/activarCuenta", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean activarCuenta(@RequestBody Token token){
        return this.usuarioService.activarCuenta(token.getToken());
    }
    
    @RequestMapping(value = "/onlineUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OnlineUserDTO> onli(){
        return this.usuarioService.getUsuariosOnline();
    }
    
    @RequestMapping(value = "/onlineUsers/mensajes/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MensajeDTO> men(@PathVariable("username") String username){
        return this.usuarioService.getMensajesUsuario(username);
    }
    
    /*DTOS personalizados solo para obtener json especifico*/
    public static class ResetPW{
        private String correo;

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }
    }
    
    public static class Token{
        private String token;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
        
    }
    
}
