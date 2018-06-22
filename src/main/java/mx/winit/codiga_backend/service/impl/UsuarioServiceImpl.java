/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.winit.codiga_backend.service.impl;

import java.util.ArrayList;
import mx.winit.codiga_backend.exception.NoContentException;
import mx.winit.codiga_backend.model.Perfil;
import mx.winit.codiga_backend.model.Role;
import mx.winit.codiga_backend.model.User;
import mx.winit.codiga_backend.model.UsuarioDTO;

import mx.winit.codiga_backend.util.Constant;
import java.util.List;
import java.util.UUID;
import mx.winit.codiga_backend.exception.InternalServerException;
import mx.winit.codiga_backend.mapper.UsuarioMapper;
import mx.winit.codiga_backend.util.GenericService;
import mx.winit.codiga_backend.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.winit.codiga_backend.mapper.PerfilMapper;
import mx.winit.codiga_backend.model.EmailDTO;
import mx.winit.codiga_backend.model.MensajeDTO;
import mx.winit.codiga_backend.model.OnlineUserDTO;
import mx.winit.codiga_backend.model.UsuarioDetalleDTO;
import mx.winit.codiga_backend.model.UsuarioPerfilDTO;
import mx.winit.codiga_backend.service.EmailService;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author Cliente
 */
@Service("userDetailsServiceImpl")
public class UsuarioServiceImpl extends GenericService implements UserDetailsService, UsuarioService{
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Value("${email.username}")
    private String EMAIL_USERNAME;
    
    @Value("${app.path_frontend}")
    private String APP_PATH_FRONTEND;
    
    @Autowired
    private UsuarioMapper usuarioMapper;
    
    @Autowired
    private PerfilMapper perfilMapper;
    
