package it.unicam.cs.terravalore.service;

import it.unicam.cs.terravalore.model.Itinerario;
import it.unicam.cs.terravalore.repository.ItinerarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servizio per gestire le operazioni sugli itinerari.
 *
 * Questa classe fornisce metodi per accedere ai dati relativi agli itinerari tramite
 * il {@link ItinerarioRepository}. Include metodi per recuperare tutti gli itinerari
 * memorizzati nel database.
 */
@Service
public class ItinerarioService {

    @Autowired
    private ItinerarioRepository itinerarioRepository;

    /**
     * Recupera tutti gli itinerari presenti nel database.
     *
     * Questo metodo utilizza il repository {@link ItinerarioRepository} per ottenere
     * una lista di tutti gli itinerari. I dati sono recuperati dalla sorgente dati
     * e restituiti come una lista di oggetti {@link Itinerario}.
     *
     * @return Una lista di tutti gli {@link Itinerario} presenti nel database.
     */
    public List<Itinerario> findAll() {
        return itinerarioRepository.findAll();
    }
}
