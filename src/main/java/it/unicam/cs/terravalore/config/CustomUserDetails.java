package it.unicam.cs.terravalore.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import it.unicam.cs.terravalore.model.utenti.Utente;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private Utente utente;

    public CustomUserDetails(Utente utente) {
        this.utente = utente;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Qui puoi assegnare differenti ruoli o permessi basati sul tipo dell'utente.
        // Per semplificare, restituiamo una collezione vuota qui.
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return utente.getPassword();
    }

    @Override
    public String getUsername() {
        return utente.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;  // Consideriamo che l'account non scada per la semplificazione
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // Consideriamo che l'account non sia bloccato
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // Consideriamo che le credenziali non scadano
    }

    @Override
    public boolean isEnabled() {
        return utente.isActive();  // Usa il campo 'active' dell'utente per determinare se è abilitato
    }

    public Utente getUtente() {
        return this.utente;
    }
}
