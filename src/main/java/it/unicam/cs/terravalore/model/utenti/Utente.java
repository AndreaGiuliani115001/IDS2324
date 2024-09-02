package it.unicam.cs.terravalore.model.utenti;

import it.unicam.cs.terravalore.model.Comune;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Strategia JOINED per ereditarietà
public abstract class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private boolean active;

    @ManyToMany
    @JoinTable(
            name = "utente_comune", // Assicurati che il nome della tabella di join sia corretto
            joinColumns = @JoinColumn(name = "utente_id"),
            inverseJoinColumns = @JoinColumn(name = "comune_id")
    )
    private Set<Comune> comuniAssociati;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Comune> getComuniAssociati() {
        return comuniAssociati;
    }

    public void setComuniAssociati(Set<Comune> comuniAssociati) {
        this.comuniAssociati = comuniAssociati;
    }
}
