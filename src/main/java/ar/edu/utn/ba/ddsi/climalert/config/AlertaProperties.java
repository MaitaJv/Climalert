package ar.edu.utn.ba.ddsi.climalert.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "alerta")
@Data
public class AlertaProperties {
  private Integer tempMax;
  private Integer humedadMax;
}
