package ar.edu.utn.ba.ddsi.climalert;

import ar.edu.utn.ba.ddsi.climalert.config.AlertaProperties;
import ar.edu.utn.ba.ddsi.climalert.config.EmailProperties;
import ar.edu.utn.ba.ddsi.climalert.config.RestWeatherAPIProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigurationProperties({RestWeatherAPIProperties.class, EmailProperties.class, AlertaProperties.class})
@EnableScheduling
public class ClimalertApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClimalertApplication.class, args);
	}

}
