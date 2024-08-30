package it.unicam.cs.terravalore.model.utenti;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * La classe TuristaAutenticato estende Utente e rappresenta un turista che ha effettuato l'autenticazione.
 */

@Entity
public class TuristaAutenticato extends Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Costruttore della classe TuristaAutenticato.
     *
     * @param nome    Il nome del turista autenticato.
     * @param cognome Il cognome del turista autenticato.
     * @param mail    L'email del turista autenticato.
     */
    public TuristaAutenticato(String nome, String cognome, String mail) {
        super(nome, cognome, mail);
    }

    public TuristaAutenticato() {
        super();
    }

    // Getters e Setters per 'id'
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Altri metodi specifici per TuristaAutenticato

}

