package it.unicam.cs.terravalore.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import it.unicam.cs.terravalore.model.utenti.Utente;

import java.util.Collection;
import java.util.Collections;

/**
 * Implementazione personalizzata dell'interfaccia {@link UserDetails}.
 *
 * Questa classe fornisce i dettagli dell'utente per l'integrazione con il sistema di
 * autenticazione di Spring Security, adattando il modello di utente dell'applicazione
 * ai requisiti di Spring Security.
 */
public class CustomUserDetails implements UserDetails {

    private Utente utente;

    /**
     * Costruttore della classe {@link CustomUserDetails}.
     *
     * @param utente L'istanza di {@link Utente} che rappresenta l'utente dell'applicazione.
     */
    public CustomUserDetails(Utente utente) {
        this.utente = utente;
    }

    /**
     * Restituisce le autorizzazioni dell'utente.
     *
     * In questa implementazione, non vengono utilizzate autorizzazioni specifiche.
     * Per un controllo più avanzato delle autorizzazioni, è possibile estendere
     * questa classe e implementare logiche specifiche.
     *
     * @return Una collezione vuota di {@link GrantedAuthority}.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    /**
     * Restituisce la password dell'utente.
     *
     * @return La password codificata dell'utente.
     */
    @Override
    public String getPassword() {
        return utente.getPassword();
    }

    /**
     * Restituisce il nome utente dell'utente.
     *
     * @return Il nome utente dell'utente.
     */
    @Override
    public String getUsername() {
        return utente.getUsername();
    }

    /**
     * Indica se l'account dell'utente è scaduto.
     *
     * In questa implementazione, si assume che l'account non sia mai scaduto.
     * Se si desidera gestire la scadenza dell'account, è possibile modificare
     * questa logica.
     *
     * @return {@code true} se l'account non è scaduto, {@code false} altrimenti.
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indica se l'account dell'utente è bloccato.
     *
     * In questa implementazione, si assume che l'account non sia mai bloccato.
     * Se si desidera gestire il blocco dell'account, è possibile modificare
     * questa logica.
     *
     * @return {@code true} se l'account non è bloccato, {@code false} altrimenti.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indica se le credenziali dell'utente sono scadute.
     *
     * In questa implementazione, si assume che le credenziali non siano mai scadute.
     * Se si desidera gestire la scadenza delle credenziali, è possibile modificare
     * questa logica.
     *
     * @return {@code true} se le credenziali non sono scadute, {@code false} altrimenti.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indica se l'utente è abilitato.
     *
     * Un utente è considerato abilitato se il flag {@code active} è {@code true}.
     *
     * @return {@code true} se l'utente è abilitato, {@code false} altrimenti.
     */
    @Override
    public boolean isEnabled() {
        return utente.isActive();
    }

    /**
     * Restituisce l'istanza di {@link Utente} associata a questi dettagli.
     *
     * @return L'istanza di {@link Utente}.
     */
    public Utente getUtente() {
        return this.utente;
    }
}
