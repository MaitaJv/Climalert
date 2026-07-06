package ar.edu.utn.ba.ddsi.climalert.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "email")
@Data
public class EmailProperties {
  private String username;
  private List<String> destinatarios;
}
