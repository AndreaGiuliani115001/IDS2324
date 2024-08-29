package it.unicam.cs.terravalore.model;

import java.util.Date;

/**
 * La classe Contenuto rappresenta un contenuto multimediale o testuale associato a un punto di interesse.
 */
public class Contenuto {
    private String id;
    private String tipo; // Testo, Immagine, Video, ecc.
    private Date dataCaricamento;
    private String stato; // In attesa, Approvato, Rifiutato
    private PuntoInteresse puntoDiInteresse;

    /**
     * Costruttore della classe Contenuto.
     *
     * @param id L'identificativo univoco del contenuto.
     * @param tipo Il tipo di contenuto (Testo, Immagine, Video, ecc.).
     * @param dataCaricamento La data di caricamento del contenuto.
     * @param stato Lo stato del contenuto (In attesa, Approvato, Rifiutato).
     * @param puntoDiInteresse Il punto di interesse associato al contenuto.
     */
    public Contenuto(String id, String tipo, Date dataCaricamento, String stato, PuntoInteresse puntoDiInteresse) {
        this.id = id;
        this.tipo = tipo;
        this.dataCaricamento = dataCaricamento;
        this.stato = stato;
        this.puntoDiInteresse = puntoDiInteresse;
    }

    // Getter e Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getDataCaricamento() {
        return dataCaricamento;
    }

    public void setDataCaricamento(Date dataCaricamento) {
        this.dataCaricamento = dataCaricamento;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public PuntoInteresse getPuntoDiInteresse() {
        return puntoDiInteresse;
    }

    public void setPuntoDiInteresse(PuntoInteresse puntoDiInteresse) {
        this.puntoDiInteresse = puntoDiInteresse;
    }
}