    @Autowired
    private EmailService emailService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = new User();
        UsuarioDTO usuarioDTO=new UsuarioDTO();
        usuarioDTO.setUsuario(username);
        user.setUsuario(usuarioMapper.getUsuarioBy(usuarioDTO));
        List<Perfil> roles = perfilMapper.getPerfilByIdUsuario(user.getUsuario().getIdUsuario());
        roles.stream().forEach(p -> {
            Role r =  new Role();
            r.setName(p.getTarjet());
            user.getAuthorities().add(r);
        });
        return user;
    }
    
    @Override
    @Transactional(readOnly = true)
    public UsuarioDTO getUsuarioBy(UsuarioDTO usuarioDTO) {
        UsuarioDTO user = this.usuarioMapper.getUsuarioBy(usuarioDTO);
        if(objetoValido(user)){ return user;}
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public UsuarioDTO insertUsuario(UsuarioDTO usuarioDTO) {
        try {
            String token=getToken();
            usuarioDTO.setPassword(this.passwordEncoder().encode(usuarioDTO.getPassword()));
            usuarioDTO.setTokenActivate(token);
            this.usuarioMapper.insertUsuario(usuarioDTO);
            Thread.sleep(500);
            UsuarioDetalleDTO usuarioDetalleDTO=usuarioDTO.getUsuarioDetalle();
            usuarioDetalleDTO.setIdUsuario(usuarioDTO.getIdUsuario());
            this.usuarioMapper.insertUsuarioDetalle(usuarioDetalleDTO);
            Thread.sleep(500);
            UsuarioPerfilDTO usuarioPerfilDTO=new UsuarioPerfilDTO();
            usuarioPerfilDTO.setIdUsuario(usuarioDTO.getIdUsuario());
            usuarioPerfilDTO.setIdPerfil(2);//ROLE_USER;
            if(this.perfilMapper.insertPerfilUsuario(usuarioPerfilDTO)){
                usuarioDTO.setUsuarioDetalle(usuarioDetalleDTO);
                EmailDTO emailDTO=new EmailDTO();
                String asunto="Registro en Codiga2.0";
                emailDTO.setSubject(asunto);
                String url=APP_PATH_FRONTEND+"/auth/activate/"+token;
                String mensaje="Bienvenido a Codiga2.0:  <br>"
                        + "<p>Para activar su cuenta de clic en el siguiente en el siguiente enlace: <br><br><a href='"+url+"'><strong>"+url+"</strong></a></p>";
                emailDTO.setMsj(mensaje);
                emailDTO.setConCopia(new ArrayList<>());
                List<String> to=new ArrayList<>();
                List<String> cco=new ArrayList<>();
                to.add(usuarioDTO.getUsuarioDetalle().getCorreo());
                cco.add(EMAIL_USERNAME);
                emailDTO.setTo(to);
                emailDTO.setConCopiaOculta(cco);
                this.emailService.sendMail(emailDTO);
                return usuarioDTO;
            }
        } catch (InterruptedException e) {
            this.log.error("Error al insertar usuario"+e.getMessage());
            throw new InternalServerException("Error al insertar usuario");
        }
        return null;
        
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public UsuarioDTO updateUsuarioInfo(UsuarioDTO usuarioDTO) {
        try {
            this.usuarioMapper.updateUsuarioInfo(usuarioDTO);
            this.usuarioMapper.updateUserData(usuarioDTO);
            return this.getUsuarioBy(usuarioDTO);
        } catch (Exception e) {
            this.log.error("Error al actualizar usuario"+e.getMessage());
            throw new InternalServerException("Error al actualizar usuario");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioDTO> getUsuarioAll() {
       List<UsuarioDTO> userList =  null;//this.usuarioMapper.getUsuarioAll();
       if(listaValida(userList)) { return userList;}
       throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean resetPassword(String correo) {
        try {
            String passRandom = RandomStringUtils.randomAlphabetic(10);
            log.debug(passRandom);
            UsuarioDTO usuarioDTO=this.usuarioMapper.getUsuarioByCorreo(correo);
            if(objetoValido(usuarioDTO)){
                usuarioDTO.setPassword(this.passwordEncoder().encode(passRandom));
                this.usuarioMapper.updateUserPassword(usuarioDTO);
                EmailDTO emailDTO=new EmailDTO();
                String asunto="Recuperación de contraseña Codiga2.0";
                emailDTO.setSubject(asunto);
                String mensaje="Se envia sus nuevos datos de acceso: <br>"
                        + "<p>Usuario: <strong>"+usuarioDTO.getUsuario()+"</strong></p>"
                        + "<p>Constraseña: <strong>"+passRandom+"</strong></p>"
                        + "<br>"
                        + "<p>Acceso: <a href='"+APP_PATH_FRONTEND+"'><strong>"+APP_PATH_FRONTEND+"</strong></a></p>";
                emailDTO.setMsj(mensaje);
                emailDTO.setConCopia(new ArrayList<>());
                List<String> to=new ArrayList<>();
                List<String> cco=new ArrayList<>();
                to.add(usuarioDTO.getUsuarioDetalle().getCorreo());
                cco.add(EMAIL_USERNAME);
                emailDTO.setTo(to);
                emailDTO.setConCopiaOculta(cco);
                this.emailService.sendMail(emailDTO);
            }else{
                throw new NoContentException("Correo no existente");
            }
        } catch (Exception e) {
            this.log.error("Error al recuperar contraseña"+e.getMessage());
            throw new InternalServerException("Error al recuperar contraseña");
        }
        return null;
        
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean activarCuenta(String token) {
        try {
            Thread.sleep(5000);
            return this.usuarioMapper.activarCuenta(token);
        } catch (Exception e) {
            this.log.error("Error al activar cuenta"+e.getMessage());
            throw new InternalServerException("Error al activar cuenta");
        }
    }
    
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    public static String getToken(){
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OnlineUserDTO> getUsuariosOnline() {
       List<OnlineUserDTO> userList = this.usuarioMapper.getUsuariosOnline();
       if(listaValida(userList)) { return userList;}
       throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MensajeDTO> getMensajesUsuario(String username) {
       List<MensajeDTO> list = this.usuarioMapper.getMensajesUsuario(username);
       return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean addMsj(MensajeDTO mensajeDTO) {
        try {
            return this.usuarioMapper.addMsj(mensajeDTO);
        } catch (Exception e) {
            this.log.error(e.getMessage());
            throw new InternalServerException("Error");
        }
    }
}