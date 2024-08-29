package it.unicam.cs.terravalore.model.utenti;

/**
 * La classe Animatore estende Utente e rappresenta un utente con il ruolo di Animatore.
 */
public class Animatore extends Utente {

    /**
     * Costruttore della classe Animatore.
     *
     * @param nome Il nome dell'animatore.
     * @param cognome Il cognome dell'animatore.
     * @param mail L'email dell'animatore.
     */
    public Animatore(String nome, String cognome, String mail) {
        super(nome, cognome, mail);
    }

    // Metodi specifici per l'animatore
}
