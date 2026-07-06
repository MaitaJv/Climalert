package ar.edu.utn.ba.ddsi.climalert.models.entities;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Clima {
  private Long id;
  private String pais;
  private String region;
  private String nombre;
  private Integer humedad;
  private Float temperatura;
  private LocalDate fecha;

  public Clima(Long id, String pais, String region, String nombre, Integer humedad, Float temperatura, LocalDate fecha) {
    this.id = id;
    this.pais = pais;
    this.region = region;
    this.nombre = nombre;
    this.humedad = humedad;
    this.temperatura = temperatura;
    this.fecha = fecha;
  }
}
