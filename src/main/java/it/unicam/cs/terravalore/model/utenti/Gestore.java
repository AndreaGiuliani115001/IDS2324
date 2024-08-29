package it.unicam.cs.terravalore.model.utenti;

/**
 * La classe Gestore estende Utente e rappresenta un utente con il ruolo di Gestore.
 */
public class Gestore extends Utente {

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

    // Metodi specifici per il gestore possono essere aggiunti qui
}

