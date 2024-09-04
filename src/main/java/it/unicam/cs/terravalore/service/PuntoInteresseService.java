package it.unicam.cs.terravalore.service;

import it.unicam.cs.terravalore.model.PuntoInteresse;
import it.unicam.cs.terravalore.repository.PuntoInteresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servizio per gestire le operazioni sui punti di interesse.
 *
 * Questa classe fornisce metodi per accedere e manipolare i dati dei punti di interesse
 * associati a un comune specifico. Utilizza il {@link PuntoInteresseRepository} per
 * effettuare le operazioni di persistenza e recupero dei dati.
 */
@Service
public class PuntoInteresseService {

    @Autowired
    private PuntoInteresseRepository puntoInteresseRepository;

    /**
     * Recupera una lista di punti di interesse associati a un comune specifico.
     *
     * Questo metodo utilizza il repository {@link PuntoInteresseRepository} per trovare
     * tutti i punti di interesse che sono associati al comune identificato dal {@code comuneId}.
     *
     * @param comuneId L'ID del comune per cui recuperare i punti di interesse.
     * @return Una lista di {@link PuntoInteresse} associati al comune specificato.
     */
    public List<PuntoInteresse> findByComuneId(Long comuneId) {
        return puntoInteresseRepository.findByComuneId(comuneId);
    }
}
