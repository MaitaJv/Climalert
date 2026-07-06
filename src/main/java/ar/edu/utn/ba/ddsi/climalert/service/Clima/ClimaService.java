package ar.edu.utn.ba.ddsi.climalert.service.Clima;

import ar.edu.utn.ba.ddsi.climalert.dto.ClimaResponse;
import ar.edu.utn.ba.ddsi.climalert.models.entities.Clima;

public interface ClimaService {
  Clima cargarClima(ClimaResponse clima);

  ClimaResponse consultarClima();
}
