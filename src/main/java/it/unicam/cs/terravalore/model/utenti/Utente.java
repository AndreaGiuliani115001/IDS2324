package it.unicam.cs.terravalore.model.utenti;

/**
 * La classe astratta Utente rappresenta la base per tutti i tipi di utenti della piattaforma.
 */
public abstract class Utente {
    private String nome;
    private String cognome;
    private String mail;

    /**
     * Costruttore della classe Utente.
     *
     * @param nome Il nome dell'utente.
     * @param cognome Il cognome dell'utente.
     * @param mail L'email dell'utente.
     */
    public Utente(String nome, String cognome, String mail) {
        this.nome = nome;
        this.cognome = cognome;
        this.mail = mail;
    }

    // Getter e Setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
