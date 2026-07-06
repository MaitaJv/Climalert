package ar.edu.utn.ba.ddsi.climalert.scheduler;

import ar.edu.utn.ba.ddsi.climalert.config.AlertaProperties;
import ar.edu.utn.ba.ddsi.climalert.models.entities.Clima;
import ar.edu.utn.ba.ddsi.climalert.repositories.ClimaRepository;
import ar.edu.utn.ba.ddsi.climalert.service.Clima.ClimaService;
import ar.edu.utn.ba.ddsi.climalert.service.Email.EmailService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class ProcesarAlertas {
  private final ClimaRepository climaRepository;
  private final EmailService emailService;
  private final AlertaProperties alertaProperties;


  public ProcesarAlertas(ClimaRepository climaRepository, EmailService emailService, AlertaProperties alertaProperties) {
    this.climaRepository = climaRepository;
    this.emailService = emailService;
    this.alertaProperties = alertaProperties;
  }

  @Scheduled(fixedRate = 60000)
  public void realizarAlertar(){
    Clima clima = climaRepository
                  .findAll()
                  .stream()
                  .max(Comparator.comparing(Clima::getFecha))
                  .orElseThrow(() -> new RuntimeException("No existe"));

    if (hayAlerta(clima)){
      String asunto = "Alerta Meteorológica";
      String cuerpo = crearHTML(clima);
      emailService.enviarEmail(asunto, cuerpo);
    }
  }

  public String crearHTML(Clima clima){

    String respuesta = """
        <!DOCTYPE html>
        <html>
        <head>
            <meta charset="UTF-8">
            <title>Alerta Meteorológica</title>
        </head>
        <body>
        
            <h1>Alerta Meteorológica</h1>
        
            <h3>Clima actual: %s</h3>
            <h4>País: %s</h4>
            <h4>Ciudad: %s</h4>
            <h4>Temperatura: %s</h4>
            <h4>Humedad: %s</h4>
        
        </body>
        </html>
        """.formatted(clima.getFecha().toString(), clima.getPais(), clima.getNombre(), clima.getTemperatura(), clima.getHumedad());

    return respuesta;
  }

  public Boolean hayAlerta(Clima clima){
    return clima.getTemperatura() > alertaProperties.getTempMax() && clima.getHumedad() > alertaProperties.getHumedadMax()
        ? true
        : false;
  }
}
