/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.winit.codiga_backend.mapper;

import java.util.List;
import mx.winit.codiga_backend.model.LimiteDTO;

/**
 *
 * @author Cliente
 */
public interface LimiteMapper {

    List<LimiteDTO> getLimiteByIdUsuario(Integer idUsuario);
    public Boolean deleteLimite(Integer idUsuario);
    public Boolean insertLimite(List<LimiteDTO> limites);
}
