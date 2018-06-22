
package mx.winit.codiga_backend.tasks;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import mx.winit.codiga_backend.mapper.UsuarioMapper;
import mx.winit.codiga_backend.model.MensajeDTO;
import mx.winit.codiga_backend.model.OnlineUserDTO;
import mx.winit.codiga_backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class Task{
    
    @Autowired
    private UsuarioService usuarioService;
   
    @Autowired
    private UsuarioMapper usuarioMapper;
    
    @Scheduled(cron = "*/5 * * * * *")//each 10 seg
    public void cronTest() throws IOException{
        List<OnlineUserDTO> users=this.usuarioService.getUsuariosOnline();
        
        for (OnlineUserDTO user : users) {
            
            List<MensajeDTO> list = this.usuarioMapper.getMensajesUsuario(user.getUsername());
            if(list.size()>10){
                this.usuarioMapper.deleteMensajesUsuario(user.getUsername());
            }
            MensajeDTO mensajeDTO=new MensajeDTO();
            mensajeDTO.setUsername(user.getUsername());
            mensajeDTO.setMensaje("Mensaje "+new Date());
            this.usuarioService.addMsj(mensajeDTO);
        }
    }
    
}