package it.unicam.cs.terravalore.model.utenti;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * La classe Gestore estende Utente e rappresenta un utente con il ruolo di Gestore.
 */

@Entity
public class Gestore extends Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Costruttore della classe Gestore.
     *
     * @param nome Il nome del gestore.
     * @param cognome Il cognome del gestore.
     * @param mail L'email del gestore.
     */
    public Gestore(String nome, String cognome, String mail) {
        super(nome, cognome, mail);
    }

    public Gestore() {

    }

    // Getters e Setters per 'id'
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Altri metodi specifici per Gestore

}

