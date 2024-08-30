package it.unicam.cs.terravalore.service;

import it.unicam.cs.terravalore.model.Comune;
import it.unicam.cs.terravalore.repository.ComuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComuneService {

    @Autowired
    private ComuneRepository comuneRepository;

    public List<Comune> findAll() {
        return comuneRepository.findAll();
    }
}
