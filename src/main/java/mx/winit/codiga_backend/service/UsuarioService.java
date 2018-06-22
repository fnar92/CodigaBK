/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.winit.codiga_backend.service;


import mx.winit.codiga_backend.model.UsuarioDTO;
import java.util.List;
import mx.winit.codiga_backend.model.MensajeDTO;
import mx.winit.codiga_backend.model.OnlineUserDTO;

/**
 *
 * @author Cliente
 */
public interface UsuarioService {
    UsuarioDTO getUsuarioBy(UsuarioDTO usuarioDTO);
    UsuarioDTO insertUsuario(UsuarioDTO usuarioDTO);
    UsuarioDTO updateUsuarioInfo(UsuarioDTO usuarioDTO);
    List<UsuarioDTO>getUsuarioAll();
    Boolean resetPassword(String correo);
    Boolean activarCuenta(String token);
    List<OnlineUserDTO> getUsuariosOnline();
    List<MensajeDTO> getMensajesUsuario(String username);
    Boolean addMsj(MensajeDTO mensajeDTO);
}
