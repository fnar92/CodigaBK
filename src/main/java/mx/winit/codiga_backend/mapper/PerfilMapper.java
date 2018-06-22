/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.winit.codiga_backend.mapper;

import java.util.List;
import mx.winit.codiga_backend.model.Perfil;
import mx.winit.codiga_backend.model.UsuarioPerfilDTO;

/**
 *
 * @author Cliente
 */
public interface PerfilMapper {
    List<Perfil> getPerfilByIdUsuario(Integer idUsuario);
    Boolean insertPerfilUsuario(UsuarioPerfilDTO usuarioPerfilDTO);
}
