package it.unicam.cs.terravalore.model;

import java.util.List;

/**
 * La classe Itinerario rappresenta un percorso turistico o culturale.
 */
public class Itinerario {
    private String id;
    private String nome;
    private String descrizione;
    private Boolean approvazione;
    private List<PuntoInteresse> listaPuntiDiInteresse;

    /**
     * Costruttore della classe Itinerario.
     *
     * @param id L'identificativo dell'itinerario.
     * @param nome Il nome dell'itinerario.
     * @param descrizione La descrizione dell'itinerario.
     * @param approvazione Lo stato di approvazione dell'itinerario.
     * @param listaPuntiDiInteresse La lista dei punti di interesse nell'itinerario.
     */
    public Itinerario(String id, String nome, String descrizione, Boolean approvazione, List<PuntoInteresse> listaPuntiDiInteresse) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.approvazione = approvazione;
        this.listaPuntiDiInteresse = listaPuntiDiInteresse;
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

    public Boolean getApprovazione() {
        return approvazione;
    }

    public void setApprovazione(Boolean approvazione) {
        this.approvazione = approvazione;
    }

    public List<PuntoInteresse> getListaPuntiDiInteresse() {
        return listaPuntiDiInteresse;
    }

    public void setListaPuntiDiInteresse(List<PuntoInteresse> listaPuntiDiInteresse) {
        this.listaPuntiDiInteresse = listaPuntiDiInteresse;
    }
}



