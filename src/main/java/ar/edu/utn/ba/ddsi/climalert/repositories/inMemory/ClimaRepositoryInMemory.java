package ar.edu.utn.ba.ddsi.climalert.repositories.inMemory;

import ar.edu.utn.ba.ddsi.climalert.models.entities.Clima;
import ar.edu.utn.ba.ddsi.climalert.repositories.ClimaRepository;
import ar.edu.utn.ba.ddsi.climalert.utils.GeneradorIdSecuencial;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClimaRepositoryInMemory implements ClimaRepository {
  private final List<Clima> climas = new ArrayList<>();
  private final GeneradorIdSecuencial generadorId = new GeneradorIdSecuencial();

  @Override
  public List<Clima> findAll() {
    return new ArrayList<>(climas);
  }

  @Override
  public Optional<Clima> findById(Long id) {
    return climas.stream().filter(c -> c.getId().equals(id)).findFirst();
  }

  @Override
  public Clima save(Clima clima) {
    if (clima.getId() == null) {
      clima.setId(generadorId.siguiente());
      climas.add(clima);
      return clima;
    }
    delete(clima);
    climas.add(clima);
    return null;
  }

  @Override
  public void delete(Clima clima) {
    if (clima.getId() == null) {
      return;
    }
    climas.removeIf(p -> p.getId().equals(clima.getId()));
  }
}
