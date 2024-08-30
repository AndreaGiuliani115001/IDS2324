package it.unicam.cs.terravalore.service;

import it.unicam.cs.terravalore.model.Itinerario;
import it.unicam.cs.terravalore.repository.ItinerarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItinerarioService {

    @Autowired
    private ItinerarioRepository itinerarioRepository;

    public List<Itinerario> findAll() {
        return itinerarioRepository.findAll();
    }
}
