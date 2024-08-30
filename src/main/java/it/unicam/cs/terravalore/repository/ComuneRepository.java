package it.unicam.cs.terravalore.repository;

import it.unicam.cs.terravalore.model.Comune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComuneRepository extends JpaRepository<Comune, Long> {
}
