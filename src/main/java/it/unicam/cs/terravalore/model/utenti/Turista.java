package it.unicam.cs.terravalore.model.utenti;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * La classe Turista estende Utente e rappresenta un utente con il ruolo di Turista.
 */

@Entity
public class Turista extends Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Costruttore della classe Turista.
     *
     * @param nome    Il nome del turista.
     * @param cognome Il cognome del turista.
     * @param mail    L'email del turista.
     */
    public Turista(String nome, String cognome, String mail) {
        super(nome, cognome, mail);
    }

    public Turista() {

    }

    // Getters e Setters per 'id'
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Altri metodi specifici per Turista

}

