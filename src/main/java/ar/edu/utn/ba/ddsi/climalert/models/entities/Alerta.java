package ar.edu.utn.ba.ddsi.climalert.models.entities;

import lombok.Data;

@Data
public class Alerta {
  private Clima clima;
  private String Destinatario;


  public Alerta(Clima clima, String destinatario) {
    this.clima = clima;
    Destinatario = destinatario;
  }
}
