
package mx.winit.codiga_backend.model;

import java.io.Serializable;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author francisco.acevedo
 */
public class EmailDTO implements Serializable{
    private Integer idApp;
    private String user;
    private String pass;
    private String from;
    private List <String> to;
    private List <String> conCopia;
    private List <String> conCopiaOculta;
    private String subject;
    private String msj;
    private List<MultipartFile> files;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public Integer getIdApp() {
        return idApp;
    }

    public void setIdApp(Integer idApp) {
        this.idApp = idApp;
    }
    
    public List<MultipartFile> getFiles() {
        return files;
    }

    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }
    
    public EmailDTO(){}
    
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public List<String> getTo() {
        return to;
    }

    public void setTo(List<String> to) {
        this.to = to;
    }

    public List<String> getConCopia() {
        return conCopia;
    }

    public void setConCopia(List<String> conCopia) {
        this.conCopia = conCopia;
    }

    public List<String> getConCopiaOculta() {
        return conCopiaOculta;
    }

    public void setConCopiaOculta(List<String> conCopiaOculta) {
        this.conCopiaOculta = conCopiaOculta;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMsj() {
        return msj;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }
    
}
