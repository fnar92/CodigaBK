/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.winit.codiga_backend.service.impl;

import java.util.ArrayList;
import java.util.List;
import mx.winit.codiga_backend.configuration.Email;
import mx.winit.codiga_backend.model.EmailDTO;
import mx.winit.codiga_backend.service.EmailService;
import mx.winit.codiga_backend.util.GenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cliente
 */
@Service
public class EmailServiceImpl extends GenericService implements EmailService{
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private Email email;

    @Value("${mail.app}")
    private String APP;
    
    @Value("${mail.email_dev}")
    private String EMAIL_DEV;
    
    @Override
    public Boolean sendMail(EmailDTO emailDTO) {
        String toNames="";
        String coNames="";
        String cooNames="";
        if( this.APP.equals("qa") || this.APP.equals("pre") || this.APP.equals("dev") ){
            //Destinatarios
            for (String to : emailDTO.getTo()) {
                toNames+=""+to+"<br>";
            }
            //Destinatarios co
            for (String to : emailDTO.getConCopia()) {
                coNames+=""+to+"<br>";
            }
            //Destinatarios coc
            for (String to : emailDTO.getConCopiaOculta()) {
                cooNames+=""+to+"<br>";
            }

            //Settear de nuevo
            List<String> to=new ArrayList<>();
            to.add(this.EMAIL_DEV);
            emailDTO.setTo(to);
            emailDTO.setConCopia(null);
            emailDTO.setConCopiaOculta(null);

            String htmlOriginal=emailDTO.getMsj();
            String ley="Este es un correo de prueba, NO TIENE VALIDEZ OFICIAL.";
            htmlOriginal+="<br><br><br><strong>"+ley+"</strong><br><br><hr><h4>Destinatarios:</h4>"+toNames;
            htmlOriginal+="<h4>Con copia:</h4>"+coNames;
            htmlOriginal+="<h4>COO:</h4>"+cooNames;
            String estilo="<div style=\"font-family: Arial; font-size:12px\">";
            emailDTO.setMsj(estilo+htmlOriginal+"</div>");
        }
        return this.email.sendMail(emailDTO);
    }

}