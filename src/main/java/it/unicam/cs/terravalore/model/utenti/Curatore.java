package it.unicam.cs.terravalore.model.utenti;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * La classe Curatore estende Utente e rappresenta un utente con il ruolo di Curatore.
 */

@Entity
public class Curatore extends Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Costruttore della classe Curatore.
     *
     * @param nome Il nome del curatore.
     * @param cognome Il cognome del curatore.
     * @param mail L'email del curatore.
     */
    public Curatore(String nome, String cognome, String mail) {
        super(nome, cognome, mail);
    }

    public Curatore() {

    }

    // Getters e Setters per 'id'
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Altri metodi specifici per Curatore
}

