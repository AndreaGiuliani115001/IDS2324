package it.unicam.cs.terravalore.service;

import it.unicam.cs.terravalore.model.utenti.Utente;
import it.unicam.cs.terravalore.model.Comune;
import it.unicam.cs.terravalore.repository.ComuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service per la gestione delle operazioni sui comuni.
 * Questa classe fornisce metodi per recuperare i dati relativi ai comuni
 * dal repository e per filtrare i comuni in base a specifici criteri.
 */
@Service
public class ComuneService {

    @Autowired
    private ComuneRepository comuneRepository;

    /**
     * Recupera tutti i comuni presenti nel sistema.
     *
     * @return Una lista di tutti i comuni.
     */
    public List<Comune> findAll() {
        return comuneRepository.findAll();
    }

    /**
     * Recupera tutti i comuni associati a un utente specifico.
     *
     * @param utente L'utente di cui si vogliono ottenere i comuni associati.
     * @return Una lista di comuni associati all'utente specificato.
     */
    public List<Comune> findAllByUser(Utente utente) {
        return comuneRepository.findByUtenti_Id(utente.getId());
    }
}
