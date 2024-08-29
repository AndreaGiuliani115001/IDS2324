package it.unicam.cs.terravalore.model.utenti;

/**
 * La classe ContributoreAutorizzato estende Contributore e rappresenta un contributore con autorizzazioni speciali.
 */
public class ContributoreAutorizzato extends Contributore {

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

    // Metodi specifici per il contributore autorizzato possono essere aggiunti qui
}

