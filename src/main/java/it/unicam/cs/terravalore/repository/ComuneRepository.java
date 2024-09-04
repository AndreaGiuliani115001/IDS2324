package it.unicam.cs.terravalore.repository;

import it.unicam.cs.terravalore.model.Comune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository per la gestione delle operazioni di accesso ai dati relativi ai comuni.
 * Questa interfaccia estende {@link JpaRepository}, fornendo metodi CRUD standard
 * e un metodo personalizzato per trovare i comuni associati a un utente specifico.
 */
@Repository
public interface ComuneRepository extends JpaRepository<Comune, Long> {

    /**
     * Trova tutti i comuni associati a un utente specifico identificato dal suo ID.
     *
     * @param utenteId L'ID dell'utente per cui si vogliono trovare i comuni associati.
     * @return Una lista di comuni associati all'ID utente specificato.
     */
    List<Comune> findByUtenti_Id(Long utenteId);
}
