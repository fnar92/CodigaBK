package mx.winit.codiga_backend.configuration;

/**
 *
 * @author francisco.acevedo
 */
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.MimeMessage;
import mx.winit.codiga_backend.model.EmailDTO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class Email {

    @Value("${email.host}")
    private String HOST;

    @Value("${email.port}")
    private Integer PORT;

    @Value("${email.smtp.auth}")
    private String MAIL_STMP_AUTH;

    @Value("${email.smtp.starttls.enable}")
    private String MAIL_STMP_STARTTLS_ENABLED;

    @Value("${email.smtp.debug}")
    private String MAIL_DEBUG;

    @Value("${email.smtp.ssl.trust}")
    private String MAIL_STMP_SSL_TRUST;
    
    @Value("${email.username}")
    private String EMAIL_USERNAME;
    
    @Value("${email.password}")
    private String EMAIL_PASSWORD;

    private JavaMailSender mailSender;

    /*public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }*/
    
    public void setMailSender(EmailDTO emailDTO) {
        mailSender = this.set(emailDTO);
    }

    public JavaMailSender set(EmailDTO emailDTO) {
            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            mailSender.setDefaultEncoding("UTF-8");
            mailSender.setHost(HOST);
            mailSender.setPort(PORT);
            mailSender.setUsername(emailDTO.getUser());
            mailSender.setPassword(emailDTO.getPass());
            Properties properties = new Properties();
            properties.put("mail.smtp.auth", MAIL_STMP_AUTH);
            properties.put("mail.smtp.starttls.enable", MAIL_STMP_STARTTLS_ENABLED);
            properties.put("mail.debug", MAIL_DEBUG);
            properties.put("mail.smtp.ssl.trust", MAIL_STMP_SSL_TRUST);
            mailSender.setJavaMailProperties(properties);
            return mailSender;
    }

    public Boolean sendMail(EmailDTO emailDTO) {
        try {
            emailDTO.setUser(EMAIL_USERNAME);
            emailDTO.setPass(EMAIL_PASSWORD);
            emailDTO.setFrom("Codiga2.0 <"+EMAIL_USERNAME+">");
            this.setMailSender(emailDTO);
            MimeMessage message = mailSender.createMimeMessage();
            message.setContent(message, "text/plain; charset=UTF-8");
            message.setSubject(emailDTO.getSubject(), "utf-8");
            MimeMessageHelper helper;
            helper = new MimeMessageHelper(message, true);

            helper.setFrom(emailDTO.getFrom());

            if (emailDTO.getTo() != null) {
                List<String> to = emailDTO.getTo();
                for (String string : to) {
                    helper.addTo(string);
                }
            }

            if (emailDTO.getConCopia() != null) {
                List<String> cc = emailDTO.getConCopia();
                for (String string : cc) {
                    helper.addCc(string);
                }
            }
            if (emailDTO.getConCopiaOculta() != null) {
                List<String> ccO = emailDTO.getConCopiaOculta();
                for (String string : ccO) {
                    helper.addBcc(string);
                }
            }

            helper.setText(emailDTO.getMsj(), true);

            if (emailDTO.getFiles() != null && emailDTO.getFiles().size() > 0) {
                for (int i = 0; i < emailDTO.getFiles().size(); i++) {
                    helper.addAttachment(emailDTO.getFiles().get(i).getOriginalFilename(), emailDTO.getFiles().get(i));
                }
            }

            mailSender.send(message);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
