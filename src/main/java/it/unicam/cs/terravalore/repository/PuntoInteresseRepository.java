package it.unicam.cs.terravalore.repository;

import it.unicam.cs.terravalore.model.PuntoInteresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Il repository per accedere ai dati dei punti di interesse.
 */
@Repository
public interface PuntoInteresseRepository extends JpaRepository<PuntoInteresse, Long> {
}

