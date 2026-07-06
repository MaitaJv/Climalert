package ar.edu.utn.ba.ddsi.climalert.scheduler;

import ar.edu.utn.ba.ddsi.climalert.dto.ClimaResponse;
import ar.edu.utn.ba.ddsi.climalert.models.entities.Clima;
import ar.edu.utn.ba.ddsi.climalert.service.Clima.ClimaService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ClimaActual {
  private final ClimaService climaService;

  public ClimaActual(ClimaService climaService) {
    this.climaService = climaService;
  }

  @Scheduled(fixedRate = 300000) // 5 minutos
  public void actualizarClimas(){
    ClimaResponse climaActual = climaService.consultarClima();

    System.out.println("climaActual: ");
    System.out.println(climaActual);

    Clima nuevoClima = climaService.cargarClima(climaActual);

    System.out.println("nuevoClima");
    System.out.println(nuevoClima);
  }
}
