package it.unicam.cs.terravalore.model;

import jakarta.persistence.*;

import java.util.List;

/**
 * La classe Itinerario rappresenta un itinerario composto da punti di interesse.
 */
@Entity
@Table(name = "itinerario")
public class Itinerario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descrizione;
    private Boolean approvazione; // Stato di approvazione

    @ManyToOne
    @JoinColumn(name = "comune_id")
    private Comune comune;

    @ManyToMany
    @JoinTable(
            name = "itinerario_punto_interesse",
            joinColumns = @JoinColumn(name = "itinerario_id"),
            inverseJoinColumns = @JoinColumn(name = "punto_interesse_id")
    )
    private List<PuntoInteresse> listaPuntiDiInteresse;

    // Costruttore senza argomenti richiesto da JPA
    public Itinerario() {
    }

    /**
     * Costruttore della classe Itinerario.
     *
     * @param nome                  Il nome dell'itinerario.
     * @param descrizione           La descrizione dell'itinerario.
     * @param approvazione          Lo stato di approvazione dell'itinerario.
     * @param comune                Il comune associato all'itinerario.
     * @param listaPuntiDiInteresse La lista dei punti di interesse associati all'itinerario.
     */
    public Itinerario(String nome, String descrizione, Boolean approvazione, Comune comune, List<PuntoInteresse> listaPuntiDiInteresse) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.approvazione = approvazione;
        this.comune = comune;
        this.listaPuntiDiInteresse = listaPuntiDiInteresse;
    }

    // Getter e Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Boolean getApprovazione() {
        return approvazione;
    }

    public void setApprovazione(Boolean approvazione) {
        this.approvazione = approvazione;
    }

    public Comune getComune() {
        return comune;
    }

    public void setComune(Comune comune) {
        this.comune = comune;
    }

    public List<PuntoInteresse> getListaPuntiDiInteresse() {
        return listaPuntiDiInteresse;
    }

    public void setListaPuntiDiInteresse(List<PuntoInteresse> listaPuntiDiInteresse) {
        this.listaPuntiDiInteresse = listaPuntiDiInteresse;
    }
}
