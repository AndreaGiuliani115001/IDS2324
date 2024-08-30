package it.unicam.cs.terravalore.model.utenti;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * La classe ContributoreAutorizzato estende Contributore e rappresenta un contributore con autorizzazioni speciali.
 */

@Entity
public class ContributoreAutorizzato extends Contributore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Costruttore della classe ContributoreAutorizzato.
     *
     * @param nome Il nome del contributore autorizzato.
     * @param cognome Il cognome del contributore autorizzato.
     * @param mail L'email del contributore autorizzato.
     */
    public ContributoreAutorizzato(String nome, String cognome, String mail) {
        super(nome, cognome, mail);
    }

    public ContributoreAutorizzato() {

    }

    // Getters e Setters per 'id'
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Altri metodi specifici per ContributoreAutorizzato

}

