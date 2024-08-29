package it.unicam.cs.terravalore.model.utenti;

/**
 * La classe Contributore estende Utente e rappresenta un utente con il ruolo di Contributore.
 */
public class Contributore extends Utente {

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

    // Metodi specifici per il contributore possono essere aggiunti qui
}

