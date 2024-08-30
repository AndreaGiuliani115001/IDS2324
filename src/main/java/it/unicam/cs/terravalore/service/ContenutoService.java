package it.unicam.cs.terravalore.service;

import it.unicam.cs.terravalore.model.Contenuto;
import it.unicam.cs.terravalore.repository.ContenutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContenutoService {

    @Autowired
    private ContenutoRepository contenutoRepository;

    public List<Contenuto> findAll() {
        return contenutoRepository.findAll();
    }
}
