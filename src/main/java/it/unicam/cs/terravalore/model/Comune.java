package it.unicam.cs.terravalore.model;

import it.unicam.cs.terravalore.model.utenti.Utente;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

/**
 * La classe Comune rappresenta un comune e le sue informazioni rilevanti.
 */
@Entity
@Table(name = "comune")
public class Comune {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descrizione;

    @OneToMany(mappedBy = "comune")
    private List<PuntoInteresse> puntiDiInteresse;

    @OneToMany(mappedBy = "comune")
    private List<Itinerario> itinerari;

    @ManyToMany(mappedBy = "comuniAssociati")
    private Set<Utente> utenti;

    // Costruttore senza argomenti richiesto da JPA
    public Comune() {
    }

    /**
     * Costruttore della classe Comune.
     *
     * @param nome             Il nome del comune.
     * @param descrizione      La descrizione del comune.
     * @param puntiDiInteresse La lista dei punti di interesse nel comune.
     * @param itinerari        La lista degli itinerari associati al comune.
     */
    public Comune(String nome, String descrizione, List<PuntoInteresse> puntiDiInteresse, List<Itinerario> itinerari) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.puntiDiInteresse = puntiDiInteresse;
        this.itinerari = itinerari;
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
