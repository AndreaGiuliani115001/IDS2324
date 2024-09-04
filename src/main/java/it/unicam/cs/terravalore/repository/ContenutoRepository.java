package it.unicam.cs.terravalore.repository;

import it.unicam.cs.terravalore.model.Contenuto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository per la gestione delle operazioni di accesso ai dati relativi ai contenuti.
 * Questa interfaccia estende {@link JpaRepository}, fornendo metodi CRUD standard
 * e un metodo personalizzato per trovare i contenuti associati a un punto di interesse specifico.
 */
@Repository
public interface ContenutoRepository extends JpaRepository<Contenuto, Long> {

    /**
     * Trova tutti i contenuti associati a un punto di interesse specifico identificato dal suo ID.
     *
     * @param puntoInteresseId L'ID del punto di interesse per cui si vogliono trovare i contenuti associati.
     * @return Una lista di contenuti associati al punto di interesse specificato.
     */
    List<Contenuto> findByPuntoInteresseId(Long puntoInteresseId);
}
