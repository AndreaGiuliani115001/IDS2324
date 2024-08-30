package it.unicam.cs.terravalore.service;

import it.unicam.cs.terravalore.model.PuntoInteresse;
import it.unicam.cs.terravalore.repository.PuntoInteresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Il servizio per gestire le operazioni sui punti di interesse.
 */
@Service
public class PuntoInteresseService {

    @Autowired
    private PuntoInteresseRepository puntoInteresseRepository;

    /**
     * Trova tutti i punti di interesse.
     *
     * @return La lista di tutti i punti di interesse.
     */
    public List<PuntoInteresse> trovaTuttiPuntiDiInteresse() {
        return puntoInteresseRepository.findAll();
    }
}
