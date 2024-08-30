package it.unicam.cs.terravalore.repository;

import it.unicam.cs.terravalore.model.Itinerario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItinerarioRepository extends JpaRepository<Itinerario, Long> {
}
