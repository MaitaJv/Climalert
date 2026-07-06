package ar.edu.utn.ba.ddsi.climalert.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Current {

  @JsonProperty("temp_c")
  private Float temp;
  @JsonProperty("humidity")
  private Integer humidity;
}
