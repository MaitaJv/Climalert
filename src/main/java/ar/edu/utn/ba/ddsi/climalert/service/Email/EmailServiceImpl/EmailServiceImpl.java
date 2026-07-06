package ar.edu.utn.ba.ddsi.climalert.service.Email.EmailServiceImpl;

import ar.edu.utn.ba.ddsi.climalert.config.EmailProperties;
import ar.edu.utn.ba.ddsi.climalert.service.Email.EmailService;
import jakarta.mail.internet.MimeMessage;
import lombok.SneakyThrows;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

  private EmailProperties properties;
  private JavaMailSender mailSender;

  public EmailServiceImpl(EmailProperties properties, JavaMailSender mailSender){
    this.properties = properties;
    this.mailSender = mailSender;
  }

  @Override
  @SneakyThrows
  public void enviarEmail(String asunto, String cuerpo) {
    MimeMessage msg = mailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(msg, "UTF-8");

    helper.setFrom(properties.getUsername());
    helper.setTo(properties.getDestinatarios().toArray(String[]::new));
    helper.setSubject(asunto);
    helper.setText(cuerpo, true);

    mailSender.send(msg);
  }
}