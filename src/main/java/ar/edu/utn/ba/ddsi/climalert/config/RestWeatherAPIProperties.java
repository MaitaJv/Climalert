package ar.edu.utn.ba.ddsi.climalert.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "weather")
@Data
public class RestWeatherAPIProperties {
  private String baseUrl;
  private String apiKey;
}
