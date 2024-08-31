package it.unicam.cs.terravalore.repository;

import it.unicam.cs.terravalore.model.utenti.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UtenteRepository extends JpaRepository<Utente, Long> {
    Optional<Utente> findByUsername(String username);
}
