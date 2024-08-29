package it.unicam.cs.terravalore.model;

import java.util.List;

/**
 * La classe PuntoInteresse rappresenta un punto di interesse.
 */
public class PuntoInteresse {
    private String id;
    private String nome;
    private String descrizione;
    private String tipo; // Fisico o Logico
    private Comune comune;
    private List<Contenuto> contenuti;

    /**
     * Costruttore della classe PuntoInteresse.
     *
     * @param id L'identificativo del punto di interesse.
     * @param nome Il nome del punto di interesse.
     * @param descrizione La descrizione del punto di interesse.
     * @param tipo Il tipo del punto di interesse (Fisico o Logico).
     * @param comune Il comune associato al punto di interesse.
     */
    public PuntoInteresse(String id, String nome, String descrizione, String tipo, Comune comune, List<Contenuto> contenuti) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.comune = comune;
        this.contenuti = contenuti;
    }

    // Getter e Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Comune getComune() {
        return comune;
    }

    public void setComune(Comune comune) {
        this.comune = comune;
    }

    public List<Contenuto> getContenuti() {
        return contenuti;
    }

    public void setContenuti(List<Contenuto> contenuti) {
        this.contenuti = contenuti;
    }
}


