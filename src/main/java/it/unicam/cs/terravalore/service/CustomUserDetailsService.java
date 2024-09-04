package it.unicam.cs.terravalore.service;

import it.unicam.cs.terravalore.config.CustomUserDetails;
import it.unicam.cs.terravalore.model.utenti.Utente;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import it.unicam.cs.terravalore.repository.UtenteRepository;
import org.springframework.stereotype.Service;

/**
 * Servizio personalizzato per la gestione dei dettagli utente.
 *
 * Questa classe implementa l'interfaccia {@link UserDetailsService} di Spring Security
 * e fornisce un metodo per caricare i dettagli dell'utente in base al nome utente.
 * Utilizza il {@link UtenteRepository} per recuperare le informazioni dell'utente
 * dal database e ritorna un'istanza di {@link CustomUserDetails}.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UtenteRepository utenteRepository;

    /**
     * Carica i dettagli dell'utente in base al nome utente.
     *
     * Questo metodo utilizza il repository {@link UtenteRepository} per trovare
     * l'utente associato al nome utente fornito. Se l'utente non viene trovato,
     * viene sollevata un'eccezione {@link UsernameNotFoundException}.
     *
     * @param username Il nome utente dell'utente di cui caricare i dettagli.
     * @return Un'istanza di {@link CustomUserDetails} contenente le informazioni
     *         dell'utente trovato.
     * @throws UsernameNotFoundException Se l'utente non viene trovato con il nome utente fornito.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utente utente = utenteRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return new CustomUserDetails(utente);
    }
}
