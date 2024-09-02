package it.unicam.cs.terravalore.model;

import jakarta.persistence.*;

import java.util.Date;

/**
 * La classe Contenuto rappresenta un contenuto multimediale o testuale associato a un punto di interesse.
 */
@Entity
@Table(name = "contenuto")
public class Contenuto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo; // Testo, Immagine, Video, ecc.
    private Date dataCaricamento;
    private boolean stato; // In attesa, Approvato, Rifiutato

    @ManyToOne
    @JoinColumn(name = "puntoInteresseId")
    private PuntoInteresse puntoInteresse;

    // Costruttore senza argomenti richiesto da JPA
    public Contenuto() {
    }

    /**
     * Costruttore della classe Contenuto.
     *
     * @param tipo             Il tipo di contenuto (Testo, Immagine, Video, ecc.).
     * @param dataCaricamento  La data di caricamento del contenuto.
     * @param stato            Lo stato del contenuto (In attesa, Approvato, Rifiutato).
     * @param puntoInteresse Il punto di interesse associato al contenuto.
     */
    public Contenuto(String tipo, Date dataCaricamento, boolean stato, PuntoInteresse puntoInteresse) {
        this.tipo = tipo;
        this.dataCaricamento = dataCaricamento;
        this.stato = stato;
        this.puntoInteresse = puntoInteresse;
    }

    // Getter e Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public boolean getStato() {
        return stato;
    }

    public void setStato(boolean stato) {
        this.stato = stato;
    }

    public PuntoInteresse getPuntoDiInteresse() {
        return puntoInteresse;
    }

    public void setPuntoDiInteresse(PuntoInteresse puntoDiInteresse) {
        this.puntoInteresse = puntoDiInteresse;
    }
}
