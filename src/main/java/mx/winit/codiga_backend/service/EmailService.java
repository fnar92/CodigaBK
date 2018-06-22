/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.winit.codiga_backend.service;


import mx.winit.codiga_backend.model.EmailDTO;

/**
 *
 * @author francisco.acevedo
 */
public interface EmailService {
    public Boolean sendMail(EmailDTO emailDTO);
    
}
