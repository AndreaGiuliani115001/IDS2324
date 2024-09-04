package it.unicam.cs.terravalore.model.utenti;

import it.unicam.cs.terravalore.model.Comune;
import jakarta.persistence.*;

import java.util.Set;

/**
 * Classe base astratta per gli utenti del sistema.
 *
 * Utilizza la strategia di ereditarietà {@link InheritanceType#JOINED} per creare
 * tabelle separate per questa classe e le sue sottoclassi. Contiene i campi comuni
 * a tutti gli utenti, inclusi nome utente, password, stato attivo e comuni associati.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private boolean active;

    @ManyToMany
    @JoinTable(
            name = "utente_comune",
            joinColumns = @JoinColumn(name = "utente_id"),
            inverseJoinColumns = @JoinColumn(name = "comune_id")
    )
    private Set<Comune> comuniAssociati;

    /**
     * Restituisce l'ID dell'utente.
     *
     * @return L'ID dell'utente.
     */
    public Long getId() {
        return id;
    }

    /**
     * Imposta l'ID dell'utente.
     *
     * @param id L'ID dell'utente.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Restituisce il nome utente.
     *
     * @return Il nome utente.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Imposta il nome utente.
     *
     * @param username Il nome utente.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Restituisce la password dell'utente.
     *
     * @return La password dell'utente.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Imposta la password dell'utente.
     *
     * @param password La password dell'utente.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Indica se l'utente è attivo.
     *
     * @return {@code true} se l'utente è attivo, {@code false} altrimenti.
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Imposta lo stato attivo dell'utente.
     *
     * @param active {@code true} se l'utente deve essere attivo, {@code false} altrimenti.
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Restituisce i comuni associati all'utente.
     *
     * @return Un insieme di comuni associati all'utente.
     */
    public Set<Comune> getComuniAssociati() {
        return comuniAssociati;
    }

    /**
     * Imposta i comuni associati all'utente.
     *
     * @param comuniAssociati Un insieme di comuni da associare all'utente.
     */
    public void setComuniAssociati(Set<Comune> comuniAssociati) {
        this.comuniAssociati = comuniAssociati;
    }
}
