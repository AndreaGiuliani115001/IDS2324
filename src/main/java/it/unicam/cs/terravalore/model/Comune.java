package it.unicam.cs.terravalore.model;

import java.util.List;

/**
 * La classe Comune rappresenta un comune e le sue informazioni rilevanti.
 */
public class Comune {
    private String nome;
    private String descrizione;
    private List<PuntoInteresse> puntiDiInteresse;
    private List<Itinerario> itinerari;

    /**
     * Costruttore della classe Comune.
     *
     * @param nome Il nome del comune.
     * @param descrizione La descrizione del comune.
     * @param puntiDiInteresse La lista dei punti di interesse nel comune.
     * @param itinerari La lista degli itinerari associati al comune.
     */
    public Comune(String nome, String descrizione, List<PuntoInteresse> puntiDiInteresse, List<Itinerario> itinerari) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.puntiDiInteresse = puntiDiInteresse;
        this.itinerari = itinerari;
    }

    // Getter e Setter
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

    public List<PuntoInteresse> getPuntiDiInteresse() {
        return puntiDiInteresse;
    }

    public void setPuntiDiInteresse(List<PuntoInteresse> puntiDiInteresse) {
        this.puntiDiInteresse = puntiDiInteresse;
    }

    public List<Itinerario> getItinerari() {
        return itinerari;
    }

    public void setItinerari(List<Itinerario> itinerari) {
        this.itinerari = itinerari;
    }
}


