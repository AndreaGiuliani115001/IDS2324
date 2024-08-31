package it.unicam.cs.terravalore.model.utenti;

import jakarta.persistence.*;
import it.unicam.cs.terravalore.model.Comune;
import java.util.List;

@Entity
public class Contributore extends Utente {

    @ManyToMany
    @JoinTable(
            name = "contributore_comuni",
            joinColumns = @JoinColumn(name = "contributore_id"),
            inverseJoinColumns = @JoinColumn(name = "comune_id")
    )
    private List<Comune> comuniAssociati;

    // Getter e Setter per comuniAssociati
    public List<Comune> getComuniAssociati() {
        return comuniAssociati;
    }

    public void setComuniAssociati(List<Comune> comuniAssociati) {
        this.comuniAssociati = comuniAssociati;
    }
}
