package it.unicam.cs.terravalore.repository;

import it.unicam.cs.terravalore.model.PuntoInteresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository per la gestione delle operazioni di accesso ai dati relativi ai punti di interesse.
 * Questa interfaccia estende {@link JpaRepository}, fornendo metodi CRUD standard e un metodo personalizzato
 * per trovare i punti di interesse associati a un determinato comune.
 */
@Repository
public interface PuntoInteresseRepository extends JpaRepository<PuntoInteresse, Long> {

    /**
     * Trova tutti i punti di interesse associati a un comune specifico identificato dal suo ID.
     *
     * @param comuneId L'ID del comune per cui si vogliono trovare i punti di interesse associati.
     * @return Una lista di punti di interesse associati al comune specificato.
     */
    List<PuntoInteresse> findByComuneId(Long comuneId);
}
