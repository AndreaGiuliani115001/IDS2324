package it.unicam.cs.terravalore.model.utenti;

/**
 * La classe Turista estende Utente e rappresenta un utente con il ruolo di Turista.
 */
public class Turista extends Utente {

    /**
     * Costruttore della classe Turista.
     *
     * @param nome Il nome del turista.
     * @param cognome Il cognome del turista.
     * @param mail L'email del turista.
     */
    public Turista(String nome, String cognome, String mail) {
        super(nome, cognome, mail);
    }

    // Metodi specifici per il turista possono essere aggiunti qui
}

