package it.unicam.cs.terravalore.service;

import it.unicam.cs.terravalore.model.Contenuto;
import it.unicam.cs.terravalore.repository.ContenutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service per la gestione delle operazioni relative ai contenuti.
 * Questa classe fornisce metodi per recuperare i contenuti associati a un punto di interesse specifico.
 */
@Service
public class ContenutoService {

    @Autowired
    private ContenutoRepository contenutoRepository;

    /**
     * Recupera tutti i contenuti associati a un punto di interesse specifico.
     *
     * @param puntoInteresseId L'ID del punto di interesse di cui si vogliono ottenere i contenuti associati.
     * @return Una lista di contenuti associati al punto di interesse specificato.
     */
    public List<Contenuto> findByPuntoInteresseId(Long puntoInteresseId) {
        return contenutoRepository.findByPuntoInteresseId(puntoInteresseId);
    }
}
