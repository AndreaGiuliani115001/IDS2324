package it.unicam.cs.terravalore.model.utenti;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * La classe Contributore estende Utente e rappresenta un utente con il ruolo di Contributore.
 */

@Entity
public class Contributore extends Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Costruttore della classe Contributore.
     *
     * @param nome Il nome del contributore.
     * @param cognome Il cognome del contributore.
     * @param mail L'email del contributore.
     */
    public Contributore(String nome, String cognome, String mail) {
        super(nome, cognome, mail);
    }

    public Contributore() {

    }

    // Getters e Setters per 'id'
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Altri metodi specifici per Contributore

}

