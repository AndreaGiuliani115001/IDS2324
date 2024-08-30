package it.unicam.cs.terravalore.model.utenti;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * La classe Animatore estende Utente e rappresenta un utente con il ruolo di Animatore.
 */

@Entity
public class Animatore extends Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Costruttore della classe Animatore.
     *
     * @param nome Il nome dell'animatore.
     * @param cognome Il cognome dell'animatore.
     * @param mail L'email dell'animatore.
     */
    public Animatore(String nome, String cognome, String mail) {
        super(nome, cognome, mail);
    }

    public Animatore() {

    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Altri metodi specifici per Animatore

}
