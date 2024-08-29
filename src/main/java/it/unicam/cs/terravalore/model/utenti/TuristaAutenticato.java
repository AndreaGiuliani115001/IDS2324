package it.unicam.cs.terravalore.model.utenti;

/**
 * La classe TuristaAutenticato estende Utente e rappresenta un turista che ha effettuato l'autenticazione.
 */
public class TuristaAutenticato extends Utente {

    /**
     * Costruttore della classe TuristaAutenticato.
     *
     * @param nome Il nome del turista autenticato.
     * @param cognome Il cognome del turista autenticato.
     * @param mail L'email del turista autenticato.
     */
    public TuristaAutenticato(String nome, String cognome, String mail) {
        super(nome, cognome, mail);
    }

    // Metodi specifici per il turista autenticato possono essere aggiunti qui
}

