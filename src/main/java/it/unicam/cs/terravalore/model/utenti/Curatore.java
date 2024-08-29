package it.unicam.cs.terravalore.model.utenti;

/**
 * La classe Curatore estende Utente e rappresenta un utente con il ruolo di Curatore.
 */
public class Curatore extends Utente {

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

    // Metodi specifici per il curatore possono essere aggiunti qui
}

