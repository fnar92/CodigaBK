/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.winit.codiga_backend.mapper;

import java.util.List;
import mx.winit.codiga_backend.model.MensajeDTO;
import mx.winit.codiga_backend.model.OnlineUserDTO;
import mx.winit.codiga_backend.model.UsuarioDTO;
import mx.winit.codiga_backend.model.UsuarioDetalleDTO;

/**
 *
 * @author Cliente
 */
public interface UsuarioMapper {
    UsuarioDTO getUsuarioBy(UsuarioDTO usuarioDTO);
    Boolean updateUsuarioInfo(UsuarioDTO usuarioDTO);
    Boolean updateUserData(UsuarioDTO usuarioDTO);
    void insertUsuario(UsuarioDTO usuarioDTO);
    void insertUsuarioDetalle(UsuarioDetalleDTO usuarioDetalleDTO);
    UsuarioDTO getUsuarioByCorreo(String correo);
    Boolean updateUserPassword(UsuarioDTO usuarioDTO);
    Boolean activarCuenta(String token);
    List<OnlineUserDTO> getUsuariosOnline();
    List<MensajeDTO> getMensajesUsuario(String username);
    Boolean addMsj(MensajeDTO mensajeDTO);
    Boolean deleteMensajesUsuario(String username);
}
