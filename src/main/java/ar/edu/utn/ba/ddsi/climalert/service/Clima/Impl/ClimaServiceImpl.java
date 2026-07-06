package ar.edu.utn.ba.ddsi.climalert.service.Clima.Impl;

import ar.edu.utn.ba.ddsi.climalert.config.AlertaProperties;
import ar.edu.utn.ba.ddsi.climalert.config.RestWeatherAPIProperties;
import ar.edu.utn.ba.ddsi.climalert.dto.ClimaResponse;
import ar.edu.utn.ba.ddsi.climalert.models.entities.Clima;
import ar.edu.utn.ba.ddsi.climalert.repositories.ClimaRepository;
import ar.edu.utn.ba.ddsi.climalert.service.Clima.ClimaService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class ClimaServiceImpl implements ClimaService {
  private final ClimaRepository climaRepository;
  private final RestTemplate restTemplate;
  private final RestWeatherAPIProperties properties;
  private final AlertaProperties alertaProperties;

  public ClimaServiceImpl(ClimaRepository climaRepository, RestTemplate restTemplate, RestWeatherAPIProperties properties, AlertaProperties alertaProperties) {
    this.climaRepository = climaRepository;
    this.restTemplate = restTemplate;
    this.properties = properties;
    this.alertaProperties = alertaProperties;
  }


  @Override
  public Clima cargarClima(ClimaResponse clima) {
    Clima nuevoClima = new Clima(
        null,
        clima.getLocation().getCountry(),
        clima.getLocation().getRegion(),
        clima.getLocation().getName(),
        clima.getCurrent().getHumidity(),
        clima.getCurrent().getTemp(),
        LocalDate.now()
    );
    return climaRepository.save(nuevoClima);
  }

  @Override
  public ClimaResponse consultarClima() {

    URI url = UriComponentsBuilder
        .fromUriString(properties.getBaseUrl())
        .path("/current.json")
        .queryParam("q",alertaProperties.getUbicacion())
        .queryParam("key", properties.getApiKey())
        .build()
        .toUri();

    ClimaResponse clima = restTemplate.getForObject(url, ClimaResponse.class);

    return clima == null ? null : clima;
  }
}
