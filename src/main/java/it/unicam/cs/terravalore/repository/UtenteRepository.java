package it.unicam.cs.terravalore.repository;

import it.unicam.cs.terravalore.model.utenti.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * Repository per la gestione delle operazioni di accesso ai dati relativi agli utenti.
 * Questa interfaccia estende {@link JpaRepository}, fornendo metodi CRUD standard
 * e un metodo personalizzato per trovare un utente in base al nome utente.
 */
public interface UtenteRepository extends JpaRepository<Utente, Long> {

    /**
     * Trova un utente in base al nome utente.
     *
     * @param username Il nome utente dell'utente da trovare.
     * @return Un {@link Optional} contenente l'utente trovato, se esiste, altrimenti un {@link Optional} vuoto.
     */
    Optional<Utente> findByUsername(String username);
}
