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

    public List<PuntoInteresse> findByComuneId(Long comuneId) {
        return puntoInteresseRepository.findByComuneId(comuneId);
    }
}
